package com.cat.tests.web.aem;

import com.cat.pages.web.aem.HomePageAEM;
import com.cat.pages.web.aem.pageComponents.FooterComponentsAEM;
import com.cat.pages.web.aem.pageComponents.LeftNavMenuComponentsAEM;
import com.cat.pages.web.aem.pageComponents.TopMenuComponentsAEM;
import org.testng.annotations.Test;

import static com.cat.utils.SeleniumUtils.*;

public class AEMSmokeTest extends BaseTestAEM {

    @Test (groups = {"smoke"})
    public void aemDispatcherHomeAndGlobalTest() {
        HomePageAEM homePageAEM = new HomePageAEM()
                .acceptCookies()
                .isCRSLogoPresent()
                .isSignInBtnPresent()
                .isPhoneIconPresent()
                .isCartIconPresent()
                .isLanguageSelectorPresent()
                .isRegisterBtnPresent()
                ;
        //scrollByPixels(500);

        TopMenuComponentsAEM topMenuComponents = new TopMenuComponentsAEM()
                .clickOnBrowserEquipment()//now it's pointing to bug element
                .clickOnAboutUs() //now it's clicking on subMenu 'Racing' since the top ber is too wide
                .clickOnLocation()
                .clickOnBlog();

        LeftNavMenuComponentsAEM leftNavMenuComponentsAEM = new LeftNavMenuComponentsAEM()
                .verifyAlphabeticalOrder()
                .clickOnAerialEquipment()
                .clickOnAirEquipment()
                .clickOnCompactionEquipment()

                .scrollLeftNavMenuByPixels(1000)

                .clickOnQuickQuote()
                .clickOnFindADealer()
                .clickOnFeedback();

        //selecting ES
        FooterComponentsAEM footerComponentsAEM = new FooterComponentsAEM()
                .hoverOnLanguageSelector()
                .selectLanguageByIndex(0)
                    .verifyPageBasedOnSelectedLanguage()
                .scrollToBottomPage()
                .hoverOnLanguageSelector()
        //selecting EN again, it goes to 0 index
                .selectLanguageByIndex(0)
                    .verifyPageBasedOnSelectedLanguage()
                .scrollToBottomPage()
                .clickOnCookieSettings()
                .scrollInCookieSettings(150)
                .clickOnTargetingCookies()
                .clickOnConfirmMyChoicesBtn()
                ;
        waitForGivenTime(3);
        refreshPage();
        waitForGivenTime(3);
    }
}
