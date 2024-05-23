package com.cat.pages.mobile.loginScreen;

import com.cat.enums.WaitType;
import com.cat.pages.mobile.homeScreen.HomeScreen;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import static com.cat.utils.MobileUtils.*;
import static com.cat.utils.SeleniumUtils.waitForGivenTime;

public class LoginScreen {

    //private TopMenuComponentsAEM topMenuComponent;

    public LoginScreen() {
        //topMenuComponent = new TopMenuComponentsAEM();
        //DriverManager.getDriver().get(ConfigFactory.getConfig().urlDMT());
    }

    private static final By ALLOW_NOTIFICATION_BTN = By.xpath("//android.widget.Button[@text='Allow']");
    private static final By ACCEPT_SWITCH = AppiumBy.xpath("//android.widget.Switch[@resource-id=\"com.perficient.rental.catstaging:id/switch_accept\"]");
    private static final By ACCEPT_BTN = By.id("com.perficient.rental.catstaging:id/button_accept");
    private static final By LOGIN_BTN = By.id("com.perficient.rental.catstaging:id/button_login");
    private static final By BIOMETRIC_NOT_NOW_BTN = By.id("android:id/button2");
    private static final By BIOMETRIC_OK_BTN = By.id("android:id/button1");
    private static final By ACCEPT_AND_CONTINUE_GOOGLE_TERMS = By.id("com.android.chrome:id/terms_accept");
    private static final By NO_THANKS_BTN = AppiumBy.id("com.android.chrome:id/negative_button");
    //private static final By I_ACCEPT_COOKIES_BTN = AppiumBy.id("onetrust-accept-btn-handler");
    private static final By I_ACCEPT_COOKIES_BTN = AppiumBy.xpath("//android.view.View[@resource-id=\"body-footer\"]");
    private static final By TXTBOX_USERNAME = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"signInName\"]"); //100 threads  --> 1 txtBoxUsername
    private static final By TXTBOX_PASSWORD = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]");
    private static final By NEXT_BTN = AppiumBy.xpath("//android.widget.Button[@resource-id=\"next\"]");


    public LoginScreen setUsername(String username) {
        sendKeys(TXTBOX_USERNAME, username);
        return this;
    }

    public LoginScreen setPassword(String password) {
        sendKeys(TXTBOX_PASSWORD, password);
        return this;
    }

    public LoginScreen clickNext() {
        click(NEXT_BTN, WaitType.CLICKABLE);
        return this;
    }

    public LoginScreen acceptAgreement() {
        if (ALLOW_NOTIFICATION_BTN != null) {
            click(ALLOW_NOTIFICATION_BTN, WaitType.CLICKABLE);
        }
        click(ACCEPT_SWITCH, WaitType.CLICKABLE);
        click(ACCEPT_BTN, WaitType.CLICKABLE);
        return this;
    }

    public LoginScreen acceptBiometrics() {
        click(LOGIN_BTN, WaitType.CLICKABLE);
        if (BIOMETRIC_NOT_NOW_BTN != null)
            click(BIOMETRIC_NOT_NOW_BTN, WaitType.CLICKABLE);
        if (BIOMETRIC_OK_BTN != null)
            click(BIOMETRIC_OK_BTN, WaitType.CLICKABLE);
        System.out.println("Biometrics accepted/not accepted.");
        return this;
    }
    public LoginScreen acceptGoogleTermsAndCookies() {
        waitForGivenTime(3);
        //if (ACCEPT_AND_CONTINUE_GOOGLE_TERMS != null)
        click(ACCEPT_AND_CONTINUE_GOOGLE_TERMS, WaitType.CLICKABLE);
        //if (NO_THANKS_BTN != null)
        click(NO_THANKS_BTN, WaitType.CLICKABLE);
        System.out.println("Google terms declined.");
        //if (NO_THANKS_BTN != null)
        //    click(NO_THANKS_BTN, WaitType.CLICKABLE);
        //System.out.println("No thanks 2 accepted");
        //waitForGivenTime(3);
        click(I_ACCEPT_COOKIES_BTN, WaitType.CLICKABLE);
        System.out.println("Cookies accepted.");
        return this;
    }
    public HomeScreen loginToApplication(String username, String password) {
        setUsername(username).clickNext();
        setPassword(password).clickNext();
        return new HomeScreen();
    }

}
