package com.cat.pages.mobile.homeScreen.requestsScreen;

import com.cat.pages.mobile.homeScreen.rentScreen.RentScreen;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import static com.cat.utils.MobileUtils.getElementText;
import static com.cat.utils.MobileUtils.waitUntilElementToBeVisible;
import static com.cat.utils.VerificationUtils.areEqual;

public class RequestsScreen {

    private static final By HEADER_NAME = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.perficient.rental.catstaging:id/linearlayout1_toolbar_title\"]");

    public RequestsScreen verifyHeaderName() {
        //waitUntilElementToBeVisible(HEADER_NAME);
        areEqual(getElementText(HEADER_NAME),"Requests");
        return this;
    }
}
