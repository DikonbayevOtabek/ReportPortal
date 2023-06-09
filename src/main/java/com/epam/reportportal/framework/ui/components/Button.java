package com.epam.reportportal.framework.ui.components;

import com.epam.reportportal.framework.browser.Browser;
import org.openqa.selenium.By;

import java.util.Objects;

public class Button extends CommonPageElement {

    public Button(By locator) {
        Objects.requireNonNull(locator, Browser.LOCATOR_NOT_NULL_MESSAGE);
        this.locator = locator;
    }

    public void click() {
        waitForPageElementToBeClickable(locator);
        Browser.getInstance().click(locator);
    }
    public void click(By otherLocator) {
        waitForPageElementPresenceLocated(otherLocator);
        Browser.getInstance().click(locator);
    }

    public String getText() {
        waitForPageElementVisibilityLocated(locator);
        return Browser.getInstance().getText(locator);
    }

    @Override
    public String toString() {
        String buttonName = getText();
        return String.format("Button \"%s\"", buttonName);
    }

}
