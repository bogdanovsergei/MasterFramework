package com.cat.tests.web;

import com.cat.config.factory.ConfigFactory;
import com.cat.driver.DriverManager;
import com.cat.pages.web.aem.HomePageAEM;
import com.cat.pages.web.aem.LoginPageAEM;
import com.cat.tests.WebBase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.HashMap;

import static com.cat.utils.SeleniumUtils.getPageTitle;
import static com.cat.utils.SeleniumUtils.waitUntilTitleIs;
import static com.cat.utils.SeleniumUtils.waitForGivenTime;

public class LoginTest extends WebBase {

    public static String titleName;

    @Test(description = "To login with valid credentials")
    public void validCredentials() {
        DriverManager.getDriver().get(ConfigFactory.getConfig().urlAEM());
        HomePageAEM HomePageAEM = new HomePageAEM();
        LoginPageAEM LoginPageAEM = new LoginPageAEM();
        LoginPageAEM.loginToApplication(ConfigFactory.getConfig().usernameAEM(),
                        ConfigFactory.getConfig().passwordAEM());
        waitUntilTitleIs("Rentals");
        Assert.assertEquals(getPageTitle(), "Rentals");
    }

    @Test(description = "")
    public void twoDriversTest() {
        DriverManager.getDriver().get(ConfigFactory.getConfig().urlAEM());
        HomePageAEM HomePageAEM = new HomePageAEM();
        LoginPageAEM LoginPageAEM = new LoginPageAEM();
        LoginPageAEM.loginToApplication(ConfigFactory.getConfig().usernameAEM(),
                ConfigFactory.getConfig().passwordAEM());
        waitUntilTitleIs("Rentals");
        titleName = getPageTitle();
        Assert.assertEquals(getPageTitle(), "Rentals");
        System.out.println("titleName = " + titleName);

        DriverManager.getDriver().get(ConfigFactory.getConfig().urlDMT());
        LoginPageAEM LoginPageAEM2 = new LoginPageAEM();
        String titleName2 = getPageTitle();
        System.out.println("titleName2 = " + titleName2);
        System.out.println("titleName = " + titleName);
        LoginPageAEM2.loginToApplication(ConfigFactory.getConfig().usernameAEM(),
                ConfigFactory.getConfig().passwordAEM());
        waitForGivenTime(5000);
    }

    @Test
    public void androidTest() throws Exception {
        //UiAutomator2Options options = new UiAutomator2Options();
        /*
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("testobject_api_key","hpd4QKVaXfcgteJxF7TckYrs3dkJeOBR");
        caps.setCapability("testobject_app_id","223435113");
        caps.setCapability("platformName", "Android");
        //caps.setCapability("deviceName","Samsung_Galaxy_S10_real");
        caps.setCapability("deviceName","Google_Pixel_3a_real");
        caps.setCapability("automationName", "Appium");
*/
        /* Remember to change your Appium URL (command executor) to 'https://us-west-mobile-hub.bitbar.com/wd/hub' */
        /* Mobile native capabilities */
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "uiautomator2");

        HashMap<String, String> bitbarOptions = new HashMap<String, String>();
        bitbarOptions.put("project", "First mobile test");
        bitbarOptions.put("testrun", "My local mobile first test");
        bitbarOptions.put("app", "223435113");
        bitbarOptions.put("apiKey", "hpd4QKVaXfcgteJxF7TckYrs3dkJeOBR");
        bitbarOptions.put("device", "Google Pixel 3a -US");
        bitbarOptions.put("appiumVersion", "2.1");
        capabilities.setCapability("bitbar:options", bitbarOptions);

        AndroidDriver driver = new AndroidDriver(new URL("https://us-west-mobile-hub.bitbar.com/wd/hub"),capabilities);



    }
}
