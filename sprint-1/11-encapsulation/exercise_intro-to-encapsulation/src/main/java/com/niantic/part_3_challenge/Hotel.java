package com.niantic.part_3_challenge;

public class Hotel
{
    private int numberOfRooms;
    private int numberOfSuites;
    private int bookedRooms;
    private int bookedSuites;
    private int availableRooms = numberOfRooms - bookedRooms;
    private int availableSuites = numberOfSuites - bookedSuites;


    public Hotel(int numberOfRooms, int numberOfSuites)
    {
        this.numberOfRooms = numberOfRooms;
        this.numberOfSuites = numberOfSuites;
    }

    public int getNumberOfRooms()
    {
        return numberOfRooms;
    }
    public int getNumberOfSuites()
    {
        return numberOfSuites;
    }

    public Hotel(int numberOfRooms, int numberOfSuites, int bookedRooms, int bookedSuites)
    {
        this.numberOfRooms = numberOfRooms;
        this.numberOfSuites = numberOfSuites;
        this.bookedRooms = bookedRooms;
        this.bookedSuites = bookedSuites;

    }

    public int getBookedRooms()
    {
        return bookedRooms;
    }

    public int getBookedSuites()
    {
        return bookedSuites;
    }

    public int getAvailableRooms()
    {
        return availableRooms;
    }

    public int getAvailableSuites()
    {
        return availableSuites;
    }

    public boolean makeReservation(int numberOfRooms, boolean isSuite)
    {
        if(isSuite  && bookedSuites < numberOfSuites  )
        {
            availableSuites--;
            bookedSuites++;
            return true;
        }
        if(bookedSuites == numberOfSuites && bookedRooms< numberOfRooms) {

            availableRooms--;
            bookedRooms++;
            return true;
        }
        return false;
    }
}
