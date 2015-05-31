package org.hestia.RecipeBox.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Direction
{
    private String instruction;
    private int step;

    public String getInstruction()
    {
        return instruction;
    }

    public void setInstruction(String instruction)
    {
        this.instruction = instruction;
    }

    public int getStep()
    {
        return step;
    }

    public void setStep(int step)
    {
        this.step = step;
    }
}
