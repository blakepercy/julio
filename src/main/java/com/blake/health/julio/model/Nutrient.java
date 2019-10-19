package com.blake.health.julio.model;

public class Nutrient
{

    private float id;
    private String number;
    private String name;
    private float rank;
    private String unitName;

    // Getter Methods

    public float getId()
    {
        return id;
    }

    public String getNumber()
    {
        return number;
    }

    public String getName()
    {
        return name;
    }

    public float getRank()
    {
        return rank;
    }

    public String getUnitName()
    {
        return unitName;
    }

    // Setter Methods

    public void setId(float id)
    {
        this.id = id;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setRank(float rank)
    {
        this.rank = rank;
    }

    public void setUnitName(String unitName)
    {
        this.unitName = unitName;
    }
}