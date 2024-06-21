package com.booking.myfirsttest;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PutBooking {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void PutNewBooking() {

        given()
                .when()
                .body("{\n" +
                        "    \"firstname\" : \"Kate\",\n" +
                        "    \"lastname\" : \"Red\",\n" +
                        "    \"totalprice\" : 151,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .put("https://restful-booker.herokuapp.com/booking/2910")
                .then().log().all()
                .statusCode(200);
    }
}
