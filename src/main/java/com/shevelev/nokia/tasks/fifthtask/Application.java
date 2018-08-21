package com.shevelev.nokia.tasks.fifthtask;

import com.shevelev.nokia.tasks.fourthtask.company.DeeShevFuncCompany;
import com.shevelev.nokia.tasks.fourthtask.employee.Boss;
import com.shevelev.nokia.tasks.fourthtask.employee.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
       SpringApplication.run(Application.class, args);
    }

    @Bean
    public DeeShevFuncCompany deeShevFuncCompany(){
        DeeShevFuncCompany deeShev = new DeeShevFuncCompany("deeShev");
        deeShev.addEmployee(new Boss(new Person("Denis", "Shevelev", 24),true),5,true);
        return deeShev;
    }
}
