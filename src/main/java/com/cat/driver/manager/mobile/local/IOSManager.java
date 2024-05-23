package com.cat.driver.manager.mobile.local;

import com.cat.config.factory.BitbarConfigFactory;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public final class IOSManager {
    private IOSManager() {
    }

    public static WebDriver getDriver() {
        /* Remember to change your Appium URL (command executor) to 'https://us-west-mobile-hub.bitbar.com/wd/hub' */
        /* Mobile native capabilities */
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("appium:automationName", "XCUITest");

        HashMap<String, String> bitbarOptions = new HashMap<String, String>();
        bitbarOptions.put("project", "CatRental");
        bitbarOptions.put("testrun", "Smoke Mobile iOS Test");
        bitbarOptions.put("app", "227136965");
        bitbarOptions.put("apiKey", BitbarConfigFactory.getConfig().key());
        bitbarOptions.put("device", "Apple iPhone 13 Pro Max A2484 15.1 -US");
        bitbarOptions.put("appiumVersion", "2.0");
        capabilities.setCapability("bitbar:options", bitbarOptions);

        return new IOSDriver(BitbarConfigFactory.getConfig().bitbarURLMobile(), capabilities);
    }
}
