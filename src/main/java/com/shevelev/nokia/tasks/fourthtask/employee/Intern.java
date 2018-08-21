package com.shevelev.nokia.tasks.fourthtask.employee;

public class Intern extends Employee {

    public Intern(Person person, boolean taxResidentCountry) {
        super(person, taxResidentCountry);
    }

    @Override
    public String toString() {
        return "Intern{" + super.toString() +
                "}";
    }
}
