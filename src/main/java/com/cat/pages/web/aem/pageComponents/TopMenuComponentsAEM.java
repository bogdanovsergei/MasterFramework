package com.cat.pages.web.aem.pageComponents;

import com.cat.enums.WaitType;
import org.openqa.selenium.By;

import static com.cat.utils.SeleniumUtils.*;

public class TopMenuComponentsAEM {

    private static final By MENU=By.xpath("//li[@class='menu']");
    private static final By BROWSE_EQUIPMENT_MENU=By.xpath("//a[contains(text(),'Browse Equipment') and @tabindex='1']");
    private static final By BROWSE_EQUIPMENT_BUG=By.xpath("//a[contains(text(),'Browse Equipment') and @tabindex='3']");
    private static final By ABOUT_US_MENU=By.xpath("//a[contains(text(),'About Us') and @tabindex='2' and @class='hidden-phone']");
    private static final By LOCATION_MENU=By.xpath("//a[contains(text(),'Location') and @tabindex='3']");
    private static final By BLOG_MENU=By.xpath("//a[contains(text(),'Blog') and @tabindex='4']");

    private static final By LNK_RENTALS = By.id("menu_admin_viewAdminModule");
    private static final String LNK_RENTALS_TXT = "Link: Admin";

    public TopMenuComponentsAEM clickOnRentals() {
        click(LNK_RENTALS, WaitType.CLICKABLE);
        return this;
    }

    public TopMenuComponentsAEM clickOnBrowserEquipment() {
//        try {
//            click(BROWSE_EQUIPMENT_BUG, WaitType.CLICKABLE);
//        } catch (Exception e){
//            click(BROWSE_EQUIPMENT_MENU, WaitType.CLICKABLE);
//        }
        click(BROWSE_EQUIPMENT_MENU, WaitType.CLICKABLE);
        waitUntilTitleIs("Tool Rentals & Equipment Rentals Near You | The Cat Rental Store");
        return this;
    }

    public TopMenuComponentsAEM clickOnAboutUs() {
        click(ABOUT_US_MENU, WaitType.CLICKABLE);
        waitUntilTitleIs("The Cat Rental Store - About Us");
        return this;
    }

    public TopMenuComponentsAEM clickOnLocation() {
        click(LOCATION_MENU, WaitType.CLICKABLE);
        waitUntilTitleIs("The Cat Rental Store Locations | Find An Equipment Rental Store Near You");
        return this;
    }

    public TopMenuComponentsAEM clickOnBlog() {
        click(BLOG_MENU, WaitType.CLICKABLE);
        waitUntilTitleIs("Construction Industry News and Rental Equipment Guides | The Cat Rental Store");
        return this;
    }



}
