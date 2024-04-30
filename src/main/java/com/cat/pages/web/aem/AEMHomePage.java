package com.cat.pages.web.aem;

import com.cat.config.factory.ConfigFactory;
import com.cat.driver.DriverManager;
import com.cat.enums.WaitType;
import com.cat.pages.web.aem.pageComponents.TopMenuComponent;
import org.openqa.selenium.By;
import static com.cat.utils.SeleniumUtils.*;

public class AEMHomePage {

    private TopMenuComponent topMenuComponent;

    public AEMHomePage() {
        topMenuComponent = new TopMenuComponent();
        DriverManager.getDriver().get(ConfigFactory.getConfig().urlAEM());
    }

    private static final By USER_ICON = By.xpath("//li[@class=\"login my-account my-account-desktop not-logged-in crs-nav-dropdown\"]//i[@class=\"fa fa-user\"]");
    private static final By SIGN_IN_BTN_ICON = By.xpath("//ul[@class=\"my-account-content menu--content login_auth-track show-menu-dropdown\"]//button[@class=\"signin-button card-shadow\"]");
    private static final By SIGN_IN_BTN = By.xpath("//a[@class=\"signin-button\"]");
    private static final By LOGOUT=By.xpath("");

    public void clickOnRentals() {
        topMenuComponent.clickRentals();
    }

    public AEMHomePage clickOnSignIn() {
        click(SIGN_IN_BTN, WaitType.CLICKABLE);
        return this;
    }

    private AEMLoginPage clickOnLogout() {
        click(LOGOUT, WaitType.CLICKABLE);
        return new AEMLoginPage();
    }

}
