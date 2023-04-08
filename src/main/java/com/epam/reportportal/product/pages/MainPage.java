package com.epam.reportportal.product.pages;

import com.epam.reportportal.framework.ui.components.Button;
import org.openqa.selenium.By;

public class MainPage {
    private final By launchesButtonLocator = By.xpath("//a[@href='#default_personal/launches']");
    private final By allLaunchesLocator = By.xpath("//div[contains(text(),'All launches')]");
    private final By debugButtonLocator = By.xpath("//a[@href='#default_personal/userdebug/all']");
    private final By refreshLocator = By.xpath("//span[contains(text(),'Refresh')]");


    public void clickAllLaunchesButton() {
        Button allLaunchesButton = new Button(launchesButtonLocator);
        allLaunchesButton.click();
    }

    public boolean isAllLaunchesVisible() {
        try {
            Button allLaunchesButton = new Button(allLaunchesLocator);
            allLaunchesButton.click();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public void clickDebugButton() {
        Button debugButton = new Button(debugButtonLocator);
        debugButton.click();
    }

    public boolean isDebugSettingVisible() {
        try {
            Button debugSettingButton = new Button(refreshLocator);
            debugSettingButton.click();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
