package com.epam.reportportal.framework.browser;

import com.epam.reportportal.framework.configuration.CapabilitiesCreator;
import com.epam.reportportal.framework.configuration.SauceLabsURLFactory;
import com.epam.reportportal.framework.listeners.DriverListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {
    private static final String DEFAULT_HUB_URL = "http://localhost:4444";
    private static WebDriver driver;

    public WebDriverFactory() {
        throw new AssertionError("Creating entity of " + WebDriverFactory.class + " is forbidden");
    }

    public static WebDriver getDriver(BrowserType type, boolean isGridBeingUsed, Host host) {
        WebDriver driver = null;
        try {
            switch (host) {
                case SAUCE_LABS -> {
                    MutableCapabilities capabilities = CapabilitiesCreator.getCapabilities(type);
                    driver = new RemoteWebDriver(SauceLabsURLFactory.withPropertyData(), capabilities);
                }
                case LOCAL -> {
                    switch (type) {
                        case CHROME -> driver = selectChromeDriverInstanceTypeBasedOnGridCondition(isGridBeingUsed);
                        case FIREFOX -> driver = selectFirefoxDriverInstanceTypeBasedOnGridCondition(isGridBeingUsed);
                        default -> throw new IllegalArgumentException("Incorrect browser type to initialize: " + type);
                    }
                }
            }
        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        }
        EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(new DriverListener());
        return decorator.decorate(driver);
    }

    private static WebDriver selectChromeDriverInstanceTypeBasedOnGridCondition(boolean isGridBeingUsed)
            throws MalformedURLException {
        if (isGridBeingUsed) {
            driver = new RemoteWebDriver(new URL(DEFAULT_HUB_URL),
                    CapabilitiesCreator.getChromeDesiredCapabilities());
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    private static WebDriver selectFirefoxDriverInstanceTypeBasedOnGridCondition(boolean isGridBeingUsed)
            throws MalformedURLException {
        if (isGridBeingUsed) {
            driver = new RemoteWebDriver(new URL(DEFAULT_HUB_URL),
                    CapabilitiesCreator.getFirefoxDesiredCapabilities());
        } else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }
}
