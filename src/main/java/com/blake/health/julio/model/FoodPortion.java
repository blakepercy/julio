package com.blake.health.julio.model;

public class FoodPortion
{
    private float id;
    MeasureUnit MeasureUnitObject;
    private String modifier;
    private float gramWeight;
    private String portionDescription;
    private float sequenceNumber;

    // Getter Methods

    public float getId()
    {
        return id;
    }

    public MeasureUnit getMeasureUnit()
    {
        return MeasureUnitObject;
    }

    public String getModifier()
    {
        return modifier;
    }

    public float getGramWeight()
    {
        return gramWeight;
    }

    public String getPortionDescription()
    {
        return portionDescription;
    }

    public float getSequenceNumber()
    {
        return sequenceNumber;
    }

    // Setter Methods

    public void setId(float id)
    {
        this.id = id;
    }

    public void setMeasureUnit(MeasureUnit measureUnitObject)
    {
        this.MeasureUnitObject = measureUnitObject;
    }

    public void setModifier(String modifier)
    {
        this.modifier = modifier;
    }

    public void setGramWeight(float gramWeight)
    {
        this.gramWeight = gramWeight;
    }

    public void setPortionDescription(String portionDescription)
    {
        this.portionDescription = portionDescription;
    }

    public void setSequenceNumber(float sequenceNumber)
    {
        this.sequenceNumber = sequenceNumber;
    }
}
