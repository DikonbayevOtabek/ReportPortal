package com.epam.reportportal.product.http.model.request;

import com.epam.reportportal.utils.JsonRepresentation;

import java.util.Objects;

public class DashboardRequestBody {
    private String name;
    private String description;
    private boolean share;

    public DashboardRequestBody(String description, String name, boolean share) {
        this.name = name;
        this.description = description;
        this.share = share;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isShare() {
        return share;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DashboardRequestBody that = (DashboardRequestBody) o;
        return share == that.share && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, share);
    }

    @Override
    public String toString() {
        return JsonRepresentation.convertToJsonString(this);
    }
}
