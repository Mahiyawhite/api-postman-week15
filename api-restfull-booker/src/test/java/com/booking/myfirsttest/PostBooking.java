package com.booking.myfirsttest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostBooking {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void createNewBooking(){
        given()
                .when()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"firstname\" : \"Kate\",\n" +
                        "    \"lastname\" : \"pink\",\n" +
                        "    \"totalprice\" : 151,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .post("https://restful-booker.herokuapp.com/booking")
                .then().log().all()
                .statusCode(200);
    }
    @Test
    public void verifyStatusCode() {

        String BookingData = "{\n" +
                "    \"firstname\" : \"Kate\",\n" +
                "    \"lastname\" : \"pink\",\n" +
                "    \"totalprice\" : 151,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";

        requestSpecification = RestAssured.given().contentType(ContentType.JSON);

        requestSpecification.body(BookingData);

        response = requestSpecification.post();

        String resString = response.prettyPrint();
        System.out.println("Response Details : " + resString);

        validatableResponse = response.then();

        validatableResponse.statusCode(200);

        validatableResponse.statusLine("HTTP/1.1 200 OK");

    }
}
