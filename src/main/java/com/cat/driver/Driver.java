package com.cat.driver;

import com.cat.config.factory.ConfigFactory;
import com.cat.driver.entity.WebDriverData;
import static com.cat.config.factory.ConfigFactory.getConfig;

import com.cat.driver.factory.DriverFactory;
import com.cat.driver.factory.web.local.LocalDriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class Driver {

    private Driver() {}
    //local web, remote web, local mobile, remote mobile

    public static void initDriverForWeb() { //LocalDrive
        WebDriverData driverData = WebDriverData.builder()
                .browserType(getConfig().browser())
                .browserRemoteModeType(getConfig().browserRemoteMode())
                .runModeType(getConfig().browserRunMode())
                .build();
        WebDriver driver = DriverFactory.getDriverForWeb(driverData);
        DriverManager.setDriver(driver);
    }

    public static void loadAEM() {
        DriverManager.getDriver().get(getConfig().urlAEM());
    }

    public static void initDriverForMobile() {

    }

    public static void quitDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
