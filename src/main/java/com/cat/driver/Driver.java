package com.cat.driver;

import com.cat.config.factory.BitbarConfigFactory;
import com.cat.config.factory.ConfigFactory;
import com.cat.driver.entity.WebDriverData;

import com.cat.driver.factory.DriverFactory;
import com.cat.enums.*;
import org.openqa.selenium.WebDriver;

public final class Driver {

    private Driver() {}
    //local web, remote web, local mobile, remote mobile
    public static void initDriver(PlatformType platformType) {
        if (platformType == PlatformType.WEB) {
            initDriverForWeb();
        } else {
            initDriverForMobile();
        }
    }

    public static void initDriverForWeb() { //LocalDrive
        WebDriverData driverData = WebDriverData.builder()
                .browserType(ConfigFactory.getConfig().browser())
                .runModeType(ConfigFactory.getConfig().browserRunMode())
                .osType(BitbarConfigFactory.getConfig().osType())
                .browserVersion(BitbarConfigFactory.getConfig().browserVersion())
                .build();
        WebDriver driver = DriverFactory.getDriverForWeb(driverData);
        DriverManager.setDriver(driver);
    }

    public static void initDriverForMobile() {
        WebDriver driver = DriverFactory.getDriverForMobile();
        DriverManager.setDriver(driver);
    }

    public static void quitDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
