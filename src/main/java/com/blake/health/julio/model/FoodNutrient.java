package com.blake.health.julio.model;

public class FoodNutrient
{
    private String type;
    private float id;
    Nutrient NutrientObject;
    private float amount;

    // Getter Methods

    public String getType()
    {
        return type;
    }

    public float getId()
    {
        return id;
    }

    public Nutrient getNutrient()
    {
        return NutrientObject;
    }

    public float getAmount()
    {
        return amount;
    }

    // Setter Methods

    public void setType(String type)
    {
        this.type = type;
    }

    public void setId(float id)
    {
        this.id = id;
    }

    public void setNutrient(Nutrient nutrientObject)
    {
        this.NutrientObject = nutrientObject;
    }

    public void setAmount(float amount)
    {
        this.amount = amount;
    }
}
