package com.epam.reportportal.product.pages;

import com.epam.reportportal.framework.browser.Browser;
import com.epam.reportportal.framework.ui.components.Button;
import com.epam.reportportal.framework.ui.components.PopUp;
import com.epam.reportportal.framework.ui.components.TextField;
import org.openqa.selenium.By;

public class LoginPage extends BasicPage {
    public static final String ESSENTIAL_URL = "http://localhost:8080";
    private final By loginTextFieldLocator = By.xpath("//input[@name='login']");
    private final By passwordFieldLocator = By.xpath("//input[@name='password']");
    private final By loginButtonLocator = By.xpath("//button[@type='submit']");
    private final By signedInSuccessfullyLocator = By.xpath(String
            .format(anyElementContainsSpecifiedTextLocator, successfulLoginPopUp));


    public LoginPage typeLogin(String login) {
        TextField loginTextField = new TextField(loginTextFieldLocator);
        loginTextField.clear();
        loginTextField.type(login);
        return this;
    }

    public LoginPage typePassword(String password) {
        TextField passwordTextField = new TextField(passwordFieldLocator);
        passwordTextField.clear();
        passwordTextField.type(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        Button button = new Button(loginButtonLocator);
        button.click();
        return this;
    }

    public boolean isSignedSuccessfully() {
        try {
            PopUp signedInSuccessfully = new PopUp(signedInSuccessfullyLocator);
            return signedInSuccessfully.isDisplayed();
        } catch (Exception exception) {
            return false;
        }
    }

    public LoginPage open() {
        Browser.getInstance().getDriver().get(ESSENTIAL_URL);
        Browser.getInstance().getDriver().manage().window().maximize();
        return this;
    }

    public MainPage navigateToMainPage() {
        return new MainPage();
    }
}
