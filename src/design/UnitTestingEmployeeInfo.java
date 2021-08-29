package design;

import java.util.Scanner;

public class UnitTestingEmployeeInfo{

    public static void main(String[] args) {
        // Use this class to write unit tests for all user-defined methods that you have implemented in this package.

        Scanner stdin = new Scanner(System.in);
     EmployeeInfo employee1 = new EmployeeInfo(101);


        System.out.println(employee1.employeeSalary(stdin.nextInt()));



    }
}
