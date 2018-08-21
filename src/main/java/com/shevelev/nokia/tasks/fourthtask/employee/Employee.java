package com.shevelev.nokia.tasks.fourthtask.employee;

import java.util.Objects;

public class Employee {
    private Person person;
    private int wage;
    private boolean taxResidentCountry;

    public Employee(Person person, boolean taxResidentCountry) {
        this.person = person;
        this.taxResidentCountry = taxResidentCountry;
    }

    public Person getPerson() {
        return person;
    }

    public boolean isTaxResidentCountry() {
        return taxResidentCountry;
    }

    public void setTaxResidentCountry(boolean taxResidentCountry) {
        this.taxResidentCountry = taxResidentCountry;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return taxResidentCountry == employee.taxResidentCountry &&
                Objects.equals(person, employee.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, taxResidentCountry);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "person=" + person +
                ", wage=" + wage +
                ", taxResidentCountry=" + taxResidentCountry +
                '}';
    }
}
