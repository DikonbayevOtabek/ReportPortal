package com.epam.reportportal.product.http.model.request.widget;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class WidgetOptions {

    private Map<String, Object> additionalProperties = new LinkedHashMap<>();

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof WidgetOptions options)) {
            return false;
        }
        return (Objects.equals(this.additionalProperties, options.additionalProperties));
    }

}