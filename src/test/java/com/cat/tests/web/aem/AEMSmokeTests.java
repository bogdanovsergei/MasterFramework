package com.cat.tests.web.aem;

import com.cat.config.factory.BitbarConfigFactory;
import com.cat.config.factory.ConfigFactory;
import com.cat.driver.Driver;
import com.cat.driver.DriverManager;
import com.cat.enums.BrowserType;
import com.cat.enums.PlatformType;
import com.cat.enums.RunModeType;
import com.cat.pages.web.aem.AEMHomePage;
import com.cat.pages.web.aem.AEMLoginPage;
import com.cat.tests.WebBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.cat.utils.SeleniumUtils.waitUntilTitleIs;

public class AEMSmokeTests extends WebBase {

    @Test
    public void aemDispatcherHomeAndGlobalTest() throws InterruptedException {
        //WebDriver driver = DriverManager.getDriver();
        //driver.get(ConfigFactory.getConfig().urlAEM());
        Driver.initDriver(PlatformType.WEB);
        AEMHomePage aemHomePage = new AEMHomePage();
        aemHomePage.clickOnSignIn();
        Thread.sleep(1000);

        //AEMHomePage AEMHomePage = new AEMHomePage()
        //        .clickOnSignIn();
        //AEMLoginPage AEMLoginPage = new AEMLoginPage();
        //AEMLoginPage.loginToApplication(ConfigFactory.getConfig().usernameAEM(),
        //        ConfigFactory.getConfig().passwordAEM());
        //waitUntilTitleIs("Rentals");

    }
}
