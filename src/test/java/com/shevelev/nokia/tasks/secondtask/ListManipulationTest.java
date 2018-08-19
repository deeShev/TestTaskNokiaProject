package com.shevelev.nokia.tasks.secondtask;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListManipulationTest {
    private ListManipulation listManipulation;
    private List<Person> testList;

    @Before
    public void setUp() {
        listManipulation = new ListManipulation();
        testList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            testList.add(new Person("Denis", i));
        }
        for (int i = 2; i < 5; i++) {
            testList.add(new Person("Denis Sh", i));
        }
        for (int i = 5; i < 7; i++) {
            testList.add(new Person("Denis", i));
        }
    }

    @Test
    public void createListPerson() {
        List<Person> resultTest = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            resultTest.add(new Person("Denis", i));
        }
        for (int i = 2; i < 5; i++) {
            resultTest.add(new Person("Denis Sh", i));
        }
        for (int i = 5; i < 6; i++) {
            resultTest.add(new Person("Denis", i));
        }

        List<Person> listPerson = listManipulation.createListPerson(testList);

        Assert.assertEquals(resultTest, listPerson);
    }

    @Test
    public void calcNumberPersons() {
        Map<Integer, Integer> resultTest = new HashMap<>();
        resultTest.put(0, 1);
        resultTest.put(1, 1);
        resultTest.put(2, 2);
        resultTest.put(3, 2);
        resultTest.put(4, 2);
        resultTest.put(5, 1);
        resultTest.put(6, 1);

        Assert.assertEquals(resultTest, listManipulation.calcNumberPersons(testList));
    }
}
