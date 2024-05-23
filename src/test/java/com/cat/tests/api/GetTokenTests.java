package com.cat.tests.api;

import com.cat.config.factory.ConfigFactory;
import com.cat.driver.Driver;
import com.cat.driver.DriverManager;
import com.cat.enums.PlatformType;
import com.cat.pages.web.dmt.LoginPageDMT;
import io.restassured.RestAssured;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v124.network.Network;
import org.openqa.selenium.devtools.v124.network.model.Request;
import org.openqa.selenium.devtools.v124.network.model.RequestId;
import org.openqa.selenium.devtools.v124.network.model.Response;
import org.openqa.selenium.devtools.v124.network.model.ResponseReceived;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.Base64;
import java.util.Optional;
import java.util.function.Consumer;

import static com.cat.config.factory.ConfigFactory.getConfig;
import static com.cat.utils.SeleniumUtils.maximizeWindow;
import static com.cat.utils.SeleniumUtils.waitForGivenTime;

public class GetTokenTests {

    @Test
    public void firstAPITest() {
        Driver.initDriver(PlatformType.WEB);
        maximizeWindow();

        // Create a new instance of ChromeDriver
        WebDriver driver = DriverManager.getDriver();

        // Start the DevTools session
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
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
            if (request.getUrl().contains("https://signin.cat.com")) {
                System.out.println("API request captured:");
                System.out.println("URL: " + request.getUrl());
                System.out.println("Headers: " + request.getHeaders().toString());
                System.out.println("Method: " + request.getMethod().toString());
            }
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
    public void secondAPITest() {
        Driver.initDriver(PlatformType.WEB);
        maximizeWindow();

        // Create a new instance of ChromeDriver
        WebDriver driver = DriverManager.getDriver();

        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        // Enable Network
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        devTools.addListener(Network.responseReceived(), new Consumer<ResponseReceived>() {
            @Override
            public void accept(ResponseReceived responseReceived) {
                String requestId = responseReceived.getRequestId().toString();
                String url = responseReceived.getResponse().getUrl();

                // Filter the specific request by URL (adjust the URL as needed)
                if (url.contains("https://signin.cat.com/4f0f19d0-f44c-4a03-b8cb-ab327bd2b12b/")) {
                    Network.GetResponseBodyResponse responseBody = devTools.send(Network.getResponseBody(new RequestId(requestId)));
                    if (responseBody != null) {
                        String body = responseBody.getBody();
                        System.out.println("Response Body: " + body.toString());
                        System.out.println("getRequestHeaders = " + responseReceived.getResponse().getRequestHeaders());
                        System.out.println("Headers response = " + responseReceived.getResponse().getHeaders());

                        // Extract the access_token from the response body
                       // String accessToken = extractAccessToken(body);
                        //System.out.println("Access Token: " + accessToken);
                    }
                }
            }
        });
        /*
        // Add listener to capture network responses
        devTools.addListener(Network.responseReceived(), responseReceived -> {
            String requestId = responseReceived.getRequestId().toString();
            String url = responseReceived.getResponse().getUrl();

            // Filter the specific request by URL (adjust the URL as needed)
            if (url.contains("https://signin.cat.com")) {
                Network.GetResponseBodyResponse responseBody1 = devTools.send(Network.getResponseBody(new RequestId(requestId)));
                if (responseBody1 != null) {
                    System.out.println("RequestID: " + requestId);
                    System.out.println("Response Body: " + responseBody1.getBody());
                }
            }
        });
*/
        LoginPageDMT loginPageDMT = new LoginPageDMT();
        System.out.println("HERE111!!!");
        loginPageDMT.setUsername(getConfig().usernameDMT());
        System.out.println("HERE222!!!");
        loginPageDMT.setPassword(getConfig().passwordDMT());
        System.out.println("HERE333!!!");
        //loginPageDMT.loginToApplication(getConfig().usernameDMT(), getConfig().passwordDMT());
        waitForGivenTime(4);
    }
    /*
    private static String extractAccessToken(String responseBody) {
        // Assuming the response body is in JSON format and contains the access token
        // Adjust the JSON parsing as needed based on the actual response format
        try {
            org.json.JSONObject jsonObject = new org.json.JSONObject(responseBody);
            return jsonObject.getString("access_token");
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
    */

    @Test
    public void userCurrent() {
        io.restassured.response.Response response = RestAssured.get("user/current");
        //response.prettyPrint();
        response.then().assertThat().statusCode(200);
        String cwsLogin = response.jsonPath().getString("cwsLogin");
        System.out.println("cwsLogin = " + cwsLogin);
        Assert.assertEquals(cwsLogin, ConfigFactory.getConfig().usernameDMT());
    }

    @Test
    public void apiRequest2() {
        io.restassured.response.Response response = RestAssured.get("user/current?t=1714677249903");
        //response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }
    @Test
    public void katalonAPITest() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Driver.initDriver(PlatformType.WEB);
        maximizeWindow();

        // Create a new instance of ChromeDriver
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://dealerqa.catrentalstore.com");
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("signInName")));

        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        driver.quit();
        int j = currentUrl.indexOf("code_challenge=");
        int n = currentUrl.indexOf("&code_challenge_method=");
        String code_challenge = currentUrl.substring(j + 15, n);
        String codeVerifier = generateCodeVerifier();
        String codeChallenge = generateCodeChallenge(codeVerifier);
        currentUrl = currentUrl.replace(code_challenge, codeChallenge);
        System.out.println(currentUrl);

    }

    public String generateCodeVerifier() throws UnsupportedEncodingException {
        SecureRandom secureRandom = new SecureRandom();
        byte[] codeVerifier = new byte[32];
        secureRandom.nextBytes(codeVerifier);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(codeVerifier);
    }

    public String generateCodeChallenge(String codeVerifier) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] bytes = codeVerifier.getBytes("US-ASCII");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(bytes, 0, bytes.length);
        byte[] digest = messageDigest.digest();
        return Base64.getUrlEncoder().withoutPadding().encodeToString(digest);
    }
}
