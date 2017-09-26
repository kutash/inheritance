package com.kutash.inheritance;

import com.kutash.inheritance.creator.EmployeeCreator;
import com.kutash.inheritance.entity.Employee;
import com.kutash.inheritance.exception.EmployeeException;
import com.kutash.inheritance.exception.EmployeeTypeNotFoundException;
import com.kutash.inheritance.exception.ReadingException;
import com.kutash.inheritance.parser.StringParser;
import com.kutash.inheritance.reader.DataReader;

import java.util.List;

public class Main {

    public static void main(String args[]) throws ReadingException, EmployeeException, EmployeeTypeNotFoundException {
        List<String> list = new DataReader().read("in.txt");
        List<String[][]> valid = new StringParser().parseString(list);

        List<Employee> developers = new EmployeeCreator().createSecurityGuard(valid);
        developers.forEach(System.out::println);
        /*long start = System.currentTimeMillis();
        System.out.println(new EmployeeAction().calculateTeamCost(developers, 247,20));
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);*/

    }
}
