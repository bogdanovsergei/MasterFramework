package com.cat.driver.factory.web.remote;

import com.cat.driver.manager.web.remote.selenium.SeleniumGridChromeManager;
import com.cat.driver.manager.web.remote.selenium.SeleniumGridEdgeManager;
import com.cat.enums.BrowserType;
import org.openqa.selenium.WebDriver;

public final class SeleniumGridFactory {
    private SeleniumGridFactory(){}

    public static WebDriver getDriver(BrowserType browserType) {
        return browserType == BrowserType.CHROME
                ? SeleniumGridChromeManager.getDriver()
                : SeleniumGridEdgeManager.getDriver();
    }
}
