package reportportal.tests.stepdefs;


import com.epam.reportportal.product.services.AuthenticationService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LogoutSteps {
    private boolean isLoggedOut;

    @When("User clicks logout button through avatar pop up window")
    public void userClicksLogoutButtonThroughAvatarPopUpWindow() {
        AuthenticationService authenticationService = new AuthenticationService();
        isLoggedOut = authenticationService.logout();

    }

    @Then("User should see successfully logout pop up message")
    public void userShouldSeeSuccessfullyLogoutPopUpMessage() {
        Assert.assertTrue(isLoggedOut);
    }
}
