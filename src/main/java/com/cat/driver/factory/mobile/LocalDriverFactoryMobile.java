package com.cat.driver.factory.mobile;

import com.cat.config.factory.BitbarConfigFactory;
import com.cat.config.factory.ConfigFactory;
import com.cat.driver.manager.mobile.local.AndroidManager;
import com.cat.driver.manager.mobile.local.IOSManager;
import com.cat.driver.manager.mobile.remote.BitbarAndroidManager;
import com.cat.driver.manager.mobile.remote.BitbarIOSManager;
import com.cat.driver.manager.web.local.ChromeManager;
import com.cat.driver.manager.web.local.EdgeManager;
import com.cat.enums.BrowserType;
import com.cat.enums.MobilePlatformType;
import org.openqa.selenium.WebDriver;

public final class LocalDriverFactoryMobile {
    private LocalDriverFactoryMobile(){}

    public static WebDriver getDriver() {
        return ConfigFactory.getConfig().mobilePlatformLocal() == MobilePlatformType.ANDROID
                ? AndroidManager.getDriver()
                : IOSManager.getDriver();
    }

}
