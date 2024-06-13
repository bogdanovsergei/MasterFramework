package com.cat.pages.web.aem.homePage.rentals;

import com.cat.driver.DriverManager;
import com.cat.enums.WaitType;
import com.cat.pages.web.aem.pageComponents.FooterComponentsAEM;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.cat.utils.SeleniumUtils.*;
import static com.cat.utils.SeleniumUtils.waitUntilPresenceOfElementLocated;
import static com.cat.utils.VerificationUtils.contains;

public class RentalsPageAEM {
    private static final By MAP_OR_LIST_VIEW = By.xpath("//i[@class='fa fa-map-marker']");
    private static final By PAGE_IS_LOADED_INDICATOR = By.xpath("//body[@class='page basicpage deg crs-portal']");
    private static final By ASSETS_TYPE_ALL = By.id("rental-asset-type-all");
    private static final By ASSETS_TYPE_RESERVATION = By.id("rental-asset-type-reservations");
    private static final By ASSETS_TYPE_MACHINES = By.id("rental-asset-type-primary");
    private static final By FILTERS_BTN = By.id("portal-filter-button");
    private static final By MODAL_PREFERENCES_CLOSE_ICON = By.xpath("//a[@class='modal-close card-shadow' and @tabindex='0']");
    private static final By LIST_CONTAINER = By.id("list-container");
    private static final By CREATE_REPORT_BTN = By.id("create_report_button");
    private static final By MODAL_REPORT_TEXT = By.xpath("//div[@class='modal-container']/div[@class='modal-content']");
    private static final By MODAL_REPORT_CLOSE_WINDOW = By.xpath("//div[@class='modal-container']/a[@class='modal-close card-shadow']");

    public RentalsPageAEM clickOnAssetsTypeAll() {
        click(ASSETS_TYPE_ALL, WaitType.CLICKABLE);
        return this;
    }

    public RentalsPageAEM clickOnAssetsTypeReservation() {
        click(ASSETS_TYPE_RESERVATION, WaitType.CLICKABLE);
        return this;
    }

    public RentalsPageAEM clickOnAssetsTypeMachines() {
        click(ASSETS_TYPE_MACHINES, WaitType.CLICKABLE);
        return this;
    }

    public RentalsPageAEM clickOnFilters() {
        click(FILTERS_BTN, WaitType.CLICKABLE);
        return this;
    }

    public RentalsPageAEM clickOnCreateReportButton() {
        waitUntilPresenceOfElementLocated(CREATE_REPORT_BTN);
        click(CREATE_REPORT_BTN, WaitType.CLICKABLE);
        waitForGivenTime(3);
        return this;
    }

    public RentalsPageAEM closePreferencesModalWindow() {
        waitUntilPresenceOfElementLocated(MODAL_PREFERENCES_CLOSE_ICON);
        click(MODAL_PREFERENCES_CLOSE_ICON, WaitType.CLICKABLE);
        return this;
    }

    public RentalsPageAEM closeReportModalWindow() {
        waitUntilPresenceOfElementLocated(MODAL_REPORT_CLOSE_WINDOW);
        click(MODAL_REPORT_CLOSE_WINDOW, WaitType.CLICKABLE);
        return this;
    }

    public RentalsPageAEM verifyReportModalWindowText() {
        waitUntilPresenceOfElementLocated(MODAL_REPORT_TEXT);
        contains(getElementText(MODAL_REPORT_TEXT), "Your report is being generated and will be emailed to you at");
        return this;
    }

    public RentalsPageAEM changeMapOrListView() {
        click(MAP_OR_LIST_VIEW, WaitType.CLICKABLE);
        return this;
    }

    public RentalsPageAEM scrollListToRight(long pixels) {
        waitUntilPresenceOfElementLocated(LIST_CONTAINER);
        WebElement firstElement = DriverManager.getDriver().findElement(LIST_CONTAINER);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollLeft +=" + pixels, firstElement);
        //waitForGivenTime(2);
        return this;
    }

    public RentalsPageAEM scrollListToLeft(long pixels) {
        waitUntilPresenceOfElementLocated(LIST_CONTAINER);
        WebElement firstElement = DriverManager.getDriver().findElement(LIST_CONTAINER);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollLeft -=" + pixels, firstElement);
        //waitForGivenTime(2);
        return this;
    }

    public RentalsPageAEM clickOnListHeaderByName(String headerName) {
        By header = By.xpath("//div[@id='list-headers-container']/div/span/span[contains(text(),'" +headerName+ "')]");
        waitUntilPresenceOfElementLocated(header);
        click(header, WaitType.CLICKABLE);
        waitUntilPresenceOfElementLocated(PAGE_IS_LOADED_INDICATOR);
        return this;
    }
}
