package com.cat.pages.mobile.homeScreen.myAccountScreen;

import com.cat.config.factory.ConfigFactory;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import static com.cat.utils.MobileUtils.getElementText;
import static com.cat.utils.MobileUtils.waitUntilElementToBeVisible;
import static com.cat.utils.VerificationUtils.areEqual;
import static com.cat.utils.VerificationUtils.contains;

public class MyAccountScreen {

    private static final By CAT_ID_LABEL = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.perficient.rental.catstaging:id/catIdLabel\"]");

    public MyAccountScreen verifyCatUsername() {
        waitUntilElementToBeVisible(CAT_ID_LABEL);
        contains(getElementText(CAT_ID_LABEL), ConfigFactory.getConfig().usernameAEM());
        return this;
    }
}
