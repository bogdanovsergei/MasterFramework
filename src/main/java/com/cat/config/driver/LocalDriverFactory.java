package com.cat.config.driver;

import com.cat.config.ConfigFactory;
import com.cat.config.driver.manager.ChromeManager;
import com.cat.config.driver.manager.FirefoxManager;
import com.cat.enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class LocalDriverFactory {
    private LocalDriverFactory(){}

    public static WebDriver getDriver(){
        WebDriver driver = null;
        if (ConfigFactory.getConfig().browser() == BrowserType.CHROME) {
            driver = ChromeManager.getDriver();
        } else if (ConfigFactory.getConfig().browser() == BrowserType.FIREFOX) {
            driver = FirefoxManager.getDriver();
        }
        return driver;
    }
}
