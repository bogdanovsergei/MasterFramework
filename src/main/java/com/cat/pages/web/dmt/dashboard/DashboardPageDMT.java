package com.cat.pages.web.dmt.dashboard;

import org.openqa.selenium.By;

import static com.cat.utils.SeleniumUtils.getElementText;
import static com.cat.utils.SeleniumUtils.waitUntilPresenceOfElementLocated;
import static com.cat.utils.VerificationUtils.contains;

public class DashboardPageDMT {
    private static final By LAST_NOTIFICATION_TYPE = By.xpath("//div[@class='notification-table notification-list']//tbody[@role='rowgroup']/tr[1]/td[2]");
    private static final By LAST_NOTIFICATION_CUSTOMER = By.xpath("//div[@class='notification-table notification-list']//tbody[@role='rowgroup']/tr[1]/td[5]");
    private static final By LAST_NOTIFICATION_REQUESTOR = By.xpath("//div[@class='notification-table notification-list']//tbody[@role='rowgroup']/tr[1]/td[6]");

    public DashboardPageDMT verifyLastNotificationType(String type) {
        waitUntilPresenceOfElementLocated(LAST_NOTIFICATION_TYPE);
        System.out.println("LAST_NOTIFICATION_TYPE = " + getElementText(LAST_NOTIFICATION_TYPE));
        contains(getElementText(LAST_NOTIFICATION_TYPE), type);
        return this;
    }

    public DashboardPageDMT verifyLastNotificationCustomer(String customer) {
        waitUntilPresenceOfElementLocated(LAST_NOTIFICATION_CUSTOMER);
        System.out.println("LAST_NOTIFICATION_CUSTOMER = " + getElementText(LAST_NOTIFICATION_CUSTOMER));
        contains(getElementText(LAST_NOTIFICATION_CUSTOMER), customer);
        return this;
    }

    public DashboardPageDMT verifyLastNotificationRequestor(String requestor) {
        waitUntilPresenceOfElementLocated(LAST_NOTIFICATION_REQUESTOR);
        System.out.println("LAST_NOTIFICATION_REQUESTOR = " + getElementText(LAST_NOTIFICATION_REQUESTOR));
        contains(getElementText(LAST_NOTIFICATION_REQUESTOR), requestor);
        return this;
    }

}
