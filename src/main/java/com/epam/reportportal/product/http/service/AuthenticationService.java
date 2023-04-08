package com.epam.reportportal.product.http.service;

import com.epam.reportportal.framework.api.Routes;
import com.epam.reportportal.product.http.model.request.TokenRequestBody;
import com.epam.reportportal.product.http.model.response.TokenResponseBody;
import io.restassured.RestAssured;

public class AuthenticationService {
    private AuthenticationService(){
        throw new IllegalStateException("It is prohibited to create instance of " + AuthenticationService.class);
    }

    public static String generateAccessToken(TokenRequestBody tokenRequestBody) {
        return RestAssured.given()
                .header("Authorization", "Basic dWk6dWltYW4=")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .param("grant_type", tokenRequestBody.getGrantType())
                .param("username", tokenRequestBody.getUsername())
                .param("password", tokenRequestBody.getPassword())
                .when().post(Routes.BASE_URL + Routes.GET_TOKEN)
                .as(TokenResponseBody.class).getAccess_token();
    }
}