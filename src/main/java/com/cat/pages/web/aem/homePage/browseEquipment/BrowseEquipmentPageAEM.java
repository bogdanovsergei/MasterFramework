package com.cat.pages.web.aem.homePage.browseEquipment;

import com.cat.enums.WaitType;
import com.cat.pages.web.aem.homePage.searchListEquipmentResult.SearchListEquipmentsResultPageAEM;
import org.openqa.selenium.By;

import static com.cat.utils.SeleniumUtils.click;
import static com.cat.utils.SeleniumUtils.sendKeys;

public class BrowseEquipmentPageAEM {

    private static final By EQUIPMENT_SEARCH_BOX = By.xpath("//input[@class='form-control search-what categorySuggestion']");
    private static final By LOCATION_SEARCH_BOX = By.xpath("//input[@class='form-control dropdown-toggle location-search-target searchFieldPlaceholderText']");
    private static final By FIND_EQUIPMENT_BTN = By.xpath("//a[@class='btn btn-default input-group-addon where-search']");

    public BrowseEquipmentPageAEM enterEquipmentInSearchBox(String equipment) {
        sendKeys(EQUIPMENT_SEARCH_BOX, equipment);
        return this;
    }

    public BrowseEquipmentPageAEM enterLocationInSearchBox(String location) {
        sendKeys(LOCATION_SEARCH_BOX, location);
        return this;
    }

    public SearchListEquipmentsResultPageAEM clickOnFindEquipmentBtn() {
        click(FIND_EQUIPMENT_BTN, WaitType.CLICKABLE);
        return new SearchListEquipmentsResultPageAEM();
    }
}
