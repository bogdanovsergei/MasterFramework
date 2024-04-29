package com.cat.driver.factory.web.local;

import com.cat.driver.manager.web.local.ChromeManager;
import com.cat.driver.manager.web.local.EdgeManager;
import com.cat.enums.BrowserType;
import org.openqa.selenium.WebDriver;

public final class LocalDriverFactory {
    private LocalDriverFactory(){}

    public static WebDriver getDriver(BrowserType browserType) {
        return isBrowserChrome(browserType)
                ? ChromeManager.getDriver()
                : EdgeManager.getDriver();
    }

    private static boolean isBrowserChrome(BrowserType browserType) {

        return browserType == BrowserType.CHROME;
    }
}
