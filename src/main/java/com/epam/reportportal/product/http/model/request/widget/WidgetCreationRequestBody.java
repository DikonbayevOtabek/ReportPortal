package com.epam.reportportal.product.http.model.request.widget;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class WidgetCreationRequestBody {


    private ContentParameters contentParameters;
    private String description;
    private List<Integer> filterIds;
    private String name;
    private boolean share;
    private String widgetType;
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();

    public ContentParameters getContentParameters() {
        return contentParameters;
    }

    public void setContentParameters(ContentParameters contentParameters) {
        this.contentParameters = contentParameters;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getFilterIds() {
        return filterIds;
    }

    public void setFilterIds(List<Integer> filterIds) {
        this.filterIds = filterIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isShare() {
        return share;
    }

    public void setShare(boolean share) {
        this.share = share;
    }

    public String getWidgetType() {
        return widgetType;
    }

    public void setWidgetType(String widgetType) {
        this.widgetType = widgetType;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WidgetCreationRequestBody that = (WidgetCreationRequestBody) o;
        return share == that.share && contentParameters.equals(that.contentParameters)
                && description.equals(that.description)
                && filterIds.equals(that.filterIds)
                && name.equals(that.name)
                && widgetType.equals(that.widgetType)
                && additionalProperties.equals(that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contentParameters, description, filterIds, name, share, widgetType, additionalProperties);
    }

    @Override
    public String toString() {
        return "CreateWidgetResponseBody{\n" +
                "contentParameters=" + contentParameters +
                "\n, description='" + description + '\'' +
                "\n, filterIds=" + filterIds +
                "\n, name='" + name + '\'' +
                "\n, share=" + share +
                "\n, widgetType='" + widgetType + '\'' +
                "\n, additionalProperties=" + additionalProperties +
                '}';
    }
}