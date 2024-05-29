package com.cat.pages.mobile.homeScreen.transferJobsitesScreen;

import com.cat.driver.DriverManager;
import com.cat.enums.WaitType;
import com.cat.pages.mobile.homeScreen.HomeScreen;
import com.cat.pages.mobile.homeScreen.extendRentalScreen.ExtendRentalScreen;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import static com.cat.utils.SeleniumUtils.click;
import static com.cat.utils.VerificationUtils.areEqual;

public class TransferJobsitesScreen {
    private static final By HEADER_NAME = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.perficient.rental.catstaging:id/linearlayout2_toolbar_title\"]");
    private static final By BACK_ARROW = AppiumBy.xpath("//android.widget.ImageView[@resource-id=\"com.perficient.rental.catstaging:id/imageview_backarrow\"]");

    public TransferJobsitesScreen verifyHeaderName() {
        areEqual(DriverManager.getDriver().findElement(HEADER_NAME).getText(),"TRANSFER RENTAL");
        return this;
    }

    public HomeScreen clickOnBackArrow() {
        click(BACK_ARROW, WaitType.CLICKABLE);
        return new HomeScreen();
    }
}
