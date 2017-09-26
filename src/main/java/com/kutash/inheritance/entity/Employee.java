package com.kutash.inheritance.entity;

import java.math.BigDecimal;

public abstract class Employee {

    private String name;
    private String surname;
    private BigDecimal salary;
    private Address address;

    Employee(){}

    Employee(String name, String surname, BigDecimal salary, Address address) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return (name != null ? name.equals(employee.name) : employee.name == null) && (surname != null ? surname.equals(employee.surname) : employee.surname == null) && (salary != null ? salary.equals(employee.salary) : employee.salary == null) && (address != null ? address.equals(employee.address) : employee.address == null);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", address: " + address;
    }
}
