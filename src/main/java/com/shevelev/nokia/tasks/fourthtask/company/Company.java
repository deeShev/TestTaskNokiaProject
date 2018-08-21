package com.shevelev.nokia.tasks.fourthtask.company;

import com.shevelev.nokia.tasks.fourthtask.employee.Employee;

import java.util.LinkedList;
import java.util.List;

public class Company {
    private String nameCompany;
    private List<Employee> staff = new LinkedList<>();

    public Company(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public List<Employee> getStaff() {
        return staff;
    }

    @Override
    public String toString() {
        return "Company{" +
                "nameCompany='" + nameCompany + '\'' +
                ", staff=" + staff +
                '}';
    }
}
