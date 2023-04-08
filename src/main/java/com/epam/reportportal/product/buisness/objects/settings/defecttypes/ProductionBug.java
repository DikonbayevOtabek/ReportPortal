package com.epam.reportportal.product.buisness.objects.settings.defecttypes;

import java.util.Objects;

public class ProductionBug {
    private final String name;
    private final String abbreviation;
    private String colour;

    public String getName() {
        return name;
    }

    public ProductionBug(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductionBug that = (ProductionBug) o;
        return name.equals(that.name) && abbreviation.equals(that.abbreviation) && Objects.equals(colour, that.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, abbreviation, colour);
    }

    @Override
    public String toString() {
        return "ProductionBug{" +
                "name='" + name + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}
