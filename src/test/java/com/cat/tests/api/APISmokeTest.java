package com.cat.tests.api;

import com.cat.config.factory.ConfigFactory;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


public class APISmokeTest extends BaseApiTest {

    @Test
    public void userCurrentTest() {
        Response response = given().get("user/current");
        response.then().statusCode(200).
            body("cwsLogin", equalTo(ConfigFactory.getConfig().usernameDMT()));
        System.out.println("cwsLogin = " + response.path("cwsLogin"));
    }

    @Test
    public void userCurrentIdTest() {
        given().get("user/current?t=1714677249903").
                then().statusCode(200);
    }

    @Test
    public void messageTest() {
        given().get("message").
                then().statusCode(200).
                body("content[0].messages[0].id", notNullValue());
    }

    @Test
    public void dealerTest() {
        Response response = given().get("dealer");
        response.then().statusCode(200);
        //System.out.println("Response Body:");
        //System.out.println(response.getBody().prettyPrint());

        JsonPath jsonPath = response.jsonPath();
        List<String> dealerNames = jsonPath.getList("content.dealerName");

        System.out.println("Dealer Names:");
        for (String dealerName : dealerNames) {
            //Assert.assertEquals();
            System.out.println(dealerName);
        }
    }

    @Test
    public void dealerId() {
        Response response = given().get("dealer/1");
        response.then().statusCode(200);
        System.out.println("Response Body:");
        System.out.println(response.getBody().prettyPrint());
    }

    @Test
    public void customerDealerIdTest() {
        Response response = given().get("customer?dealer=1");
        response.then().statusCode(200);
        System.out.println("Response Body:");
        System.out.println(response.getBody().prettyPrint());
    }

    @Test
    public void customerIdDealerIdTest() {
        Response response = given().get("customer/1?dealer=1");
        response.then().statusCode(200);
        System.out.println("Response Body:");
        System.out.println(response.getBody().prettyPrint());
    }

    @Test
    public void catalogCategoryRecursiveTrueFalseTest () {
        Response response = given().get("catalog-category?[recursive=true]");
        response.then().statusCode(200);
        System.out.println("Response Body:");
        System.out.println(response.getBody().prettyPrint());
    }
}
