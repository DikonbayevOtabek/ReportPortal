package reportportal.tests.api;

import com.epam.reportportal.product.http.service.UserControllerAPIService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class UserControllerAPITests  extends  BaseAPITest {

    private Response response;
    private int id;
    private UserControllerAPIService userControllerService = new UserControllerAPIService(adminToken);

    @Test
    public void getCurrentLoggedUserInformation() {
        response = userControllerService.getUserInformation();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void createSpecifiedUser() {
        response = userControllerService.createSpecifiedUser();
        id = response.jsonPath().getInt(ID);
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test(dependsOnMethods = {"createSpecifiedUser"})
    public void deleteSpecifiedUserById(){
        response = userControllerService.deleteUserById(id);
        List<Integer> responseIds = response.jsonPath().getList("successfullyDeleted");
        int responseId = responseIds.get(0);
        Assert.assertEquals(responseId, id);
    }
}
