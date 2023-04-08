package com.epam.reportportal.framework.ui.components;

import com.epam.reportportal.framework.browser.Browser;
import org.openqa.selenium.By;

import java.util.Objects;

public class TextField extends CommonPageElement {

    public TextField(By locator) {
        Objects.requireNonNull(locator, Browser.LOCATOR_NOT_NULL_MESSAGE);
        this.locator = locator;
    }

    public void clear() {
        waitForPageElementVisibilityLocated(locator);
        Browser.getInstance().clear(locator);
    }

    public void type(CharSequence... textForType) {
        Objects.requireNonNull(textForType, String.format(Browser.CAN_NOT_BE_NULL_MESSAGE,"Text"));
        waitForPageElementPresenceLocated(locator);
        Browser.getInstance().sendKeys(locator, textForType);
    }

    public String getText() {
        return CommonPageElement.getAttribute(locator, "value");
    }
}
