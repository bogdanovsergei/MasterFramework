package com.cat.pages.web.aem;

import com.cat.config.factory.ConfigFactory;
import com.cat.driver.DriverManager;
import com.cat.enums.WaitType;
import com.cat.pages.web.aem.pageComponents.TopMenuComponentsAEM;
import org.openqa.selenium.By;
import static com.cat.utils.SeleniumUtils.*;

public class HomePageAEM {

    private TopMenuComponentsAEM topMenuComponent;

    public HomePageAEM() {
        topMenuComponent = new TopMenuComponentsAEM();
        DriverManager.getDriver().get(ConfigFactory.getConfig().urlAEM());
    }

    private static final By USER_ICON = By.xpath("//li[@class=\"login my-account my-account-desktop not-logged-in crs-nav-dropdown\"]//i[@class=\"fa fa-user\"]");
    private static final By SIGN_IN_BTN_ICON = By.xpath("//ul[@class=\"my-account-content menu--content login_auth-track show-menu-dropdown\"]//button[@class=\"signin-button card-shadow\"]");
    private static final By SIGN_IN_BTN = By.xpath("//a[@class=\"signin-button\"]");
    private static final By LOGOUT=By.xpath("");
    private static final By CRS_LOGO=By.xpath("//img[@class='desktop-logo']");
    private static final By PHONE_ICON=By.xpath("//a[@class='phone-number marketingPhone_auth-track']");
    private static final By CART_ICON=By.xpath("//a[contains(text(),'CART')]");
    private static final By LANGUAGE_SELECTOR=By.xpath("//span[@class='current-lenguage']");
    private static final By REGISTER_BTN=By.xpath("//a[@class='register-button']");

    /*
    public void clickOnRentals() {
        topMenuComponent.clickRentals();
    }
    public HomePageAEM clickBrowserEquipment() {
        topMenuComponent.clickBrowserEquipment();
    }
    */
    public LoginPageAEM clickOnSignIn() {
        click(SIGN_IN_BTN, WaitType.CLICKABLE);
        return new LoginPageAEM();
    }

    private LoginPageAEM clickOnLogout() {
        click(LOGOUT, WaitType.CLICKABLE);
        return new LoginPageAEM();
    }

    public HomePageAEM isCRSLogoPresent() {
        waitUntilPresenceOfElementLocated(CRS_LOGO);
        return this;
    }

    public HomePageAEM isSignInBtnPresent() {
        waitUntilPresenceOfElementLocated(SIGN_IN_BTN);
        return this;
    }

    public HomePageAEM isPhoneIconPresent() {
        waitUntilPresenceOfElementLocated(PHONE_ICON);
        return this;
    }

    public HomePageAEM isCartIconPresent() {
        waitUntilPresenceOfElementLocated(CART_ICON);
    return this;
    }

    public HomePageAEM isLanguageSelectorPresent() {
        waitUntilPresenceOfElementLocated(LANGUAGE_SELECTOR);
        return this;
    }

    public HomePageAEM isRegisterBtnPresent() {
        waitUntilPresenceOfElementLocated(REGISTER_BTN);
        return this;
    }
}
