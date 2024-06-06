package com.cat.pages.web.aem.pageComponents;

import com.cat.enums.WaitType;
import com.cat.pages.web.aem.homePage.locations.LocationsPageAEM;
import com.cat.pages.web.aem.homePage.shoppingCart.ShoppingCartPageAEM;
import com.cat.pages.web.aem.loginPage.LoginPageAEM;
import org.openqa.selenium.By;

import static com.cat.utils.SeleniumUtils.*;
import static com.cat.utils.VerificationUtils.areEqual;

public class TopMenuComponentsAEM {

    private static final By MENU=By.xpath("//li[@class='menu']");
    //private static final By BROWSE_EQUIPMENT_MENU=By.xpath("//a[contains(text(),'Browse Equipment') and @tabindex='1']");
    private static final By BROWSE_EQUIPMENT_MENU=By.xpath("li[@class='menu']//li[@class='no-hover no-children desktop-equipment-link']");
    private static final By BROWSE_EQUIPMENT_BUG=By.xpath("//a[contains(text(),'Browse Equipment') and @tabindex='3']");
    private static final By ABOUT_US_MENU=By.xpath("//a[contains(text(),'About Us') and @tabindex='2' and @class='hidden-phone']");
    private static final By LOCATION_MENU=By.xpath("//li[@class='menu']//a[@class='hidden-phone' and contains(text(),'Location')]");
    private static final By BLOG_MENU=By.xpath("//li[@class='menu']//a[@class='hidden-phone' and contains(text(),'Blog')]");
    private static final By CART_ITEMS_NUMBER = By.xpath("//span[@class='cart-items-number']");
    private static final By CART_ICON = By.xpath("//a[contains(text(),'CART')]");
    private static final By SIGNIN_BTN = By.xpath("//a[@class='signin-button']");

    private static final By LNK_RENTALS = By.id("menu_admin_viewAdminModule");
    private static final String LNK_RENTALS_TXT = "Link: Admin";

    public TopMenuComponentsAEM clickOnRentals() {
        click(LNK_RENTALS, WaitType.CLICKABLE);
        return this;
    }

    public TopMenuComponentsAEM clickOnBrowserEquipment() {
        try {
            click(BROWSE_EQUIPMENT_BUG, WaitType.CLICKABLE);
        } catch (Exception e){
            click(BROWSE_EQUIPMENT_MENU, WaitType.CLICKABLE);
        }
        //click(BROWSE_EQUIPMENT_MENU, WaitType.CLICKABLE);
        waitUntilTitleIs("Tool Rentals & Equipment Rentals Near You | The Cat Rental Store");
        return this;
    }

    public TopMenuComponentsAEM clickOnAboutUs() {
        click(ABOUT_US_MENU, WaitType.CLICKABLE);
        waitUntilTitleIs("The Cat Rental Store - About Us");
        return this;
    }

    public LocationsPageAEM clickOnLocation() {
        waitUntilPresenceOfElementLocated(LOCATION_MENU);
        click(LOCATION_MENU, WaitType.CLICKABLE);
        //waitUntilTitleIs("The Cat Rental Store Locations | Find An Equipment Rental Store Near You");
        return new LocationsPageAEM();
    }

    public TopMenuComponentsAEM clickOnBlog() {
        click(BLOG_MENU, WaitType.CLICKABLE);
        waitUntilTitleIs("Construction Industry News and Rental Equipment Guides | The Cat Rental Store");
        return this;
    }

    public ShoppingCartPageAEM clickOnCartIcon() {
        click(CART_ICON, WaitType.CLICKABLE);
        return new ShoppingCartPageAEM();
    }

    public LoginPageAEM clickOnSignInButton() {
        click(SIGNIN_BTN, WaitType.CLICKABLE);
        waitUntilTitleIs("Sign In");
        return new LoginPageAEM();
    }

    public TopMenuComponentsAEM isCartItemsNumberEqualTo(int number) {
        waitUntilPresenceOfElementLocated(CART_ITEMS_NUMBER);
        String actualNumber = getElementText(CART_ITEMS_NUMBER);
        String expectedNumber = String.valueOf(number);
        areEqual(actualNumber, expectedNumber);
        return this;
    }

}
