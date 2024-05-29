package com.cat.driver.manager.mobile.remote;

import com.cat.config.factory.BitbarConfigFactory;
import com.cat.config.factory.ConfigFactory;
import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public final class BitbarAndroidManager {
    private BitbarAndroidManager() {
    }

    public static WebDriver getDriver() {
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "uiautomator2");
        capabilities.setCapability("bitbar_appPackage", ConfigFactory.getConfig().appPackage());
        capabilities.setCapability("bitbar_appActivity", ConfigFactory.getConfig().appActivity());

        HashMap<String, String> bitbarOptions = new HashMap<String, String>();
        bitbarOptions.put("project", "CatRental");
        bitbarOptions.put("testrun", "Smoke Mobile Android Test");
        bitbarOptions.put("app", "228430730");
        bitbarOptions.put("apiKey", BitbarConfigFactory.getConfig().key());
        bitbarOptions.put("device", "Google Pixel 7 -US");
        bitbarOptions.put("appiumVersion", "2.1");
        capabilities.setCapability("bitbar:options", bitbarOptions);

        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        return new AndroidDriver(BitbarConfigFactory.getConfig().bitbarURLMobile(), capabilities);
    }
}
