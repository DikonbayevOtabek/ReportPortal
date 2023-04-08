package com.epam.reportportal.product.http.service;

import com.epam.reportportal.framework.api.Routes;
import com.epam.reportportal.product.buisness.objects.dashboard.Dashboard;
import com.epam.reportportal.product.buisness.objects.dashboard.DashboardFactory;
import com.epam.reportportal.product.http.model.response.DashboardListBody;
import com.epam.reportportal.product.http.model.response.DashboardResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashboardService extends AbstractService {

    public DashboardService(String token) {
        super(token);
    }

    public Response addDashboard(Dashboard dashboard) throws JsonProcessingException {
        Map<String, Object> bodyParams = new HashMap<>();
        bodyParams.put("name", dashboard.getName());
        bodyParams.put("share", dashboard.getShare());
        return RestAssured.given()
                .header(AUTHORIZATION, formatBearerAuthHeader())
                .header("Content-Type", CONTENT_TYPE)
                .body(new ObjectMapper().writeValueAsString(bodyParams))
                .when()
                .post(Routes.CREATE_DASHBOARD);
    }

    public void addSeveralDashboards(int numberOfDashboards) throws JsonProcessingException {
        for (int i = 0; i < numberOfDashboards; i++) {
            addDashboard(DashboardFactory.withRandomTestData());
        }
    }

    public Response getDashboardByParameter(String parameter) {
        return RestAssured.given()
                .header(AUTHORIZATION, formatBearerAuthHeader())
                .header("Control-Type", CONTROL_TYPE)
                .get(String.format(Routes.MODIFY_DASHBOARD, parameter));

    }

    public Response getAllDashboards() {
        return RestAssured.given()
                .header(AUTHORIZATION, formatBearerAuthHeader())
                .header("Control-Type", CONTROL_TYPE)
                .param("page.page", 1)
                .param("page.size", 300)
                .get(String.format(Routes.CREATE_DASHBOARD));
    }

    public List<DashboardResponseBody> listOfDashboards(Response response) {
        return response
                .body()
                .as(DashboardListBody.class)
                .getContent();
    }

    public boolean checkSharedDashboards() {
        List<DashboardResponseBody> allDashboards = listOfDashboards(getAllDashboards());
        List<DashboardResponseBody> sharedDashboardsViaRequest = listOfDashboards(getDashboardByParameter("shared"));
        for (DashboardResponseBody dashboard : sharedDashboardsViaRequest) {
            dashboard.setShare(true);
        }
        List<DashboardResponseBody> sharedDashboards = new ArrayList<>();
        for (DashboardResponseBody dashboard : allDashboards) {
            if (dashboard.getShare()) {
                sharedDashboards.add(dashboard);
            }
        }
        return sharedDashboards.equals(sharedDashboardsViaRequest);
    }

    public void deleteAllDashboards() {
        List<DashboardResponseBody> allDashboards = listOfDashboards(getAllDashboards());
        for (DashboardResponseBody dashboard : allDashboards) {
            String id = dashboard.getId();
            RestAssured.given()
                    .header("Authorization", formatBearerAuthHeader())
                    .header("Control-Type", CONTROL_TYPE)
                    .delete(String.format(Routes.MODIFY_DASHBOARD, id));
        }
    }
}
