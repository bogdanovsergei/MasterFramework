package com.cat.pages.web.dmt;

import com.cat.driver.DriverManager;
import com.cat.enums.WaitType;
import com.cat.pages.web.dmt.pageComponents.LeftNavMenuComponentsDMT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.cat.utils.SeleniumUtils.*;
import static com.cat.utils.VerificationUtils.*;

public class HomePageDMT {

    private final LeftNavMenuComponentsDMT leftNavMenuComponentsDMT;

    public HomePageDMT() {
        leftNavMenuComponentsDMT = new LeftNavMenuComponentsDMT();
        //DriverManager.getDriver().get(ConfigFactory.getConfig().urlAEM());
    }

    private static final By ACCOUNT_DROPDOWN_MENU_BTN = By.id("dropdownMenuButton");
    private static final By LOGOUT = By.xpath("//a[@class='dropdown-item' and contains(text(),'Logout')]");
    private static final By SWITCH_DEALER_DROPDOWN = By.xpath("//span[@class='ng-arrow-wrapper']");
    private static final By DEALER_LIST_FROM_DROPDOWN = By.xpath("//div[@role='option']");
    private static final By DEALER_LIST_FROM_SELECTION_PAGE = By.xpath("//ul[@class='user-role-list ml-5']/li/a");
    private static final By SUPER_ADMIN_BTN = By.xpath("//a[@class='btn btn-outline-dark btn-sm mt-5']");

    public LoginPageDMT clickOnLogout() {
        click(ACCOUNT_DROPDOWN_MENU_BTN, WaitType.CLICKABLE);
        click(LOGOUT, WaitType.CLICKABLE);
        waitForGivenTime(8);
        return new LoginPageDMT();
    }
    public HomePageDMT clickOnSwitchDealerDropdown() {
        waitForGivenTime(3);
        click(ACCOUNT_DROPDOWN_MENU_BTN, WaitType.CLICKABLE);
        click(SWITCH_DEALER_DROPDOWN, WaitType.CLICKABLE);
        return this;
    }

    public HomePageDMT verifyDealersListFromSwitchDealerDropdownMenu() {
        waitForGivenTime(2);
        List<WebElement> dealerListFromDropdown = DriverManager.getDriver().findElements(DEALER_LIST_FROM_DROPDOWN);
        List<WebElement> dealerListFromSelectionPage = DriverManager.getDriver().findElements(DEALER_LIST_FROM_SELECTION_PAGE);

        //convert to List of Strings
        System.out.println("Dealer list from Dropdown menu:");
        for (WebElement dealer : dealerListFromDropdown) {
            System.out.println(dealer.getText());
        }
        //adding Super Admin web element
        if (!dealerListFromSelectionPage.get(0).getText().equalsIgnoreCase("Super Admin")) {
            dealerListFromSelectionPage.add(0,DriverManager.getDriver().findElement(SUPER_ADMIN_BTN));
        }
        System.out.println("Dealer list from Selection page");
        for (WebElement dealer : dealerListFromSelectionPage) {
            System.out.println(dealer.getText());
        }
        areListsOfWebElementsEqual(dealerListFromDropdown, dealerListFromSelectionPage);
        return this;
    }

    public HomePageDMT clickOnDealerByName(String dealer) {
        waitForGivenTime(2);
        List<WebElement> dealerListFromSelectionPage = DriverManager.getDriver().findElements(DEALER_LIST_FROM_SELECTION_PAGE);
        for (WebElement dealerFromList: dealerListFromSelectionPage) {
            if (dealerFromList.getText().equalsIgnoreCase(dealer)) {
                click(dealerFromList);
                return this;
            }
        }
        return this;
    }

    public HomePageDMT verifyAllMenuItems(String menuItem) {
        waitForGivenTime(3);
        //List<WebElement> leftMenuListOfElements = DriverManager.getDriver().findElements(leftNavMenuComponentsDMT.getLeftMenuListLocator());

        return this;
    }

}
