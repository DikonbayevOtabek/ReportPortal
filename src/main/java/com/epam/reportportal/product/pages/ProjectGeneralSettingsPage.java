package com.epam.reportportal.product.pages;

import com.epam.reportportal.framework.exception.LaunchInactivityTimeoutException;
import com.epam.reportportal.framework.ui.components.Button;
import com.epam.reportportal.framework.ui.components.CommonPageElement;
import com.epam.reportportal.framework.ui.components.Link;
import com.epam.reportportal.framework.ui.components.PopUp;
import com.epam.reportportal.product.buisness.objects.settings.general.GeneralSettingsConfig;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProjectGeneralSettingsPage extends BasicPage {

    public void isNameFieldDisabled(String attributeName) {
        By nameFieldLocator = By.xpath("//input");
        String elementStatus = CommonPageElement.getAttribute(nameFieldLocator, attributeName);
        Assert.assertTrue(Boolean.parseBoolean(elementStatus));
    }

    public ProjectGeneralSettingsPage open() {
        By pageLocator = By.xpath("//a[@href='#default_personal/settings']");
        Link link = new Link(pageLocator);
        link.click();
        return this;
    }

    public ProjectGeneralSettingsPage setLaunchInactivityTimeout(GeneralSettingsConfig config) {
        if (config.getLaunchInactivityTimeoutOption() != null) {
            By dropDownLocator = By.xpath("(//div[contains(@class,'inputDropdown__dropdown-container')])[2]");
            new Link(dropDownLocator)
                    .click();
            By optionXpath = By.xpath(String.format("//div[contains(text(), '%s')]",
                    config.getLaunchInactivityTimeoutOption()));
            Link option = new Link(optionXpath);
            option.click();
        } else {
            throw new LaunchInactivityTimeoutException();
        }
        return this;
    }

    public void pressSubmitButtonAndValidateSuccessfulChange() {
        By submitButton = By.xpath("//button[@type='submit']");
        Button button = new Button(submitButton);
        button.click();
        By popUpLocator = By.xpath(String.format(anyElementContainsSpecifiedTextLocator, successfulSettingsUpdatePopUpMessage));
        PopUp popUp = new PopUp(popUpLocator);
        Assert.assertEquals(popUp.getText(), successfulSettingsUpdatePopUpMessage);
    }

}
