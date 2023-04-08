package com.epam.reportportal.framework.configuration;

import com.epam.reportportal.framework.browser.BrowserType;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesCreator {
    private static String methodName;

    public static DesiredCapabilities getChromeDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WIN10);
        return capabilities;
    }

    public static DesiredCapabilities getFirefoxDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.WIN10);
        return capabilities;
    }

    public static MutableCapabilities getCapabilities(BrowserType type) {
        MutableCapabilities browserCapabilities = null;
        MutableCapabilities sauceOptions = new DesiredCapabilities();
        sauceOptions.setCapability("username", PropertyDataReader.getDataByKey(SauceLabsURLFactory.SAUCE_LABS_USERNAME_KEY));
        sauceOptions.setCapability("accesskey", PropertyDataReader.getDataByKey(SauceLabsURLFactory.SAUCE_LABS_ACCESS_TOKEN_KEY));
        sauceOptions.setCapability("name", methodName);
        switch (type) {
            case FIREFOX -> browserCapabilities = getFirefoxDesiredCapabilities();
            case CHROME -> browserCapabilities = getChromeDesiredCapabilities();
        }
        browserCapabilities.setCapability("sauce:options", sauceOptions);
        return browserCapabilities;
    }

    public static void getMethodName(String name) {
        methodName = name;
    }
}
