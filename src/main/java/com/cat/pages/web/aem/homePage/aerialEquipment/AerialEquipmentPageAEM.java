package com.cat.pages.web.aem.homePage.aerialEquipment;

import com.cat.enums.WaitType;
import com.cat.pages.web.aem.homePage.aerialEquipment.boomLifts.BoomLiftsAEM;
import org.openqa.selenium.By;

import static com.cat.utils.SeleniumUtils.click;

public class AerialEquipmentPageAEM {

    private static final By BOOM_LIFTS = By.xpath("//span[contains(text(), 'Boom Lifts')]");

    public BoomLiftsAEM clickOnBoomLifts() {
        click(BOOM_LIFTS, WaitType.CLICKABLE);
        return new BoomLiftsAEM();
    }
}
