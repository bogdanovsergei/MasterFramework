package com.cat.tests.mobile;

import com.cat.config.factory.ConfigFactory;
import com.cat.driver.Driver;
import com.cat.driver.DriverManager;
import com.cat.enums.PlatformType;
import com.cat.pages.mobile.homeScreen.HomeScreen;
import com.cat.pages.mobile.homeScreen.rentScreen.RentScreen;
import com.cat.pages.mobile.loginScreen.LoginScreen;
import com.cat.pages.web.dmt.LoginPageDMT;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.cat.utils.MobileUtils.*;
import static com.cat.utils.SeleniumUtils.*;

public class MobileSmokeTest extends BaseTestMobile {

    @Test (groups = {"smoke"})
    public void mobileSmokeTest() {
        //Driver.initDriver(PlatformType.MOBILE);
        //WebDriver driver = DriverManager.getDriver();

        HomeScreen loginScreen = new LoginScreen()
                .acceptAgreement()
                .acceptBiometrics()
                .acceptGoogleTermsAndCookies()
                .loginToApplication(ConfigFactory.getConfig().usernameAEM(),
                                    ConfigFactory.getConfig().passwordAEM());
        waitForGivenTime(10);
        closeBrowserAndGetToApp();
        waitForGivenTime(10);

        loginScreen.verifyLabelQuickActions()
                .clickOnRentEquipment()
                .verifyHeaderName();

        loginScreen.clickOnDashboardBottomMenu()
                .clickOnCRSLogo()
                        .verifyLabelQuickActions()
                .clickOnRentBottomMenu()
                        .verifyHeaderName();
        loginScreen.clickOnRequestsBottomMenu()
                .verifyHeaderName();
        loginScreen.clickOnMyRentalsBottomMenu()
                .verifyHeaderName();
        loginScreen.clickOnMyAccountBottomMenu()
                .verifyCatUsername();
        loginScreen.clickOnDashboardBottomMenu()
                .verifyLabelQuickActions();

        HomeScreen requestServiceVerification = new HomeScreen()
                .clickOnRequestService()
                    .verifyHeaderName()
                    .clickOnBackArrow()
                //.clickOnEndRental()
                //    .verifyHeaderName()
                //    .clickOnBackArrow()
                .clickOnExtendRental()
                    .verifyHeaderName()
                    .clickOnBackArrow()
                .clickOnTransferJobsites()
                    .verifyHeaderName()
                    .clickOnBackArrow();

        waitForGivenTime(5);

    }

}
