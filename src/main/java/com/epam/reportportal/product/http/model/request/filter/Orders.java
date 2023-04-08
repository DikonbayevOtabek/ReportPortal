package com.epam.reportportal.product.http.model.request.filter;


public class Orders {

    private boolean isAsc;
    private String sortingColumn;

    public Orders(boolean isAsc, String sortingColumn) {
        this.isAsc = isAsc;
        this.sortingColumn = sortingColumn;
    }
}
