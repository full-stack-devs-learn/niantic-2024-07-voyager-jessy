package com.nianatic;

import javax.swing.*;
import java.security.cert.TrustAnchor;
import java.util.*;

public class Exercises
{
    /*
     * 1)
     * Return an array of 7 strings with the
     * names of the days of the week
     *
     * [Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday]
     */
    public String[] daysOfTheWeek()
    {
        String[] daysOfTheWeek = new String[] {"Sunday","Monday", "Tuesday", "Wednesday", "Thursday","Friday","Saturday"};

        return daysOfTheWeek;
    }


    /*
     * 2)
     * Return an array of 12 strings with the
     * names of the months of the year
     *
     * [January, February, March, April, May, June, July, August, September, October, November, December]
     */
    public String[] monthsOfTheYear()
    {
        String[] monthsOfTheYear;
        monthsOfTheYear = new String[] {"January" , "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        return monthsOfTheYear;
    }

    /*
     * 3)
     * Return an array of 50 numbers from 1 to 50
     * (this will be best done with a loop)
     *
     * The first number of the array must be 1
     * The last number of the array must be 50
     *
     * [1, 2, 3, ... 50]
     */
    public int[] oneToFifty()
    {
        int[] oneToFifty;
        oneToFifty = new int[50];

        //find numbers starting from 1 to 50 to list within the array with the set length of 50
        for (int i = 0; i< oneToFifty.length; i++)
        {
            //the values found are added into the array in order from place value 0 - 49 to complete array length of 50
            oneToFifty[i] = i +1;
        }

        return oneToFifty;
    }

    /*
     * 4)
     * Return an array of 100 that includes
     * only the even numbers from 1 to 200
     *
     * The first number of the array must be 2
     * The last number of the array must be 200
     *
     * [2, 4, 6, ... 200]
     */
    public static int [] evenNumbers() {


        int[] evenNumbers = new int[100];//cr8 array variable that notates we will have 100 variables withing the array
        int index = 0; // cr8 index variable to dictate place value within array. 0 is the first value


        for (int i = 2; i <= 200; i++) //create for loop to pull numbers starting from 2 and ending in 200 in order
        {
            if(i%2 == 0) //only adding even numbers (this LITERALLY means if num / 2 has no remainders (ie. even))
            {
                evenNumbers[index]= i;  //add those found values into array starting at the 1st place value (0 because arrays start with 0 duh)
                index++; //continue on within array until length of 100 is filled

            }

        }

        return evenNumbers; // return your new even array =]
    }

    /*
     * 5)
     * This function accepts an array of strings
     * that represents all of the days of the week.
     *
     * You need to return the name of the FIRST
     * day of the week.
     *
     * The week might begin with a different day.
     * I.e. the full week begins on Sunday
     *      but the work week begins on Monday
     *
     * Example Expectations:
     * Input                                                                               Output
     * firstDayOfWeek([Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday]) => Sunday
     * firstDayOfWeek([Monday, Tuesday, Wednesday, Thursday, Friday])                   => Monday
     */
    public String firstDayOfWeek(String[] daysOfTheWeek)
    {

        return daysOfTheWeek[0];
    }

    /*
     * 6)
     * This function accepts an array of strings
     * that represents all of the days of the week.
     *
     * You need to return the name of the LAST
     * day of the week.
     *
     * The week might begin with a different day.
     * I.e. the full week begins on Sunday
     *      but the work week begins on Monday
     *
     * Example Expectations:
     * Input                                                                              Output
     * lastDayOfWeek([Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday]) => Saturday
     * lastDayOfWeek([Monday, Tuesday, Wednesday, Thursday, Friday])                   => Friday
     */
    public String lastDayOfWeek(String[] daysOfTheWeek)
    {
        //there are two ways of doing this, 1: simply return the array, specifying last element by array[array.length - 1]
        //OR 2: is as follows: create a new value that holds the specific value of that array element.
        //String lastDayofWeek = daysOfTheWeek[daysOfTheWeek.length - 1]; and then return lastDayofWeek

        return daysOfTheWeek[daysOfTheWeek.length - 1] ;
    }

    /*
     * 7)
     * This function accepts 2 input parameters.
     * 1 - an array of strings (month names)
     * 2 - the number of the month of the year
     *
     * You need to return the name of the month
     * that corresponds with the number.
     *
     * Example Expectations:
     * Input                                                                          Output
     * monthName([Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec], 2)  => Feb
     * monthName([Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec], 8)  => Aug
     */
    public String monthName(String[] months, int monthNumber)
    {

        return months[monthNumber - 1];
    }

    /*
     * 8)
     * This function accepts 2 input parameters.
     * 1 - an array of names
     * 2 - a name to search for in the array
     *
     * Return true if the name is in the list,
     * and false if it does not.
     *
     * The search should not be case sensitive.
     *
     * Example Expectations:
     * Input                                                      Output
     * hasName(["Ron", "Lisa", "Kent", "Michelle"], "Kent")   =>  true
     * hasName(["Ron", "Lisa", "Kent", "Michelle"], "kent")   =>  true
     * hasName(["Ron", "Lisa", "Kent", "Michelle"], "Jenny")  =>  false
     */
    public boolean hasName(String[] names, String nameToFind)
    {
        boolean trueOrFalse = true;
        for(int i=0; i <names.length; i++)
        {
            if(names[i] == nameToFind)
                {trueOrFalse = true;}

            else
                { trueOrFalse = false;}
        }


        return trueOrFalse;

    }

    /*
     * 9)
     * This function accepts 2 input parameters.
     * 1 - an array of names
     * 2 - a name to search for in the array
     *
     * Return a count of how many times the name is found in the list.
     *
     * The search should not be case sensitive.
     *
     * Example Expectations:
     * Input                                                                  Output
     * countName(["Ron", "Michelle", "Lisa", "Kent", "Michelle"], "Ron")    =>  1
     * countName(["Ron", "Michelle", "Lisa", "Kent", "Michelle"], "kent")   =>  2
     * countName(["Ron", "Michelle", "Lisa", "Kent", "Michelle"], "Jenny")  =>  0
     */
    public int countName(String[] names, String nameToFind)
    {
        int count = 0;
        for (int i = 0; i <names.length; i++)
        {
            if(names[i] == namesToFind)
            {
                count++;
            }
        }
        return count;
    }

    /*
     * 10)
     * Given an array of integers. Add all
     * numbers in the array and return the value.
     *
     * sumNumbers([1,2,3,4])    =>  10
     * sumNumbers([1,3,5])      =>  9
     * sumNumbers([1,1,2,3])    =>  7
     */
    public int sumNumbers(int[] numbers)
    {
        int sum = 0;
        for(int value : numbers)
        {
            sum += value;
        }
        return sum;
    }

    /*
     * 11)
     * Given an array of integers. Add all EVEN
     * numbers in the array and double it.
     *
     * Return the answer.
     *
     * doubleEvens([1,2,3,4])  => 2 + 4 => 6 * 2   =>  12
     * doubleEvens([10,11,13]) => 10 * 2           =>  20
     */
    public int doubleEvens(int[] numbers)
    {
        int sum = 0; // always declare aggregate
        for(int value : numbers)
        {
            if(value % 2 == 0)
            {
                sum += value;
            }
        }

        return sum *2 ;
    }

    /*
     * 12)
     * Given an array of integers. Add the
     * value of every third number in the
     * array and return the answer.
     *
     * sumEveryThird([1,2,3,4]) => 1 + 4                =>  5
     * sumEveryThird([1,3,5])                           =>  1
     * sumEveryThird([1,1,2,3,5,8,13]) => 1 + 3 + 13    =>  17
     */
    public int sumEveryThird(int[] numbers)
    {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if( i % 3 == 0)
            sum += numbers[i];
            ;
        }
        return sum;
    }

