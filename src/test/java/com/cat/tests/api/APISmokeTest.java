package com.cat.tests.api;

import com.cat.driver.Driver;
import com.cat.driver.DriverManager;
import com.cat.enums.PlatformType;
import com.cat.pages.web.dmt.LoginPageDMT;
import com.cat.tests.BaseTest;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.v124.network.model.*;
import org.openqa.selenium.devtools.v124.fetch.Fetch;
import org.openqa.selenium.devtools.v124.network.model.*;
//import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v124.network.Network;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Optional;

import static com.cat.config.factory.ConfigFactory.getConfig;
import static com.cat.utils.SeleniumUtils.maximizeWindow;
import static com.cat.utils.SeleniumUtils.waitForGivenTime;

public class APISmokeTest extends BaseTest {

    @Test
    public void firstAPITest() {
        Driver.initDriver(PlatformType.WEB);
        maximizeWindow();

        // Create a new instance of ChromeDriver
        WebDriver driver = DriverManager.getDriver();

        // Start the DevTools session
        DevTools devTools = ((EdgeDriver) driver).getDevTools();
        devTools.createSession();

        // Enable the Network domain to capture network events
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Listen for ResponseReceived events to capture API requests
        devTools.addListener(Network.requestWillBeSent(), event -> {
            Request request = event.getRequest();
            RequestId requestId = event.getRequestId();
//            devTools.send(Network.getResponseBody(requestId), response -> {
//                String body = response;
//                // Print response body
//                System.out.println("Response Body:");
//                //System.out.println(body);
//            });
            // Print request details
            System.out.println("API request captured:");
            System.out.println("URL: " + request.getUrl());
            System.out.println("Headers: " + request.getHeaders().toString());
            System.out.println("Method: " + request.getMethod().toString());
        });

        devTools.addListener(Network.responseReceived(), event -> {
            Response response = event.getResponse();

            System.out.println("Response Headers Text:");
            System.out.println("Response url: " + response.getUrl());
            System.out.println("Response request headers:" + response.getRequestHeaders().toString());
            System.out.println("Response get header: " + response.getHeaders().toString());
        });

        LoginPageDMT loginPageDMT = new LoginPageDMT();
        System.out.println("HERE111!!!");
        loginPageDMT.setUsername(getConfig().usernameDMT());
        System.out.println("HERE222!!!");
        loginPageDMT.setPassword(getConfig().passwordDMT());
        System.out.println("HERE333!!!");
        //loginPageDMT.loginToApplication(getConfig().usernameDMT(), getConfig().passwordDMT());
        waitForGivenTime(4);


        /*
        RestAssured.given()
                .baseUri("https://apiqa.catdevservices.com/dealerCommunication/rentalStoreServices/api/v1/")
                .header("Authorization","Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjREWFlYTk9BbThmeC0zU2w2UUxEbTlFbGZ2R0c3amd3U0ZheDdyOWVLY2siLCJ0eXAiOiJKV1QifQ.eyJjbGllbnRfaWQiOiJjYjIxNjFmOS1jZDhlLTQ4NWQtYTAwMC00Mjg4NGZhMDVhNjkiLCJjYXRhZmx0bmNsYXNzIjoiQ1VTVCIsImNhdGxvZ2luaWQiOiJjcnMucWEud2FkaGFtLmRlYWxlcjAxIiwiY2F0cmVjaWQiOiJQQ1AtMDAxMUEzMTUiLCJjYXRhZmx0bmNvZGUiOiIwMDQiLCJlbWFpbF9hZGRyZXNzIjoibWFoZXNoLndhZGhhaUBwZXJmaWNpZW50LmNvbSIsInN1YiI6ImMyMGI2Y2ZmLWQxZmYtNDBkMS1hNDQ2LTUzZTExYjc3ZWQwOSIsIm5hbWUiOiJNYWhlc2ggV2FkaGFpIiwiZ2l2ZW5fbmFtZSI6Ik1haGVzaCIsImZhbWlseV9uYW1lIjoiV2FkaGFpIiwiY291bnRyeSI6IklOIiwicG9zdGFsQ29kZSI6IjQ0MDAyMiIsInN0YXRlIjoiTWFoYXJhc2h0cmEiLCJ0ZWxlcGhvbmVOdW1iZXIiOiIrOTEgOTY3Mzk0NDIyMiIsImNvbXBhbnkiOiJQZXJmaWNpZW50IiwidGlkIjoiNGYwZjE5ZDAtZjQ0Yy00YTAzLWI4Y2ItYWIzMjdiZDJiMTJiIiwidGZwIjoiQjJDXzFBX1AyX1YxX1NpZ25Jbl9TdGFnaW5nIiwibGFuZ3VhZ2UiOiJlbiIsIm5vbmNlIjoiMTc4YjE4MjEtZWMwYi00NWIyLTk1MTYtYTQwYjJhNGNlYTRhIiwic2NwIjoiQ2F0UmVudGFsU3RvcmVXZWJTZXJ2aWNlc19hcGlfc2NvcGUiLCJhenAiOiJjYjIxNjFmOS1jZDhlLTQ4NWQtYTAwMC00Mjg4NGZhMDVhNjkiLCJ2ZXIiOiIxLjAiLCJpYXQiOjE3MTQ2NzcyNTMsImF1ZCI6ImM0YWQ2YTZmLTFjMDEtNDUwYS1hMGEzLWI5ZjdkMjIzMjkyMCIsImV4cCI6MTcxNDY4MDg1MywiaXNzIjoiaHR0cHM6Ly9zaWduaW4uY2F0LmNvbS90ZnAvNGYwZjE5ZDAtZjQ0Yy00YTAzLWI4Y2ItYWIzMjdiZDJiMTJiL2IyY18xYV9wMl92MV9zaWduaW5fc3RhZ2luZy92Mi4wLyIsIm5iZiI6MTcxNDY3NzI1M30.ka3f7m-U4tINCy6P4K8BnYwCTxY8zD5cBvwVOegHe_m5uOdhvZhhl1l2O8EJlCtNrPhRmeFZ1q9-WzVc8uLO66AT8GqS4OgK-ab0rCWucfjhq9f1h8vmpVBNidW3uPGL_smGqcS3Wz6DgdSEnUrstu031dk50Weo8EedvBFLPmR3jGJdrhLDSg2LWldERBS6zJiWPOS_FZN_6lQsVN3AjI_urWadShdevpva_dIRRn9LFQu0oDT9oImwEMlMYFyou_FbXsQrYkzT23y_I7UQ6QMINA8tpsfLaqWuiXVhcGjhmJXDnkDZTl1jKZHAi0ZUsvhGyRs48Lq_vphyDc5ybg")
                .get("user/current?t=1714677249903")
                .prettyPrint();

         */
    }

