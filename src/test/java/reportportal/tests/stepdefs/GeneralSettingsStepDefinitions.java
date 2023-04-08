package reportportal.tests.stepdefs;

import com.epam.reportportal.product.buisness.objects.settings.general.GeneralSettingsConfigFactory;
import com.epam.reportportal.product.pages.ProjectGeneralSettingsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GeneralSettingsStepDefinitions {
    private final ProjectGeneralSettingsPage generalSettingsPage = new ProjectGeneralSettingsPage();

    @When("General project settings tab is opened")
    public void openGeneralProjectSettingsTab() {
        generalSettingsPage.open();
    }

    @Then("Project name field have an attribute {string}")
    public void isProjectNameFieldHaveAnAttribute(String attribute) {
        generalSettingsPage.isNameFieldDisabled(attribute);
    }

    @Given("Launch inactivity timeout option is set to {string}")
    public void setLaunchInactivityTimeoutOption(String launchInactivityTimeout) {
        generalSettingsPage.setLaunchInactivityTimeout(GeneralSettingsConfigFactory
                .withLaunchInactivityTimeoutFromFeature(launchInactivityTimeout));
    }

    @Then("Pop up successful message is present")
    public void isPopUpSuccessfulMessagePresent() {
        generalSettingsPage.pressSubmitButtonAndValidateSuccessfulChange();
    }

}
