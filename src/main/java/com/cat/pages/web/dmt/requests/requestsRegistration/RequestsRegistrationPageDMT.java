package com.cat.pages.web.dmt.requests.requestsRegistration;

import com.cat.enums.WaitType;
import com.cat.pages.web.dmt.requests.requestsLead.RequestsLeadPageDMT;
import com.cat.pages.web.dmt.requests.requestsRegistration.registrationRequestDetail.RegistrationRequestDetailPageDMT;
import org.openqa.selenium.By;

import static com.cat.utils.SeleniumUtils.*;
import static com.cat.utils.VerificationUtils.contains;

public class RequestsRegistrationPageDMT {

    private static final By HEADER_NAME = By.xpath("//h1[@class='secondary']");
    private static final By LAST_REQUEST_STATUS = By.xpath("//tbody[@role='rowgroup']/tr[1]/td[@data-label='Status']/a");


    public RequestsRegistrationPageDMT verifyLastRequestStatus(String status) {
        waitUntilPresenceOfElementLocated(LAST_REQUEST_STATUS);
        System.out.println("LAST_REQUEST_STATUS = " + getElementText(LAST_REQUEST_STATUS));
        contains(getElementText(LAST_REQUEST_STATUS), status);
        return this;
    }

    public RegistrationRequestDetailPageDMT clickOnLastRequest() {
        click(LAST_REQUEST_STATUS, WaitType.CLICKABLE);
        waitUntilElementTextEqualsToDesiredValue(HEADER_NAME, "REGISTRATION REQUEST DETAIL");
        return new RegistrationRequestDetailPageDMT();
    }


}
