package com.student.myfirsttest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostRestApi {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;


    @Test
    public void createNewStudent(){
        given().log().all()
                .contentType(ContentType.JSON)
                .when()
                .body("{\n" +
                        "        \"id\": 105,\n" +
                        "        \"firstName\": \"Hir\",\n" +
                        "        \"lastName\": \"Ayachi\",\n" +
                        "        \"email\": \"hir.ayachi@gmail.com\",\n" +
                        "        \"programme\": \"Financial Analysis\",\n" +
                        "        \"courses\": [\n" +
                        "            \"Accounting\",\n" +
                        "            \"Statistics\"\n" +
                        "        ]\n" +
                        "    }")
                .post("http://localhost:8080/student")
                .then().log().all()
                .statusCode(201);

    }
    @Test
    public void verifyStatusCode() {

        String studentData = "{\n" +
                "        \"id\": 105,\n" +
                "        \"firstName\": \"Hir\",\n" +
                "        \"lastName\": \"Ayachi\",\n" +
                "        \"email\": \"hir.aya@gmail.com\",\n" +
                "        \"programme\": \"Financial Analysis\",\n" +
                "        \"courses\": [\n" +
                "            \"Accounting\",\n" +
                "            \"Statistics\"\n" +
                "        ]\n" +
                "    }";

        RestAssured.baseURI = "http://localhost:8080/student";

        requestSpecification = RestAssured.given().contentType(ContentType.JSON);

        requestSpecification.body(studentData);

        response = requestSpecification.post();

        String resString = response.prettyPrint();
        System.out.println("Response Details : " + resString);

        validatableResponse = response.then();

        validatableResponse.statusCode(201);

        validatableResponse.statusLine("HTTP/1.1 201 ");

        //validatableResponse.body("message", equalTo("Student added"));
    }
}
