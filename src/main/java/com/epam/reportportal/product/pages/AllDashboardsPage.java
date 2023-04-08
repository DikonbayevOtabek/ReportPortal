package com.epam.reportportal.product.pages;

import com.epam.reportportal.framework.ui.components.Button;
import com.epam.reportportal.framework.ui.components.CommonPageElement;
import com.epam.reportportal.framework.ui.components.Link;
import com.epam.reportportal.framework.ui.components.TextField;
import com.epam.reportportal.product.buisness.objects.dashboard.Dashboard;
import com.epam.reportportal.product.buisness.objects.dashboard.DashboardFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AllDashboardsPage extends BasicPage {
    private final String nameLink = "//div[contains(concat((@class), ''), 'pageLayout__page-content')]//a";
    private final By nameOfCreatedDashboardLocator =
            By.xpath(String.format(nameLink));
    private final By descriptionOfCreatedDashboardLocator =
            By.xpath(String.format("%s/..//div[1]", nameLink));

    public AllDashboardsPage open() {
        By pageLocator = By.xpath("//*[contains(text(), 'Dashboards')]/ancestor::a");
        Link link = new Link(pageLocator);
        link.click();
        return this;
    }

    private void clickEditIcon(String dashboardName) {
        String editIconLocator = String.format("%s[text()='%s']/..//i[contains(concat((@class), ''), 'icon-pencil')]", nameLink, dashboardName);
        Button edit = new Button(By.xpath(editIconLocator));
        edit.click();
    }

    public AllDashboardsPage deleteDashboard(String dashboardName) {
        waitUntilPopupsExtinct();
        String deleteIconLocator = String.format("%s[text()= '%s' ]/..//i[contains(concat((@class), ''), 'icon-delete')]", nameLink, dashboardName);
        new Button(By.xpath(deleteIconLocator)).click();
        new Button(By.xpath("//button[text()='Delete']")).click();
        return this;
    }

    public boolean isDashboardDeleted(String dashboardName) {
        return !isNameOfCreatedDashboardCorrect(dashboardName);
    }

    public AllDashboardsPage editDashboard(String dashboardName, String newDashboardName) {
        waitUntilPopupsExtinct();
        clickEditIcon(dashboardName);
        By nameOfChangedDashboard = By.xpath("//input[@type='text' and @placeholder='Enter dashboard name']");
        By descriptionOfChangedDashboard = By.xpath("//textarea[@placeholder='Enter dashboard description']");
        By updateButton = By.xpath("//button[text()='Update']");
        TextField nameTextField = new TextField(nameOfChangedDashboard);
        TextField descriptionTextField = new TextField(descriptionOfChangedDashboard);
        Button update = new Button(updateButton);
        nameTextField.clear();
        nameTextField.type(newDashboardName);
        descriptionTextField.clear();
        descriptionTextField.type(newDashboardName);
        update.click();
        return this;
    }

    public DashboardPage addNewDashboard(String nameOfCreatedDashboard, String descriptionOfCreatedDashboard) {
        By addNewDashboardButton = By.xpath("//span[text()='Add New Dashboard']");
        By nameOfNewDashboardLocator = By.xpath("//div[@id='modal-root']//input[@type='text']");
        By descriptionOfNewDashboardLocator = By.xpath("//div[@id='modal-root']//textarea");
        By addButtonLocator = By.xpath("//button[text()='Add']");

        Button addNewDashboard = new Button(addNewDashboardButton);
        addNewDashboard.click();

        TextField name = new TextField(nameOfNewDashboardLocator);
        name.type(nameOfCreatedDashboard);
        TextField description = new TextField(descriptionOfNewDashboardLocator);
        description.type(descriptionOfCreatedDashboard);

        Button add = new Button(addButtonLocator);
        add.click();
        return new DashboardPage();
    }

    private boolean isInsideOfList(List<WebElement> listOfDashboardNames, String nameOfDashboard) {
        for (int i = 0; i < listOfDashboardNames.toArray().length; ++i) {
            if (listOfDashboardNames.get(i).getText().equals(nameOfDashboard)) {
                return true;
            }
        }
        return false;
    }

    public boolean isNameOfCreatedDashboardCorrect(String nameOfDashboard) {
        waitUntilPopupsExtinct();
        CommonPageElement.waitForAllElementsPresenceLocated(nameOfCreatedDashboardLocator);
        List<WebElement> listOfDashboardNames = driver.findElements(nameOfCreatedDashboardLocator);
        return isInsideOfList(listOfDashboardNames, nameOfDashboard);
    }

    public boolean isDescriptionOfCreatedDashboardCorrect(String descriptionOfDashboard) {
        CommonPageElement.waitForAllElementsPresenceLocated(descriptionOfCreatedDashboardLocator);
        List<WebElement> listOfDashboardDescriptions = driver.findElements(descriptionOfCreatedDashboardLocator);
        return isInsideOfList(listOfDashboardDescriptions, descriptionOfDashboard);
    }

    public AllDashboardsPage addSeveralDashboards(int numberOfDashboards) {
        for (int i = 0; i < numberOfDashboards; i++) {
            Dashboard dashboard = DashboardFactory.withRandomTestData();
            addNewDashboard(dashboard.getName(), dashboard.getDescription())
                    .returnToAllDashboardsPage();
        }
        return this;
    }

    public AllDashboardsPage typeDashboardNameIntoSearchByNameInput(String dashboardName) {
        By searchByNameInputLocator = By.xpath("//input[@type='text']");
        TextField searchByNameInput = new TextField(searchByNameInputLocator);
        searchByNameInput.type(dashboardName + "\n");
        return this;
    }

    public boolean isDashboardFoundWithSearchByNameInput(String dashboardName) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.numberOfElementsToBe(nameOfCreatedDashboardLocator, 1));
        Link foundDashboard = new Link(nameOfCreatedDashboardLocator);
        return foundDashboard.getText().equals(dashboardName);
    }
}
