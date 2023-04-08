package reportportal.tests.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty"},
        monochrome = true,
        features = {"src/test/resources/features/Dashboard.feature"},
        glue = {"reportportal.tests.stepdefs"},
        tags = "@Dashboard"
)
public class DashboardTestRunner extends AbstractTestNGCucumberTests {
}
