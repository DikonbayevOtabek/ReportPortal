package com.epam.reportportal.framework.ui.components;

import com.epam.reportportal.framework.browser.Browser;
import org.openqa.selenium.By;

import java.util.Objects;

public class Link extends CommonPageElement {

    public Link(By locator) {
        Objects.requireNonNull(locator, Browser.LOCATOR_NOT_NULL_MESSAGE);
        this.locator = locator;
    }

    public void click() {
        waitForPageElementToBeClickable(locator);
        Browser.getInstance().click(locator);
    }

    public String getText() {
        waitForPageElementVisibilityLocated(locator);
        return Browser.getInstance().getText(locator);
    }
}
