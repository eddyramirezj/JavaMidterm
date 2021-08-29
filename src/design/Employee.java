package design;

public interface Employee {

	/*
	Employee is an Interface which contains multiple unimplemented methods.
	A few methods have been declared below. You need to come up with more methods to meet business requirements of this
	    application
	*/

    /*
     Please read the following methods and understand the business requirements of these following methods
        and then implement these in a concrete class.
     */

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
