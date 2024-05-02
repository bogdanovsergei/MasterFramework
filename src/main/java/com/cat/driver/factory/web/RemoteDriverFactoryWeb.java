package com.cat.driver.factory.web;

import com.cat.config.BitbarConfig;
import com.cat.config.factory.BitbarConfigFactory;
import com.cat.config.factory.ConfigFactory;
import com.cat.driver.manager.web.remote.bitbar.BitbarChromeWebManager;
import com.cat.driver.manager.web.remote.bitbar.BitbarEdgeWebManager;
import com.cat.enums.BrowserType;
import org.openqa.selenium.WebDriver;

public final class RemoteDriverFactoryWeb {
    private RemoteDriverFactoryWeb(){}
    public static WebDriver getDriver() {
        return BitbarConfigFactory.getConfig().remoteBrowser() == BrowserType.CHROME
                ? BitbarChromeWebManager.getDriver()
                : BitbarEdgeWebManager.getDriver();
    }
}
