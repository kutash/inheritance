package com.kutash.inheritance.action;

import com.kutash.inheritance.entity.Employee;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;


public class EmployeeAction {

    private static final Logger LOGGER = LogManager.getLogger();

    public List<Employee> sortBySalary(List<Employee> employees){

        LOGGER.log(Level.INFO,"sorting employees by salary");

        employees.sort(Comparator.comparing(Employee::getSalary));
        return employees;
    }

    public List<Employee> sortBySalaryAndBySurname(List<Employee> employees){

        LOGGER.log(Level.INFO,"sorting employees by salary and by name");

        employees.sort(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getSurname));
        return employees;
    }

    public Employee findByRangeOfSalary(List<Employee> employees, BigDecimal start, BigDecimal finish){

        LOGGER.log(Level.INFO,"finding an employee for a given range of salaries");

        return employees.stream().filter(emp -> emp.getSalary().compareTo(start)>=0 && emp.getSalary().compareTo(finish)<=0).findFirst().orElse(null);
    }

    public BigDecimal calculateTeamCost(List<Employee> developers,int workingDays,int vocationDays){

        LOGGER.log(Level.INFO,"calculate the cost of the development team");

        double workingHoursPerMonth = (workingDays-vocationDays)/12*8;
        return developers.stream().map(dev -> dev.getSalary().divide(new BigDecimal(workingHoursPerMonth),BigDecimal.ROUND_CEILING)).reduce(BigDecimal::add).orElse(new BigDecimal(0.0));
    }
}
