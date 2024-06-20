package com.student.myfirsttest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PutRestApi {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void PutNewStudent() {

        given().log().all()
                .when()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "        \"id\": 105,\n" +
                        "        \"firstName\": \"Hira\",\n" +
                        "        \"lastName\": \"Ayachi\",\n" +
                        "        \"email\": \"hira.ayachi@gmail.com\",\n" +
                        "        \"programme\": \"Financial Analysis\",\n" +
                        "        \"courses\": [\n" +
                        "            \"Accounting\",\n" +
                        "            \"Statistics\"\n" +
                        "        ]\n" +
                        "    }")
                .put("http://localhost:8080/student/102")
                .then().log().all()
                .statusCode(200);
    }
    @Test
    public void updateStudent() {

        validatableResponse = given()
                .baseUri("http://localhost:8080/student/102")
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .assertThat().statusCode(200);
                //.body("msg", equalTo("Student Updated"));

        System.out.println("Response1 :" + validatableResponse.extract().asPrettyString());
    }
}
