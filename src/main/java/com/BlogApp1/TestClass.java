package com.BlogApp1;

import java.util.function.Predicate;

public class TestClass {
    public static void main(String[] args) {
        //INTEGER
        Predicate<Integer> result = n -> n%2 != 0;
        boolean val = result.test(101);
        System.out.println(val);

        //STRING
        Predicate<String> results = str -> str.startsWith("S");
        boolean values = results.test("Smriti");
        System.out.println(values);

        //String -endswith
        Predicate<String> res = str -> str.endsWith("S");
        boolean val1 = res.test("Smriti");
        System.out.println(val1);

        //String - equals
        Predicate<String> res1 = str ->str.equalsIgnoreCase("smriti");
        boolean val2 = res1.test("Smriti");
        System.out.println(val2);
        //String
        Predicate<String> res2 = str ->str.equals("smriti");
        boolean val3 = res2.test("Smriti");
        System.out.println(val3);
    }
}
