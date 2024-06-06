package com.cat.pages.web.aem.homePage.aerialEquipment.boomLifts;

import com.cat.enums.WaitType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.cat.utils.SeleniumUtils.*;

public class BoomLiftsAEM {

    private static final By HEADER_NAME = By.xpath("//h1[@class='h1-title family-title']");
    private static final By LIST_OF_BOOM_LIFTS = By.xpath("//div[@id='product-card-list']//span[@class='product-card-title']");
    private static final By CLOSE_FIND_EQUIPMENT_NEAR_YOU_POPUP = By.xpath("//i[@class='fa fa-times']");

    public BoomLiftsAEM clickOnBoomLiftByIndex(int index) {
        //waitUntilElementToBeVisible(LIST_OF_BOOM_LIFTS);
        WebElement element = getListOfWebElements(LIST_OF_BOOM_LIFTS).get(index);
        for (WebElement el : getListOfWebElements(LIST_OF_BOOM_LIFTS)) {
            System.out.println(el.getText());
        }
        click(element);
        return this;
    }

    public BoomLiftsAEM closeFindEquipmentNearYouPopUp() {
        waitUntilElementToBeVisible(CLOSE_FIND_EQUIPMENT_NEAR_YOU_POPUP);
        click(CLOSE_FIND_EQUIPMENT_NEAR_YOU_POPUP, WaitType.CLICKABLE);
        return this;
    }
}
