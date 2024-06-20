package com.student.myfirsttest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetRestApi {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void getAllStudent(){
        given()
              .when()
              .get("http://localhost:8080/student/list")
              .then()
              .statusCode(200);
    }
    @Test
    public void getStudentById(){
        given()
                .when()
                .get("http://localhost:8080/student/list/37")
                .prettyPrint();

    }
    @Test
    public void verifyStatusCode(){

        RestAssured.baseURI = "http://localhost:8080/student/list";

        requestSpecification = given();

        response = requestSpecification.get();

        String resString = response.prettyPrint();
        System.out.println("Response Details : " + resString);

        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine, "HTTP/1.1 200 ");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
}
