package com.cat.pages.web.aem.homePage.addToRequestModal;

import com.cat.driver.DriverManager;
import com.cat.enums.WaitType;
import com.cat.pages.web.aem.homePage.searchListEquipmentResult.SearchListEquipmentsResultPageAEM;
import com.cat.pages.web.aem.homePage.shoppingCart.ShoppingCartPageAEM;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.cat.utils.SeleniumUtils.*;

public class AddToRequestModalPageAEM {

    private static final By QUANTITY_PLUS = By.xpath("//i[@class='fa fa-plus']");
    private static final By START_DATE = By.xpath("//div[@class='modal-content']//td[@class='today in-range-min active start-date active end-date in-range available' or @class='today weekend in-range-min active start-date active end-date in-range available']");
    private static final By END_DATE = By.xpath("//div[@class='modal-content']//div[@class='drp-calendar right']//tbody//tr[5]//td[@data-title='r4c1']");
    private static final By MODAL_BODY = By.xpath("//div[@class='modal-container add-cart-modal']");
    private static final By NOTES_TEXTBOX = By.xpath("//textarea[@name='cart-notes']");
    private static final By ADD_TO_REQUEST_BTN = By.id("submit_modal_button");
    private static final By ATTACHMENT_FIRST = By.xpath("//input[@name='list 1' and @label='item 10']");
    private static final By SAVE_CHANGES_BTN = By.id("submit_modal_button");

    public static String note;

    public AddToRequestModalPageAEM increaseQuantity() {
        waitUntilPresenceOfElementLocated(QUANTITY_PLUS);
        click(QUANTITY_PLUS, WaitType.CLICKABLE);
        return this;
    }

    public AddToRequestModalPageAEM selectStartDate() {
        waitUntilPresenceOfElementLocated(START_DATE);
        click(START_DATE, WaitType.CLICKABLE);
        return this;
    }

    public AddToRequestModalPageAEM selectEndDate() {
        waitUntilPresenceOfElementLocated(END_DATE);
        click(END_DATE, WaitType.CLICKABLE);
        return this;
    }

    public AddToRequestModalPageAEM scrollToBottom() {
        WebElement modalBody = DriverManager.getDriver().findElement(MODAL_BODY);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", modalBody);
        return this;
    }

    public AddToRequestModalPageAEM inputNotes(String note) {
        this.note=note;
        waitUntilPresenceOfElementLocated(NOTES_TEXTBOX);
        getElement(NOTES_TEXTBOX).clear();
        sendKeys(NOTES_TEXTBOX, note);
        return this;
    }

    public SearchListEquipmentsResultPageAEM clickOnAddToRequestButton() {
        waitUntilPresenceOfElementLocated(ADD_TO_REQUEST_BTN);
        click(ADD_TO_REQUEST_BTN, WaitType.CLICKABLE);
        return new SearchListEquipmentsResultPageAEM();
    }

    public AddToRequestModalPageAEM selectFirstAttachment() {
        waitUntilPresenceOfElementLocated(ATTACHMENT_FIRST);
        click(ATTACHMENT_FIRST, WaitType.CLICKABLE);
        return this;
    }

    public ShoppingCartPageAEM clickOnSaveChangesButton() {
        waitUntilPresenceOfElementLocated(SAVE_CHANGES_BTN);
        click(SAVE_CHANGES_BTN, WaitType.CLICKABLE);
        return new ShoppingCartPageAEM();
    }
}
