package com.cat.pages.web.dmt.requests.requestsRegistration.registrationRequestDetail;

import com.cat.config.factory.ConfigFactory;
import com.cat.enums.WaitType;
import com.cat.pages.web.dmt.requests.requestsRegistration.RequestsRegistrationPageDMT;
import org.openqa.selenium.By;

import java.util.concurrent.locks.Lock;

import static com.cat.utils.SeleniumUtils.*;
import static com.cat.utils.SeleniumUtils.getElementText;
import static com.cat.utils.VerificationUtils.contains;

public class RegistrationRequestDetailPageDMT {

    private static final By STATUS = By.xpath("//p[@class='subhead']");
    private static final By HEADER_NAME = By.xpath("//h1[@class='secondary']");
    private static final By LOCK_REQUEST_BTN = By.xpath("//button[@class='btn btn-primary btn-block ng-star-inserted']");
    private static final By LOCKED_BY = By.xpath("//span[@class='ng-star-inserted']");
    private static final By BACK_TO_LIST = By.xpath("//span[@class='close--label']");


    public RegistrationRequestDetailPageDMT clickOnLockRequest() {
        click(LOCK_REQUEST_BTN, WaitType.CLICKABLE);
        waitUntilElementTextEqualsToDesiredValue(HEADER_NAME, "REGISTRATION REQUEST DETAIL");
        return this;
    }

    public RequestsRegistrationPageDMT clickOnBackToList() {
        click(BACK_TO_LIST, WaitType.CLICKABLE);
        waitUntilElementTextEqualsToDesiredValue(HEADER_NAME, "REGISTRATION");
        return new RequestsRegistrationPageDMT();
    }

    public RegistrationRequestDetailPageDMT verifyStatus(String status) {
        waitUntilElementTextEqualsToDesiredValue(STATUS,status);
        return this;
    }

    public RegistrationRequestDetailPageDMT verifyLockedBy() {
        waitUntilPresenceOfElementLocated(LOCKED_BY);
        contains(getElementText(LOCKED_BY), ConfigFactory.getConfig().usernameDMT());
        return this;
    }

}
