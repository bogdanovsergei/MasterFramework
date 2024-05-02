package com.cat.driver.factory.mobile;

import com.cat.config.factory.BitbarConfigFactory;
import com.cat.driver.manager.mobile.remote.BitbarAndroidManager;
import com.cat.driver.manager.mobile.remote.BitbarIOSManager;
import com.cat.driver.manager.web.remote.bitbar.BitbarChromeWebManager;
import com.cat.driver.manager.web.remote.bitbar.BitbarEdgeWebManager;
import com.cat.enums.BrowserType;
import com.cat.enums.MobilePlatformType;
import org.openqa.selenium.WebDriver;

public final class RemoteDriverFactoryMobile {
    private RemoteDriverFactoryMobile(){}
    public static WebDriver getDriver() {
        return BitbarConfigFactory.getConfig().mobilePlatform() == MobilePlatformType.ANDROID
                ? BitbarAndroidManager.getDriver()
                : BitbarIOSManager.getDriver();
    }
}
