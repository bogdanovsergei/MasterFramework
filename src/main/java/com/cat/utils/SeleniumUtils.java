package com.cat.utils;

import com.cat.config.factory.ConfigFactory;
import com.cat.driver.DriverManager;
import com.cat.driver.manager.web.local.EdgeManager;
import com.cat.enums.WaitType;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumUtils {

    public static WebElement waitUntilPresenceOfElementLocated(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static WebElement waitUntilElementToBeClickable(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static WebElement waitUntilElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitUntilElementToBeVisible(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitUntilTitleIs(String title) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        wait.until(ExpectedConditions.titleIs(title));
    }

    public static void waitUntilTitleContains(String title) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        wait.until(ExpectedConditions.titleContains(title));
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
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
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
        WebElement element = waitUntilElementToBeVisible(by);
        return element.getText();
    }

    public static String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    public static WebElement getElement(By by) {
        return waitUntilElementToBeVisible(by);
    }

    public static void waitForGivenTime(long time) {
        Uninterruptibles.sleepUninterruptibly(time, TimeUnit.SECONDS);
    }

    public static void maximizeWindow() {
        DriverManager.getDriver().manage().window().maximize();
    }

    public static List<WebElement> getListOfWebElements(By by) {
        return DriverManager.getDriver().findElements(by);
    }

    public static void scrollByPixels(long pixels) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.scrollBy(0, "+pixels+")");
    }

    public static void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void hoverToElement(By by) {
        WebElement elementToHover = DriverManager.getDriver().findElement(by);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(elementToHover).perform();
    }

    public static void refreshPage() {
        DriverManager.getDriver().navigate().refresh();
    }
}