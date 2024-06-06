package com.cat.pages.web.dmt.requests.requestsLead;

import com.cat.pages.web.dmt.requests.RequestsPageDMT;
import org.openqa.selenium.By;

import static com.cat.utils.SeleniumUtils.getElementText;
import static com.cat.utils.SeleniumUtils.waitUntilPresenceOfElementLocated;
import static com.cat.utils.VerificationUtils.contains;

public class RequestsLeadPageDMT {

    private static final By LAST_REQUEST_STATUS = By.xpath("//tr[@role='row'][1]/td[@class='mat-cell cdk-cell cdk-column-status mat-column-status ng-star-inserted']/a");
    private static final By LAST_REQUEST_CUSTOMER = By.xpath("//tr[@role='row'][1]/td[@class='mat-cell cdk-cell cdk-column-customer mat-column-customer ng-star-inserted']");
    private static final By LAST_REQUEST_REQUESTOR = By.xpath("//tr[@role='row'][1]/td[@class='mat-cell cdk-cell cdk-column-requestor mat-column-requestor ng-star-inserted']");

    public RequestsLeadPageDMT verifyLastRequestStatus(String status) {
        waitUntilPresenceOfElementLocated(LAST_REQUEST_STATUS);
        System.out.println("LAST_REQUEST_STATUS = " + getElementText(LAST_REQUEST_STATUS));
        contains(getElementText(LAST_REQUEST_STATUS), status);
        return this;
    }

    public RequestsLeadPageDMT verifyLastRequestCustomer(String customer) {
        waitUntilPresenceOfElementLocated(LAST_REQUEST_CUSTOMER);
        System.out.println("LAST_REQUEST_CUSTOMER = " + getElementText(LAST_REQUEST_CUSTOMER));
        contains(getElementText(LAST_REQUEST_CUSTOMER), customer);
        return this;
    }

    public RequestsLeadPageDMT verifyLastRequestRequestor(String requestor) {
        waitUntilPresenceOfElementLocated(LAST_REQUEST_REQUESTOR);
        System.out.println("LAST_REQUEST_REQUESTOR = " + getElementText(LAST_REQUEST_REQUESTOR));
        contains(getElementText(LAST_REQUEST_REQUESTOR), requestor);
        return this;
    }
}
