package com.cat.utils;

import com.cat.config.factory.ConfigFactory;
import com.cat.driver.DriverManager;
import com.cat.enums.WaitType;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MobileUtils {

    public static WebElement waitUntilPresenceOfElementLocated(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeoutMobile()));
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static WebElement waitUntilElementToBeClickable(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeoutMobile()));
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static WebElement waitUntilElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeoutMobile()));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitUntilElementToBeVisible(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeoutMobile()));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void sendKeys(By by, String value) {
        WebElement element = waitUntilPresenceOfElementLocated(by);
        element.sendKeys(value);
    }

    public static void click(By by, WaitType waitType) {
        WebElement element = getElementAfterWait(by, waitType);
        element.click();
    }

    public static void click(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeoutMobile()));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static WebElement getElementAfterWait(By by, WaitType waitType) {
        //waitUntilElementToBeClickable(by).click();
        WebElement element = null;
        if (waitType == WaitType.PRESENCE) {
            element = waitUntilPresenceOfElementLocated(by);
        } else if (waitType == WaitType.CLICKABLE) {
            element = waitUntilElementToBeClickable(by);
        } else if (waitType == WaitType.VISIBLE) {
            element = waitUntilElementToBeVisible(by);
        }
        return element;
    }

    public static String getElementText(By by) {
        WebElement element = waitUntilPresenceOfElementLocated(by);
        return element.getText();
    }

    public static WebElement getElement(By by) {
        return waitUntilElementToBeVisible(by);
    }

    public static void refreshScreen() {
        WebDriver driver = DriverManager.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if (driver instanceof AndroidDriver) {
            js.executeScript("mobile: shell", ImmutableMap.of("command", "input swipe", "args", "300 800 300 200 1000"));
        }
        else if (driver instanceof IOSDriver) {
            js.executeScript("mobile: scroll", ImmutableMap.of("direction", "down"));
        }
        System.out.println("Screen refreshed.");
    }

    public static void refreshScreen1() {
        WebDriver driver = DriverManager.getDriver();
        AndroidDriver androidDriver = (AndroidDriver) driver;//casting
        Dimension screenSize = androidDriver.manage().window().getSize();
        int screenWidth = screenSize.getWidth();
        int screenHeight = screenSize.getHeight();

        int startX = screenWidth / 2;
        int startY = (int) (screenHeight * 0.8);
        int endX = screenWidth / 2;
        int endY = (int) (screenHeight * 0.2);

        new TouchAction<>(androidDriver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
        System.out.println("Page refreshed1!");
    }

    public static void closeBrowserAndGetToApp() {
        WebDriver driver = DriverManager.getDriver();
        AndroidDriver androidDriver = (AndroidDriver) driver;//casting
        String currentContext = androidDriver.getContext();
        System.out.println("currentContext = " + currentContext.toString());

        Set<String> contextHandles = androidDriver.getContextHandles();
        for (String context : contextHandles) {
            System.out.println("Context: " + context);
        }

        androidDriver.context(androidDriver.getContextHandles().toArray()[1].toString()); //the first context is the browser
        androidDriver.close();
        // Switch back to the native app context
        androidDriver.context(currentContext);
    }

    private static void performScroll() {
        Dimension size = DriverManager.getDriver().manage().window().getSize();
        int startX = size.getWidth() / 2;
        int endX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endY = (int) (size.getHeight() * 0.25);

        performScrollUsingSequence(startX, startY, endX, endY);
    }

    private static void performScrollUsingSequence(int startX, int startY, int endX, int endY) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "first-finger");
        Sequence sequence = new Sequence(finger, 0)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        ((AppiumDriver)(DriverManager.getDriver())).perform(Collections.singletonList(sequence));
    }
}
