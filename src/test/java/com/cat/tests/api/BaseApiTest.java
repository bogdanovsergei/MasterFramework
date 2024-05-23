package com.cat.tests.api;

import com.cat.config.factory.ApiConfigFactory;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseApiTest {

    @BeforeMethod
    public void setup() {
        RestAssured.baseURI = ApiConfigFactory.getConfig().baseUrl();
        RestAssured.requestSpecification = RestAssured.given().header("Authorization","Bearer " + ApiConfigFactory.getConfig().access_token());
    }

    @AfterMethod
    public void cleanUp() {
        RestAssured.reset();
    }

}
