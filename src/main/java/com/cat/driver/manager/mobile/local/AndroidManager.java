package com.cat.driver.manager.mobile.local;

import com.cat.config.factory.BitbarConfigFactory;
import com.cat.config.factory.ConfigFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public final class AndroidManager {
    private AndroidManager() {
    }

    public static WebDriver getDriver(){
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("Pixel 3a");
        options.setApp(System.getProperty("user.dir") + "\\apps\\" + ConfigFactory.getConfig().appNameAndroid());
        options.setAppPackage(ConfigFactory.getConfig().appPackage());
        options.setAppActivity(ConfigFactory.getConfig().appActivity());

        return new AndroidDriver(ConfigFactory.getConfig().localURL(), options);
    }
}
