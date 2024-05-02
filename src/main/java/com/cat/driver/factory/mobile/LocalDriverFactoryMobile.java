package com.cat.driver.factory.mobile;

import com.cat.config.factory.ConfigFactory;
import com.cat.driver.manager.web.local.ChromeManager;
import com.cat.driver.manager.web.local.EdgeManager;
import com.cat.enums.BrowserType;
import org.openqa.selenium.WebDriver;

public final class LocalDriverFactoryMobile {
    private LocalDriverFactoryMobile(){}

    public static WebDriver getDriver() {
        BrowserType browserType = ConfigFactory.getConfig().browser();
        return null;
    }

}
