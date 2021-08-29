package design;

import databases.ConnectToSqlDB;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class FortuneEmployee extends EmployeeInfo {

    public FortuneEmployee(int employeeId) {
        super(employeeId);
    }

    public FortuneEmployee(int employeeId, String employeeName) {
        super(employeeId, employeeName);
    }

    public FortuneEmployee(int employeeId, String employeeName, int employeeSalary) {
        super(employeeId, employeeName, employeeSalary);
    }

    public FortuneEmployee(int employeeId, String employeeName, int employeeSalary, Department department) {
        super(employeeId, employeeName, employeeSalary, department);
    }

       public static void main(String[] args) {

        humanResourcesPortal();

    }
        ///MAIN METHOD WILL CALL THIS METHOD TO RUN THE APPLICATION:
    public static void humanResourcesPortal() {
        EmployeeInfo user = new EmployeeInfo(1337);

        Scanner stdin = new Scanner(System.in);

        try {

                System.out.println("Welcome to " + COMPANY_NAME + "'s Human Resources Portal. \nPlease select one of the following options: ");
                System.out.println("Option a: Register New Employee. \nOption b: Retrieve ID, Name, Salary or Department. \nOption c: Department Transfer." +
                        " \nOption d: Verify Benefits.");
                System.out.print("Choose option (or Type \"Exit\" to exit): ");

                String userSelection = stdin.next();

                if (userSelection.equals("Exit")) {
                    System.exit(0);
                }

                while ((!userSelection.equals("a")) && (!userSelection.equals("b")) && (!userSelection.equals("c")) && (!userSelection.equals("d"))) {
                    System.out.println("Wrong selection. \nPlease select one of the following options: ");
                    System.out.println("Option a: Register New Employee. \nOption b: Retrieve ID, Name, Salary or Department. " +
                            "\nOption c: Department Transfer. \nOption d: Verify Benefits.");
                    System.out.print("Choose option (or Type \"Exit\" to exit): ");
                    userSelection = stdin.next();
                    if (userSelection.equals("Exit")) {
                        System.exit(0);
                    }
                }
                switch (userSelection) {
                    case "a":
                        registerNewEmployee();
                        break;
                    case "b":
                        System.out.println("Select information to retrieve: \n Option a: Employee ID. \n Option b: Employee Name. " +
                                "\n Option c: Employee Salary. \n Option d: Employee Department.");
                        System.out.print("Choose option (or Type \"Exit\" to exit): ");
                        String userSelection2 = stdin.next();

                        while ((!userSelection2.equals("a")) && (!userSelection2.equals("b")) && (!userSelection2.equals("c")) && (!userSelection2.equals("d"))) {
                            System.out.println("Wrong selection. \nPlease select one of the following options: ");
                            System.out.println(" Option a: Employee ID. \n Option b: Employee Department. " +
                                    "\n Option c: Employee Salary. \n Option d: Verify Benefits.");
                            System.out.print("Choose option (or Type \"Exit\" to exit): ");
                            userSelection2 = stdin.next();
                            if (userSelection2.equals("Exit")) {
                                System.exit(0);
                            }
                        }

                        if (userSelection2.equals("a")) {
                            System.out.print("Please provide name of employee (format: \"FirstName_LastName\"): ");
                            String userSelection3 = stdin.next();
                            System.out.println(user.employeeId(userSelection3));
                        }
                        if (userSelection2.equals("b")) {
                            System.out.print("Please provide ID of employee: ");
                            int userSelection3 = stdin.nextInt();
                            System.out.println(user.employeeName(userSelection3));
                        }
                        if (userSelection2.equals("c")) {
                            System.out.print("Please provide name of employee (format: \"FirstName_LastName\"): ");
                            String userSelection3 = stdin.next();
                            System.out.println(user.employeeSalary(userSelection3));
                        }
                        if (userSelection2.equals("d")) {
                            System.out.print("Please provide name of employee (format: \"FirstName_LastName\"): ");
                            String userSelection3 = stdin.next();
                            System.out.println(user.employeeDepartment(userSelection3));
                        }
                        break;
                    case "c":
                        user.assignDepartment();
                        break;
                    case "d":
                        user.benefitLayout();
                        break;
                    case "Exit":
                        System.exit(0);
                }

                System.out.println("Thank you for using" + COMPANY_NAME + "'s Human Resources Portal. " +
                        "\nYou are now exiting the portal...");
            System.exit(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

            //REGISTERS A NEW EMPLOYEE IN THE DATABASE:
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
