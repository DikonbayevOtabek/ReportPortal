package com.epam.reportportal.product.http.model.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties({"owner", "id", "description", "page"})
public class DashboardListBody {

    private List<DashboardResponseBody> content;

    public List<DashboardResponseBody> getContent() {
        return content;
    }
}
