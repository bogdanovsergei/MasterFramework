package com.cat.tests.web.aem;

import com.cat.driver.Driver;
import com.cat.enums.PlatformType;
import com.cat.pages.web.aem.HomePageAEM;
import com.cat.pages.web.aem.pageComponents.LeftNavMenuComponentsAEM;
import com.cat.pages.web.aem.pageComponents.TopMenuComponentsAEM;
import com.cat.tests.BaseTest;
import org.testng.annotations.Test;

import static com.cat.utils.SeleniumUtils.maximizeWindow;
import static com.cat.utils.SeleniumUtils.waitForGivenTime;

public class AEMSmokeTest extends BaseTest {

    @Test
    public void aemDispatcherHomeAndGlobalTest() throws InterruptedException {
        //WebDriver driver = DriverManager.getDriver();
        //driver.get(ConfigFactory.getConfig().urlAEM());
        Driver.initDriver(PlatformType.WEB);
        maximizeWindow();
        HomePageAEM homePageAEM = new HomePageAEM()
                .isCRSLogoPresent()
                .isSignInBtnPresent()
                .isPhoneIconPresent()
                .isCartIconPresent()
                .isLanguageSelectorPresent()
                .isRegisterBtnPresent();

        TopMenuComponentsAEM topMenuComponents = new TopMenuComponentsAEM()
                .clickBrowserEquipment()
                .clickAboutUs()
                .clickLocation();

        LeftNavMenuComponentsAEM leftNavMenuComponentsAEM = new LeftNavMenuComponentsAEM()
                .verifyAlphabeticalOrder()
                .clickAerialEquipment();

        waitForGivenTime(3);
    }
}
