package models.api.models;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationBuilder {

    private final String baseUrl;
    private final String accessToken;

    public RequestSpecificationBuilder(String baseUrl, String accessToken){
        this.baseUrl = baseUrl;
        this.accessToken = accessToken;
    }

    protected RequestSpecification getRequestSpecification(){
        RestAssured.baseURI = baseUrl;
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.ANY)
                .auth().oauth2(accessToken)
                .log().all();
    }
}