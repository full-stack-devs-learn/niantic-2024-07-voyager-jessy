package com.niantic.application;

import com.niantic.models.Assignment;
import com.niantic.services.GradesFileService;
import com.niantic.services.GradesService;
import com.niantic.ui.UserInput;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class GradingApplication implements Runnable
{
    private GradesService gradesService = new GradesFileService();

    public void run()
    {
        while(true)
        {
            int choice = UserInput.homeScreenSelection();
            switch(choice)
            {
                case 1:
                    displayAllFiles();
                    UserInput.continueMessage();
                    break;
                case 2:
                    displayFileScores();
                    UserInput.returnToDirectory();
                    displayFileScores();
                    break;
                case 3:
                    displayStudentAverages();
                    break;
                case 4:
                    displayAllStudentStatistics();
                    break;
                case 5:
                    displayAssignmentStatistics();
                    break;
                case 0:
                    UserInput.displayMessage("Goodbye");
                    System.exit(0);
                default:
                    UserInput.displayMessage("Please make a valid selection");
            }
        }
    }

    private void displayAllFiles()
    {
        // todo: 1 - get and display all student file names
        String[] files =  gradesService.getFileNames();
        AtomicInteger counter = new AtomicInteger(1);

        System.out.println();
        System.out.println("File Names: ");
        System.out.println("-".repeat(30));
        Arrays.stream(files)
                .sorted()
                .forEach(file ->{
                System.out.println(counter.getAndIncrement() + ". " + file);
                });

    }

    private void displayFileScores()
    {
        // todo: 2 - allow the user to select a file name
        // load all student assignment scores from the file - display all files
        displayAllFiles();
        System.out.println("-".repeat(30));

        int choice = UserInput.chooseFile();
        String[] files =  gradesService.getFileNames();
        Arrays.sort(files);

        if(choice > 0 && choice <= files.length){
            var choiceFile = files[choice - 1];
            System.out.println("User Selected: " + choiceFile);//debug
            System.out.println();
            var showFile = gradesService.getAssignments(choiceFile);
            System.out.println("Assignments for : " + showFile.getFirst().getFirstName().toUpperCase() + " " + showFile.getLast().getLastName().toUpperCase()); //debug
            showFile.forEach(assignment -> {
                System.out.println(assignment);
            });
//            System.out.println(showFile);
        }



//        switch(choice)
//        {
//            case 1:
//                List<Assignment> assignments =  gradesService.getAssignments("files/student_1_anna_williams.csv");
//                System.out.println(assignments);
//                System.out.println("-".repeat(30));
//                UserInput.returnToDirectory();
//                break;
//        }


//        List<Assignment> assignments = gradesService.getAssignments(fileName);
    }

    private void displayStudentAverages()
    {
        // todo: 3 - allow the user to select a file name
        // load all student assignment scores from the file - display student statistics (low score, high score, average score)

    }

    private void displayAllStudentStatistics()
    {
        // todo: 4 - Optional / Challenge - load all scores from all student and all assignments
        // display the statistics for all scores (low score, high score, average score, number of students, number of assignments)
    }

    private void displayAssignmentStatistics()
    {
        // todo: 5 - Optional / Challenge - load all scores from all student and all assignments
        // display the statistics for each assignment (assignment name, low score, high score, average score)
        // this one could take some time
    }

    private String parseStudentName(String fileName)
    {
        return fileName.replace(".csv", "")
                        .replace("_", " ")
                        .substring(10);
    }
}
