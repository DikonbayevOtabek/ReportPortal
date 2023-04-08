package com.epam.reportportal.product.http.service;

import com.epam.reportportal.framework.api.Routes;
import com.epam.reportportal.product.http.model.request.filter.ApiBodyFilterCreator;
import io.restassured.RestAssured;

public class FilterService extends AbstractService {

    public FilterService(String token) {
        super(token);
    }

    public int createUserFilterAndReturnItsId() {
        response = RestAssured.given()
                .header("Authorization", "bearer " + token)
                .header("Content-type", "application/json")
                .body(ApiBodyFilterCreator.withHardCodedBodyData())
                .post(Routes.BASE_URL + Routes.CREATE_USER_FILTER);
        return response.jsonPath().getInt("id");
    }
}
