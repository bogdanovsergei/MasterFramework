package com.cat.pages.web.aem.loginPage;

import com.cat.enums.WaitType;
import com.cat.pages.web.aem.homePage.HomePageAEM;
import org.openqa.selenium.By;

import static com.cat.utils.SeleniumUtils.*;

public class LoginPageAEM {

    private static final By TXTBOX_USERNAME = By.id("signInName"); //100 threads  --> 1 txtBoxUsername
    private static final By TXTBOX_PASSWORD = By.id("password");
    private static final By BTN_NEXT = By.id("next");
    private static final By MSG_ERROR = By.id("spanMessage");
    //private static final String MSG_ERROR_TXT = "Error Message";

    private LoginPageAEM setUsername(String username) {
        sendKeys(TXTBOX_USERNAME, username);
        return this;
    }

    private LoginPageAEM setPassword(String password) {
        sendKeys(TXTBOX_PASSWORD, password);
        return this;
    }

    private void clickNext() {
        click(BTN_NEXT, WaitType.CLICKABLE);
    }

    public HomePageAEM loginToApplication(String username, String password) {
        setUsername(username).clickNext();
        setPassword(password).clickNext();
        waitUntilTitleIs("Rentals");
        return new HomePageAEM();
    }

}
