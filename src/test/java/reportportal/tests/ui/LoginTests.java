package reportportal.tests.ui;

import com.epam.jira.JIRATestKey;
import com.epam.reportportal.product.buisness.objects.credentials.Credentials;
import com.epam.reportportal.product.buisness.objects.credentials.CredentialsFactory;
import com.epam.reportportal.product.services.AuthenticationService;
import com.epam.reportportal.product.services.NavigationService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest{

    private static final String USERNAME = CredentialsFactory.withDataFromProperty().getLogin();
    private static final String PASSWORD = CredentialsFactory.withDataFromProperty().getPassword();
    private final AuthenticationService authenticationService = new AuthenticationService();

    @BeforeMethod(description = "open login page")
    public void openLoginPage() {
        NavigationService navigationService = new NavigationService();
        navigationService.navigateToLoginPage();
    }
    @JIRATestKey(key="EPMFARMATS-16798")
    @Test(description = "***LoginWithValidCredentials***\n")
    public void loginWithValidCredentialsTest(){
        boolean isLoggedIn =  authenticationService.login(USERNAME, PASSWORD);
        Assert.assertTrue(isLoggedIn);
    }
    @Test(description = "***LoginWithInvalidUsername***\n")
    public void loginWithInvalidUsernameTest(){
        Credentials user = Credentials.createUserWithIncorrectUsername();
        boolean isLoggedIn = authenticationService.login(user.getLogin(), user.getPassword());
        Assert.assertFalse(isLoggedIn);
    }
    @JIRATestKey(key="EPMFARMATS-16800")
    @Test(description = "***LoginWithInvalidPassword***\n")
    public void loginWithInvalidPasswordTest(){
        Credentials user = Credentials.createUserWithIncorrectPassword();
        boolean isLoggedIn = authenticationService.login(user.getLogin(), user.getPassword());
        Assert.assertFalse(isLoggedIn);
    }
    @Test(description = "***LoginWithEmptyUsername***\n")
    public void loginWithEmptyUsernameTest(){
        Credentials user = Credentials.createUserWithEmptyUsername();
        boolean isLoggedIn = authenticationService.login(user.getLogin(), user.getPassword());
        Assert.assertFalse(isLoggedIn);
    }

    @Test(description = "***LoginWithEmptyPassword***\n")
    public void loginWithEmptyPasswordTest(){
        Credentials user = Credentials.createUserWithEmptyPassword();
        boolean isLoggedIn = authenticationService.login(user.getLogin(), user.getPassword());
        Assert.assertFalse(isLoggedIn);
    }
}
