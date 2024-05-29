package com.cat.pages.mobile.homeScreen.extendRentalScreen;

import com.cat.driver.DriverManager;
import com.cat.enums.WaitType;
import com.cat.pages.mobile.homeScreen.HomeScreen;
import com.cat.pages.mobile.homeScreen.endRentalScreen.EndRentalScreen;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import static com.cat.utils.SeleniumUtils.click;
import static com.cat.utils.VerificationUtils.areEqual;

public class ExtendRentalScreen {
    private static final By HEADER_NAME = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.perficient.rental.catstaging:id/linearlayout2_toolbar_title\"]");
    private static final By BACK_ARROW = AppiumBy.xpath("//android.widget.ImageView[@resource-id=\"com.perficient.rental.catstaging:id/imageview_backarrow\"]");

    public ExtendRentalScreen verifyHeaderName() {
        areEqual(DriverManager.getDriver().findElement(HEADER_NAME).getText(),"EXTEND RENTAL");
        return this;
    }

    public HomeScreen clickOnBackArrow() {
        click(BACK_ARROW, WaitType.CLICKABLE);
        return new HomeScreen();
    }
}
