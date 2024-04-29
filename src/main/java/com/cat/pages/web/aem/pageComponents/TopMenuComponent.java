package com.cat.pages.web.aem.pageComponents;

import com.cat.enums.WaitType;
import org.openqa.selenium.By;

import static com.cat.utils.SeleniumUtils.click;

public class TopMenuComponent {
    private static final By LNK_RENTALS = By.id("menu_admin_viewAdminModule");
    private static final String LNK_RENTALS_TXT = "Link: Admin";

    public TopMenuComponent clickRentals() {
        click(LNK_RENTALS, WaitType.CLICKABLE);
        return this;
    }
}
