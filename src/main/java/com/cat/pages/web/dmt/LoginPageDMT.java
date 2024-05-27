package com.cat.pages.web.dmt;

import com.cat.config.factory.ConfigFactory;
import com.cat.driver.DriverManager;
import com.cat.enums.WaitType;
import com.cat.pages.web.aem.LoginPageAEM;
import org.openqa.selenium.By;

import static com.cat.utils.SeleniumUtils.*;

public class LoginPageDMT {

    //private TopMenuComponentsAEM topMenuComponent;

    public LoginPageDMT() {
        //topMenuComponent = new TopMenuComponentsAEM();
    }

    private static final By TXTBOX_USERNAME = By.id("signInName"); //100 threads  --> 1 txtBoxUsername
    private static final By TXTBOX_PASSWORD = By.id("password");
    private static final By BTN_NEXT = By.id("next");
    private static final By ACCEPT_COOKIES_BTN = By.id("onetrust-accept-btn-handler");

    public LoginPageDMT acceptCookies() {
        click(ACCEPT_COOKIES_BTN, WaitType.VISIBLE);
        return this;
    }
    public LoginPageDMT setUsername(String username) {
        waitUntilElementToBeVisible(TXTBOX_USERNAME);
        sendKeys(TXTBOX_USERNAME, username);
        return this;
    }

    public LoginPageDMT setPassword(String password) {
        waitUntilElementToBeVisible(TXTBOX_PASSWORD);
        sendKeys(TXTBOX_PASSWORD, password);
        return this;
    }

    public LoginPageDMT clickNext() {
        click(BTN_NEXT, WaitType.CLICKABLE);
        return this;
    }

    public HomePageDMT loginToApplication(String username, String password) {
        setUsername(username).clickNext();
        setPassword(password).clickNext();
        waitForGivenTime(8);
        return new HomePageDMT();
    }


}
