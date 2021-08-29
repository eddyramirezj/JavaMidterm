package design;

import databases.ConnectToSqlDB;
import databases.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 /*
    This class should implement the Employee interface. You can do that by directly implementing it, however you must
        also implement the Employee interface into an abstract class. So create an Abstract class then inherit that
        abstract class into this EmployeeInfo class. Once you're done with designing EmployeeInfo class,
        go to FortuneEmployee class to apply all the fields and attributes.

    Important: YOU MUST USE:
        - OOP (Abstraction, Encapsulation, Inheritance and Polymorphism) concepts in every level possible.
        - Use all kind of keywords (super, this, static, final, etc)
        - Implement nested class below (DateConversion)
        - Use Exception Handling

Make sure to declare and use static, non-static & final fields
 */

public class EmployeeInfo implements Employee {

    static final String COMPANY_NAME = "EddyTech";
    public enum Department {Executive, Development, Accounting, Human_Resources}
    public int employeeId;
    public String employeeName;
    public int employeeSalary;

    /*
     You must implement the logic for below 2 methods and
        following 2 methods are prototype as well for other methods need to be design,
        as you will come up with the new ideas.
     */

    public EmployeeInfo(int employeeId) {
        this.employeeId = employeeId;
    }

    public EmployeeInfo(int employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public EmployeeInfo(int employeeId, String employeeName, int employeeSalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
    }

    public EmployeeInfo(int employeeId, String employeeName, int employeeSalary, Department department) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;}

    public int employeeId(String employeeName) {
        return 0;
    }

    public String employeeName(int employeeId) {
        return null;
    }

