package reportportal.tests.stepdefs;

import com.epam.reportportal.product.buisness.objects.credentials.Credentials;
import com.epam.reportportal.product.buisness.objects.credentials.CredentialsFactory;
import com.epam.reportportal.product.services.AuthenticationService;
import com.epam.reportportal.product.services.NavigationService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {


    private  AuthenticationService authenticationService;
    private boolean isLoggedIn = false;
    private static final String LOGIN = CredentialsFactory.withDataFromProperty().getLogin();
    private static final String PASSWORD = CredentialsFactory.withDataFromProperty().getPassword();

    @Given("User navigates to login page")
    public void userNavigateToLoginPage() {
        NavigationService navigationService = new NavigationService();
        navigationService.navigateToLoginPage();
    }

    @When("User fills fields with given information")
    public void userFillsFieldsWithGivenInformation() {
        authenticationService = new AuthenticationService();
        isLoggedIn = authenticationService.login(LOGIN, PASSWORD);
    }

    @Then("User should see pop up message")
    public void userShouldSeePopUpMessage() {
        Assert.assertTrue(isLoggedIn);
    }

    @When("User fills username and password fields with invalid values")
    public void iFillUsernameAndPasswordFieldsWithInvalidValues() {
        authenticationService = new AuthenticationService();
        Credentials credentials = Credentials.createUserWithIncorrectUsername();
        isLoggedIn = authenticationService.login(credentials.getLogin(), credentials.getPassword());
    }


    @When("User fills username and password fields with empty values")
    public void iFillUsernameAndPasswordFieldsWithEmptyValues() {
        authenticationService = new AuthenticationService();
        Credentials credentials = Credentials.createUserWithEmptyUsername();
        isLoggedIn = authenticationService.login(credentials.getLogin(), credentials.getPassword());
    }

    @Then("User should not see pop up message")
    public void iShouldNotSeePopUpMessage() {
        Assert.assertFalse(isLoggedIn);
    }


}
