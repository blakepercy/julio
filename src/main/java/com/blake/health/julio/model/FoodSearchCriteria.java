package com.blake.health.julio.model;

public class FoodSearchCriteria
{

    private String generalSearchInput;
    private float pageNumber;
    private boolean requireAllWords;

    // Getter Methods

    public String getGeneralSearchInput()
    {
        return generalSearchInput;
    }

    public float getPageNumber()
    {
        return pageNumber;
    }

    public boolean getRequireAllWords()
    {
        return requireAllWords;
    }

    // Setter Methods

    public void setGeneralSearchInput(String generalSearchInput)
    {
        this.generalSearchInput = generalSearchInput;
    }

    public void setPageNumber(float pageNumber)
    {
        this.pageNumber = pageNumber;
    }

    public void setRequireAllWords(boolean requireAllWords)
    {
        this.requireAllWords = requireAllWords;
    }
}