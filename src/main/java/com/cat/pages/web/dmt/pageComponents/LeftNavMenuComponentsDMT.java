package com.cat.pages.web.dmt.pageComponents;

import com.cat.driver.DriverManager;
import com.cat.pages.web.dmt.requests.RequestsPageDMT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.cat.utils.SeleniumUtils.*;
import static com.cat.utils.VerificationUtils.contains;

public class LeftNavMenuComponentsDMT {

    private static final By LEFT_MENU_LIST = By.xpath("//span[@class='side-detail badge-container']");
    private static final By REQUESTS_SUBMENU_LIST = By.xpath("//a[@class='user-view']");
    private static final By HEADER_NAME = By.xpath("//h1['_ngcontent-dgn-c151']");

    public LeftNavMenuComponentsDMT clickOnLeftMenuByName(String menuItem) {
        waitUntilPresenceOfElementLocated(LEFT_MENU_LIST);
        List<WebElement> leftMenuListOfElements = DriverManager.getDriver().findElements(LEFT_MENU_LIST);
        for (WebElement leftMenuListOfElement : leftMenuListOfElements) {
            System.out.println(leftMenuListOfElement.getText());
            if (leftMenuListOfElement.getText().toUpperCase().contains(menuItem.toUpperCase())) {
                click(leftMenuListOfElement);
                //return this;
            }
        }
        //verify if headerName contains desired menuName
        //waitUntilPresenceOfElementLocated(HEADER_NAME);
        contains(getElementText(HEADER_NAME), menuItem);
        return this;
    }

    public void clickOnRequestsSubMenu(String submenuItem) {
        //waitUntilPresenceOfElementLocated(LEFT_MENU_LIST);
        //waitUntilAllElementsArePresent(LEFT_MENU_LIST);
        waitForGivenTime(2);
        List<WebElement> leftMenuListOfElements = waitUntilAllElementsArePresent(LEFT_MENU_LIST);
        for (WebElement leftMenuListOfElement : leftMenuListOfElements) {
            System.out.println(leftMenuListOfElement.getText());
            if (leftMenuListOfElement.getText().toUpperCase().contains("REQUESTS")) {
                click(leftMenuListOfElement);
                //return this;
            }
        }

        //waitUntilAllElementsArePresent(REQUESTS_SUBMENU_LIST);
        waitForGivenTime(2);
        List<WebElement> leftRequestsSubMenuListOfElements = waitUntilAllElementsArePresent(REQUESTS_SUBMENU_LIST);
        for (WebElement leftRequestsSubMenuListOfElement : leftRequestsSubMenuListOfElements) {
            System.out.println(leftRequestsSubMenuListOfElement.getText());
            if (leftRequestsSubMenuListOfElement.getText().toUpperCase().contains(submenuItem.toUpperCase())) {
                click(leftRequestsSubMenuListOfElement);
                System.out.println("Clicked on Sub menu");
                //return this;
            }
        }
        waitForGivenTime(2);
        waitUntilPresenceOfElementLocated(HEADER_NAME);
        waitUntilElementTextEqualsToDesiredValue(HEADER_NAME, submenuItem.toUpperCase());
    }

}
