package com.epam.reportportal.product.services;

import com.epam.reportportal.product.pages.LoginPage;
import com.epam.reportportal.product.pages.LogoutPage;

public class AuthenticationService {
    public boolean login(String login, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage
                .typeLogin(login)
                .typePassword(password)
                .clickLoginButton();
        return loginPage.isSignedSuccessfully();
    }


    public boolean logout() {
        LogoutPage logoutPage = new LogoutPage();
        logoutPage.clickAvatar()
                .clickLogoutButton();
        return logoutPage.isSuccessfullyLogout();
    }
}
