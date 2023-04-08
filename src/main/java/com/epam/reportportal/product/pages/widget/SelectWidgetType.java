package com.epam.reportportal.product.pages.widget;

import com.epam.reportportal.framework.ui.components.Button;
import com.epam.reportportal.product.pages.BasicPage;
import org.openqa.selenium.By;

public class SelectWidgetType extends BasicPage {
    public ConfigureWidget clickLaunchStatisticsChartItem() {
        By launchStatisticsChartItemLocator = By.xpath("//div[text()='Launch statistics chart']");
        By activeLaunchStatisticsChartItemLocator = By.xpath("//div[text()='Launch statistics chart' and contains(concat((@class), ''), 'active')]");
        By nextStepButtonLocator = By.xpath("//span[text()='Next step']");
        Button launchStatisticsChart = new Button(launchStatisticsChartItemLocator);
        launchStatisticsChart.click();
        Button nextStep = new Button(nextStepButtonLocator);
        nextStep.click(activeLaunchStatisticsChartItemLocator);
        return new ConfigureWidget();
    }
}
