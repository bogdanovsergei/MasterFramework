package com.cat.pages.web.dmt.activeRentals;

import com.cat.driver.DriverManager;
import com.cat.enums.WaitType;
import com.cat.pages.web.dmt.LoginPageDMT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

import static com.cat.utils.SeleniumUtils.click;
import static com.cat.utils.SeleniumUtils.getListOfWebElements;
import static com.cat.utils.SeleniumUtils.waitForGivenTime;
import static com.cat.utils.VerificationUtils.areEqual;

public class ActiveRentalsPageDMT {

    private static final By CUSTOMER_ACCOUNT_INPUT_TXTBOX = By.id("customer-account-input");
    private static final By JOBSITES_INPUT_TXTBOX = By.id("jobsites-input");
    private static final By ACCOUNT_AND_JOBSITE_DROPDOWN = By.xpath("//div[@role='option']");
    private static final By SHOW_RENTALS_BTN = By.xpath("//button[@class='btn btn-sm btn-primary']");
    private static final By ASSETS_LIST = By.xpath("//td[@data-label='Asset']/a");
    private static final By ASSET_HEADER = By.xpath("//h1[@class='secondary ng-star-inserted']");

    public ActiveRentalsPageDMT clickOnEnterCustomerAccountNameOrNumber() {
        click(CUSTOMER_ACCOUNT_INPUT_TXTBOX, WaitType.CLICKABLE);
        waitForGivenTime(3);
        return this;
    }

    public ActiveRentalsPageDMT selectCustomerAccountByName(String customerAccountName) {
        for (WebElement customerAccount: getListOfWebElements(ACCOUNT_AND_JOBSITE_DROPDOWN)) {
            System.out.println(customerAccount.getText());
        }
        for (WebElement customerAccount: getListOfWebElements(ACCOUNT_AND_JOBSITE_DROPDOWN)) {
            if (customerAccount.getText().toUpperCase().contains(customerAccountName.toUpperCase())) {
                click(customerAccount);
                return this;
            }
        }
        waitForGivenTime(3);
        return this;
    }

    public ActiveRentalsPageDMT clickOnJobsiteInput() {
        click(JOBSITES_INPUT_TXTBOX, WaitType.CLICKABLE);
        waitForGivenTime(5);
        return this;
    }

    public ActiveRentalsPageDMT clickOnShowRentalsBtn() {
        click(SHOW_RENTALS_BTN, WaitType.CLICKABLE);
        waitForGivenTime(3);
        return this;
    }

    public ActiveRentalsPageDMT selectJobsiteByName(String jobsiteName) {
        for (WebElement jobsite: getListOfWebElements(ACCOUNT_AND_JOBSITE_DROPDOWN)) {
            if (jobsite.getText().toUpperCase().contains(jobsiteName.toUpperCase())) {
                click(jobsite);
                return this;
            }
        }
        waitForGivenTime(3);
        return this;
    }

    public ActiveRentalsPageDMT clickOnAssetByIndex(int index) {
        String assetTitle = getListOfWebElements(ASSETS_LIST).get(index).getAttribute("title");
        System.out.println(assetTitle);
        click(getListOfWebElements(ASSETS_LIST).get(index));

        //verify if the corresponding asset was selected
        waitForGivenTime(3);
        System.out.println(DriverManager.getDriver().findElement(ASSET_HEADER).getText());
        areEqual(assetTitle, DriverManager.getDriver().findElement(ASSET_HEADER).getText());
        return this;
    }
}
