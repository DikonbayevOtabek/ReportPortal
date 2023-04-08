package com.epam.reportportal.framework.configuration;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabsURLFactory {
    public static final String SAUCE_LABS_USERNAME_KEY = "sauce-labs.credentials.username";
    public static final String SAUCE_LABS_ACCESS_TOKEN_KEY = "sauce-labs.credentials.token";

    public static URL withPropertyData() throws MalformedURLException {
        String username = PropertyDataReader.getDataByKey(SAUCE_LABS_USERNAME_KEY);
        String token = PropertyDataReader.getDataByKey(SAUCE_LABS_ACCESS_TOKEN_KEY);
        return new URL("https://" + username + ":" + token + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
    }

}
