package com.niantic;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {//step 3 added string[] to create list
        String[] creditCards = createCCList();
        displayOptions(creditCards);

        System.out.print()
        String[] team = getTeamMembers();
        display.Option

    }
// step 1 started here (below this comment) to define string function
    public static String[] createCCList()
    {// step 2 create string data with array elements hard coded
        String[] creditCardTypes = {"VISA","DISCOVER", "AMEX","MASTERCARD"};
        return creditCardTypes;
    }

    public static String[] getTeamMembers()
    {
        Scanner userInput = new Scanner(System.in);
        String[] teamMembers;

        System.out.print("How bid is this team?");
        int size = userInput.nextInt();
        userInput.nextLine();

        teamMembers = new String[size];

        for (int i = 0; i< size; i++);
        {
            System.out.print("Please enter name of one player" + (i+1) + ":");
            teamMembers[i] = userInput.nextLine();

        }
    return teamMembers

    }


}