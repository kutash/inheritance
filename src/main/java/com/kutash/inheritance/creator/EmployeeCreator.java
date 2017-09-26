package com.kutash.inheritance.creator;

import com.kutash.inheritance.entity.*;
import com.kutash.inheritance.exception.EmployeeException;
import com.kutash.inheritance.exception.EmployeeTypeNotFoundException;
import com.kutash.inheritance.factory.EmployeeFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeCreator {

    private static final Logger LOGGER = LogManager.getLogger();
    private EmployeeFactory factory = new EmployeeFactory();

    public List<Employee> createDeveloper(List<String[][]> data) throws EmployeeException, EmployeeTypeNotFoundException {

        LOGGER.log(Level.INFO,"creating developer");

        if (data == null){
            throw new EmployeeException("no data to create object");
        }
        List<Employee> developers = new ArrayList<>();
        for (String[][] line : data){
            Developer developer = (Developer) factory.getEmployee("developer",line[0][0],line[0][1],new BigDecimal(line[0][2]),setAddress(line[0]));
            developer.setEnglishLevel(EnglishLevel.valueOf(line[0][8]));
            developer.setRank(Rank.valueOf(line[0][9]));
            List<String> technologies = new ArrayList<>();
            Collections.addAll(technologies, line[1]);
            developer.setTechnologies(technologies);
            developers.add(developer);
        }
        return developers;
    }

    public List<Employee> createAnalyst(List<String[][]> data) throws EmployeeException, EmployeeTypeNotFoundException {

        LOGGER.log(Level.INFO,"creating analyst");

        if (data == null){
            throw new EmployeeException("no data to create object");
        }
        List<Employee> analysts = new ArrayList<>();
        for (String[][] line : data){
            BusinessAnalyst analyst = (BusinessAnalyst) factory.getEmployee("analyst",line[0][0],line[0][1],new BigDecimal(line[0][2]),setAddress(line[0]));
            analyst.setEnglishLevel(EnglishLevel.valueOf(line[0][8]));
            analyst.setYearsExperience(Integer.parseInt(line[0][9]));
            List<String> skills = new ArrayList<>();
            Collections.addAll(skills, line[1]);
            analyst.setSkills(skills);
            analysts.add(analyst);
        }
        return analysts;
    }

    public List<Employee> createSecurityGuard(List<String[][]> data) throws EmployeeException, EmployeeTypeNotFoundException {

        LOGGER.log(Level.INFO,"creating security guard");

        if (data == null){
            throw new EmployeeException("no data to create object");
        }
        List<Employee> guards = new ArrayList<>();
        for (String[][] line : data){
            SecurityGuard securityGuard = (SecurityGuard) factory.getEmployee("guard",line[0][0],line[0][1],new BigDecimal(line[0][2]),setAddress(line[0]));
            securityGuard.setYearsExperience(Integer.parseInt(line[0][8]));
            securityGuard.setMilitaryService(Boolean.parseBoolean(line[0][9]));
            guards.add(securityGuard);
        }
        return guards;
    }

    private Address setAddress(String[] line){

        LOGGER.log(Level.INFO,"creating address");

        String country = line[3];
        String city = line[4];
        String street = line[5];
        String house = line[6];
        String flat = line[7];
        return new Address(country,city,street,house,flat);
    }
}
