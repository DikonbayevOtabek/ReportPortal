package reportportal.tests.ui;


import com.epam.jira.JIRATestKey;
import com.epam.reportportal.product.buisness.objects.credentials.CredentialsFactory;
import com.epam.reportportal.product.services.NavigationMenuService;
import com.epam.reportportal.product.services.NavigationService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigationManuTest extends BaseTest{

    private static final String USERNAME = CredentialsFactory.withDataFromProperty().getLogin();
    private static final String PASSWORD = CredentialsFactory.withDataFromProperty().getPassword();
    private final NavigationMenuService navigationMenuService = new NavigationMenuService();

    @BeforeMethod(description = "open login page")
    public void openLoginPage() {
        NavigationService navigationService = new NavigationService();
        navigationService.navigateToLoginPage();
    }
    @JIRATestKey(key="EPMFARMATS-16802")
    @Test(description = "***LaunchesButtonCheck***\n")
    public void launchesButtonCheck(){
        boolean isLaunchesButtonVisible =  navigationMenuService.isLaunchesButtonWorking(USERNAME, PASSWORD);
        Assert.assertTrue(isLaunchesButtonVisible);
    }
    @JIRATestKey(key="EPMFARMATS-16803")
    @Test(description = "***DebugButtonCheck***\n")
    public void debugButtonCheck() {
        boolean isDebugButtonVisible = navigationMenuService.isDebugButtonWorking(USERNAME, PASSWORD);
        Assert.assertTrue(isDebugButtonVisible);
    }

}

