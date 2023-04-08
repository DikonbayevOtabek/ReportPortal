package reportportal.tests.stepdefs;

import com.epam.reportportal.framework.browser.Browser;
import io.cucumber.java.After;
import org.testng.annotations.BeforeMethod;

public class Hooks {
    @After
    public void tearDown() {
        Browser.stop();
    }
}
