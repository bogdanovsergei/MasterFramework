package com.cat.driver.manager.web.remote.selenium;

import com.cat.config.factory.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class SeleniumGridEdgeManager {

    private SeleniumGridEdgeManager(){}

    public static WebDriver getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(Browser.EDGE.browserName());
        return new RemoteWebDriver(ConfigFactory.getConfig()
                .seleniumGridURL(), capabilities);
    }
}
