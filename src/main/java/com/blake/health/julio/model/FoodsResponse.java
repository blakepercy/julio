package com.blake.health.julio.model;

import java.util.ArrayList;
import java.util.List;

public class FoodsResponse
{
    FoodSearchCriteria FoodSearchCriteriaObject;
    private float totalHits;
    private float currentPage;
    private float totalPages;
    private List<Food> foods = new ArrayList<>();

    public List<Food> getFoods()
    {
        return foods;
    }

    public void setFoods(List<Food> foods)
    {
        this.foods = foods;
    }

    // Getter Methods

    public FoodSearchCriteria getFoodSearchCriteria()
    {
        return FoodSearchCriteriaObject;
    }

    public float getTotalHits()
    {
        return totalHits;
    }

    public float getCurrentPage()
    {
        return currentPage;
    }

    public float getTotalPages()
    {
        return totalPages;
    }

    // Setter Methods

    public void setFoodSearchCriteria(FoodSearchCriteria foodSearchCriteriaObject)
    {
        this.FoodSearchCriteriaObject = foodSearchCriteriaObject;
    }

    public void setTotalHits(float totalHits)
    {
        this.totalHits = totalHits;
    }

    public void setCurrentPage(float currentPage)
    {
        this.currentPage = currentPage;
    }

    public void setTotalPages(float totalPages)
    {
        this.totalPages = totalPages;
    }
}
