package com.shevelev.nokia.tasks.fifthtask;

import com.shevelev.nokia.tasks.fifthtask.service.InfoService;
import com.shevelev.nokia.tasks.fourthtask.employee.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {
    @Mock
    private InfoService mockInfoService;

    @InjectMocks
    private HomeController homeController;

    @Test
    public void home() {
        when(mockInfoService.getInfoEmployee(any(Employee.class)))
                .thenReturn("Boss{Employee{person=Person{name='Denis', surname='Shevelev', age=24}, wage=5, taxResidentCountry=true}directReports=[]}");
        ResponseEntity<String> resp = homeController.home("Denis","Shevelev",24,true);
        assertEquals(200, resp.getStatusCodeValue());
        assertEquals("Boss{Employee{person=Person{name='Denis', surname='Shevelev', age=24}, wage=5, taxResidentCountry=true}directReports=[]}", resp.getBody());
    }
}
