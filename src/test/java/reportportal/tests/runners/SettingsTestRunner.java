package reportportal.tests.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/change-settings.feature",
        glue = {"reportportal.tests.stepdefs"},
        plugin = "pretty",
        monochrome = true,
        tags = "@Settings"
)
public class SettingsTestRunner extends AbstractTestNGCucumberTests {

}
