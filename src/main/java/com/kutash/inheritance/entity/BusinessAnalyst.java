package com.kutash.inheritance.entity;

import java.math.BigDecimal;
import java.util.List;

public class BusinessAnalyst extends Employee {

    private List<String> skills;
    private EnglishLevel englishLevel;
    private int yearsExperience;
    private boolean knowledgeOfProgramming;

    public BusinessAnalyst(String name, String surname, BigDecimal salary, Address address) {
        super(name, surname, salary, address);
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public EnglishLevel getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(EnglishLevel englishLevel) {
        this.englishLevel = englishLevel;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        BusinessAnalyst analyst = (BusinessAnalyst) o;

        return Double.compare(analyst.yearsExperience, yearsExperience) == 0 && (skills != null ? skills.equals(analyst.skills) : analyst.skills == null) && englishLevel == analyst.englishLevel;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (skills != null ? skills.hashCode() : 0);
        result = 31 * result + (englishLevel != null ? englishLevel.hashCode() : 0);
        temp = Double.doubleToLongBits(yearsExperience);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "BusinessAnalyst{" +
                "skills=" + skills +
                ", englishLevel=" + englishLevel +
                ", yearsExperience=" + yearsExperience +
                " " + super.toString();
    }
}
