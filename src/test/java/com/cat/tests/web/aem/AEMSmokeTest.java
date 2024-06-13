package com.cat.tests.web.aem;

import com.cat.pages.web.aem.homePage.HomePageAEM;
import com.cat.pages.web.aem.homePage.account.AccountPageAEM;
import com.cat.pages.web.aem.homePage.aerialEquipment.AerialEquipmentPageAEM;
import com.cat.pages.web.aem.homePage.locations.LocationsPageAEM;
import com.cat.pages.web.aem.homePage.quickQuote.QuickQuotePageAEM;
import com.cat.pages.web.aem.homePage.rentals.RentalsPageAEM;
import com.cat.pages.web.aem.homePage.searchListEquipmentResult.SearchListEquipmentsResultPageAEM;
import com.cat.pages.web.aem.pageComponents.FooterComponentsAEM;
import com.cat.pages.web.aem.pageComponents.LeftNavMenuComponentsAEM;
import com.cat.pages.web.aem.pageComponents.TopMenuComponentsAEM;
import com.cat.pages.web.dmt.HomePageDMT;
import com.cat.pages.web.dmt.LoginPageDMT;
import com.cat.pages.web.dmt.dashboard.DashboardPageDMT;
import com.cat.pages.web.dmt.pageComponents.LeftNavMenuComponentsDMT;
import com.cat.pages.web.dmt.requests.RequestsPageDMT;
import com.cat.pages.web.dmt.requests.requestsLead.RequestsLeadPageDMT;
import com.cat.tests.web.dmt.BaseTestDMT;
import org.testng.annotations.Test;

import static com.cat.config.factory.ConfigFactory.getConfig;
import static com.cat.utils.SeleniumUtils.*;

public class AEMSmokeTest extends BaseTestAEM {

    @Test (groups = {"smoke", "AEM"}, description = "1")
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

        LocationsPageAEM topMenuComponents = new TopMenuComponentsAEM()
                .clickOnBrowserEquipment()//now it's pointing to bug element
                .clickOnAboutUs() //now it's clicking on subMenu 'Racing' since the top ber is too wide
                .clickOnBlog()
                .clickOnLocation();

        AerialEquipmentPageAEM leftNavMenuComponentsAEM = new LeftNavMenuComponentsAEM()
                .verifyAlphabeticalOrder()
                .clickOnAerialEquipment();
        new LeftNavMenuComponentsAEM().clickOnAirEquipment()
                .clickOnCompactionEquipment()

                .scrollLeftNavMenuByPixels(1000);
        new LeftNavMenuComponentsAEM().clickOnQuickQuote();
        new LeftNavMenuComponentsAEM().clickOnFindADealer()
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

