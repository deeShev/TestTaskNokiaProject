package com.shevelev.nokia.tasks.fourthtask.employee;

public class Contributor extends Employee {

    public Contributor(Person person, boolean taxResidentCountry) {
        super(person, taxResidentCountry);
    }

    @Override
    public String toString() {
        return "Contributor{" + super.toString() +
                "}";
    }
}
