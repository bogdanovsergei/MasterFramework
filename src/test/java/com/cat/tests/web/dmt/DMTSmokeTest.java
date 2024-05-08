package com.cat.tests.web.dmt;

import com.cat.driver.Driver;
import com.cat.enums.PlatformType;
import com.cat.pages.web.dmt.LoginPageDMT;
import com.cat.tests.BaseTest;
import org.testng.annotations.Test;

import static com.cat.utils.SeleniumUtils.maximizeWindow;
import static com.cat.config.factory.ConfigFactory.getConfig;
import static com.cat.utils.SeleniumUtils.waitForGivenTime;

public class DMTSmokeTest extends BaseTest {

    @Test
    public void dmtSmokeTest() {
        Driver.initDriver(PlatformType.WEB);
        maximizeWindow();

        LoginPageDMT loginPageDMT = new LoginPageDMT();
        loginPageDMT.loginToApplication(getConfig().usernameDMT(), getConfig().passwordDMT());

        waitForGivenTime(4);
    }
}
