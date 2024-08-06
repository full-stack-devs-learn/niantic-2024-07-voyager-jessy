package com.niantic.part_3_challenge;

public class Refrigerator
{
    private int currentTemperature;
    private int maxCapacity;
    private final int MIN_CAPACITY = 0;
    private int defaultTemperature = 32;
    private int capacity;
    private int availableCapacity;
   private int removeCapacity;
   private int addedItem;


    private boolean isDoorOpen = false;

    public Refrigerator(int currentTemperature, int maxCapacity)
    {
        this.currentTemperature = currentTemperature;
        this.maxCapacity = maxCapacity;
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
        return  capacity;
    }

    public int getAvailableCapacity()
    {
        return maxCapacity - capacity;
    }

    public int getAddedItem()
    {
        return addedItem;
    }

    public boolean addItem(int capacity)
    {
        if (capacity < maxCapacity && isDoorOpen)
        {
            availableCapacity=+ addedItem;
            return true;
        }
        return false;
        //questionable
    }

    public int getRemoveCapacity()
    {
        return removeCapacity;
    }

    public void removeItem(int capacity)
    {
        if(isDoorOpen() && capacity>= MIN_CAPACITY)
        {
         availableCapacity =+ removeCapacity;
         capacity=- removeCapacity;
        }
    }


}


