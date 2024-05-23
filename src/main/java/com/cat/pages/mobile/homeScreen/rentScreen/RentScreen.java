package com.cat.pages.mobile.homeScreen.rentScreen;

import com.cat.driver.DriverManager;
import com.cat.enums.WaitType;
import com.cat.pages.mobile.homeScreen.HomeScreen;
import com.cat.pages.mobile.homeScreen.requestServiceScreen.RequestServiceScreen;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import static com.cat.utils.MobileUtils.*;
import static com.cat.utils.SeleniumUtils.waitForGivenTime;
import static com.cat.utils.VerificationUtils.areEqual;

public class RentScreen {
    private static final By SELECT_JOBSITE_BTN = AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.perficient.rental.catstaging:id/button_jobsites\"]");

    public RentScreen verifyHeaderName() {
        waitUntilElementToBeVisible(SELECT_JOBSITE_BTN);
        areEqual(getElementText(SELECT_JOBSITE_BTN),"SELECT A JOBSITE");
        return this;
    }
}
