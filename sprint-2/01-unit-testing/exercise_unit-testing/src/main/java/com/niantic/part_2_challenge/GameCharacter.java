package com.niantic.part_2_challenge;

public class GameCharacter
{
    private final String name;
    private final int maxEnergyLevel;
    private int energyLevel;

    public String getName()
    {
        return name;
    }

    public int getEnergyLevel()
    {
        return energyLevel;
    }

    public int getMaxEnergyLevel()
    {
        return maxEnergyLevel;
    }

    public GameCharacter(int maxEnergyLevel, String name)
    {
        this.maxEnergyLevel = maxEnergyLevel;
        this.name = name;

        this.energyLevel = maxEnergyLevel;
    }

    public void takeHit(int damage)
    {
        if(damage > this.energyLevel) {
            this.energyLevel = 0;
        }
        energyLevel -= damage;
    }

    public void heal(int amount)
    {
//        if(energyLevel == maxEnergyLevel)
//        {
//            return energyLevel;
//        }

        energyLevel += amount;
    }

    public boolean isKnockedOut()
    {
        return energyLevel == 0;
    }
}
