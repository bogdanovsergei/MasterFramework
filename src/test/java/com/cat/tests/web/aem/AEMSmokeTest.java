package com.cat.tests.web.aem;

import com.cat.pages.web.aem.homePage.HomePageAEM;
import com.cat.pages.web.aem.homePage.addToRequestModalPage.AddToRequestModalPageAEM;
import com.cat.pages.web.aem.homePage.aerialEquipmentPage.AerialEquipmentPageAEM;
import com.cat.pages.web.aem.homePage.searchListEquipmentResultPage.SearchListEquipmentsResultPageAEM;
import com.cat.pages.web.aem.pageComponents.FooterComponentsAEM;
import com.cat.pages.web.aem.pageComponents.LeftNavMenuComponentsAEM;
import com.cat.pages.web.aem.pageComponents.TopMenuComponentsAEM;
import org.testng.annotations.Test;

import static com.cat.utils.SeleniumUtils.*;

public class AEMSmokeTest extends BaseTestAEM {

    @Test (groups = {"smoke", "AEM"})
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

        AerialEquipmentPageAEM leftNavMenuComponentsAEM = new LeftNavMenuComponentsAEM()
                .verifyAlphabeticalOrder()
                .clickOnAerialEquipment();
        new LeftNavMenuComponentsAEM().clickOnAirEquipment()
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

    @Test (groups = {"smoke", "AEM"})
    public void aemDispatcherProductsTest() {
        HomePageAEM homePageAEM = new HomePageAEM()
                .acceptCookies()
                .isCRSLogoPresent();
        SearchListEquipmentsResultPageAEM searchListEquipmentsResultPageAEM = new FooterComponentsAEM()
                .scrollToBottomPage()
                .clickOnBrowseEquipment()
                .enterEquipmentInSearchBox("BOOM LIFT, 40FT ARTICULATING")
                .enterLocationInSearchBox("Ohio, US")
                .clickOnFindEquipmentBtn()
                .clickOnEquipmentByIndex(1)
                .clickOnQuantityPlus()
                .selectStartDate()
                .selectEndDate()
                //.selectFirstAttachment()
                .scrollToBottom()
                .inputNotes("test Product 1")
                .clickOnAddToRequestButton();
        TopMenuComponentsAEM topMenuComponentsAEM = new TopMenuComponentsAEM()
                .isCartItemsNumberEqualTo(2);
        searchListEquipmentsResultPageAEM
                .clickOnEquipmentByIndex(2)
                .clickOnQuantityPlus()
                .scrollToBottom()
                .inputNotes("test Product 2")
                .clickOnAddToRequestButton();
        topMenuComponentsAEM
                .isCartItemsNumberEqualTo(4)
                .clickOnCartIcon()
                ;

        /*
        BoomLiftsAEM leftNavMenuComponentsAEM = new LeftNavMenuComponentsAEM()
                .clickOnAerialEquipment()
                .clickOnBoomLifts()
                .closeFindEquipmentNearYouPopUp()
                .clickOnBoomLiftByIndex(0)
                ;
                */

        waitForGivenTime(8);
    }
}