    @Test
    public void apiRequest() {
        String token = "";
        RestAssured.given()
                .baseUri("https://apiqa.catdevservices.com/dealerCommunication/rentalStoreServices/api/v1/")
                .header("Authorization","Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjREWFlYTk9BbThmeC0zU2w2UUxEbTlFbGZ2R0c3amd3U0ZheDdyOWVLY2siLCJ0eXAiOiJKV1QifQ.eyJjbGllbnRfaWQiOiJjYjIxNjFmOS1jZDhlLTQ4NWQtYTAwMC00Mjg4NGZhMDVhNjkiLCJjYXRhZmx0bmNsYXNzIjoiQ1VTVCIsImNhdGxvZ2luaWQiOiJjcnMucWEud2FkaGFtLmRlYWxlcjAxIiwiY2F0cmVjaWQiOiJQQ1AtMDAxMUEzMTUiLCJjYXRhZmx0bmNvZGUiOiIwMDQiLCJlbWFpbF9hZGRyZXNzIjoibWFoZXNoLndhZGhhaUBwZXJmaWNpZW50LmNvbSIsInN1YiI6ImMyMGI2Y2ZmLWQxZmYtNDBkMS1hNDQ2LTUzZTExYjc3ZWQwOSIsIm5hbWUiOiJNYWhlc2ggV2FkaGFpIiwiZ2l2ZW5fbmFtZSI6Ik1haGVzaCIsImZhbWlseV9uYW1lIjoiV2FkaGFpIiwiY291bnRyeSI6IklOIiwicG9zdGFsQ29kZSI6IjQ0MDAyMiIsInN0YXRlIjoiTWFoYXJhc2h0cmEiLCJ0ZWxlcGhvbmVOdW1iZXIiOiIrOTEgOTY3Mzk0NDIyMiIsImNvbXBhbnkiOiJQZXJmaWNpZW50IiwidGlkIjoiNGYwZjE5ZDAtZjQ0Yy00YTAzLWI4Y2ItYWIzMjdiZDJiMTJiIiwidGZwIjoiQjJDXzFBX1AyX1YxX1NpZ25Jbl9TdGFnaW5nIiwibGFuZ3VhZ2UiOiJlbiIsIm5vbmNlIjoiMTc4YjE4MjEtZWMwYi00NWIyLTk1MTYtYTQwYjJhNGNlYTRhIiwic2NwIjoiQ2F0UmVudGFsU3RvcmVXZWJTZXJ2aWNlc19hcGlfc2NvcGUiLCJhenAiOiJjYjIxNjFmOS1jZDhlLTQ4NWQtYTAwMC00Mjg4NGZhMDVhNjkiLCJ2ZXIiOiIxLjAiLCJpYXQiOjE3MTQ2NzcyNTMsImF1ZCI6ImM0YWQ2YTZmLTFjMDEtNDUwYS1hMGEzLWI5ZjdkMjIzMjkyMCIsImV4cCI6MTcxNDY4MDg1MywiaXNzIjoiaHR0cHM6Ly9zaWduaW4uY2F0LmNvbS90ZnAvNGYwZjE5ZDAtZjQ0Yy00YTAzLWI4Y2ItYWIzMjdiZDJiMTJiL2IyY18xYV9wMl92MV9zaWduaW5fc3RhZ2luZy92Mi4wLyIsIm5iZiI6MTcxNDY3NzI1M30.ka3f7m-U4tINCy6P4K8BnYwCTxY8zD5cBvwVOegHe_m5uOdhvZhhl1l2O8EJlCtNrPhRmeFZ1q9-WzVc8uLO66AT8GqS4OgK-ab0rCWucfjhq9f1h8vmpVBNidW3uPGL_smGqcS3Wz6DgdSEnUrstu031dk50Weo8EedvBFLPmR3jGJdrhLDSg2LWldERBS6zJiWPOS_FZN_6lQsVN3AjI_urWadShdevpva_dIRRn9LFQu0oDT9oImwEMlMYFyou_FbXsQrYkzT23y_I7UQ6QMINA8tpsfLaqWuiXVhcGjhmJXDnkDZTl1jKZHAi0ZUsvhGyRs48Lq_vphyDc5ybg")
                .get("user/current?t=1714677249903")
                .prettyPrint();

    }
}
