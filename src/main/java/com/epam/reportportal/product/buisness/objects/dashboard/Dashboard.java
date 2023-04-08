package com.epam.reportportal.product.buisness.objects.dashboard;

public class Dashboard {
    private final String name;
    private final String description;
    private boolean share;

    public Dashboard(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Dashboard(String name, String description, boolean share) {
        this.name = name;
        this.description = description;
        this.share = share;
    }

    public String getName() {
        return name;
    }


    public  String getDescription() {
        return description;
    }


    public boolean getShare() {
        return share;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Dashboard{}";
    }
}