    @Test (groups = {"smoke", "AEM"}, description = "2")
    public void aemDispatcherProductsTest() {
        String firstName = "Sergei",
                lastName = "Bogdanov",
                companyName = "Test Company";

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
                .increaseQuantity()
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
                .increaseQuantity()
                .scrollToBottom()
                .inputNotes("test Product 1")
                .clickOnAddToRequestButton();
        topMenuComponentsAEM
                .isCartItemsNumberEqualTo(4)
                .clickOnCartIcon()
                .verifyNotes(0)
                .verifyNotes(1)
                .clickOnEdit(0)
                .increaseQuantity()
                .inputNotes("test Product 1 updated")
                .clickOnSaveChangesButton()
                .verifyNotes(1)
                .deleteItem(0)
                .submitDeletion()
                .enterFirstname(firstName)
                .enterLastname(lastName)
                .enterEmail("sergei.bogdanov@perficient.com")
                .enterPhone("1234567890")
                .enterCompanyName(companyName)
                .enterJobsiteAddress("Ohio, US")
                .declineMarketingConsent()
                .clickOnSubmitButton()
                ;

        closeExistingDriverAndInitiateNewWebDriver();
        getToDMT();

        HomePageDMT homePageDMT = new LoginPageDMT()
                .acceptCookies()
                .loginToApplication(getConfig().usernameDMT(), getConfig().passwordDMT())
                .clickOnDealerByName("DEMO Dealer 1");
        LeftNavMenuComponentsDMT leftNavMenuComponentsDMT = new LeftNavMenuComponentsDMT();
            leftNavMenuComponentsDMT
                .clickOnRequestsSubMenu("LEAD");

        RequestsLeadPageDMT requestsLeadPageDMT = new RequestsLeadPageDMT()
                .verifyLastRequestStatus("Submitted")
                .verifyLastRequestCustomer(companyName)
                .verifyLastRequestRequestor(firstName + " " + lastName);


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

    @Test (groups = {"smoke"}, description = "3")
    public void aemDispatcherLeadsTest() {
        String firstName = "Sergei",
                lastName = "Bogdanov",
                companyName = "Test Company";

        HomePageAEM homePageAEM = new HomePageAEM()
                .acceptCookies()
                .isCRSLogoPresent();
        QuickQuotePageAEM quickQuotePageAEM = new LeftNavMenuComponentsAEM()
                .clickOnQuickQuote()
                .enterFirstname(firstName)
                .enterLastname(lastName)
                .enterEmail("sergei.bogdanov@perficient.com")
                .enterPhone("1234567890")
                .enterCompanyName(companyName)
                .enterJobsiteAddress("Cincinnati, Ohio, US")
                .selectStartDate()
                .selectEndDate()
                .clickOnSubmitButton()
                .verifyErrorComment()
                .enterEquipmentNeeded("test equipment")
                .declineMarketingConsent()
                .clickOnSubmitButton()
                .waitForConfirmation();

        closeExistingDriverAndInitiateNewWebDriver();
        getToDMT();

        HomePageDMT homePageDMT = new LoginPageDMT()
                .acceptCookies()
                .loginToApplication(getConfig().usernameDMT(), getConfig().passwordDMT())
                .clickOnDealerByName("DEMO Dealer 1");
        DashboardPageDMT dashboardPageDMT = new DashboardPageDMT()
                .verifyLastNotificationType("Lead")
                .verifyLastNotificationCustomer(companyName)
                .verifyLastNotificationRequestor(firstName + " " + lastName);

        closeExistingDriverAndInitiateNewWebDriver();
        getToAEM();

        HomePageAEM homePageAEM2 = new HomePageAEM()
                .acceptCookies()
                .isCRSLogoPresent();
        HomePageAEM topMenuComponentsAEM = new TopMenuComponentsAEM()
                .clickOnSignInButton()
                .loginToApplication(getConfig().usernameAEM(), getConfig().passwordAEM());

    }


    @Test (groups = {"smoke", "AEM"}, description = "4")
    public void aemDispatcherLocationsTest() {

        HomePageAEM homePageAEM = new HomePageAEM()
                .acceptCookies()
                .isCRSLogoPresent();
        LocationsPageAEM locationsPageAEM = new TopMenuComponentsAEM()
                .clickOnLocation()
                .clickOnDealerNameRadioButton()
                .enterInput("Cashman")
                .clickOnSearchButton()
                .isDealerNamePresent()
                .isAddressPresent()
                .isCityPresent()
                .isStatePresent()
                .isPhonePresent()
                .isZipPresent()
                .clickOnMoreInfoBySearchItemNumber(1)
                .clickOnViewEquipmentBySearchItemNumber(1)
                .clickOnLocation()
                .enterInput("Miamisburg, Ohio, US")
                .clickOnSearchButton()
                .clickOnMoreInfoBySearchItemNumber(1);


        waitForGivenTime(5);
    }

    @Test (groups = {"smoke", "AEM"}, description = "6")
    public void aemDispatcherSCPAccountTest() {
        HomePageAEM homePageAEM = new HomePageAEM()
                .acceptCookies();
        HomePageAEM homePageAEM2 = new TopMenuComponentsAEM()
                .clickOnSignInButton()
                .loginToApplication(getConfig().usernameAEM(), getConfig().passwordAEM());
        AccountPageAEM accountPageAEM = new TopMenuComponentsAEM()
                .clickOnAccount()
                .verifyUsername()
                .isChangePasswordLinkPresent()
                .isEditProfileLinkPresent();
        scrollByPixels(300);
                accountPageAEM
                .switchRentReportSettingsDaily("on")
                .switchRentReportSettingsDaily("off")
                .switchRentReportSettingsWeekly("on")
                .switchRentReportSettingsWeekly("off")
                .switchRentReportSettingsMonthly("on")
                .switchRentReportSettingsMonthly("off")
                .clickOnLanguageDropdown()
                .clickOnLanguageDropdown()
                .clickOnDateFormatDropdown()
                .clickOnDateFormatDropdown()
                .clickOnTimeZoneDropdown()
                .selectTimeZoneByName("Pacific/Honolulu")
                .clickOnTimeZoneDropdown();
        scrollByPixels(1000);
                accountPageAEM
                .switchEmailNotification("on")
                .switchEmailNotification("off")
                .switchBrowserNotification("on")
                .switchMobileAppNotification("on")
                .switchMobileAppNotification("off");
                //.downloadReport()
                //.deleteReport();

        waitForGivenTime(4);
    }

    @Test (groups = {"smoke", "AEM"}, description = "7")
    public void aemDispatcherSCPRentalsTest() {
        HomePageAEM homePageAEM = new HomePageAEM()
                .acceptCookies();
        HomePageAEM homePageAEM2 = new TopMenuComponentsAEM()
                .clickOnSignInButton()
                .loginToApplication(getConfig().usernameAEM(), getConfig().passwordAEM());
        RentalsPageAEM rentalsPageAEM = new TopMenuComponentsAEM()
                .clickOnRentals()
                .changeMapOrListView()
                .changeMapOrListView()
                .scrollListToRight(300)
                .scrollListToLeft(300)
                .clickOnAssetsTypeAll()
                .clickOnAssetsTypeReservation()
                .clickOnAssetsTypeMachines()
                .clickOnFilters()
                .closePreferencesModalWindow()
                .scrollListToRight(300)
                .scrollListToLeft(300)
                .clickOnListHeaderByName("Take Action")
                .clickOnListHeaderByName("Asset Name")
                .clickOnListHeaderByName("Asset Id");
                //.clickOnCreateReportButton()
                //.verifyReportModalWindowText()
                //.closeReportModalWindow();

        waitForGivenTime(4);
    }
}
