package com.niantic.part_3_challenge;

public class Refrigerator
{
    private int currentTemperature;
    private int maxCapacity;
    private final int MIN_CAPACITY = 0;
    private int defaultTemperature = 32;
    private int capacity;
    private int availableCapacity;
   private int addedItem;


    private boolean isDoorOpen = false;

    public Refrigerator(int currentTemperature, int maxCapacity)
    {
        this.currentTemperature = currentTemperature;
        this.maxCapacity = maxCapacity;
        this.availableCapacity = maxCapacity;
    }

    public int getCurrentTemperature()
    {
        return  currentTemperature;
    }

    public int getMaxCapacity()
    {
        return maxCapacity;
    }
    public boolean isDoorOpen()
    {
        return isDoorOpen;
    }

    public void openDoor()
    {
        currentTemperature = defaultTemperature;
        isDoorOpen = true;
    }

    public void closeDoor()
    {
        isDoorOpen = false;
    }

    public int getCapacity()
    {
        return  maxCapacity;
    }

    public int getAvailableCapacity()
    {
        return availableCapacity;
    }

    public boolean addItem(int capacity)
    {
        if (capacity <=  availableCapacity && isDoorOpen)
        {
            availableCapacity -= capacity;
            return true;
        }
        return false;
        //questionable
    }

    public void removeItem(int capacity)
    {
        if(isDoorOpen)
        {
         availableCapacity += capacity;

        }
        if(availableCapacity> maxCapacity)
        {
            availableCapacity= maxCapacity;
        }
    }


}


