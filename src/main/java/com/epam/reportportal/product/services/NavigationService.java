package com.epam.reportportal.product.services;

import com.epam.reportportal.product.pages.LoginPage;

public class NavigationService {
    private final LoginPage loginPage = new LoginPage();

    public void navigateToLoginPage() {
        loginPage.open();
    }
}
