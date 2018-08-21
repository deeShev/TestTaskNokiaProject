package com.shevelev.nokia.tasks.fifthtask;

import com.shevelev.nokia.tasks.fifthtask.service.InfoService;
import com.shevelev.nokia.tasks.fourthtask.employee.Employee;
import com.shevelev.nokia.tasks.fourthtask.employee.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
    private final InfoService infoService;

    @Autowired
    public HomeController(InfoService infoService) {
        this.infoService = infoService;
    }

    //http://localhost:8080/?name=Denis&surname=Shevelev&age=24&taxResidentCountry=true
    @GetMapping("/")
    public ResponseEntity<String> home(@RequestParam("name") String name,
                               @RequestParam("surname") String surname,
                               @RequestParam("age") int age,
                               @RequestParam("taxResidentCountry") boolean taxResidentCountry){

        Employee employee = new Employee(new Person(name, surname, age), taxResidentCountry);
        String resp = infoService.getInfoEmployee(employee);
        if (resp != null){
            return new ResponseEntity<>(resp,HttpStatus.OK);
        }else {
            LOG.info("There is no such employee:" + employee);
            return new ResponseEntity<>("There is no such employee!", HttpStatus.NOT_FOUND);
        }
    }
}
