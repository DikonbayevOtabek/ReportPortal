package com.epam.reportportal.product.http.model.request.filter;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;

public class ApiBodyFilterCreator {
    private ApiBodyFilterCreator() {
        throw new IllegalStateException("It is forbidden to create instance of " + ApiBodyFilterCreator.class + " class");
    }

    public static FilterCreationRequestBody withHardCodedBodyData() {
        FilterCreationRequestBody body = new FilterCreationRequestBody();
        body.setConditions(List.of(new Conditions("has", "compositeAttribute", "demo")));
        body.setDescription("someDescription");
        body.setName(RandomStringUtils.randomAlphabetic(3, 8));
        body.setShare(false);
        body.setType("Launch");
        body.setOrders(List.of(new Orders(false, "startTime")));
        return body;
    }
}
