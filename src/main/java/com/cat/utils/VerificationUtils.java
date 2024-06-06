package com.cat.utils;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class VerificationUtils {

    public static void areEqual(String actual, String expected) {
        Assert.assertEquals(actual.toUpperCase(), expected.toUpperCase(), actual + "string is not equal to " + expected + "!");
    }

    public static void contains(String str1, String str2) {
        Assert.assertTrue(str1.toUpperCase().contains(str2.toUpperCase()), str1 + " does not contain " + str2 + "!");
    }
    public static void isListInAlphabeticalOrder(List<String> list) {
        for (int i=0; i<list.size()-1;i++) {
            String current = list.get(i);
            String next = list.get(i+1);
            Assert.assertTrue(current.compareTo(next) > 0, "List is not in alphabetical order!");
        }
    }

    public static void areListsOfWebElementsEqual(List<WebElement> list1, List<WebElement> list2) {
        Assert.assertTrue(list1.size() == list2.size(),"List sizes are not equal! List1.size=" +list1.size()+ "List2.size=" + list2.size());
        for (int i=0; i<list1.size(); i++) {
            Assert.assertTrue(list1.get(i).getText().equalsIgnoreCase(list2.get(i).getText()), "Elements are not equal! Element at index of " + i + " are not matching!");
        }
    }

    public static void areListsOfStringsEqual(List<String> list1, List<String> list2) {
        Assert.assertTrue(list1.size() == list2.size(),"List sizes are not equal! List1.size=" +list1.size()+ "List2.size=" + list2.size());
        for (int i=0; i<list1.size(); i++) {
            Assert.assertTrue(list1.get(i).equals(list2.get(i)), "Elements are not equal! Element at index of " + i + " are not matching!");
        }
    }
}
