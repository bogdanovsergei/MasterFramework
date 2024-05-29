package com.cat.pages.mobile.homeScreen;

import com.cat.driver.DriverManager;
import com.cat.enums.WaitType;
import com.cat.pages.mobile.homeScreen.endRentalScreen.EndRentalScreen;
import com.cat.pages.mobile.homeScreen.extendRentalScreen.ExtendRentalScreen;
import com.cat.pages.mobile.homeScreen.myAccountScreen.MyAccountScreen;
import com.cat.pages.mobile.homeScreen.myRentalsScreen.MyRentalsScreen;
import com.cat.pages.mobile.homeScreen.rentScreen.RentScreen;
import com.cat.pages.mobile.homeScreen.requestServiceScreen.RequestServiceScreen;
import com.cat.pages.mobile.homeScreen.requestsScreen.RequestsScreen;
import com.cat.pages.mobile.homeScreen.transferJobsitesScreen.TransferJobsitesScreen;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import java.sql.SQLOutput;

import static com.cat.utils.MobileUtils.*;
//import static com.cat.utils.SeleniumUtils.click;
import static com.cat.utils.SeleniumUtils.waitForGivenTime;
import static com.cat.utils.VerificationUtils.areEqual;

public class HomeScreen {
    private static final By LABEL_QUICK_ACTIONS = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.perficient.rental.catstaging:id/label_actions\"]");
    private static final By REQUEST_SERVICE_BTN = AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.perficient.rental.catstaging:id/button_service\"]");
    private static final By END_RENTAL_BTN = AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.perficient.rental.catstaging:id/button_end\"]");
    private static final By EXTEND_RENTAL_BTN = AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.perficient.rental.catstaging:id/button_extend\"]");
    private static final By TRANSFER_JOBSITES_BTN = AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.perficient.rental.catstaging:id/button_transfer\"]");
    private static final By CRS_LOGO = AppiumBy.xpath("//android.widget.ImageView[@resource-id=\"com.perficient.rental.catstaging:id/imageview_logo\"]");
    private static final By RENT_EQUIPMENT_BTN = AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.perficient.rental.catstaging:id/button_rent_equipment\"]");
    //bottom menu
    private static final By BOTTOM_MENU_DASHBOARD = AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Dashboard\"]");
    private static final By BOTTOM_MENU_RENT = AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Rent\"]");
    private static final By BOTTOM_MENU_REQUESTS = AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Requests\"]");
    private static final By BOTTOM_MENU_MYRENTALS = AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"My Rentals\"]");
    private static final By BOTTOM_MENU_MYACCOUNT = AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"My Account\"]");

    public HomeScreen clickOnCRSLogo() {
        click(CRS_LOGO, WaitType.CLICKABLE);
        return this;
    }
    public HomeScreen verifyLabelQuickActions() {
        String labelName = getElementText(LABEL_QUICK_ACTIONS);
        areEqual(labelName, "QUICK ACTIONS");
        return this;
    }

    public RequestServiceScreen clickOnRequestService() {
        click(REQUEST_SERVICE_BTN, WaitType.CLICKABLE);
        waitForGivenTime(40);
        return new RequestServiceScreen();
    }

    public EndRentalScreen clickOnEndRental() {
        click(END_RENTAL_BTN, WaitType.CLICKABLE);
        waitForGivenTime(40);
        return new EndRentalScreen();
    }

    public ExtendRentalScreen clickOnExtendRental() {
        click(EXTEND_RENTAL_BTN, WaitType.CLICKABLE);
        waitForGivenTime(40);
        return new ExtendRentalScreen();
    }

    public TransferJobsitesScreen clickOnTransferJobsites() {
        click(TRANSFER_JOBSITES_BTN, WaitType.CLICKABLE);
        waitForGivenTime(40);
        return new TransferJobsitesScreen();
    }

    public RentScreen clickOnRentBottomMenu() {
        click(BOTTOM_MENU_RENT, WaitType.CLICKABLE);
        waitForGivenTime(15);
        return new RentScreen();
    }

    public RequestsScreen clickOnRequestsBottomMenu() {
        click(BOTTOM_MENU_REQUESTS, WaitType.CLICKABLE);
        waitForGivenTime(15);
        return new RequestsScreen();
    }

    public MyRentalsScreen clickOnMyRentalsBottomMenu() {
        click(BOTTOM_MENU_MYRENTALS, WaitType.CLICKABLE);
        waitForGivenTime(15);
        return new MyRentalsScreen();
    }

    public MyAccountScreen clickOnMyAccountBottomMenu() {
        click(BOTTOM_MENU_MYACCOUNT, WaitType.CLICKABLE);
        waitForGivenTime(15);
        return new MyAccountScreen();
    }

    public HomeScreen clickOnDashboardBottomMenu() {
        click(BOTTOM_MENU_DASHBOARD, WaitType.CLICKABLE);
        waitForGivenTime(15);
        return new HomeScreen();
    }

    public RentScreen clickOnRentEquipment() {
        click(RENT_EQUIPMENT_BTN, WaitType.CLICKABLE);
        waitForGivenTime(15);
        return new RentScreen();
    }
}
