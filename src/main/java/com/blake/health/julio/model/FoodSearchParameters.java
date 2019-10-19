package com.blake.health.julio.model;

public class FoodSearchParameters
{
    private String generalSearchInput;
    private String sortField = "dataType.keyword";
    private String sortDirection = "asc";

    public FoodSearchParameters(String generalSearchInput)
    {
        this.generalSearchInput = generalSearchInput;
    }

    public FoodSearchParameters(String generalSearchInput, String sortField, String sortDirection)
    {
        this.generalSearchInput = generalSearchInput;
        this.sortField = sortField;
        this.sortDirection = sortDirection;
    }

    // Getter Methods

    public String getGeneralSearchInput() {
        return generalSearchInput;
    }

    public String getSortField() {
        return sortField;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    // Setter Methods

    public void setGeneralSearchInput(String generalSearchInput) {
        this.generalSearchInput = generalSearchInput;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }
}