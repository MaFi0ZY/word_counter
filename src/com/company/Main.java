package com.company;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String[] str = {""};
        if (!isArrayOfStringsValid(str)) {
            System.out.println("Array of strings contains empty strings");
        } else  {
            wordCounter(str);
        }
    }

    private static void wordCounter(String[] str) {
        String line = Arrays.stream(str)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        assert line != null;
        long word = Arrays.stream(line.split(" ")).count();
        System.out.println("The most popular line is: " + line);
        System.out.print("The number of words in this line is: " + word);
    }
    private static boolean isArrayOfStringsValid(String[] str) {
        boolean isValid = true;
        for (String tmp : str) {
            if (tmp == null || tmp.trim().equals("")) {
                isValid = false;
            }
        }
        return isValid;
    }
}
