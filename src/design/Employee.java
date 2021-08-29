package design;

public interface Employee {



    // employeeId() will return employee id.
    int employeeId(String employeeName);

    //employeeName() will return employee name
    String employeeName(int employeeId);

    //employeeSalary() returns employee salary
    int employeeSalary(String employeeName);

    //employeeDepartment() returns employee department
    EmployeeInfo.Department employeeDepartment(String employeeName);

    //assignDepartment() will assign employee to a specific department
    void assignDepartment();

    //a layout of different employee benefit
    void benefitLayout();

}
