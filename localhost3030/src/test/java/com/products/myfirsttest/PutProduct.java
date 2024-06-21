package com.products.myfirsttest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PutProduct {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void UpdateNewProduct() {

        given().log().all()
                .when()
                .contentType(ContentType.JSON)
                .body("{\"name\": \"Baloons - Arch kit (4-Pack)\",\n" +
                        "            \"type\": \"Celebrations\",\n" +
                        "            \"price\": 15.00,\n" +
                        "            \"upc\": \"041333424019\",\n" +
                        "            \"shipping\": 0,\n" +
                        "            \"description\": \"Rubber Product\",\n" +
                        "            \"manufacturer\": \"Craft\",\n" +
                        "            \"model\": \"MN2400B4Z\"\n" +
                        "}")
                .put("http://localhost:3030/products/9999680")
                .then().log().all()
                .statusCode(200);
    }
    @Test
    public void UpdateProduct() {

        validatableResponse = given()
                .baseUri("http://localhost:3030/products/9999680")
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .assertThat().statusCode(200);
        //.body("msg", equalTo("Student Updated"));

        System.out.println("Response1 :" + validatableResponse.extract().asPrettyString());
    }

}
