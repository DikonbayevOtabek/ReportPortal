package com.epam.reportportal.product.pages.widget;

import com.epam.reportportal.framework.ui.components.Button;
import com.epam.reportportal.framework.ui.components.TextField;
import com.epam.reportportal.product.pages.BasicPage;
import org.openqa.selenium.By;

public class ConfigureWidget extends BasicPage {

    public ConfigureWidget addFilter(String filterName, String launchName) {
        By addFilterButtonLocator = By.xpath("//span[text()='Add filter']");
        By inputFilterNameFieldLocator = By.xpath("//input[@placeholder='Input filter name']");
        By launchNameFieldLocator = By.xpath("//input[@placeholder='Enter name']");
        By submitButtonLocator = By.xpath("//button[text()='Submit']");
        new Button(addFilterButtonLocator).click();
        new TextField(inputFilterNameFieldLocator).type(filterName);
        new TextField(launchNameFieldLocator).type(launchName);
        new Button(submitButtonLocator).click();
        return this;
    }

    public Save clickNextStep() {
        By nextStepButtonLocator = By.xpath("//span[text()='Next step']");
        Button nextStep = new Button(nextStepButtonLocator);
        nextStep.click();
        return new Save();
    }
}
