package com.shevelev.nokia.tasks.secondtask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toMap;

public class ListManipulation {
    private static final Logger LOG = LoggerFactory.getLogger(ListManipulation.class);

    public List<Person> createListPerson(List<Person> listPerson) {
        return listPerson.stream().filter(n -> ((listPerson.indexOf(n) + 1) % 5 != 0)).collect(toCollection(ArrayList::new));
    }

    public Map<Integer, Integer> calcNumberPersons(List<Person> listPerson) {
        return listPerson.stream().collect(toMap(Person::getAge, value -> 1, (integer, integer2) -> ++integer));
    }
}
