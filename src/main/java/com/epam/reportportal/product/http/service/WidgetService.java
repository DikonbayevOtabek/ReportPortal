package com.epam.reportportal.product.http.service;

import com.epam.reportportal.framework.api.Routes;
import com.epam.reportportal.product.http.model.request.widget.ApiBodyWidgetCreator;
import com.epam.reportportal.product.http.model.response.WidgetNamesAllResponseBody;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class WidgetService extends AbstractService {
    public WidgetService(String token) {
        super(token);
    }

    public WidgetService getAllWidgetNames() {
        response = RestAssured.given()
                .header(AUTHORIZATION, formatBearerAuthHeader())
                .get(Routes.BASE_URL + Routes.GET_ALL_WIDGET_NAMES_WHICH_BELONG_TO_A_USER);
        return this;
    }

    public String convertResponseAndReturnAsString() {
        return response.getBody()
                .as(WidgetNamesAllResponseBody.class)
                .toString();
    }

    public Response createNewWidget() {
        response = RestAssured.given()
                .header(AUTHORIZATION, formatBearerAuthHeader())
                .header("Content-type", CONTROL_TYPE)
                .body(ApiBodyWidgetCreator.withHardCodedBodyData())
                .post(Routes.BASE_URL + Routes.CREATE_A_NEW_WIDGET);
        return response;
    }

    public Response getWidgetById(int id) {
        response = RestAssured.given()
                .header(AUTHORIZATION, formatBearerAuthHeader())
                .get(Routes.BASE_URL + Routes.GET_WIDGET_BY_ID + id);
        return response;
    }
}
