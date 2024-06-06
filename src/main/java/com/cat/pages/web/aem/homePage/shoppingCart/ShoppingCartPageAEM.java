package com.cat.pages.web.aem.homePage.shoppingCart;

import com.cat.driver.DriverManager;
import com.cat.enums.WaitType;
import com.cat.pages.web.aem.homePage.addToRequestModal.AddToRequestModalPageAEM;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.cat.utils.SeleniumUtils.*;
import static com.cat.utils.VerificationUtils.areEqual;

public class ShoppingCartPageAEM {

    private static final By EDITS = By.xpath("//div[@class='cart-item-actions']//button[@id='asset-edit-btn']");
    private static final By NOTES = By.id("notes");
    private static final By DELETE_ICONS = By.xpath("//i[@class='fa fa-trash']");
    private static final By YES_BTN = By.id("submit_modal_button");
    private static final By FIRST_NAME_TEXTBOX = By.id("name-first");
    private static final By LAST_NAME_TEXTBOX = By.id("name-last");
    private static final By EMAIL_TEXTBOX = By.id("email");
    private static final By PHONE_TEXTBOX = By.id("phone-business");
    private static final By COMPANY_NAME_TEXTBOX = By.xpath("//input[@name='name-company']");
    private static final By JOBSITE_ADDRESS_TEXTBOX = By.id("jobsite-address-1");
    private static final By MARKETING_CONSENT_NO = By.xpath("//label[@for='subscription-no']");
    private static final By SUBMIT_BTN = By.id("request-btn-quoteRequired-true");
    private static final By JOBSITE_ADDRESS_SUGGESTED_LIST = By.xpath("//li[@role='presentation']");


    public AddToRequestModalPageAEM clickOnEdit(int elementNumberToEdit) {
        waitUntilPresenceOfElementLocated(EDITS);
        List<WebElement> list = getListOfWebElements(EDITS);
        click(list.get(elementNumberToEdit));
        return new AddToRequestModalPageAEM();
    }

    public ShoppingCartPageAEM verifyNotes(int noteNumber) {
        waitUntilPresenceOfElementLocated(NOTES);
        List<WebElement> list = getListOfWebElements(NOTES);
        //getting text from hidden elements using JavaScript executor
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        String noteText = (String) js.executeScript("return arguments[0].textContent;", list.get(noteNumber));
        System.out.println("Actual noteText = " + noteText);
        System.out.println("AddToRequestModalPageAEM.note = " + AddToRequestModalPageAEM.note);
        areEqual(noteText, AddToRequestModalPageAEM.note);
        return this;
    }

    public ShoppingCartPageAEM deleteItem(int itemNumberToDelete) {
        waitUntilPresenceOfElementLocated(DELETE_ICONS);
        List<WebElement> list = getListOfWebElements(DELETE_ICONS);
        click(list.get(itemNumberToDelete));
        return this;
    }

    public ShoppingCartPageAEM submitDeletion() {
        waitUntilPresenceOfElementLocated(YES_BTN);
        click(YES_BTN, WaitType.CLICKABLE);
        return this;
    }

    public ShoppingCartPageAEM enterFirstname(String input) {
        waitUntilPresenceOfElementLocated(FIRST_NAME_TEXTBOX);
        sendKeys(FIRST_NAME_TEXTBOX, input);
        return this;
    }

    public ShoppingCartPageAEM enterLastname(String input) {
        waitUntilPresenceOfElementLocated(LAST_NAME_TEXTBOX);
        sendKeys(LAST_NAME_TEXTBOX, input);
        return this;
    }

    public ShoppingCartPageAEM enterEmail(String input) {
        waitUntilPresenceOfElementLocated(EMAIL_TEXTBOX);
        sendKeys(EMAIL_TEXTBOX, input);
        return this;
    }

    public ShoppingCartPageAEM enterPhone(String input) {
        waitUntilPresenceOfElementLocated(PHONE_TEXTBOX);
        sendKeys(PHONE_TEXTBOX, input);
        return this;
    }

    public ShoppingCartPageAEM enterCompanyName(String input) {
        waitUntilPresenceOfElementLocated(COMPANY_NAME_TEXTBOX);
        sendKeys(COMPANY_NAME_TEXTBOX, input);
        return this;
    }

    public ShoppingCartPageAEM enterJobsiteAddress(String input) {
        waitUntilPresenceOfElementLocated(JOBSITE_ADDRESS_TEXTBOX);
        sendKeys(JOBSITE_ADDRESS_TEXTBOX, input);
        List<WebElement> suggestedList = getListOfWebElements(JOBSITE_ADDRESS_SUGGESTED_LIST);
        waitForGivenTime(2);
        click(suggestedList.get(0));
        return this;
    }

    public ShoppingCartPageAEM declineMarketingConsent() {
        waitUntilPresenceOfElementLocated(MARKETING_CONSENT_NO);
        click(MARKETING_CONSENT_NO, WaitType.CLICKABLE);
        return this;
    }

    public ShoppingCartPageAEM clickOnSubmitButton() {
        waitUntilPresenceOfElementLocated(SUBMIT_BTN);
        click(SUBMIT_BTN, WaitType.CLICKABLE);
        waitUntilTitleIs("Confirmation");
        return this;
    }
}
