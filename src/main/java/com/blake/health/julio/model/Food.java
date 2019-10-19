package com.blake.health.julio.model;

public class Food {
    private float fdcId;
    private String description;
    private String additionalDescriptions;
    private String dataType;
    private String foodCode;
    private String publishedDate;
    private String allHighlightFields;
    private float score;


    // Getter Methods

    public float getFdcId() {
        return fdcId;
    }

    public String getDescription() {
        return description;
    }

    public String getAdditionalDescriptions() {
        return additionalDescriptions;
    }

    public String getDataType() {
        return dataType;
    }

    public String getFoodCode() {
        return foodCode;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getAllHighlightFields() {
        return allHighlightFields;
    }

    public float getScore() {
        return score;
    }

    // Setter Methods

    public void setFdcId(float fdcId) {
        this.fdcId = fdcId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAdditionalDescriptions(String additionalDescriptions) {
        this.additionalDescriptions = additionalDescriptions;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public void setFoodCode(String foodCode) {
        this.foodCode = foodCode;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setAllHighlightFields(String allHighlightFields) {
        this.allHighlightFields = allHighlightFields;
    }

    public void setScore(float score) {
        this.score = score;
    }
}