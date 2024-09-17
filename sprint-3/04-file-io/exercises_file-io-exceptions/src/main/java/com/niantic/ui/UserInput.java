package com.niantic.ui;

import com.niantic.models.Assignment;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class UserInput
{
    protected static Scanner in = new Scanner(System.in);

    public static int homeScreenSelection()
    {
        System.out.println();
        System.out.println("What do you want to do?");
        System.out.println("-".repeat(30));
        System.out.println();
        System.out.println("  1) Display files");
        System.out.println();
        System.out.println("  ------------ Individual File ------------");
        System.out.println("  2) Student: display all scores");
        System.out.println("  3) Student: display average score");
        System.out.println();
        System.out.println("  ---------- Challenge All Files ----------");
        System.out.println("  5) All Students: display average score");
        System.out.println("  6) All Assignments: display average score");
        System.out.println();
        System.out.println("  0) Exit");

        System.out.println();
        System.out.print("Please make a selection: ");

        return Integer.parseInt(in.nextLine());
    }

    public static void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
    }

    public static void continueMessage()
    {
        System.out.println();
        System.out.println("Press ENTER to continue");
        in.nextLine();
    }

    public static int chooseFile()
    {
        System.out.println();
        System.out.println("Please choose the number of the file you want to work with: ");
        var choice = Integer.parseInt(in.nextLine());

        return choice;
    }

    public static String returnToDirectory(){
        System.out.println();
        System.out.println("Press 'y' to return to files menu");
        System.out.println("Press 'n' to return to home");

        return in.nextLine();
    }

    public static void displayAllFiles(String[] files, AtomicInteger counter){
        System.out.println();
        System.out.println("File Names: ");
        System.out.println("-".repeat(30));
        Arrays.stream(files)
                .sorted()
                .forEach(file -> {
                    System.out.println(counter.getAndIncrement() + ". " + file);
                });
    }

    public static void displayChoice(String fileName, List<Assignment> fileAssignments){
        System.out.println("-".repeat(45));
        System.out.println();
        System.out.println("You Selected: " + fileName);
        System.out.println();
        System.out.println("Assignments for : " + fileAssignments.getFirst().getFirstName().toUpperCase() + " " + fileAssignments.getLast().getLastName().toUpperCase()); //debug
        System.out.println();
        System.out.println("-".repeat(45));

    }
}
