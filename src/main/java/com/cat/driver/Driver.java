package com.cat.driver;

import org.openqa.selenium.WebDriver;

public final class Driver {

    private Driver() {}

    public static void initDriver() { //LocalDriverFactory
        WebDriver driver = LocalDriverFactory.getDriver();
        driver.get("https://google.com");
    }

    public static void quitDriver() {

    }
}
