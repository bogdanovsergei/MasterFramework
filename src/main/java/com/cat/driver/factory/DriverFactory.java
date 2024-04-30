package com.cat.driver.factory;

import com.cat.driver.entity.WebDriverData;
import com.cat.driver.factory.web.local.LocalDriverFactory;
import com.cat.driver.factory.web.remote.RemoteDriverFactory;
import com.cat.enums.RunModeType;
import org.openqa.selenium.WebDriver;

public final class DriverFactory {

    private DriverFactory(){}

    public static WebDriver getDriverForWeb(WebDriverData driverData) {
        if (driverData.getRunModeType() == RunModeType.LOCAL) {
            return LocalDriverFactory.getDriver(driverData.getBrowserType());
        } else {
            return RemoteDriverFactory.getDriver(driverData.getBrowserType());
        }
    }

    public static WebDriver getDriverForMobile(WebDriverData driverData) {

        return null;
    }
}
