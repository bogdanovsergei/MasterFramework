package com.cat.pages.web.dmt;

import com.cat.config.factory.ConfigFactory;
import com.cat.driver.DriverManager;
import com.cat.enums.WaitType;
import com.cat.pages.web.aem.LoginPageAEM;
import org.openqa.selenium.By;

import static com.cat.utils.SeleniumUtils.click;
import static com.cat.utils.SeleniumUtils.sendKeys;

public class LoginPageDMT {

    //private TopMenuComponentsAEM topMenuComponent;

    public LoginPageDMT() {
        //topMenuComponent = new TopMenuComponentsAEM();
        DriverManager.getDriver().get(ConfigFactory.getConfig().urlDMT());
    }

    private static final By TXTBOX_USERNAME = By.id("signInName"); //100 threads  --> 1 txtBoxUsername
    private static final By TXTBOX_PASSWORD = By.id("password");
    private static final By BTN_NEXT = By.id("next");

    public LoginPageDMT setUsername(String username) {
        sendKeys(TXTBOX_USERNAME, username);
        return this;
    }

    public LoginPageDMT setPassword(String password) {
        sendKeys(TXTBOX_PASSWORD, password);
        return this;
    }

    public void clickNext() {
        click(BTN_NEXT, WaitType.CLICKABLE);
    }

    public void loginToApplication(String username, String password) {
        setUsername(username).clickNext();
        setPassword(password).clickNext();
    }
}
