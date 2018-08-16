package com.shevelev.nokia.tasks.firsttast;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class CalcNumberWordsTest {
    private CalcNumberWords calcNumberWords;
    private Map<Integer, List<String>> testResult;

    @Before
    public void setUp() {
        calcNumberWords = new CalcNumberWords();
        testResult = new HashMap<>();
        List<String> string1 = new ArrayList<>(Arrays.asList("I"));
        List<String> string2 = new ArrayList<>(Arrays.asList("to","at"));
        List<String> string4 = new ArrayList<>(Arrays.asList("want","work"));
        List<String> string5 = new ArrayList<>(Arrays.asList("Nokia"));
        testResult.put(1, string1);
        testResult.put(2, string2);
        testResult.put(4, string4);
        testResult.put(5, string5);
    }

    @Test
    public void calcWords() {
        String testStr = "I want to work at Nokia.";
        Map<Integer, List<String>> resultOfTestStr = calcNumberWords.calcWords(testStr);
        assertEquals(testResult, resultOfTestStr);
    }
}
