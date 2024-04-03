package com.cat.tests;

import com.cat.config.ConfigFactory;
import com.cat.config.FrameworkConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigCache;
//import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoTest {

    @Test
    public void testLogin() {

        System.out.println(ConfigFactory.getConfig().browser());

    }
}
