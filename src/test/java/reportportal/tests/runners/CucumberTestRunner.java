package reportportal.tests.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty"},
        monochrome = true,
        features = {"src/test/resources/features"},
        glue = {"reportportal.tests.stepdefs"}
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
