package com.booking.myfirsttest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteBooking {

    RequestSpecification requestSpecification;

    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void deleteUser() {


        RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking/2910";

        requestSpecification = given();

        String resString = response.prettyPrint();

        validatableResponse = response.then();

        // Get status code
        validatableResponse.statusCode(200);

        validatableResponse.statusLine("HTTP/1.1 200 OK");
    }

}
