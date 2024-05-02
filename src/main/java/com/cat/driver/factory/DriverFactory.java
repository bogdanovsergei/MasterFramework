package com.cat.driver.factory;

import com.cat.config.factory.ConfigFactory;
import com.cat.driver.entity.WebDriverData;
import com.cat.driver.factory.mobile.LocalDriverFactoryMobile;
import com.cat.driver.factory.web.LocalDriverFactoryWeb;
import com.cat.driver.factory.web.RemoteDriverFactoryWeb;
import com.cat.enums.RunModeType;
import org.openqa.selenium.WebDriver;

public final class DriverFactory {

    private DriverFactory(){}

    public static WebDriver getDriverForWeb(WebDriverData driverData) {
        if (driverData.getRunModeType() == RunModeType.LOCAL) {
            return LocalDriverFactoryWeb.getDriver(driverData.getBrowserType());
        } else {
            return RemoteDriverFactoryWeb.getDriver(driverData.getBrowserType());
        }
    }

    public static WebDriver getDriverForMobile() {
        if (ConfigFactory.getConfig().browserRunMode() == RunModeType.LOCAL) {
            return LocalDriverFactoryMobile.getDriver();
        } else {
            return LocalDriverFactoryMobile.getDriver();
        }
    }
}
