package com.cat.driver.manager.web.remote.bitbar;

import com.cat.config.factory.BitbarConfigFactory;
import com.cat.config.factory.ConfigFactory;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;

public final class BitbarChromeWebManager {
    private BitbarChromeWebManager() {
    }

    public static WebDriver getDriver() {
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("platformName", BitbarConfigFactory.getConfig().osType().toString());
        capabilities.setCapability("browserName", BitbarConfigFactory.getConfig().remoteBrowser().toString());
        capabilities.setCapability("browserVersion", BitbarConfigFactory.getConfig().browserVersion().toString());

        HashMap<String, String> bitbarOptions = new HashMap<String, String>();
        bitbarOptions.put("project", "CatRental");
        bitbarOptions.put("testrun", "Smoke Web Test");
        bitbarOptions.put("apiKey", BitbarConfigFactory.getConfig().key());
        bitbarOptions.put("osVersion", "11");
        bitbarOptions.put("resolution", "1920x1080");
        bitbarOptions.put("seleniumVersion", "4");
        capabilities.setCapability("bitbar:options", bitbarOptions);

        return new RemoteWebDriver(BitbarConfigFactory.getConfig().bitbarURLWeb(), capabilities);
    }
}
