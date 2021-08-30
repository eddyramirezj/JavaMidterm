package databases;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


import parser.Student;

public class ConnectToSqlDB {

    public static Connection connect = null;
    public static Statement statement = null;
    public static PreparedStatement ps = null;
    public static ResultSet resultSet = null;

    public static void main(String[] args) throws Exception {

//        ConnectToSqlDB mySQL = new ConnectToSqlDB();

        connectToSqlDatabase();
        List<User> list = readUserProfileFromSqlTable();
        for (User user : list) {
            System.out.println(user.getStName() + " " + user.getStID() + " " + user.getStDOB());
        }
    }

            //TO STREAM THE INFORMATION FROM THE SECRET.PROPERTIES:
    public static Properties loadProperties() throws IOException {
        Properties prop = new Properties();
        InputStream ism = new FileInputStream("src/secret.properties");
        prop.load(ism);
        ism.close();
        return prop;
    }

            //TO CONNECT TO THE MYSQL DATABASE:
    public static Connection connectToSqlDatabase() throws IOException, SQLException, ClassNotFoundException {
        Properties prop = loadProperties();
        String driverClass = prop.getProperty("MYSQLJDBC.driver");
        String url = prop.getProperty("MYSQLJDBC.url");
        String userName = prop.getProperty("MYSQLJDBC.userName");
        String password = prop.getProperty("MYSQLJDBC.password");
        Class.forName(driverClass);

        try {
            connect = DriverManager.getConnection(url, userName, password);
            System.out.println("Database connected.");
        }
        catch (Exception e) {
            System.out.println("COULD NOT CONNECT TO DATABASE");
            e.printStackTrace();

        }
        return connect;
    }

            //TO CREATE USER(S) FROM THE STUDENT DATABASE
    public static List<User> readUserProfileFromSqlTable(){

        List<User> list = new ArrayList<>();
        User user;
        try {
            Connection conn = connectToSqlDatabase();
            String query = "SELECT * FROM Students;";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("Student");
                String id = rs.getString("ID");
                String dob = rs.getString("DOB");
                user = new User(name, id, dob);
                list.add(user);

            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

            // TO RUN SELECT QUERIES:
    public List<String> readDataBase(String tableName, String columnName) throws Exception {
        List<String> data = new ArrayList<>();

        try {
            connectToSqlDatabase();
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT " + columnName + " FROM " + tableName + ";");
            data = getResultSetData(resultSet, columnName);

        } catch (ClassNotFoundException e) {
            throw e;
        } finally {
            close();
        }
        return data;
    }

    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

            //METHOD REQUIRED TO RUN QUERIES AND GET RESULTS:
    public List<String> getResultSetData(ResultSet resultSet, String dataColumn) throws SQLException {
        List<String> dataList = new ArrayList<String>();
        while (resultSet.next()) {
            String itemName = resultSet.getString(dataColumn);
            dataList.add(itemName);
        }
        return dataList;
    }

            //TO INSERT NUMBERS FROM AN INTEGER ARRAY:
    public void insertDataFromArrayToSqlTable(int[] ArrayData, String tableName, String columnName) {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("DROP TABLE IF EXISTS `" + tableName + "`;");
            ps.executeUpdate();
            ps = connect.prepareStatement("CREATE TABLE `" + tableName + "` (`Student` varchar(100), `ID` int(11) NOT NULL AUTO_INCREMENT,`DOB` varchar(100) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
            ps.executeUpdate();
            for (int sn : ArrayData) {
                ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUE ( " + sn + ")");
                ps.executeUpdate();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

            //THIS METHOD IS EXCLUSIVELY FOR THE SORTING ALGORITHMS LISTS:
    public void sortInsertDataFromArrayToSqlTable(int[] ArrayData, String tableName, String columnName) {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("DROP TABLE IF EXISTS `" + tableName + "`;");
            ps.executeUpdate();
            ps = connect.prepareStatement("CREATE TABLE `" + tableName + "` (`" + columnName +"` bigint(255) NOT NULL);");
//                    ", PRIMARY KEY (`" + columnName +"`) );");
            ps.executeUpdate();
            for (int sn : ArrayData) {
                ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUE ( " + sn + ")");
                ps.executeUpdate();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
            //TO INSERT A RECORD INTO THE DATABASE:
    public void insertDataFromStringToSqlTable(String ArrayData, String tableName, String columnName) {
        try {
            connectToSqlDatabase();
//            ps = connect.prepareStatement("DROP TABLE IF EXISTS `" + tableName + "`;");
//            ps.executeUpdate();
//            ps = connect.prepareStatement("CREATE TABLE `" + tableName + "` (`" + columnName + "` varchar(100), `ID` int(11) NOT NULL AUTO_INCREMENT,`SortingNumbers` bigint(20) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
//            ps.executeUpdate();
            ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUE ('" + ArrayData + "')");
            ps.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

            //TO RUN A QUERY AGAINST THE DATABASE:
    public List<String> directDatabaseQueryExecute(String passQuery, String columnName) throws Exception {
        List<String> data = new ArrayList<String>();

        try {
            connectToSqlDatabase();
            statement = connect.createStatement();
            resultSet = statement.executeQuery(passQuery);
            data = getResultSetData(resultSet, columnName);
        } catch (ClassNotFoundException e) {
            throw e;
        } finally {
            close();
        }
        return data;
    }

        //TO INSERT ELEMENTS FROM A LIST OF TYPE STUDENT INSIDE A COLUMN:
    public void insertDataFromArrayListToSqlTable(List<Student> list, String tableName, String columnName) {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("DROP TABLE IF EXISTS `" + tableName + "`;");
            ps.executeUpdate();
            ps = connect.prepareStatement("CREATE TABLE `" + tableName + "` (`" + columnName + "` varchar(100), `ID` int(11) NOT NULL AUTO_INCREMENT,`DOB` varchar(100) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
            ps.executeUpdate();
            for (Student st : list) {
                ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUE ( '" + st + "');");
                ps.executeUpdate();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertProfileToSqlTable(String tableName, String columnName1, String columnName2) {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName1 + "," + columnName2 + " ) VALUES(?,?)");
            ps.setString(1, "Ankita Sing");
            ps.setInt(2, 3590);
            ps.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}