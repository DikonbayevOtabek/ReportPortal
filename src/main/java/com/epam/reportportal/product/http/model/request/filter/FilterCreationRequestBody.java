package com.epam.reportportal.product.http.model.request.filter;

import java.util.List;

public class FilterCreationRequestBody {

    private List<Conditions> conditions;
    private String description;
    private String name;
    private List<Orders> orders;
    private boolean share;
    private String type;


    public void setConditions(List<Conditions> conditions) {
        this.conditions = conditions;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }


    public void setShare(boolean share) {
        this.share = share;
    }


    public void setType(String type) {
        this.type = type;
    }
}
