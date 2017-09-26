package com.kutash.inheritance.entity;

import java.math.BigDecimal;
import java.util.List;

public class Developer extends Employee {

    private List<String> technologies;
    private Rank rank;
    private EnglishLevel englishLevel;

    public Developer(String name, String surname, BigDecimal salary, Address address) {
        super(name, surname, salary, address);
    }

    public List<String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<String> technologies) {
        this.technologies = technologies;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public EnglishLevel getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(EnglishLevel englishLevel) {
        this.englishLevel = englishLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Developer developer = (Developer) o;

        return (technologies != null ? technologies.equals(developer.technologies) : developer.technologies == null) && rank == developer.rank && englishLevel == developer.englishLevel;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (technologies != null ? technologies.hashCode() : 0);
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        result = 31 * result + (englishLevel != null ? englishLevel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "technologies=" + technologies +
                ", rank=" + rank +
                ", englishLevel=" + englishLevel +
                " " + super.toString();
    }
}
