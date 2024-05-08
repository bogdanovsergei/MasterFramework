package com.cat.tests.mobile;

import com.cat.config.factory.ConfigFactory;
import com.cat.driver.Driver;
import com.cat.driver.DriverManager;
import com.cat.enums.PlatformType;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static com.cat.utils.SeleniumUtils.click;

public class MobileSmokeTest {

    public static final String MOBILE_URL = "https://us-west-mobile-hub.bitbar.com/wd/hub";

    @Test
    public void remoteMobileTest() {
        Driver.initDriver(PlatformType.MOBILE);
        Driver.quitDriver();
    }

    @Test
    public void localMobileTest() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("testName");
        options.setApp(System.getProperty("user.dir") + "\\apps\\com.perficient.rental.catstaging-Signed.apk");
        options.setAppPackage("com.perficient.rental.catstaging");
        options.setAppActivity("crc64cae1090ad46f60b5.InitializeView");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        Thread.sleep(3000);

        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(AppiumBy.id("com.perficient.rental.catstaging:id/switch_accept"))));
        driver.findElement(AppiumBy.id("com.perficient.rental.catstaging:id/switch_accept")).click();

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(AppiumBy.id("com.perficient.rental.catstaging:id/button_accept"))));
        driver.findElement(By.id("com.perficient.rental.catstaging:id/button_accept")).click();
        Thread.sleep(4000);
    }
}
