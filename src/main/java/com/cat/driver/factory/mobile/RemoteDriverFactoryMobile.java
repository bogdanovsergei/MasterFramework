package com.cat.driver.factory.mobile;

import com.cat.driver.manager.mobile.remote.BitbarAndroidManager;
import com.cat.enums.BrowserType;
import org.openqa.selenium.WebDriver;

public final class RemoteDriverFactoryMobile {
    private RemoteDriverFactoryMobile(){}
    public static WebDriver getDriver(BrowserType browserType) {
        return BitbarAndroidManager.getDriver();
    }
}
