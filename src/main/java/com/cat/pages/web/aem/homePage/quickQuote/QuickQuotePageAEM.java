package com.cat.pages.web.aem.homePage.quickQuote;

import com.cat.driver.DriverManager;
import com.cat.enums.WaitType;
import com.cat.pages.web.aem.homePage.addToRequestModal.AddToRequestModalPageAEM;
import com.cat.pages.web.aem.homePage.shoppingCart.ShoppingCartPageAEM;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.cat.utils.SeleniumUtils.*;
import static com.cat.utils.SeleniumUtils.waitUntilTitleIs;
import static com.cat.utils.VerificationUtils.areEqual;

public class QuickQuotePageAEM {

    private static final By FIRST_NAME_TEXTBOX = By.xpath("//input[@name='name-first']");
    private static final By LAST_NAME_TEXTBOX = By.xpath("//input[@name='name-last']");
    private static final By EMAIL_TEXTBOX = By.xpath("//input[@name='email']");
    private static final By PHONE_TEXTBOX = By.xpath("//input[@name='phone-business']");
    private static final By COMPANY_NAME_TEXTBOX = By.xpath("//input[@name='name-company']");
    private static final By JOBSITE_ADDRESS_TEXTBOX = By.xpath("//input[@name='jobsite-address-1']");
    private static final By EQUIPMENT_NEEDED_TEXTBOX = By.xpath("//textarea[@name='comments']");
    private static final By MARKETING_CONSENT_NO = By.xpath("//label[@for='subscription-no']");
    private static final By SUBMIT_BTN = By.xpath("//button[@name='submit']");
    private static final By JOBSITE_ADDRESS_SUGGESTED_LIST = By.xpath("//li[@role='presentation']");
    private static final By START_DATE = By.xpath("//div[@class='drp-calendar left']//td[@class='today in-range-min active start-date active end-date in-range available' or @class='today weekend in-range-min active start-date active end-date in-range available']");
    private static final By END_DATE = By.xpath("//div[@class='drp-calendar right']//tbody//tr[5]//td[@data-title='r4c1']");
    private static final By COMMENT_ERROR_MSG = By.xpath("//label[@id='comments-error']");

    public QuickQuotePageAEM enterFirstname(String input) {
        waitUntilPresenceOfElementLocated(FIRST_NAME_TEXTBOX);
        sendKeys(FIRST_NAME_TEXTBOX, input);
        return this;
    }

    public QuickQuotePageAEM enterLastname(String input) {
        waitUntilPresenceOfElementLocated(LAST_NAME_TEXTBOX);
        sendKeys(LAST_NAME_TEXTBOX, input);
        return this;
    }

    public QuickQuotePageAEM enterEmail(String input) {
        waitUntilPresenceOfElementLocated(EMAIL_TEXTBOX);
        sendKeys(EMAIL_TEXTBOX, input);
        return this;
    }

    public QuickQuotePageAEM enterPhone(String input) {
        waitUntilPresenceOfElementLocated(PHONE_TEXTBOX);
        sendKeys(PHONE_TEXTBOX, input);
        return this;
    }

    public QuickQuotePageAEM enterCompanyName(String input) {
        waitUntilPresenceOfElementLocated(COMPANY_NAME_TEXTBOX);
        sendKeys(COMPANY_NAME_TEXTBOX, input);
        return this;
    }

    public QuickQuotePageAEM enterEquipmentNeeded(String input) {
        waitUntilPresenceOfElementLocated(EQUIPMENT_NEEDED_TEXTBOX);
        sendKeys(EQUIPMENT_NEEDED_TEXTBOX, input);
        return this;
    }
    public QuickQuotePageAEM enterJobsiteAddress(String input) {
        waitUntilPresenceOfElementLocated(JOBSITE_ADDRESS_TEXTBOX);
        sendKeys(JOBSITE_ADDRESS_TEXTBOX, input);
        waitForGivenTime(2);
        List<WebElement> suggestedList = getListOfWebElements(JOBSITE_ADDRESS_SUGGESTED_LIST);
        click(suggestedList.get(0));
        return this;
    }

    public QuickQuotePageAEM declineMarketingConsent() {
        waitUntilPresenceOfElementLocated(MARKETING_CONSENT_NO);
        click(MARKETING_CONSENT_NO, WaitType.CLICKABLE);
        return this;
    }

    public QuickQuotePageAEM selectStartDate() {
        waitUntilPresenceOfElementLocated(START_DATE);
        click(START_DATE, WaitType.CLICKABLE);
        return this;
    }

    public QuickQuotePageAEM selectEndDate() {
        waitUntilPresenceOfElementLocated(END_DATE);
        click(END_DATE, WaitType.CLICKABLE);
        return this;
    }

    public QuickQuotePageAEM clickOnSubmitButton() {
        waitUntilPresenceOfElementLocated(SUBMIT_BTN);
        click(SUBMIT_BTN, WaitType.CLICKABLE);
        return this;
    }

    public QuickQuotePageAEM waitForConfirmation() {
        waitUntilTitleIs("Confirmation");
        return this;
    }

    public QuickQuotePageAEM verifyErrorComment() {
        waitUntilPresenceOfElementLocated(COMMENT_ERROR_MSG);
        waitUntilElementTextEqualsToDesiredValue(COMMENT_ERROR_MSG, "This field is required.");
        return this;
    }

}
