package com.cat.pages.web.aem.homePage.searchListEquipmentResult;

import com.cat.pages.web.aem.homePage.addToRequestModal.AddToRequestModalPageAEM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.cat.utils.SeleniumUtils.*;

public class SearchListEquipmentsResultPageAEM {

    private static final By SEARCH_LIST_OF_EQUIPMENTS = By.xpath("//div[@id='searchList-result']//span[@class='product-card-title']");

    public AddToRequestModalPageAEM clickOnEquipmentByIndex(int index) {
        waitUntilPresenceOfElementLocated(SEARCH_LIST_OF_EQUIPMENTS);
        WebElement element = getListOfWebElements(SEARCH_LIST_OF_EQUIPMENTS).get(index);
        for (WebElement el : getListOfWebElements(SEARCH_LIST_OF_EQUIPMENTS)) {
            System.out.println(el.getText());
        }
        click(element);
        return new AddToRequestModalPageAEM();
    }
}
