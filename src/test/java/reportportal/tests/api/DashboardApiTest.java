package reportportal.tests.api;

import com.epam.reportportal.product.buisness.objects.dashboard.Dashboard;
import com.epam.reportportal.product.buisness.objects.dashboard.DashboardFactory;
import com.epam.reportportal.product.http.service.DashboardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class DashboardApiTest extends BaseAPITest {
    DashboardService dashboardService = new DashboardService(token);
    private final Dashboard dashboard = DashboardFactory.withRandomTestData();
    private String id;
    SoftAssert softAssert = new SoftAssert();
    @Test
    public void createDashboardTest() throws JsonProcessingException {
        Response response = dashboardService.addDashboard(dashboard);
        id = response.jsonPath().getString(ID);
        softAssert.assertEquals(response.getStatusCode(), 201);
        softAssert.assertTrue(response.getStatusLine().contains("Created"));
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = {"createDashboardTest"})
    public void getDashboardByIdTest(){
        Response getResponse = dashboardService.getDashboardByParameter(id);
        softAssert.assertEquals(getResponse.getStatusCode(), 200,"status codes don't match");
        softAssert.assertEquals(getResponse.jsonPath().getString(ID), id, "ids don't match");
        softAssert.assertAll();
    }

    @Test
    public void getNamesOfSharedDashboardsTest() throws JsonProcessingException {
        dashboardService.addSeveralDashboards(5);
        Response response = dashboardService.getDashboardByParameter("shared");
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertTrue(response.getStatusLine().contains("OK"));
        softAssert.assertTrue(dashboardService.checkSharedDashboards());
        softAssert.assertAll();
    }
    @AfterClass
    public void deleteAllDashboards(){
        dashboardService.deleteAllDashboards();
    }
}
