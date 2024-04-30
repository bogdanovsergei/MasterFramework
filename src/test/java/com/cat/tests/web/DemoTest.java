package com.cat.tests.web;

import com.cat.config.factory.BitbarConfigFactory;
import com.cat.config.factory.ConfigFactory;
import com.cat.driver.DriverManager;
import com.cat.driver.factory.web.local.LocalDriverFactory;
import com.cat.tests.WebBase;
import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class DemoTest extends WebBase {

    @Test
    public void testLogin() throws InterruptedException {

        System.out.println(ConfigFactory.getConfig().browser());
        //WebDriverManager.chromedriver().proxy("http://proxy.cat.com").setup();
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://wwwqa.aws.catrentalstore.com/");
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void demoTest() throws InterruptedException {
        System.out.println(BitbarConfigFactory.getConfig().bitbarURL());
        System.out.println(ConfigFactory.getConfig().browser());
        WebDriver driver = LocalDriverFactory.getDriver(ConfigFactory.getConfig().browser());
        driver.get("https://wwwqa.aws.catrentalstore.com/");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.xpath("//li[@class=\"login my-account my-account-desktop not-logged-in crs-nav-dropdown\"]//i[@class=\"fa fa-user\"]"));
        element.click();
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void demoTest2() throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://wwwqa.aws.catrentalstore.com/");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.xpath("//li[@class=\"login my-account my-account-desktop not-logged-in crs-nav-dropdown\"]//i[@class=\"fa fa-user\"]"));
        element.click();
        Thread.sleep(2000);
        driver.quit();
    }
}
