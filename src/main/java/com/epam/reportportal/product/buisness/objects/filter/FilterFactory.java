package com.epam.reportportal.product.buisness.objects.filter;

import org.apache.commons.lang3.RandomStringUtils;

public class FilterFactory {
    private FilterFactory(){
        throw new IllegalStateException("It is prohibited to create instance of " + FilterFactory.class);
    }
    public static Filter withRandomTestData() {
        String filterName = "TestFilterName".concat(RandomStringUtils.randomAlphabetic(5));
        String launchName = "TestLaunchName".concat(RandomStringUtils.randomAlphabetic(5));
        return new Filter(filterName, launchName);
    }
}
