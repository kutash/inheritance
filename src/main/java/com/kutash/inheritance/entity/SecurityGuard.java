package com.kutash.inheritance.entity;

import java.math.BigDecimal;

public class SecurityGuard extends Employee{

    private int yearsExperience;
    private boolean militaryService;

    public SecurityGuard(String name, String surname, BigDecimal salary, Address address) {
        super(name, surname, salary, address);
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public boolean isMilitaryService() {
        return militaryService;
    }

    public void setMilitaryService(boolean militaryService) {
        this.militaryService = militaryService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SecurityGuard that = (SecurityGuard) o;

        return yearsExperience == that.yearsExperience && militaryService == that.militaryService;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + yearsExperience;
        result = 31 * result + (militaryService ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SecurityGuard{" +
                "yearsExperience=" + yearsExperience +
                ", militaryService=" + militaryService +
                "} " + super.toString();
    }
}
