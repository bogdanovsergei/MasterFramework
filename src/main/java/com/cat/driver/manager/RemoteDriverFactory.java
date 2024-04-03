package com.cat.driver.manager;

import com.cat.config.ConfigFactory;
import com.cat.enums.BrowserRemoteModeType;
import org.openqa.selenium.WebDriver;

public final class RemoteDriverFactory {
    private RemoteDriverFactory(){}
    public static WebDriver getDriver() {
        BrowserRemoteModeType browserRemoteModeType = ConfigFactory.getConfig().browserRemoteMode();
        if (browserRemoteModeType == BrowserRemoteModeType.SELENIUM) {

        } else if (browserRemoteModeType == BrowserRemoteModeType.SELENOID) {

        } else {

        }
        return null;
    }
}
