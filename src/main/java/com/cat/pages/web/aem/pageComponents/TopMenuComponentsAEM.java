package com.cat.pages.web.aem.pageComponents;

import com.cat.enums.WaitType;
import org.openqa.selenium.By;

import static com.cat.utils.SeleniumUtils.*;

public class TopMenuComponentsAEM {

    private static final By MENU=By.xpath("//li[@class='menu']");
    private static final By BROWSE_EQUIPMENT=By.xpath("//a[contains(text(),'Browse Equipment') and @tabindex='1']");
    private static final By ABOUT_US=By.xpath("//a[contains(text(),'About Us') and @tabindex='2' and @class='hidden-phone']");
    private static final By LOCATION=By.xpath("//a[contains(text(),'Location') and @tabindex='3']");

    private static final By LNK_RENTALS = By.id("menu_admin_viewAdminModule");
    private static final String LNK_RENTALS_TXT = "Link: Admin";

    public TopMenuComponentsAEM clickRentals() {
        click(LNK_RENTALS, WaitType.CLICKABLE);
        return this;
    }

    public TopMenuComponentsAEM clickBrowserEquipment() {
        click(BROWSE_EQUIPMENT, WaitType.CLICKABLE);
        waitUntilTitleIs("Tool Rentals & Equipment Rentals Near You | The Cat Rental Store");
        return this;
    }

    public TopMenuComponentsAEM clickAboutUs() {
        click(ABOUT_US, WaitType.CLICKABLE);
        waitUntilTitleIs("The Cat Rental Store - About Us");
        return this;
    }

    public TopMenuComponentsAEM clickLocation() {
        click(LOCATION, WaitType.CLICKABLE);
        waitUntilTitleIs("The Cat Rental Store Locations | Find An Equipment Rental Store Near You");
        return this;
    }



}
