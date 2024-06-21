package com.booking.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase {

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";
        RestAssured.port = 8080;
        RestAssured.basePath = "/booking";
        //http://localhost:8080/student
    }
}
