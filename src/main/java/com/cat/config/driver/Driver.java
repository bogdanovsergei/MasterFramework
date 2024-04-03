package com.cat.config.driver;

import com.cat.config.ConfigFactory;
import com.cat.enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {


    public static void initDriver() { //LocalDriverFactory
        WebDriver driver = LocalDriverFactory.getDriver();
        driver.get("https://google.com");
    }

    public static void quitDriver() {

    }
}
