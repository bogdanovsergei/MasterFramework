package com.cat.tests.web.aem;

import com.cat.config.factory.ConfigFactory;
import com.cat.driver.DriverManager;
import com.cat.pages.web.aem.AEMHomePage;
import com.cat.pages.web.aem.AEMLoginPage;
import org.testng.annotations.Test;

import static com.cat.utils.SeleniumUtils.waitUntilTitleIs;

public class AEMSmokeTests {

    @Test
    public void aemDispatcherHomeAndGlobalTest() throws InterruptedException {
        DriverManager.getDriver().get(ConfigFactory.getConfig().urlAEM());
        Thread.sleep(10000);
        //AEMHomePage AEMHomePage = new AEMHomePage()
        //        .clickOnSignIn();
        //AEMLoginPage AEMLoginPage = new AEMLoginPage();
        //AEMLoginPage.loginToApplication(ConfigFactory.getConfig().usernameAEM(),
        //        ConfigFactory.getConfig().passwordAEM());
        //waitUntilTitleIs("Rentals");

    }
}
