package com.epam.reportportal.product.pages;

import com.epam.reportportal.framework.browser.Browser;
import com.epam.reportportal.framework.ui.components.Button;
import com.epam.reportportal.framework.ui.components.CommonPageElement;
import com.epam.reportportal.framework.ui.components.Link;
import com.epam.reportportal.framework.ui.components.TextField;
import com.epam.reportportal.utils.StringConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PatternAnalysisPage extends BasicPage {
    private final String patternDescription = StringConstructor.generatePatternDescriptionTestData();


    public PatternAnalysisPage open() {
        new ProjectGeneralSettingsPage().open();
        By patternAnalysisLocator = By
                .xpath("//div[@class='']/div/a[6]");
        Link patternAnalysis = new Link(patternAnalysisLocator);
        patternAnalysis.click();
        return this;
    }

    public PatternAnalysisPage createPatternWithMaxNameValue() {
        By createButtonLocator = By.xpath("//button[@type]");
        By textFieldLocator = By.xpath("//input[@type='text']");
        By saveButtonLocator = By.xpath("//button[contains(text(),'Save')]");
        By textAreaLocator = By.tagName("textarea");
        Button createButton = new Button(createButtonLocator);
        TextField textField = new TextField(textFieldLocator);
        TextField textarea = new TextField(textAreaLocator);
        Button save = new Button(saveButtonLocator);
        createButton.click();
        textField.type(randomAlphanumericName);
        textarea.type(patternDescription);
        save.click();
        return this;
    }

    public void isCopyNotCreated() {
        CommonPageElement.scrollToElement(By.xpath("//footer"));

        By buttonLoc = By.xpath("//button[2]");
        List<WebElement> buttons = Browser.getInstance().getListOfWebElementsByLocator(buttonLoc);
        WebElement copyButton = buttons.get(buttons.size() - 1);
        copyButton.click();
        By saveLocator = By.xpath("//button[contains(text(),'Save')]");
        Button save = new Button(saveLocator);
        save.click();
    }
}
