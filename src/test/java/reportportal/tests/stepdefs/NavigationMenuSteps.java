package reportportal.tests.stepdefs;

import com.epam.reportportal.product.buisness.objects.credentials.CredentialsFactory;
import com.epam.reportportal.product.services.NavigationMenuService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class NavigationMenuSteps {

    private static final String LOGIN = CredentialsFactory.withDataFromProperty().getLogin();
    private static final String PASSWORD = CredentialsFactory.withDataFromProperty().getPassword();
    private NavigationMenuService navigationMenuService;
    private boolean isLaunchesButtonWorking;
    private boolean isDebugButtonWorking;

    @When("User navigates to Launches page")
    public void userNavigatesToLaunchesPage() {
        navigationMenuService = new NavigationMenuService();
        isLaunchesButtonWorking = navigationMenuService.isLaunchesButtonWorking(LOGIN, PASSWORD);
    }

    @Then("User should find All launches button")
    public void userShouldFindAllLaunchesButton() {
        Assert.assertTrue(isLaunchesButtonWorking);
    }

    @When("User navigates to Debug page")
    public void userNavigatesToDebugPage() {
        navigationMenuService = new NavigationMenuService();
        isDebugButtonWorking = navigationMenuService.isDebugButtonWorking(LOGIN, PASSWORD);
    }

    @Then("User should product bug tab")
    public void userShouldProductBugTab() {
        Assert.assertTrue(isDebugButtonWorking);
    }
}
