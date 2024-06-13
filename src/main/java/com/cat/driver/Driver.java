package com.cat.driver;

import com.cat.config.factory.BitbarConfigFactory;
import com.cat.config.factory.ConfigFactory;

import com.cat.driver.factory.DriverFactory;
import com.cat.enums.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v124.network.Network;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverInfo;

import java.util.Optional;

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

    public static void initDriverForWeb() {
        WebDriver driver = DriverFactory.getDriverForWeb();
        clearCache(driver);
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

    public static void clearCache(WebDriver driver) {
        if (ConfigFactory.getConfig().browser().toString().equalsIgnoreCase("EDGE")) {
            DevTools devTools = ((EdgeDriver) driver).getDevTools();
            devTools.createSession();
            devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
            devTools.send(Network.clearBrowserCache());
        }
        else if (ConfigFactory.getConfig().browser().toString().equalsIgnoreCase("CHROME")) {
            DevTools devTools = ((ChromeDriver) driver).getDevTools();
            devTools.createSession();
            devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
            devTools.send(Network.clearBrowserCache());
        }
    }
}
