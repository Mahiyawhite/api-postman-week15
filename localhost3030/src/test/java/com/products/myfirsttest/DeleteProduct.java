package com.products.myfirsttest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteProduct {
    RequestSpecification requestSpecification;

    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void deleteUser(){

        validatableResponse =
                given()
                        .baseUri("http://localhost:3030/products/9999686")
                        .contentType(ContentType.JSON)
                        .when()
                        .delete()
                        .then()
                        .assertThat().statusCode(404);

        System.out.println("Response :" + validatableResponse.extract().asPrettyString());


    }

}
