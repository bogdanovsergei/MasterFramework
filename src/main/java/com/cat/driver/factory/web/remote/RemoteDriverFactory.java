package com.cat.driver.factory.web.remote;

import com.cat.driver.manager.web.remote.bitbar.BitbarChromeManager;
import com.cat.driver.manager.web.remote.bitbar.BitbarEdgeManager;
import com.cat.enums.BrowserType;
import org.openqa.selenium.WebDriver;

public final class RemoteDriverFactory {
    private RemoteDriverFactory(){}
    public static WebDriver getDriver(BrowserType browserType) {
        return browserType == BrowserType.CHROME
                ? BitbarChromeManager.getDriver()
                : BitbarEdgeManager.getDriver();
    }
}
