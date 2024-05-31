package com.cat.pages.web.aem.pageComponents;

import com.cat.driver.DriverManager;
import com.cat.enums.WaitType;
import com.cat.pages.web.aem.homePage.browseEquipmentPage.BrowseEquipmentPageAEM;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.cat.utils.SeleniumUtils.*;
import static com.cat.utils.VerificationUtils.contains;

public class FooterComponentsAEM {

    public FooterComponentsAEM() {
        scrollToBottom();
    }

    private static final By LANGUAGE_SELECTOR =By.xpath("//div[@class='row-fluid languageSelector_auth-track']//span[@class='current-lenguage']");
    private static final By LANGUAGE_LIST = By.xpath("//div[@class='row-fluid languageSelector_auth-track']//div[@class='languageSelector']/ul/li/a");
    private static final By COOKIE_SETTINGS = By.xpath("//a[@class='ot-sdk-show-settings']");
    private static final By COOKIE_SETTINGS_CONTENT = By.id("ot-pc-content");
    private static final By TARGETING_COOkIES_TOGGLE = By.xpath("//label[@for='ot-group-id-C0004']");
    private static final By CONFIRM_MY_CHOICES_BTN = By.xpath("//button[contains(text(),'Confirm My Choices')]");
    private static final By BROWSE_EQUIPMENT = By.xpath("//div[@class='container-fluid footer_auth-track']//a[contains(text(),'Browse Equipment')]");

    private static final By BROWSE_EQUIPMENT_ES = By.xpath("//a[contains(text(),'Buscar equipo') and @tabindex='1']");
    private static final By BROWSE_EQUIPMENT_EN =By.xpath("//a[contains(text(),'Browse Equipment') and @tabindex='1']");

    private static List<WebElement> listOfLanguages;
    private static String selectedLanguage;

    public FooterComponentsAEM scrollToBottomPage() {
        scrollToBottom();
        return this;
    }

    public FooterComponentsAEM clickOnCookieSettings() {
        waitForGivenTime(3);
        click(COOKIE_SETTINGS, WaitType.CLICKABLE);
        return this;
    }

    public BrowseEquipmentPageAEM clickOnBrowseEquipment() {
        waitForGivenTime(3);
        click(BROWSE_EQUIPMENT, WaitType.CLICKABLE);
        waitUntilTitleIs("Tool Rentals & Equipment Rentals Near You | The Cat Rental Store");
        return new BrowseEquipmentPageAEM();
    }

    public FooterComponentsAEM clickOnTargetingCookies() {
        click(TARGETING_COOkIES_TOGGLE, WaitType.CLICKABLE);
        return this;
    }

    public FooterComponentsAEM clickOnConfirmMyChoicesBtn() {
        click(CONFIRM_MY_CHOICES_BTN, WaitType.CLICKABLE);
        return this;
    }

    public FooterComponentsAEM hoverOnLanguageSelector() {
        hoverToElement(LANGUAGE_SELECTOR);
        //verify if all languages are present
        String listOfLanguagesString = "";
        listOfLanguages = DriverManager.getDriver().findElements(LANGUAGE_LIST);
        for (WebElement language : listOfLanguages) {
            listOfLanguagesString += language.getText() + ", ";
        }
        System.out.println("List of languages: " + listOfLanguagesString);
        contains(listOfLanguagesString, "Español");
        contains(listOfLanguagesString, "Français");
        contains(listOfLanguagesString, "Português");
        contains(listOfLanguagesString, "简体中文");
        contains(listOfLanguagesString, "English");
        return this;
    }

    public FooterComponentsAEM selectLanguageByIndex(int index) {
        selectedLanguage = listOfLanguages.get(index).getText();
        click(listOfLanguages.get(index));
        return this;
    }

    public FooterComponentsAEM verifyPageBasedOnSelectedLanguage() {
        //verify if Browse Equipment button is present on Top Menu based on the language
        //to add 3 more languages
        if (selectedLanguage.equalsIgnoreCase("Español")) {
            waitUntilElementToBeVisible(BROWSE_EQUIPMENT_ES);
        }
        else if (selectedLanguage.equalsIgnoreCase("English")) {
            waitUntilElementToBeVisible(BROWSE_EQUIPMENT_EN);
        }
        return this;
    }

    public FooterComponentsAEM scrollInCookieSettings(long pixels) {
        WebElement firstElement = DriverManager.getDriver().findElement(COOKIE_SETTINGS_CONTENT);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollTop +=" + pixels, firstElement);
        return this;
    }
}
