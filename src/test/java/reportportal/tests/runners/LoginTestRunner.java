package reportportal.tests.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/Login.feature"},
        glue = {"reportportal.tests.stepdefs"},
        plugin = {"pretty"},
        monochrome = true
)

public class LoginTestRunner extends AbstractTestNGCucumberTests {
}
