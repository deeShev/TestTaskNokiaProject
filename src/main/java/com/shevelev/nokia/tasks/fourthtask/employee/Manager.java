package com.shevelev.nokia.tasks.fourthtask.employee;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
    //в задании было Менеджеры имеют непосредственного подчиненого (managers or individual contributors).
    // Managers have direct reports (managers or individual contributors)
    private List<Employee> directReports = new ArrayList<>();

    public Manager(Person person, boolean taxResidentCountry) {
        super(person, taxResidentCountry);
    }

    public List<Employee> getDirectReports() {
        return directReports;
    }

    public void setDirectReports(List<Employee> directReports) {
        this.directReports = directReports;
    }

    @Override
    public String toString() {
        return "Manager{" + super.toString() +
                "directReports=" + directReports +
                '}';
    }
}
