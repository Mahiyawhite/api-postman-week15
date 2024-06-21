package com.products.myfirsttest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Postproduct {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void createNewProduct(){
        given()
                .when()
                .contentType(ContentType.JSON)
                .body("{\"name\": \"Baloons - Arch kit (4-Pack)\",\n" +
                        "            \"type\": \"Happy Birthday\",\n" +
                        "            \"price\": 10.00,\n" +
                        "            \"upc\": \"041333424019\",\n" +
                        "            \"shipping\": 0,\n" +
                        "            \"description\": \"Rubber Product\",\n" +
                        "            \"manufacturer\": \"Craft\",\n" +
                        "            \"model\": \"MN2400B4Z\"\n" +
                        "}")
                .post("http://localhost:3030/products")
                .then().log().all()
                .statusCode(201);
    }
    @Test
    public void verifyStatusCode() {

        String productData = "{\"name\": \"Baloons - Arch kit (4-Pack)\",\n" +
                "            \"type\": \"Happy Birthday\",\n" +
                "            \"price\": 10.00,\n" +
                "            \"upc\": \"041333424019\",\n" +
                "            \"shipping\": 0,\n" +
                "            \"description\": \"Rubber Product\",\n" +
                "            \"manufacturer\": \"Craft\",\n" +
                "            \"model\": \"MN2400B4Z\"\n" +
                "}";

        RestAssured.baseURI = "http://localhost:3030/products";

        requestSpecification = RestAssured.given().contentType(ContentType.JSON);

        requestSpecification.body(productData);

        response = requestSpecification.post();

        String resString = response.prettyPrint();
        System.out.println("Response Details : " + resString);

        validatableResponse = response.then();

        // Get status code
        validatableResponse.statusCode(201);

    }
}
