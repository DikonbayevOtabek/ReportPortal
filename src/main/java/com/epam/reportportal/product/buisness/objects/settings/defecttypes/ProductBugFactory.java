package com.epam.reportportal.product.buisness.objects.settings.defecttypes;

import org.apache.commons.lang3.RandomStringUtils;

public class ProductBugFactory {
    private ProductBugFactory(){
        throw new IllegalStateException("It is prohibited to create instance of " + ProductBugFactory.class);
    }
    public static ProductionBug withRandomTestData() {
        String name = RandomStringUtils.randomAlphabetic(3, 55);
        String abbreviation = RandomStringUtils.randomAlphabetic(1, 4);
        return new ProductionBug(name, abbreviation);
    }
}
