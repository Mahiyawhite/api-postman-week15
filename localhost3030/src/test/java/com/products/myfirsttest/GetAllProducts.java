package com.products.myfirsttest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllProducts {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void getAllProduct(){
        given()
                .when()
                .get("http://localhost:3030/products")
                .then()
                .statusCode(200);
    }
    @Test
    public void verifyStatusCode() {

        RestAssured.baseURI = "http://localhost:3030/products";

        requestSpecification = RestAssured.given();

        response = requestSpecification.get();

        String resString = response.prettyPrint();
        System.out.println("Response Details : " + resString);

        validatableResponse = response.then();

        // Get status code
        validatableResponse.statusCode(200);

        validatableResponse.statusLine("HTTP/1.1 200 OK");
    }

}
