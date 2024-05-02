package com.cat.utils;

import org.testng.Assert;

import java.util.List;

public class VerificationUtils {

    public static void areEqual(String actual, String expected) {
        Assert.assertEquals(actual.toUpperCase(), expected.toUpperCase());
    }

    public static void contains(String str1, String str2) {
        Assert.assertTrue(str1.toUpperCase().contains(str2.toUpperCase()));
    }

    public static void isListInAlphabeticalOrder(List<String> list) {
        for (int i=0; i<list.size()-1;i++) {
            String current = list.get(i);
            String next = list.get(i+1);
            Assert.assertTrue(current.compareTo(next) > 0);
        }
    }
}
