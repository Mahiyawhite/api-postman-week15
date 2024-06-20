package com.student.myfirsttest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteRestApi {

    RequestSpecification requestSpecification;

    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void deleteUser(){

        validatableResponse =
                given()
                        .baseUri("http://localhost:8080/student/105")
                        .contentType(ContentType.JSON)
                        .when()
                        .delete()
                        .then()
                        .assertThat().statusCode(204);

        System.out.println("Response :" + validatableResponse.extract().asPrettyString());


    }
}

