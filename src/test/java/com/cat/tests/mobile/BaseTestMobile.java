package com.cat.tests.mobile;

import com.cat.driver.Driver;
import com.cat.enums.PlatformType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestMobile {
    @BeforeMethod
    public void setUp() {
        Driver.initDriver(PlatformType.MOBILE);
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }
}