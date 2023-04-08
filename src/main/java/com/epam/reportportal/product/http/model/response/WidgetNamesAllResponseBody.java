package com.epam.reportportal.product.http.model.response;

import java.util.List;
import java.util.Map;

public class WidgetNamesAllResponseBody {
    private List<String> content;
    private Map<String, Integer> page;

    public List<String> getContent() {
        return content;
    }

    public Map<String, Integer> getPage() {
        return page;
    }

    @Override
    public String toString() {
        return "WidgetNamesAllResponseBody{" +
                "content=" + content +
                ", page=" + page +
                '}';
    }
}
