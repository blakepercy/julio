package com.blake.health.julio.model;

public class MeasureUnit
{

    private float id;
    private String name;
    private String abbreviation;

    // Getter Methods

    public float getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getAbbreviation()
    {
        return abbreviation;
    }

    // Setter Methods

    public void setId(float id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAbbreviation(String abbreviation)
    {
        this.abbreviation = abbreviation;
    }
}