package com.cat.driver.factory.web.remote;

import com.cat.enums.BrowserRemoteModeType;
import com.cat.enums.BrowserType;
import org.openqa.selenium.WebDriver;

public final class RemoteDriverFactory {
    private RemoteDriverFactory(){}
    public static WebDriver getDriver(BrowserRemoteModeType browserRemoteModeType,
                                      BrowserType browserType) {

        if (browserRemoteModeType == BrowserRemoteModeType.SELENIUM) {
            return SeleniumGridFactory.getDriver(browserType);
        } else if (browserRemoteModeType == BrowserRemoteModeType.SELENOID) {

        } else if (browserRemoteModeType == BrowserRemoteModeType.BROWSER_STACK){
            return BrowserStackFactory.getDriver(browserType);
        }
        return null;
    }
}