    /*
     * 13)
     * Given an array of prices, calculate
     * the average price.
     *
     * averagePrice([12.75, 10.25, 8.44, 9.2]) => sum / 4   =>  12.66
     * averagePrice([15.25, 2.34, 3.5])        => sum / 3   =>  7.03
     */
    public double averagePrice(double[] prices)
    {   double sum = 0;
        for(double price:prices){
            sum += price;
        }


        return sum/prices.length;
    }

    /*
     * 14)
     * Given an array of prices, return the
     * highest price.
     *
     * highestPrice([12.75, 10.25, 8.44, 9.2])   =>  12.75
     * highestPrice([15.25, 21.34, 3.5])         =>  21.34
     */
    public double highestValue(double[] prices)
    {
        double max = prices[0];

        for(int i = 1; i< prices.length; i++)
        {
            if(prices[i] > max) //i has the element currently in space 1 of array [10.25] and if that is greater than the current max (12.75
            {
                max = prices[i]; // then that element becomes the new value of max


            }
        }
        return max;

// THIS IS NOT WORKING AND I THINK IT HAS TO DO WITH THE DATA TYPE.. BUT THERE ARE DECIMAL POINTS AND IF I CONVERT TO INT IT WILL ROUND AND I DONT WANT THAT TO HAPPEN


    }

    /*
     * 15)
     * Given an array of prices, return the
     * lowest price.
     *
     * lowestPrice([-15.25, 15.25, 2.34, 3.50])                        =>  2.34
     * lowestPrice([12.75, -5.5, 10.25, 18.44, 4.23, -15.55, 9.20])    =>  -15.55
     */
    public double lowestValue(double[] prices)
    {

        double min = prices[0]; // make a variable that will be the placeholder for the lowest price throughout my loop, starting at Array[0]
        for(int i = 1; i< prices.length; i++) //for-i loop that starts with Array[1], goes through all elements in array until the end one by one.
        {
            if(min > prices[i]) //if the price at min is greater than the value held at current place holder in prices array,
            {
                min = prices[i];// min becomes that new, lower, value
            }
        }

        return min;
    }

}
