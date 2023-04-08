package com.epam.reportportal.product.services;


import com.epam.reportportal.product.pages.LoginPage;
import com.epam.reportportal.product.pages.MainPage;

public class NavigationMenuService {


    public boolean isLaunchesButtonWorking(String login, String password) {
        MainPage mainPage = new LoginPage()
                .typeLogin(login)
                .typePassword(password)
                .clickLoginButton()
                .navigateToMainPage();
        mainPage.clickAllLaunchesButton();
        return mainPage.isAllLaunchesVisible();
    }

    public boolean isDebugButtonWorking(String login, String password) {
        MainPage mainPage = new LoginPage()
                .typeLogin(login)
                .typePassword(password)
                .clickLoginButton()
                .navigateToMainPage();
        mainPage.clickDebugButton();
        return mainPage.isDebugSettingVisible();
    }

}
