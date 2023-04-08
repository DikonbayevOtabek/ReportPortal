package reportportal.tests.ui;

import com.epam.jira.util.Screenshoter;
import com.epam.reportportal.framework.browser.Browser;
import com.epam.reportportal.framework.browser.Host;
import com.epam.reportportal.framework.configuration.CapabilitiesCreator;
import com.epam.reportportal.framework.listeners.SuiteListener;
import com.epam.reportportal.framework.listeners.TestListener;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.lang.reflect.Method;

@Listeners({TestListener.class, SuiteListener.class, com.epam.jira.testng.ExecutionListener.class})
public class BaseTest {
    protected Browser browser;

    @BeforeMethod(description = "Set Up", groups = {"all", "settings", "dashboard", "login/logout", "navigation menu"})
    public void setUp(Method method) {
        CapabilitiesCreator.getMethodName(method.getName());
        browser = Browser.getInstance();
        Screenshoter.initialize(browser.getDriver());
    }

    @AfterMethod(description = "Tear down", groups = {"all", "settings", "dashboard", "login/logout", "navigation menu"})
    public void tearDown(ITestResult result) {
        if (browser.getHost().equals(Host.SAUCE_LABS)) {
            String status = result.isSuccess() ? "passed" : "failed";
            ((JavascriptExecutor) browser.getDriver()).executeScript("sauce:job-result=" + status);
        }
        Browser.stop();
    }
}
