package com.epam.reportportal.product.pages;

import com.epam.reportportal.framework.browser.Browser;
import com.epam.reportportal.framework.ui.components.Button;
import com.epam.reportportal.framework.ui.components.CommonPageElement;
import com.epam.reportportal.product.pages.widget.SelectWidgetType;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasicPage {
    By addNewWidgetButtonLocator = By.xpath("//span[text()='Add new widget']");

    public boolean isDashboardAdded() {
        CommonPageElement.waitForPageElementPresenceLocated(addNewWidgetButtonLocator);
        return CommonPageElement.isElementVisible(addNewWidgetButtonLocator, 5);
    }

    private SelectWidgetType clickAddNewWidget() {
        Button addNewWidgetButton = new Button(addNewWidgetButtonLocator);
        addNewWidgetButton.click();
        return new SelectWidgetType();
    }

    public DashboardPage addNewWidget(String filterName, String launchName) {
        clickAddNewWidget()
                .clickLaunchStatisticsChartItem()
                .addFilter(filterName, launchName)
                .clickNextStep()
                .clickAdd();
        return this;
    }

    public boolean isNewWidgetAdded(String name) {
        String nameOfAddedWidgetLocator = "//div[contains(text(),'s')]";
        WebDriver driver = Browser.getInstance().getDriver();
        try {
            driver.findElement(By.xpath(String.format(nameOfAddedWidgetLocator, name)));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public AllDashboardsPage returnToAllDashboardsPage() {
        new Button(By.xpath("//a[text()='All Dashboards']")).click();
        return new AllDashboardsPage();
    }

}
