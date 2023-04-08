package com.epam.reportportal.product.http.model.request.widget;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class ApiBodyWidgetCreator {
    private ApiBodyWidgetCreator() {
        throw new IllegalStateException("It is forbidden to create instance of " + ApiBodyWidgetCreator.class + " class");
    }

    public static WidgetCreationRequestBody withHardCodedBodyData() {
        List<String> contentFields = new ArrayList<>();
        contentFields.add("statistics$executions$total");

        WidgetCreationRequestBody body = new WidgetCreationRequestBody();
        body.setDescription("some test description");
        body.setName(RandomStringUtils.randomAlphanumeric(3, 10));
        body.setContentParameters(new ContentParameters(contentFields, 600, new WidgetOptions()));
        body.setWidgetType("statisticTrend");
        body.setShare(false);
        body.setFilterIds(new ArrayList<>());
        return body;
    }
}
