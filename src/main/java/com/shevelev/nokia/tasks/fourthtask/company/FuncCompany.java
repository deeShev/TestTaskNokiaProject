package com.shevelev.nokia.tasks.fourthtask.company;

import com.shevelev.nokia.tasks.fourthtask.employee.Employee;

public interface FuncCompany {
    void addEmployee(Employee employee, int wage, boolean updateStaff);
    void deleteEmployee(Employee employee);
    void promotion(Employee employee);
    void increaseOfWages(Employee employee, Integer wage);
    String infoEmployee(Employee employee);
}