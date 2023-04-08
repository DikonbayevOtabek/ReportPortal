package reportportal.tests.api;

import com.epam.reportportal.product.http.service.WidgetService;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WidgetControllerApiTest extends BaseAPITest {
    private Response response;
    private final WidgetService widgetService = new WidgetService(token);
    private int idFieldValue;


    @Test(groups = {"api", "widget controller"},
            description = "sends GET URL query to retrieve all widget names data and validates response body fields")
    public void checkAllWidgetNamesGetRequestOnResponseBodyValidData() {
        String responseBodyContent = widgetService
                .getAllWidgetNames()
                .convertResponseAndReturnAsString();
        Assert.assertTrue(responseBodyContent.contains("page")
                && responseBodyContent.contains("content"));
    }

    @Test(groups = {"api", "widget controller"},
            description = "sends POST URL query to create new widget and validates response code")
    public void createNewWidgetUsingPOST() {
        response = widgetService.createNewWidget();
        idFieldValue = response.jsonPath().getInt(ID);
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test(groups = {"api", "widget controller"}, dependsOnMethods = {"createNewWidgetUsingPOST"},
            description = "sends GET URL query to retrieve widget data by id and validates response body id field")
    public void getWidgetByIdAndValidateIdFieldValue() {
        response = widgetService.getWidgetById(idFieldValue);
        int idFieldResponseValue = response.jsonPath().getInt(ID);
        Assert.assertEquals(idFieldResponseValue, idFieldValue);

    }
}
