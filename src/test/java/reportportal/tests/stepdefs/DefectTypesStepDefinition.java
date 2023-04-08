package reportportal.tests.stepdefs;

import com.epam.reportportal.product.buisness.objects.settings.defecttypes.ProductBugFactory;
import com.epam.reportportal.product.pages.DefectTypesPage;
import com.epam.reportportal.product.pages.ProjectGeneralSettingsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DefectTypesStepDefinition {
    private final DefectTypesPage defectTypesPage = new DefectTypesPage();
    private String generatedName;

    @When("Defect-types tab is opened")
    public void openDefectTypesTab() {
        new ProjectGeneralSettingsPage()
                .open();
        defectTypesPage
                .open();

    }

    @Given("Custom product bug group is created")
    public void createCustomProductBugGroup() {
        generatedName = ProductBugFactory.withRandomTestData().getName();
        String generatedAbbreviation = ProductBugFactory.withRandomTestData().getAbbreviation();
        defectTypesPage.createNewDefectType(generatedName, generatedAbbreviation);

    }

    @Then("Created bug group is present")
    public void isCreatedBugGroupPresent() {
        defectTypesPage.checkIfCreatedDefectTypeIsPresent(generatedName);
    }
}
