package com.epam.reportportal.product.pages;

import com.epam.reportportal.framework.browser.Browser;
import com.epam.reportportal.framework.ui.components.Button;
import com.epam.reportportal.framework.ui.components.CommonPageElement;
import com.epam.reportportal.framework.ui.components.Link;
import com.epam.reportportal.framework.ui.components.TextField;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DefectTypesPage extends BasicPage {
    private static final String BLANK = "(//input)";
    private static final String FIRST_OCCURRENCE = "[1]";

    public DefectTypesPage open() {
        By defectLocator = By
                .xpath("//div[@class='']/div/a[4]");
        Link link = new Link(defectLocator);
        link.click();
        return this;
    }

    public String createNewDefectType(String name, String abbreviation) {
        By addDefectButtonLocator = By.xpath("(//button[@title=''])" + FIRST_OCCURRENCE);
        Button button = new Button(addDefectButtonLocator);
        waitUntilPopupsExtinct();
        button.click();
        new TextField(By.xpath(BLANK + FIRST_OCCURRENCE))
                .type(name);
        new TextField(By.xpath(BLANK + "[2]"))
                .type(abbreviation);
        By confirmLocator = By.xpath("//button[@title='Confirm']");
        Button saveButton = new Button(confirmLocator);
        CommonPageElement.scrollToElement(confirmLocator);
        saveButton.click();
        return name;
    }

    public DefectTypesPage checkIfCreatedDefectTypeIsPresent(String name) {
        String nameLocator = String.format(anyElementContainsSpecifiedTextLocator, name);
        By defectTypeLocator = By.xpath(nameLocator);
        CommonPageElement.scrollToElement(defectTypeLocator);
        boolean isDisplayed = Browser.getInstance().isDisplayed(defectTypeLocator);
        Assert.assertTrue(isDisplayed);
        return this;
    }
}
