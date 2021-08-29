package design;

import databases.ConnectToSqlDB;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class FortuneEmployee {



    /**
     FortuneEmployee class has a main method where you will be able to create Object from
        EmployeeInfo class to use fields and attributes
     <p>
     Demonstrate as many methods as possible to use with proper business work flow.
        Try to think like a Software Architect/Developer.
        This application should provide basic employee information services
     </p>
     <p>
     Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
     </p>
     **/
    public static void main(String[] args) {

    registerNewEmployee();



    }

    public static void registerNewEmployee() throws NullPointerException {

        Scanner stdin = new Scanner(System.in);
        try {
            ConnectToSqlDB.connectToSqlDatabase();
            System.out.println("You're about to register a new employee into the database \nPlease provide ID: ");
            int inputId = stdin.nextInt();
            System.out.println("Please provide Name of Employee: ");
            String inputName = stdin.next();
            System.out.println("Please provide Salary of Employee: ");
            int inputSalary = stdin.nextInt();
            System.out.println("Please provide what department this Employee belongs to: ");
            String inputDepartment = stdin.next();
            while ( (!inputDepartment.equals("Executive")) && (!inputDepartment.equals("Development")) &&
                    (!inputDepartment.equals("Accounting")) && (!inputDepartment.equals("Human_Resources")) )
            {
                System.out.println("Please Enter a Valid Department");
                inputDepartment = stdin.next();
            }
            stdin.close();

            ConnectToSqlDB.ps = ConnectToSqlDB.connect.prepareStatement("INSERT INTO employees (employee_id, employee_name, employee_salary, department) VALUES ('"
            + inputId + "', '" + inputName + "', '" + inputSalary + "', '" + inputDepartment + "');");
            ConnectToSqlDB.ps.executeUpdate();

            System.out.println("Employee Registered Successfully!! \n" + inputName + " (ID: " + inputId + "), from the " + inputDepartment + " Department, with a salary of " +
                    inputSalary + ".");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
