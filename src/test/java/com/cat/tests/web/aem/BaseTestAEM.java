package com.cat.tests.web.aem;

import com.cat.config.factory.ConfigFactory;
import com.cat.driver.Driver;
import com.cat.driver.DriverManager;
import com.cat.enums.PlatformType;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.cat.utils.SeleniumUtils.maximizeWindow;

public class BaseTestAEM {

    @BeforeMethod
    public void setUp() {
        Driver.initDriver(PlatformType.WEB);
        DriverManager.getDriver().get(ConfigFactory.getConfig().urlAEM());
        maximizeWindow();
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }
}