package reportportal.tests.stepdefs;

import com.epam.reportportal.product.buisness.objects.credentials.CredentialsFactory;
import com.epam.reportportal.product.services.AuthenticationService;
import com.epam.reportportal.product.services.NavigationService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertTrue;

public class BackgroundStepDefinitions {
    boolean successfulLogin;

    @Given("I navigate to the login page")
    public void navigateToLoginPage() {
        new NavigationService().navigateToLoginPage();
    }

    @When("I submit username and password")
    public void submitCredentials() {
        successfulLogin = new AuthenticationService().login(
                CredentialsFactory.withDataFromProperty().getLogin(),
                CredentialsFactory.withDataFromProperty().getPassword());
    }

    @Then("I should be logged in")
    public void isUserLoggedIn() {
        assertTrue(successfulLogin);
    }

}
