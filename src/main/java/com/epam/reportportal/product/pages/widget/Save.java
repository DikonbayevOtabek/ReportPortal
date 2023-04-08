package com.epam.reportportal.product.pages.widget;

import com.epam.reportportal.framework.ui.components.Button;
import com.epam.reportportal.product.pages.BasicPage;
import com.epam.reportportal.product.pages.DashboardPage;
import org.openqa.selenium.By;

public class Save extends BasicPage {
    public DashboardPage clickAdd() {
        new Button(By.xpath("//button[text()='Add']")).click();
        return new DashboardPage();
    }
}
