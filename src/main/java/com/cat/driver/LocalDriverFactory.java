package com.cat.driver;

import com.cat.config.ConfigFactory;
import com.cat.driver.manager.ChromeManager;
import com.cat.driver.manager.FirefoxManager;
import com.cat.enums.BrowserType;
import org.openqa.selenium.WebDriver;

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
