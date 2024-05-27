package com.cat.tests.web.dmt;

import com.cat.config.factory.ConfigFactory;
import com.cat.driver.Driver;
import com.cat.driver.DriverManager;
import com.cat.enums.PlatformType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.cat.utils.SeleniumUtils.maximizeWindow;

public class BaseTestDMT {

    @BeforeMethod
    public void setUp() {
        Driver.initDriver(PlatformType.WEB);
        DriverManager.getDriver().get(ConfigFactory.getConfig().urlDMT());
        maximizeWindow();
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }
}