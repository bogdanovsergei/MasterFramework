package com.cat.pages.web.aem.homePage.account;

import com.cat.config.factory.ConfigFactory;
import com.cat.enums.WaitType;
import org.openqa.selenium.By;

import static com.cat.utils.SeleniumUtils.*;
import static com.cat.utils.VerificationUtils.areEqual;

public class AccountPageAEM {

    private static final By USERNAME_TXT = By.xpath("//li[@id='crs-account-details-cwsLogin']/span");
    private static final By CHANGE_PASSWORD_LINK = By.xpath("//div[@id='userInfo']//a[@id='crs-account-change-password']");
    private static final By EDIT_PROFILE_LINK = By.xpath("//div[@id='userInfo']//a[@id='crs-account-edit-profile']");
    private static final By LANGUAGE_DROPDOWN = By.id("language");
    private static final By DATE_FORMAT_DROPDOWN = By.id("date-format");
    private static final By TIMEZONE_DROPDOWN = By.id("region");
    private static final By REPORT_DOWNLOAD_LINK = By.xpath("//a[@class='report']");
    private static final By PAGE_IS_LOADED_INDICATOR = By.xpath("//body[@class='page basicpage deg crs-portal']");
    private static final By DELETE_REPORT_ICON = By.xpath("//button[@class='delete-report-button']");
    private static final By CONFIRM_BTN = By.id("confirm");

    public AccountPageAEM clickOnLanguageDropdown() {
        click(LANGUAGE_DROPDOWN, WaitType.CLICKABLE);
        return this;
    }

    public AccountPageAEM clickOnDateFormatDropdown() {
        click(DATE_FORMAT_DROPDOWN, WaitType.CLICKABLE);
        return this;
    }

    public AccountPageAEM clickOnTimeZoneDropdown() {
        click(TIMEZONE_DROPDOWN, WaitType.CLICKABLE);
        return this;
    }

    public AccountPageAEM verifyUsername() {
        areEqual(getElementText(USERNAME_TXT), ConfigFactory.getConfig().usernameAEM());
        return this;
    }

    public AccountPageAEM isChangePasswordLinkPresent() {
        waitUntilPresenceOfElementLocated(CHANGE_PASSWORD_LINK);
        return this;
    }

    public AccountPageAEM isEditProfileLinkPresent() {
        waitUntilPresenceOfElementLocated(EDIT_PROFILE_LINK);
        return this;
    }

    public AccountPageAEM switchEmailNotification(String switcher) {
        switcher = switcher.toLowerCase();
        By notificationEmail = By.xpath("//label[@for='email-notifications-" +switcher+ "']");
        click(notificationEmail, WaitType.CLICKABLE);
        return this;
    }

    public AccountPageAEM switchBrowserNotification(String switcher) {
        switcher = switcher.toLowerCase();
        By notificationBrowser = By.xpath("//label[@for='web-push-" +switcher+ "']");
        click(notificationBrowser, WaitType.CLICKABLE);
        return this;
    }

    public AccountPageAEM switchMobileAppNotification(String switcher) {
        switcher = switcher.toLowerCase();
        By notificationMobile = By.xpath("//label[@for='mobile-push-" +switcher+ "']");
        click(notificationMobile, WaitType.CLICKABLE);
        return this;
    }

    public AccountPageAEM switchRentReportSettingsDaily(String switcher) {
        switcher = switcher.toLowerCase();
        By rentReportSettingsDaily = By.xpath("//label[@for='crs-daily-morning-" +switcher+ "']");
        click(rentReportSettingsDaily, WaitType.CLICKABLE);
        return this;
    }

    public AccountPageAEM switchRentReportSettingsWeekly(String switcher) {
        switcher = switcher.toLowerCase();
        By rentReportSettingsWeekly = By.xpath("//label[@for='crs-weekly-monday-" +switcher+ "']");
        click(rentReportSettingsWeekly, WaitType.CLICKABLE);
        return this;
    }

    public AccountPageAEM switchRentReportSettingsMonthly(String switcher) {
        switcher = switcher.toLowerCase();
        By rentReportSettingsMonthly = By.xpath("//label[@for='crs-monthly-firstofmonth-" +switcher+ "']");
        click(rentReportSettingsMonthly, WaitType.CLICKABLE);
        return this;
    }

    public AccountPageAEM selectTimeZoneByName(String text) {
        selectFromDropdownByVisibleText(TIMEZONE_DROPDOWN, text);
        return this;
    }

    public AccountPageAEM downloadReport() {
        click(REPORT_DOWNLOAD_LINK, WaitType.CLICKABLE);
        waitUntilPresenceOfElementLocated(PAGE_IS_LOADED_INDICATOR);
        return this;
    }

    public AccountPageAEM deleteReport() {
        click(DELETE_REPORT_ICON, WaitType.CLICKABLE);
        waitUntilPresenceOfElementLocated(CONFIRM_BTN);
        click(CONFIRM_BTN, WaitType.CLICKABLE);
        return this;
    }


}
