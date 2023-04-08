package reportportal.tests.ui;

import com.epam.jira.JIRATestKey;
import com.epam.reportportal.product.buisness.objects.credentials.CredentialsFactory;
import com.epam.reportportal.product.services.AuthenticationService;
import com.epam.reportportal.product.services.NavigationService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTests extends  BaseTest{
    private static final String USERNAME = CredentialsFactory.withDataFromProperty().getLogin();
    private static final String PASSWORD = CredentialsFactory.withDataFromProperty().getPassword();
    private final AuthenticationService authenticationService = new AuthenticationService();

    @BeforeMethod(description = "open login page")
    public void openLoginPage() {
        NavigationService navigationService = new NavigationService();
        navigationService.navigateToLoginPage();
    }
    @JIRATestKey(key="EPMFARMATS-16801")
    @Test(description = "***LogoutFromDefaultAvatar***\n")
    public void logoutFromDefaultAccount(){
        authenticationService.login(USERNAME, PASSWORD);
        boolean isLoggedOut = authenticationService.logout();
        Assert.assertTrue(isLoggedOut);
    }
}
