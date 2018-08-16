package com.shevelev.nokia.tasks.firsttast;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class CalcNumberWords {
    private static final Logger LOG = LoggerFactory.getLogger(CalcNumberWords.class);

    public Map<Integer, List<String>> calcWords(String str) {
        Map<Integer, List<String>> result = new HashMap<>();
        List<String> listWords;

        if (str.length() != 0) {
            String[] arrWords = str.split("[^a-zA-Z]+");
            for (String word : arrWords) {
                if (result.keySet().contains(word.length())) {
                    listWords = result.get(word.length());
                    listWords.add(word);
                } else {
                    listWords = new ArrayList<>();
                    listWords.add(word);
                    result.put(word.length(), listWords);
                }
            }
        } else {
            LOG.info("String is empty!");
        }
        return result;
    }

    public void printStr(Map<Integer, List<String>> mapWords) {
        Set<Integer> sortedKey = new TreeSet<>(Integer::compareTo);
        sortedKey.addAll(mapWords.keySet());

        if (sortedKey.size() != 0) {
            for (Integer key : sortedKey) {
                System.out.println(mapWords.get(key).size() + " words of " + key + " letters");
            }
        }else {
            System.out.println("String is empty!");
        }
    }
}