    public int employeeSalary(int employeeId) {

        int actualSalaryOfEmployee = 0;

        try {
            Connection conn = ConnectToSqlDB.connectToSqlDatabase();
            String query = "SELECT * FROM employees;";

            ConnectToSqlDB.statement = conn.createStatement();

            ConnectToSqlDB.resultSet = ConnectToSqlDB.statement.executeQuery(query);

            while (ConnectToSqlDB.resultSet.next()) {
                int idField = ConnectToSqlDB.resultSet.getInt("employee_id");
                String nameField = ConnectToSqlDB.resultSet.getString("employee_name");
                String salaryField = ConnectToSqlDB.resultSet.getString("employee_salary");
                String departmentField = ConnectToSqlDB.resultSet.getString("department");

                    if (idField == employeeId) {
                    actualSalaryOfEmployee = Integer.valueOf(salaryField);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return actualSalaryOfEmployee;
//
    }

    public Department employeeDepartment(int employeeId) {
        return null;
    }

        //TO TRANSFER AN EMPLOYEE TO ANOTHER DEPARTMENT WITH EMPLOYEE ID:
    public void assignDepartment() {

        Scanner stdin = new Scanner(System.in);
        try {
            ConnectToSqlDB.connectToSqlDatabase();
            System.out.println("You're about to transfer an employee to another Department \nPlease state ID of employee: ");
            String inputEmployeeId = stdin.next();
            System.out.println("Please state the employee's new department: ");
            String inputDepartment = stdin.next();

            while ( (!inputDepartment.equals("Executive")) && (!inputDepartment.equals("Development")) &&
                    (!inputDepartment.equals("Accounting")) && (!inputDepartment.equals("Human_Resources")) )
            {
                System.out.println("Please Enter a Valid Department");
                inputDepartment = stdin.next();
            }
            stdin.close();

            ConnectToSqlDB.ps = ConnectToSqlDB.connect.prepareStatement("UPDATE employees SET department = '" + inputDepartment + "' WHERE employee_id = '" +
                    inputEmployeeId + "';");
            ConnectToSqlDB.ps.executeUpdate();

            System.out.println("Employee ID#" + inputEmployeeId + " is now a part of the " + inputDepartment + "Department.");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

        //A COLLECTION OF DIFFERENT BENEFITS TO BE CALCULATED:
    public void benefitLayout() {
        Scanner stdin = new Scanner(System.in);
        System.out.println("Please state which benefit to check (Bonus or Pension): ");
        String benefitToCheck = stdin.next();

        while ((!benefitToCheck.equals("Pension")) && (!benefitToCheck.equals("Bonus"))) {
            System.out.println("Please state which benefit to check (Bonus or Pension): ");
            benefitToCheck = stdin.next();
        }

        if (benefitToCheck.equals("Pension")) {
            System.out.println("Please state Employee ID: ");
            calculateEmployeePension(employeeSalary(stdin.nextInt()));
        }
        if (benefitToCheck.equals("Bonus")) {
            System.out.println("Please state Employee ID: ");
            calculateEmployeeBonus(employeeSalary(stdin.nextInt()), 0, null);
        }
        stdin.close();
    }

          // TO CALCULATE EMPLOYEE BONUS BASED ON PERFORMANCE:
    public static double calculateEmployeeBonus(int employeeSalary, int numberOfYearsWithCompany, String employeePerformance) {
        double total = 0;

        try {
            Scanner stdin = new Scanner(System.in);
            System.out.println("Please enter start date in format (example: May,2015): ");
            String joiningDate = stdin.nextLine();
            System.out.println("Please enter today's date in format (example: August,2017): ");
            String todayDate = stdin.nextLine();
            String convertedJoiningDate = DateConversion.convertDate(joiningDate);
            String convertedTodayDate = DateConversion.convertDate(todayDate);

            String[] actualDateToday = convertedTodayDate.split("/");
            String[] actualJoiningDate = convertedJoiningDate.split("/");

            numberOfYearsWithCompany = Integer.valueOf(actualDateToday[1]) - Integer.valueOf(actualJoiningDate[1]);

            if (Integer.valueOf(actualJoiningDate[0]) > Integer.valueOf(actualDateToday[0])) {
                numberOfYearsWithCompany--;
            }

            System.out.println("Please enter this year's performance, as indicated by HR: ");
            employeePerformance = stdin.nextLine();
            stdin.close();

            if (numberOfYearsWithCompany >= 1) {
                if (employeePerformance.equals("Excellent")) {
                    total = (employeeSalary * 0.15);
                } else if (employeePerformance.equals("Good")) {
                    total = (employeeSalary * 0.10);
                } else if (employeePerformance.equals("Average")) {
                    total = (employeeSalary * 0.05);
                } else if (employeePerformance.equals("Bad")) {
                    total = 0;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("This will be the yearly bonus for this Employee's performance: " + total);
        return total;
    }

        //CALCULATES THE TOTAL PENSION TO RECEIVE BY EMPLOYEE BASED ON START DATE AND SALARY:
    public static double calculateEmployeePension(int employeeSalary) {
        double total = 0;
        try {
            Scanner stdin = new Scanner(System.in);

            System.out.println("Please enter start date in format (example: May,2015): ");
            String joiningDate = stdin.nextLine();
            System.out.println("Please enter today's date in format (example: August,2017): ");
            String todayDate = stdin.nextLine();
            String convertedJoiningDate = DateConversion.convertDate(joiningDate);
            String convertedTodayDate = DateConversion.convertDate(todayDate);
            stdin.close();
            String[] actualDateToday = convertedTodayDate.split("/");
            String[] actualJoiningDate = convertedJoiningDate.split("/");

            Integer yearsEmployed = Integer.valueOf(actualDateToday[1]) - Integer.valueOf(actualJoiningDate[1]);

            if ( Integer.valueOf(actualJoiningDate[0]) > Integer.valueOf(actualDateToday[0]) ) {
                yearsEmployed--;
            }

            total = (((employeeSalary * 12) * 0.05) * yearsEmployed);




        System.out.println("Total pension to receive by employee based on " + yearsEmployed + " years with the company " +
                "(5% of yearly salary for each year, based on a monthly salary of $" + employeeSalary + "): " + total);

        }
        catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return total;
    }

        //CONVERTS STRING MONTHS TO INT:
    public static class DateConversion {

        Months months;

        public DateConversion(Months months) {
            this.months = months;
        }

        public static String convertDate(String date) {
            String[] extractMonth = date.split(",");
            String givenMonth = extractMonth[0];
            int monthDate = whichMonth(givenMonth);
            String actualDate = monthDate + "/" + extractMonth[1];
            return actualDate;
        }

        public static int whichMonth(String givenMonth) {
            Months months = Months.valueOf(givenMonth);
            int date;
            switch (months) {
                case January:
                    date = 1;
                    break;
                case February:
                    date = 2;
                    break;
                case March:
                    date = 3;
                    break;
                case April:
                    date = 4;
                    break;
                case May:
                    date = 5;
                    break;
                case June:
                    date = 6;
                    break;
                case July:
                    date = 7;
                    break;
                case August:
                    date = 8;
                    break;
                case September:
                    date = 9;
                    break;
                case October:
                    date = 10;
                    break;
                case November:
                    date = 11;
                    break;
                case December:
                    date = 12;
                    break;
                default:
                    date = 0;
                    break;
            }
            return date;

        }
    }
}
