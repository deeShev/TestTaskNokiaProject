package com.shevelev.nokia.tasks.fourthtask.company;

import com.shevelev.nokia.tasks.fourthtask.employee.Manager;
import com.shevelev.nokia.tasks.fourthtask.employee.Person;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeeShevFuncCompanyTest {
    DeeShevFuncCompany deeShev;

    @Before
    public void setUp() {
        deeShev = new DeeShevFuncCompany("deeShev");
    }

    @Test
    public void setWage() {
        Manager manager = new Manager(new Person("denis", "shevelev", 24), true);
        deeShev.setWage(manager,4,true);
        assertEquals(4,manager.getWage());
    }

    @Test
    public void addDirectReports() {
        Manager manager = new Manager(new Person("denis", "shevelev", 24), true);
        deeShev.addEmployee(manager, 4, true);
        deeShev.addDirectReports(manager, new Manager(new Person("Vasia", "Pupkin", 24), true));
        assertEquals("Vasia",manager.getDirectReports().get(0).getPerson().getName());
    }

    @Test
    public void addEmployee() {
        Manager manager = new Manager(new Person("denis", "shevelev", 24), true);
        deeShev.addEmployee(manager, 4, true);
        assertEquals("denis",deeShev.getStaff().get(0).getPerson().getName());
    }

    @Test
    public void deleteEmployee() {
        Manager manager = new Manager(new Person("denis", "shevelev", 24), true);
        deeShev.addEmployee(manager, 4, true);
        assertEquals("denis",deeShev.getStaff().get(0).getPerson().getName());
        deeShev.deleteEmployee(manager);
        assertEquals(0,deeShev.getStaff().size());
    }

    @Test
    public void promotion() {
        Manager manager = new Manager(new Person("denis", "shevelev", 24), true);
        deeShev.addEmployee(manager, 4, true);
        assertEquals("Manager",deeShev.getStaff().get(0).getClass().getSimpleName());
        deeShev.promotion(manager);
        assertEquals("DeputyBoss",deeShev.getStaff().get(0).getClass().getSimpleName());
    }

    @Test
    public void increaseOfWages() {
        Manager manager = new Manager(new Person("denis", "shevelev", 24), true);
        deeShev.addEmployee(manager, 4, true);
        assertEquals(4,deeShev.getStaff().get(0).getWage());
        deeShev.increaseOfWages(manager,6);
        assertEquals(6,deeShev.getStaff().get(0).getWage());
    }

}
