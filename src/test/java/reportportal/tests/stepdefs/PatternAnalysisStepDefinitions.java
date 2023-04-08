package reportportal.tests.stepdefs;

import com.epam.reportportal.product.pages.PatternAnalysisPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PatternAnalysisStepDefinitions {
    private final PatternAnalysisPage patternAnalysisPage = new PatternAnalysisPage();

    @When("Pattern-analysis settings tab is opened")
    public void openPatternAnalysisSettingsTab() {
        patternAnalysisPage.open();
    }

    @Given("New pattern with max name value is created")
    public void creteNewPatternWithMaxNameValue() {
        patternAnalysisPage.createPatternWithMaxNameValue();
    }

    @Then("User can not copy created pattern")
    public void isMaxNameValuePatternCopyNotCreated() {
        patternAnalysisPage.isCopyNotCreated();
    }
}
