package com.epam.reportportal.framework.browser;

import com.epam.reportportal.framework.configuration.PropertyDataReader;
import com.epam.reportportal.utils.DirectoryCreator;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Browser {
    private static final ThreadLocal<Browser> browserInstance = new ThreadLocal<>();
    private final WebDriver driver;
    private final String screenshotDirectoryPath;
    public static final String BROWSER_KEY_VALUE = "browser";
    public static final String HOST_KEY_VALUE = "host";
    private final Host host;
    public static final String CAN_NOT_BE_NULL_MESSAGE = "%s can not be null";
    public static final String LOCATOR_NOT_NULL_MESSAGE = "Locator can not be null";

    public Browser() {
        host = Host.valueOf(System.getProperty(HOST_KEY_VALUE, PropertyDataReader.getDataByKey(HOST_KEY_VALUE)));
        BrowserType browserType = BrowserType.valueOf(System.getProperty(BROWSER_KEY_VALUE,
                PropertyDataReader.getDataByKey(BROWSER_KEY_VALUE)));
        boolean gridStatus = Boolean.parseBoolean(System.getProperty("grid", "false"));
        screenshotDirectoryPath = DirectoryCreator.create("./target/screenshots");
        driver = WebDriverFactory.getDriver(browserType, gridStatus, host);
    }

    public static Browser getInstance() {
        if (browserInstance.get() == null) {
            browserInstance.set(new Browser());
        }
        return browserInstance.get();
    }

    public Host getHost() {
        return host;
    }

    public static void stop() {
        if (browserInstance.get() != null) {
            browserInstance.get().driver.quit();
        }
        browserInstance.remove();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void navigate(String url) {
        Objects.requireNonNull(url, String.format(CAN_NOT_BE_NULL_MESSAGE, "Url"));
        driver.navigate()
                .to(url);
    }

    public void click(By locator) {
        Objects.requireNonNull(locator, LOCATOR_NOT_NULL_MESSAGE);
        driver.findElement(locator)
                .click();
    }

    public boolean isDisplayed(By locator) {
        Objects.requireNonNull(locator, LOCATOR_NOT_NULL_MESSAGE);
        return driver.findElement(locator)
                .isDisplayed();
    }

    public boolean isSelected(By locator) {
        Objects.requireNonNull(locator, LOCATOR_NOT_NULL_MESSAGE);
        return driver.findElement(locator)
                .isSelected();
    }

    public void selectOption(By locator, String option) {
        Objects.requireNonNull(locator, LOCATOR_NOT_NULL_MESSAGE);
        Objects.requireNonNull(option, String.format(CAN_NOT_BE_NULL_MESSAGE, "Selected option"));
        WebElement dropDownElement = driver.findElement(locator);
        dropDownElement.click();
        Select select = new Select(dropDownElement);
        select.selectByVisibleText(option);
    }

    public String getFirstSelectedOption(By locator) {
        Objects.requireNonNull(locator, LOCATOR_NOT_NULL_MESSAGE);
        WebElement dropDownElement = driver.findElement(locator);
        Select dropDownList = new Select(dropDownElement);
        String selectedOptionText = dropDownList.getFirstSelectedOption().getText();
        return selectedOptionText.replace(" ", "").replace("\n", "");
    }

    public void sendKeys(By locator, CharSequence... keysToSend) {
        Objects.requireNonNull(locator, LOCATOR_NOT_NULL_MESSAGE);
        Objects.requireNonNull(keysToSend, String.format(CAN_NOT_BE_NULL_MESSAGE, "KEYS TO SEND"));
        WebElement inputArea = driver.findElement(locator);
        inputArea.sendKeys(keysToSend);
    }

    public void clear(By locator) {
        Objects.requireNonNull(locator, LOCATOR_NOT_NULL_MESSAGE);
        WebElement webElement = driver.findElement(locator);
        webElement.clear();
    }

    public void reloadPage() {
        driver.navigate().refresh();
    }

    public String getText(By locator) {
        Objects.requireNonNull(locator, LOCATOR_NOT_NULL_MESSAGE);
        WebElement webElement = driver.findElement(locator);
        return webElement.getText().trim();
    }

    public void openNewTab() {
        driver.switchTo().newWindow(WindowType.TAB);
    }

    public void switchTab(String windowHandle) {
        Objects.requireNonNull(windowHandle, String.format(CAN_NOT_BE_NULL_MESSAGE, "Window handle"));
        driver.switchTo().window(windowHandle);
    }

    public void switchToExistingTabByIndex(int index) {
        List<String> allTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allTabs.get(index));
    }

    public void closeTab(String windowHandle) {
        Objects.requireNonNull(windowHandle, String.format(CAN_NOT_BE_NULL_MESSAGE, "Window handle"));
        switchTab(windowHandle);
        driver.close();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public File takeScreenshot() {
        String screenshotPath = String.format("%s/%s.png", screenshotDirectoryPath, System.nanoTime());
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotFile;
    }

    public List<WebElement> getListOfWebElementsByLocator(By locator) {
        return driver.findElements(locator);
    }
}
