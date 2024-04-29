package com.cat.tests;

import com.cat.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebBase {

    @BeforeMethod
    public void setUp() {
        //Driver.initDriverForWeb();
    }

    @AfterMethod
    public void tearDown() {
        //Driver.quitDriver();
    }
}