package com.booking.myfirsttest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetBooking {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void getAllBooking(){

        given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
                .then()
                .statusCode(200);
    }
    @Test
    public void verifyStatusCode(){

        RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";

        requestSpecification = RestAssured.given();

        response = requestSpecification.get();

        String resString = response.prettyPrint();
        System.out.println("Response Details : " + resString);

        validatableResponse = response.then();

        validatableResponse.statusCode(200);

        validatableResponse.statusLine("HTTP/1.1 200 OK");
    }
}
