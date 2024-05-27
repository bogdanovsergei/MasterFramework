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
    //public static final String MOBILE_URL = "https://us-west-mobile-hub.bitbar.com/wd/hub";

    @Test
    public void mobileTest() throws InterruptedException {
        Driver.initDriver(PlatformType.MOBILE);
        WebDriver driver = DriverManager.getDriver();
        Thread.sleep(3000);

        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(AppiumBy.id("com.perficient.rental.catstaging:id/switch_accept"))));
        driver.findElement(AppiumBy.id("com.perficient.rental.catstaging:id/switch_accept")).click();

        //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(AppiumBy.id("com.perficient.rental.catstaging:id/button_accept"))));
        driver.findElement(By.id("com.perficient.rental.catstaging:id/button_accept")).click();
        String title = driver.getTitle();
        Thread.sleep(4000);

        System.out.println("Title is " + title);

        Driver.initDriver(PlatformType.WEB);
        maximizeWindow();

        LoginPageDMT loginPageDMT = new LoginPageDMT();
        String title2 = DriverManager.getDriver().getTitle();
        System.out.println("Title2 is " + title);
        Assert.assertEquals(title, title2);
    }

    @Test
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

        RentScreen homeScreenVerification = loginScreen
                        .verifyLabelQuickActions()
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
                .clickOnEndRental()
                    .verifyHeaderName()
                    .clickOnBackArrow()
                .clickOnExtendRental()
                    .verifyHeaderName()
                    .clickOnBackArrow()
                .clickOnTransferJobsites()
                    .verifyHeaderName()
                    .clickOnBackArrow();

        waitForGivenTime(5);

    }

}
