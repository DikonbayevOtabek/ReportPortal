package com.epam.reportportal.framework.ui.components;

import com.epam.reportportal.framework.browser.Browser;
import org.openqa.selenium.By;

import java.util.Objects;

public class PopUp extends CommonPageElement {
    public PopUp(By locator) {
        Objects.requireNonNull(locator, Browser.LOCATOR_NOT_NULL_MESSAGE);
        this.locator = locator;
    }

    public String getText() {
        waitForPageElementVisibilityLocated(locator);
        return Browser.getInstance().getText(locator);
    }
    public void waitUntilPopUpDisappeared(){
        waitForPageElementInvisibilityLocated(locator);
    }
    public boolean isDisplayed() {
        waitForPageElementVisibilityLocated(locator);
        return Browser.getInstance().isDisplayed(locator);
    }
}
