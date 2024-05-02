package com.cat.driver.manager.web.remote.bitbar;

import com.cat.config.factory.BitbarConfigFactory;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;

public final class BitbarEdgeWebManager {
    private BitbarEdgeWebManager() {
    }

    public static WebDriver getDriver() {
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("platformName", "Windows");
        capabilities.setCapability("browserName", "MicrosoftEdge");
        capabilities.setCapability("browserVersion", "122");

        HashMap<String, String> bitbarOptions = new HashMap<String, String>();
        bitbarOptions.put("project", "CatRental");
        bitbarOptions.put("testrun", "Smoke Web Test");
        bitbarOptions.put("apiKey", BitbarConfigFactory.getConfig().key());
        bitbarOptions.put("osVersion", "11");
        bitbarOptions.put("resolution", "1920x1080");
        bitbarOptions.put("seleniumVersion", "4");
        capabilities.setCapability("bitbar:options", bitbarOptions);

        // user-customizable parameters end here

        return new RemoteWebDriver(BitbarConfigFactory.getConfig().bitbarURLWeb(), capabilities);
    }
}
