package com.cat.driver.factory.web;

import com.cat.driver.manager.web.remote.bitbar.BitbarChromeWebManager;
import com.cat.driver.manager.web.remote.bitbar.BitbarEdgeWebManager;
import com.cat.enums.BrowserType;
import org.openqa.selenium.WebDriver;

public final class RemoteDriverFactoryWeb {
    private RemoteDriverFactoryWeb(){}
    public static WebDriver getDriver(BrowserType browserType) {
        return browserType == BrowserType.CHROME
                ? BitbarChromeWebManager.getDriver()
                : BitbarEdgeWebManager.getDriver();
    }
}
