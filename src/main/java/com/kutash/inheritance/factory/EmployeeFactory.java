package com.kutash.inheritance.factory;

import com.kutash.inheritance.entity.*;
import com.kutash.inheritance.exception.EmployeeTypeNotFoundException;

import java.math.BigDecimal;

public class EmployeeFactory {

    public Employee getEmployee(String employeeType, String name, String surname, BigDecimal salary, Address address) throws EmployeeTypeNotFoundException {

        if (employeeType == null){
            throw new EmployeeTypeNotFoundException("this type of employee does not exist");
        }

        Employee employee;

        switch (employeeType) {
            case "developer":
                employee = new Developer(name,surname,salary,address);
                break;
            case "analyst":
                employee = new BusinessAnalyst(name,surname,salary,address);
                break;
            case "guard":
                employee = new SecurityGuard(name,surname,salary,address);
                break;
            default:
                throw new EmployeeTypeNotFoundException("this type of employee does not exist");
        }
        return employee;
    }
}
