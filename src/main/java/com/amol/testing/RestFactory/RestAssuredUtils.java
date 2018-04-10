package com.amol.testing.RestFactory;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

/**
 * Created by adeshmukh on 4/9/18.
 */
public class RestAssuredUtils {

    private final String url = "http://restcountries.eu/rest/v2/";

    public String httpGet(String uri) {
        RestAssured.baseURI = url;
        Response response = RestAssured.given().log().all().when().get(uri);
        if (response.getStatusCode() == 200) {
            return response.getBody().asString();
        }
        return null;
    }
}
