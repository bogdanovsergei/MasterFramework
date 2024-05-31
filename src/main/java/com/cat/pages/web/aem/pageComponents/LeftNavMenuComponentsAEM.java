package com.cat.pages.web.aem.pageComponents;

import com.cat.driver.DriverManager;
import com.cat.enums.WaitType;
import com.cat.pages.web.aem.homePage.aerialEquipmentPage.AerialEquipmentPageAEM;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.cat.utils.SeleniumUtils.*;
import static com.cat.utils.SeleniumUtils.getElementText;
import static com.cat.utils.VerificationUtils.*;

public class LeftNavMenuComponentsAEM {

    private static final By HEADER=By.xpath("//strong/span[@itemprop='name']");
    private static final By MENU = By.id("leftNav-browserEquipment");
    private static final By AERIAL_EQUIPMENT_MENU=By.xpath("//span[contains(text(),'Aerial Equipment')]");
    private static final By AIR_EQUIPMENT_MENU=By.xpath("//span[contains(text(),'Air Equipment')]");
    private static final By COMPACTION_EQUIPMENT_MENU=By.xpath("//span[contains(text(),'Compaction Equipment')]");
    private static final By QUICK_QUOTE_MENU = By.id("left-nav-quick-quote-link");
    private static final By FIND_A_DEALER_MENU = By.id("find-a-dealer-link");
    private static final By FEEDBACK_MENU = By.id("left-nav-feedback-link");

    public AerialEquipmentPageAEM clickOnAerialEquipment() {
        click(AERIAL_EQUIPMENT_MENU, WaitType.CLICKABLE);
        contains(getElementText(HEADER),getElementText(AERIAL_EQUIPMENT_MENU));
        return new AerialEquipmentPageAEM();
    }

    public LeftNavMenuComponentsAEM clickOnAirEquipment() {
        click(AIR_EQUIPMENT_MENU, WaitType.CLICKABLE);
        contains(getElementText(HEADER),getElementText(AIR_EQUIPMENT_MENU));
        return this;
    }

    public LeftNavMenuComponentsAEM clickOnCompactionEquipment() {
        click(COMPACTION_EQUIPMENT_MENU, WaitType.CLICKABLE);
        contains(getElementText(HEADER),getElementText(COMPACTION_EQUIPMENT_MENU));
        return this;
    }

    public LeftNavMenuComponentsAEM clickOnFeedback() {
        click(FEEDBACK_MENU, WaitType.CLICKABLE);
        contains(getElementText(HEADER),getElementText(FEEDBACK_MENU));
        return this;
    }

    public LeftNavMenuComponentsAEM clickOnFindADealer() {
        click(FIND_A_DEALER_MENU, WaitType.CLICKABLE);
        contains(getElementText(HEADER), "Cat Rental Store Locations");
        return this;
    }

    public LeftNavMenuComponentsAEM clickOnQuickQuote() {
        click(QUICK_QUOTE_MENU, WaitType.CLICKABLE);
        contains(getElementText(HEADER),getElementText(QUICK_QUOTE_MENU));
        return this;
    }

    public LeftNavMenuComponentsAEM verifyAlphabeticalOrder() {
        List<WebElement> menu = DriverManager.getDriver().findElements(MENU);
        List<String> menuItems = new ArrayList<>();
        for (WebElement menuItem : menu) {
            menuItems.add(menuItem.getText());
            System.out.println(menuItem.getText());
        }
        isListInAlphabeticalOrder(menuItems);
        return this;
    }

    public LeftNavMenuComponentsAEM scrollLeftNavMenuByPixels(long pixels) {
        WebElement firstElement = DriverManager.getDriver().findElement(MENU);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollTop +=" + pixels, firstElement);
        return this;
    }
}
