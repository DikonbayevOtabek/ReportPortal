package com.epam.reportportal.product.http.service;

import com.epam.reportportal.framework.api.Routes;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static java.lang.String.format;

public abstract class AbstractService {

    protected Response response;
    protected static String token;
    protected static final String AUTHORIZATION = "Authorization";

    public static String formatBearerAuthHeader() {
        return format("Bearer %s", token);
    }
    protected static final String CONTENT_TYPE = "application/json;charset=UTF-8";
    protected static final String CONTROL_TYPE = "application/json";

    protected AbstractService(String token) {
        RestAssured.baseURI = Routes.BASE_URL;
        AbstractService.token = token;
    }
}