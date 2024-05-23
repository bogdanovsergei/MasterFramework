package com.cat.pages.mobile.homeScreen.endRentalScreen;

import com.cat.driver.DriverManager;
import com.cat.enums.WaitType;
import com.cat.pages.mobile.homeScreen.HomeScreen;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import static com.cat.utils.MobileUtils.*;
import static com.cat.utils.MobileUtils.waitUntilElementToBeVisible;
import static com.cat.utils.VerificationUtils.areEqual;

public class EndRentalScreen {
    private static final By HEADER_NAME = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.perficient.rental.catstaging:id/linearlayout2_toolbar_title\"]");
    private static final By BACK_ARROW = AppiumBy.xpath("//android.widget.ImageView[@resource-id=\"com.perficient.rental.catstaging:id/imageview_backarrow\"]");

    public EndRentalScreen verifyHeaderName() {
        //waitUntilElementToBeVisible(HEADER_NAME);
        areEqual(DriverManager.getDriver().findElement(HEADER_NAME).getText(),"End Rental");
        return this;
    }

    public HomeScreen clickOnBackArrow() {
        //waitUntilElementToBeVisible(BACK_ARROW);
        click(BACK_ARROW, WaitType.CLICKABLE);
        return new HomeScreen();
    }
}
