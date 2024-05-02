package com.cat.pages.web.aem.pageComponents;

import com.cat.driver.DriverManager;
import com.cat.enums.WaitType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.cat.utils.SeleniumUtils.*;
import static com.cat.utils.SeleniumUtils.getElementText;
import static com.cat.utils.VerificationUtils.*;

public class LeftNavMenuComponentsAEM {

    private static final By HEADER=By.xpath("//strong/span[@itemprop='name']");
    private static final By AERIAL_EQUIPMENT=By.xpath("//span[contains(text(),'Aerial Equipment')]");
    private static final By MENU = By.id("leftNav-browserEquipment");

    public LeftNavMenuComponentsAEM clickAerialEquipment() {
        click(AERIAL_EQUIPMENT, WaitType.CLICKABLE);
        contains(getElementText(HEADER),getElementText(AERIAL_EQUIPMENT));
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

    public LeftNavMenuComponentsAEM goThroughAllMenuItemsAndVerifyHeader() throws InterruptedException {
        //List<WebElement> menuItems = DriverManager.getDriver().findElements(By.id("leftNav-browserEquipment"));
        List<WebElement> menuItems = DriverManager.getDriver().findElements(By.xpath("//div[@class='equipment-category-item ']"));
        menuItems.get(0).click();
        Thread.sleep(2000);
        DriverManager.getDriver().findElement(By.xpath("//div[@class='equipment-category-item '][1]")).click();
        Thread.sleep(2000);
        menuItems.get(2).click();
        Thread.sleep(2000);
        menuItems.get(3).click();

        for (int i=0; i<menuItems.size(); i++) {
            System.out.println(i);
            WebElement element = DriverManager.getDriver().findElement(By.xpath("//div[@class='equipment-category-item ']["+i+"]"));
            System.out.println(menuItems.get(i).getText());
            click(element);
            WebElement headerName = getElementAfterWait(HEADER, WaitType.PRESENCE);
            System.out.println(headerName.getText());
            Thread.sleep(2000);
            //WebElement headerName = getElementAfterWait(HEADER, WaitType.VISIBLE);
            //areEqual(menuItem.getText(), headerName.getText());
        }


        return this;
    }
}
