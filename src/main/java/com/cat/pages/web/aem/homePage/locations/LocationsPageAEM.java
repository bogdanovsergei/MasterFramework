package com.cat.pages.web.aem.homePage.locations;

import com.cat.enums.WaitType;
import com.cat.pages.web.aem.homePage.HomePageAEM;
import com.cat.pages.web.aem.pageComponents.TopMenuComponentsAEM;
import org.openqa.selenium.By;

import static com.cat.utils.SeleniumUtils.*;
import static com.cat.utils.SeleniumUtils.waitUntilPresenceOfElementLocated;

public class LocationsPageAEM {

    String searchItem;
    String xpath ="//div[@id='result_" +searchItem+ "']//div[@id='details-toggle-button']";

    private static final By DEALER_NAME_RADIO_BTN = By.xpath("//label[@for='dealerName']");
    private static final By SEARCH_INPUT_TEXTBOX = By.xpath("//input[@id='search-input']");
    private static final By SEARCH_BTN = By.id("btnSearch");

    private static final By FIRST_RESULT_DEALER_NAME = By.xpath("//div[@id='result_1']//h5[@class='dealer-name']");
    private static final By FIRST_RESULT_ADDRESS = By.xpath("//div[@id='result_1']//span[@class='search-results__address1']");
    private static final By FIRST_RESULT_CITY = By.xpath("//div[@id='result_1']//span[@class='search-results__city']");
    private static final By FIRST_RESULT_STATE = By.xpath("//div[@id='result_1']//span[@class='search-results__state']");
    private static final By FIRST_RESULT_ZIP = By.xpath("//div[@id='result_1']//span[@class='search-results__zip'][1]");
    private static final By FIRST_RESULT_PHONE = By.xpath("//div[@id='result_1']//div[@id='phone']/span");
    private static final By FIRST_RESULT_MORE_INFO = By.xpath("//div[@id='result_1']//div[@id='details-toggle-button']");
    private static final By FIRST_RESULT_VIEW_EQUIPMENT = By.xpath("//div[@id='result_1']//a[@class='cta-details-link cta-details-fleet']");
    private static final By FIRST_RESULT_QUICK_QUOTE = By.xpath("//div[@id='result_1']//a[@class='cta-details-link cta-details-QQ']");
    By SECOND_RESULT_MORE_INFO = By.xpath(xpath);


    public LocationsPageAEM clickOnDealerNameRadioButton() {
        click(DEALER_NAME_RADIO_BTN, WaitType.CLICKABLE);
        return this;
    }

    public LocationsPageAEM enterInput(String input) {
        sendKeys(SEARCH_INPUT_TEXTBOX, input);
        return this;
    }

    public LocationsPageAEM clickOnSearchButton() {
        click(SEARCH_BTN, WaitType.CLICKABLE);
        return this;
    }

    public TopMenuComponentsAEM clickOnViewEquipmentBySearchItemNumber(int itemNumber) {
        By viewEquipment = By.xpath("//div[@id='result_" +itemNumber+ "']//a[@class='cta-details-link cta-details-fleet']");
        waitUntilPresenceOfElementLocated(viewEquipment);
        click(viewEquipment, WaitType.CLICKABLE);
        return new TopMenuComponentsAEM();
    }

    public LocationsPageAEM clickOnQuickQuote() {
        waitUntilPresenceOfElementLocated(FIRST_RESULT_QUICK_QUOTE);
        click(FIRST_RESULT_QUICK_QUOTE, WaitType.CLICKABLE);
        return this;
    }

    public LocationsPageAEM clickOnMoreInfoBySearchItemNumber(int itemNumber) {
        By moreInfo = By.xpath("//div[@id='result_" +itemNumber+ "']//div[@id='details-toggle-button']");
        waitUntilPresenceOfElementLocated(moreInfo);
        click(moreInfo, WaitType.CLICKABLE);
        return this;
    }

    public LocationsPageAEM isAddressPresent() {
        waitUntilPresenceOfElementLocated(FIRST_RESULT_ADDRESS);
        return this;
    }

    public LocationsPageAEM isCityPresent() {
        waitUntilPresenceOfElementLocated(FIRST_RESULT_CITY);
        return this;
    }

    public LocationsPageAEM isStatePresent() {
        waitUntilPresenceOfElementLocated(FIRST_RESULT_STATE);
        return this;
    }

    public LocationsPageAEM isPhonePresent() {
        waitUntilPresenceOfElementLocated(FIRST_RESULT_PHONE);
        return this;
    }

    public LocationsPageAEM isDealerNamePresent() {
        waitUntilPresenceOfElementLocated(FIRST_RESULT_DEALER_NAME);
        return this;
    }

    public LocationsPageAEM isZipPresent() {
        waitUntilPresenceOfElementLocated(FIRST_RESULT_ZIP);
        return this;
    }

    public LocationsPageAEM clickOnMoreInfo() {
        waitUntilPresenceOfElementLocated(FIRST_RESULT_MORE_INFO);
        click(FIRST_RESULT_MORE_INFO, WaitType.CLICKABLE);
        return this;
    }


}
