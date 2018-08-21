package com.shevelev.nokia.tasks.fourthtask.company;

import com.shevelev.nokia.tasks.fourthtask.employee.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

enum HierarchyOfPostsInCompanyDeeShev {
    Intern,
    Contributor,
    Manager,
    DeputyBoss,
    Boss
}

public class DeeShevFuncCompany extends Company implements FuncCompany {
    private static final Logger LOG = LoggerFactory.getLogger(DeeShevFuncCompany.class);
    private HierarchyOfPostsInCompanyDeeShev[] hierarchyOfPosts = HierarchyOfPostsInCompanyDeeShev.values();

    public DeeShevFuncCompany(String nameCompany) {
        super(nameCompany);
    }

    /**
     * INFO [Separated the method of establishing wages from the Employee class,
     * since every company has a pile of policy and a salary gradation.]
     * <p>
     * Wage setup procedure
     *
     * @param employee    workman
     * @param integerWage wage
     */
    public void setWage(Employee employee, int integerWage, boolean updateStaff) {
        if (integerWage > 0 && integerWage < 11) {
            if (!updateStaff) {
                if (employee.isTaxResidentCountry()) {
                    int wage = integerWage + 1;
                    if (wage < 11) {
                        employee.setWage(wage);
                    } else {
                        employee.setWage(10);
                    }
                } else {
                    employee.setWage(integerWage);
                }
            } else {
                employee.setWage(integerWage);
            }
        } else {
            LOG.info("You went beyond wages! Wages framework 1- 10!");
        }
    }

    public void addDirectReports(Manager manager, Employee subordinate) {
        if (subordinate.getClass() == Manager.class || subordinate.getClass() == Contributor.class) {
            if (manager.getWage() >= subordinate.getWage()) {
                manager.getDirectReports().add(subordinate);
            } else {
                LOG.info("Pay grades of direct reports shall not exceed grade of  manager!");
            }
        } else {
            LOG.info("A manager can have subordinates or managers, or contributor!");
        }
    }


    @Override
    public void addEmployee(Employee employee, int integerWage, boolean updateStaff) {
        this.setWage(employee, integerWage, updateStaff);
        this.getStaff().add(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        if (this.getStaff().contains(employee)) {
            this.getStaff().remove(employee);
        } else {
            LOG.info("This employee: " + employee + " not in staff company!");
        }
    }

    @Override
    public void promotion(Employee employee) {
        String className = employee.getClass().getSimpleName();

        for (int i = 0; i < hierarchyOfPosts.length; i++) {

            if (hierarchyOfPosts[i].toString().equals(className)) {

                if (i != hierarchyOfPosts.length - 1) {
                    String newPost = hierarchyOfPosts[++i].toString();

                    if (newPost.equals(Contributor.class.getSimpleName())) {
                        Contributor newPostEmp = new Contributor(employee.getPerson(), employee.isTaxResidentCountry());
                        this.deleteEmployee(employee);
                        this.addEmployee(newPostEmp, employee.getWage(), true);
                        break;
                    } else if (newPost.equals(Manager.class.getSimpleName())) {
                        Manager newPostEmp = new Manager(employee.getPerson(), employee.isTaxResidentCountry());
                        this.deleteEmployee(employee);
                        this.addEmployee(newPostEmp, employee.getWage(), true);
                        break;
                    } else if (newPost.equals(DeputyBoss.class.getSimpleName())) {
                        DeputyBoss newPostEmp = new DeputyBoss(employee.getPerson(), employee.isTaxResidentCountry());
                        newPostEmp.setDirectReports(((Manager) employee).getDirectReports());
                        this.deleteEmployee(employee);
                        this.addEmployee(newPostEmp, employee.getWage(), true);
                        break;
                    } else if (newPost.equals(Boss.class.getSimpleName())) {
                        Boss newPostEmp = new Boss(employee.getPerson(), employee.isTaxResidentCountry());
                        newPostEmp.setDirectReports(((DeputyBoss) employee).getDirectReports());
                        this.deleteEmployee(employee);
                        this.addEmployee(newPostEmp, employee.getWage(), true);
                        break;
                    }
                } else {
                    LOG.info("This employee: " + employee + "! You are already the boss!");
                }
            }
        }
    }

    @Override
    public void increaseOfWages(Employee employee, Integer wage) {
        this.setWage(employee, wage, true);
    }

    @Override
    public String infoEmployee(Employee employee) {
        String info = "";
        if (this.getStaff().contains(employee)){
            for (int i = 0; i < this.getStaff().size(); i++){
                if (this.getStaff().get(i).equals(employee)){
                    Employee foundEmp = this.getStaff().get(i);
                    info = foundEmp.toString();
                }
            }
        }else {
            LOG.info("There is no such employee! " + employee);
        }
        return info;
    }
}
