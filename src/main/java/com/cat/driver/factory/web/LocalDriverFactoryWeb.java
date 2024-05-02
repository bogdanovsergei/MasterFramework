package com.cat.driver.factory.web;

import com.cat.config.factory.ConfigFactory;
import com.cat.driver.manager.web.local.ChromeManager;
import com.cat.driver.manager.web.local.EdgeManager;
import com.cat.enums.BrowserType;
import org.openqa.selenium.WebDriver;

public final class LocalDriverFactoryWeb {
    private LocalDriverFactoryWeb(){}

    public static WebDriver getDriver() {
        return isBrowserChrome(ConfigFactory.getConfig().browser())
                ? ChromeManager.getDriver()
                : EdgeManager.getDriver();
    }

    private static boolean isBrowserChrome(BrowserType browserType) {
        return browserType == BrowserType.CHROME;
    }
}
