package com.cat.tests.mobile;

import com.cat.driver.Driver;
import com.cat.enums.PlatformType;
import org.testng.annotations.Test;

public class MobileSmokeTest {

    public static final String MOBILE_URL = "https://us-west-mobile-hub.bitbar.com/wd/hub";

    @Test
    public void remoteMobileTest() {
        Driver.initDriver(PlatformType.MOBILE);

    }
}
