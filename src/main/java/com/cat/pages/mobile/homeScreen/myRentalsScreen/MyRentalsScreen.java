package com.cat.pages.mobile.homeScreen.myRentalsScreen;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import static com.cat.utils.MobileUtils.getElementText;
import static com.cat.utils.MobileUtils.waitUntilElementToBeVisible;
import static com.cat.utils.VerificationUtils.areEqual;

public class MyRentalsScreen {

    private static final By HEADER_NAME = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.perficient.rental.catstaging:id/linearlayout1_toolbar_title\"]");

    public MyRentalsScreen verifyHeaderName() {
        waitUntilElementToBeVisible(HEADER_NAME);
        areEqual(getElementText(HEADER_NAME),"My Rentals");
        return this;
    }
}
