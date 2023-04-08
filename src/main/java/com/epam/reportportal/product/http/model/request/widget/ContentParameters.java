package com.epam.reportportal.product.http.model.request.widget;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ContentParameters {

    private List<String> contentFields;
    private int itemsCount;
    private WidgetOptions widgetOptions;
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();

    public ContentParameters(List<String> contentFields, int itemsCount, WidgetOptions widgetOptions) {
        this.contentFields = contentFields;
        this.itemsCount = itemsCount;
        this.widgetOptions = widgetOptions;
    }

    public List<String> getContentFields() {
        return contentFields;
    }

    public void setContentFields(List<String> contentFields) {
        this.contentFields = contentFields;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }

    public WidgetOptions getWidgetOptions() {
        return widgetOptions;
    }

    public void setWidgetOptions(WidgetOptions widgetOptions) {
        this.widgetOptions = widgetOptions;
    }

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
        result = ((result * 31) + ((this.widgetOptions == null) ? 0 : this.widgetOptions.hashCode()));
        result = ((result * 31) + ((this.contentFields == null) ? 0 : this.contentFields.hashCode()));
        result = ((result * 31) + this.itemsCount);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ContentParameters rhs)) {
            return false;
        }
        return ((((Objects.equals(this.additionalProperties, rhs.additionalProperties))
                && (Objects.equals(this.widgetOptions, rhs.widgetOptions)))
                && (Objects.equals(this.contentFields, rhs.contentFields)))
                && (this.itemsCount == rhs.itemsCount));
    }

}
