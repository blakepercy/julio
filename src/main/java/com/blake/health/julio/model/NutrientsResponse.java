package com.blake.health.julio.model;

import java.util.ArrayList;
import java.util.List;

public class NutrientsResponse
{
    private String foodClass;
    private String description;
    List< FoodNutrient > foodNutrients = new ArrayList<>();
    ArrayList < Object > foodComponents = new ArrayList < Object > ();
    ArrayList < Object > foodAttributes = new ArrayList < Object > ();
    private String tableAliasName;
    private String foodCode;
    private String startDate;
    private String endDate;
    WweiaFoodCategory WweiaFoodCategoryObject;
    private float fdcId;
    private String dataType;
    private String publicationDate;
    List < FoodPortion > foodPortions = new ArrayList<> ();
    ArrayList < Object > inputFoods = new ArrayList < Object > ();


    // Getter Methods

    public List<FoodNutrient> getFoodNutrients()
    {
        return foodNutrients;
    }

    public List<FoodPortion> getFoodPortions()
    {
        return foodPortions;
    }

    public String getFoodClass() {
        return foodClass;
    }

    public String getDescription() {
        return description;
    }

    public String getTableAliasName() {
        return tableAliasName;
    }

    public String getFoodCode() {
        return foodCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public WweiaFoodCategory getWweiaFoodCategory() {
        return WweiaFoodCategoryObject;
    }

    public float getFdcId() {
        return fdcId;
    }

    public String getDataType() {
        return dataType;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    // Setter Methods

    public void setFoodClass(String foodClass) {
        this.foodClass = foodClass;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTableAliasName(String tableAliasName) {
        this.tableAliasName = tableAliasName;
    }

    public void setFoodCode(String foodCode) {
        this.foodCode = foodCode;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setWweiaFoodCategory(WweiaFoodCategory wweiaFoodCategoryObject) {
        this.WweiaFoodCategoryObject = wweiaFoodCategoryObject;
    }

    public void setFdcId(float fdcId) {
        this.fdcId = fdcId;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }
}
