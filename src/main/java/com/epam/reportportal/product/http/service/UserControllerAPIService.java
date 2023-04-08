package com.epam.reportportal.product.http.service;

import com.epam.reportportal.framework.api.Routes;
import com.epam.reportportal.product.http.model.request.user.DeleteSpecifiedUserRequestBody;
import com.epam.reportportal.product.http.model.request.user.UserCreationRequestBody;
import com.epam.reportportal.product.http.model.request.user.UserCreationRequestBodyCreator;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserControllerAPIService extends AbstractService {

    private final UserCreationRequestBody userCreationRequestBody = UserCreationRequestBodyCreator.createWithDefaultValues();

    public UserControllerAPIService(String token) {
        super(token);
    }
    public Response getUserInformation() {
        response = RestAssured.given()
                .header(AUTHORIZATION, formatBearerAuthHeader())
                .get(Routes.BASE_URL + Routes.USER_CONTROLLER);
        return response;
    }

    public Response createSpecifiedUser(){
        response = RestAssured.given()
                .header(AUTHORIZATION, formatBearerAuthHeader())
                .header("Content-type", CONTROL_TYPE)
                .body(userCreationRequestBody.toString())
                .post(Routes.BASE_URL + Routes.USER_CONTROLLER);
        return response;
    }

    public Response deleteUserById(int id){
        response = RestAssured.given()
                .header(AUTHORIZATION, formatBearerAuthHeader())
                .header("Content-type", CONTROL_TYPE)
                .body(new DeleteSpecifiedUserRequestBody(id).toString())
                .delete(Routes.BASE_URL + Routes.USER_CONTROLLER);
        return response;
    }
}
