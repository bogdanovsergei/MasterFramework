package com.cat.driver.manager.web.remote.browserstack;

import com.cat.config.factory.BrowserStackConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class BrowserStackEdgeManager {
    private BrowserStackEdgeManager() {
    }

    public static WebDriver getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browser", "edge");
        capabilities.setCapability("browser_version", "latest");
        capabilities.setCapability("os", "Windows");
        capabilities.setCapability("os_version", "10");
        return new RemoteWebDriver(BrowserStackConfigFactory.getConfig()
                .browserStackURL(), capabilities);
    }
}
