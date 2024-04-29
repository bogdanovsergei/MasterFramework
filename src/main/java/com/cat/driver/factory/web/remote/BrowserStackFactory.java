package com.cat.driver.factory.web.remote;

import com.cat.driver.manager.web.remote.browserstack.BrowserStackChromeManager;
import com.cat.driver.manager.web.remote.browserstack.BrowserStackEdgeManager;
import com.cat.enums.BrowserType;
import org.openqa.selenium.WebDriver;

public final class BrowserStackFactory {
    private BrowserStackFactory(){}

    public static WebDriver getDriver(BrowserType browserType) {
        return browserType == BrowserType.CHROME
                ? BrowserStackChromeManager.getDriver()
                : BrowserStackEdgeManager.getDriver();
    }
}
