package com.cat.driver.manager.mobile.remote;

import com.cat.config.factory.BitbarConfigFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public final class BitbarIOSManager {
    private BitbarIOSManager() {
    }

    public static WebDriver getDriver() {
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "uiautomator2");

        HashMap<String, String> bitbarOptions = new HashMap<String, String>();
        bitbarOptions.put("project", "First mobile test");
        bitbarOptions.put("testrun", "My first mobile test run");
        bitbarOptions.put("app", "226530585");
        bitbarOptions.put("apiKey", BitbarConfigFactory.getConfig().key());
        bitbarOptions.put("device", "Google Pixel 8 -US");
        bitbarOptions.put("appiumVersion", "2.1");
        capabilities.setCapability("bitbar:options", bitbarOptions);

        return new IOSDriver(BitbarConfigFactory.getConfig().bitbarURLMobile(), capabilities);
    }
}
