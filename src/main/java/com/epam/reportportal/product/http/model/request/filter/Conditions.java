package com.epam.reportportal.product.http.model.request.filter;

import java.util.LinkedHashMap;
import java.util.Map;

public class Conditions {

    private String condition;
    private String filteringField;
    private String value;
    private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

    public Conditions(String condition, String filteringField, String value) {

        this.condition = condition;
        this.filteringField = filteringField;
        this.value = value;
    }
}
