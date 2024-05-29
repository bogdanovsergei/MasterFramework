package com.cat.tests.web.dmt;

import com.cat.driver.Driver;
import com.cat.enums.PlatformType;
import com.cat.pages.web.dmt.HomePageDMT;
import com.cat.pages.web.dmt.LoginPageDMT;
import com.cat.pages.web.dmt.activeRentals.ActiveRentalsPageDMT;
import org.testng.annotations.Test;

import static com.cat.utils.SeleniumUtils.maximizeWindow;
import static com.cat.config.factory.ConfigFactory.getConfig;
import static com.cat.utils.SeleniumUtils.waitForGivenTime;

public class DMTSmokeTest extends BaseTestDMT {

    @Test (groups = {"smoke", "DMT"})
    public void dmtSmokeTest1_HomepageNavigation() {

        HomePageDMT homePageDMT = new LoginPageDMT()
                .acceptCookies()
                .loginToApplication(getConfig().usernameDMT(), getConfig().passwordDMT())
                .clickOnLogout()
                .loginToApplication(getConfig().usernameDMT(), getConfig().passwordDMT())
                .clickOnSwitchDealerDropdown()
                .verifyDealersListFromSwitchDealerDropdownMenu()
                .clickOnDealerByName("Cresco")

                .clickOnLeftMenuByName("Messaging")
                .clickOnLeftMenuByName("Resources")
                .clickOnLeftMenuByName("FORMS")
                .clickOnLeftMenuByName("CATALOG MANAGEMENT")
                .clickOnLeftMenuByName("USER MANAGEMENT")
                .clickOnLeftMenuByName("REPORTS")
                .clickOnLeftMenuByName("Active Rentals");

        ActiveRentalsPageDMT activeRental = new ActiveRentalsPageDMT()
                .clickOnEnterCustomerAccountNameOrNumber()
                .selectCustomerAccountByName("Shimmick Construction")
                .clickOnJobsiteInput()
                .selectJobsiteByName("All Jobsites")
                .clickOnShowRentalsBtn()
                .clickOnAssetByIndex(0);

       // homePageDMT.clickOnLeftMenuByName("Reports")
                ;

        waitForGivenTime(6);
    }

    @Test (groups = {"smoke", "DMT"})
    public void dmtSmokeTest2_RequestsRegistration() {

    }
}
