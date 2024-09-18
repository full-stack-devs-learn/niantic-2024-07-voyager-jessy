package com.niantic.application;

import com.niantic.models.Assignment;
import com.niantic.models.AssignmentStatistics;
import com.niantic.models.ReportsStatistics;
import com.niantic.services.GradesFileService;
import com.niantic.services.GradesService;
import com.niantic.services.LoggingService;
import com.niantic.services.ReportsService;
import com.niantic.ui.UserInput;


import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class GradingApplication implements Runnable {
    private GradesService gradesServices = new GradesFileService();
    private List<Integer> studentAllScores = new ArrayList<>();

    private final LoggingService appLog = new LoggingService("application");

    private boolean viewing = true;

    public void run() {
        while (true) {
            int choice = UserInput.homeScreenSelection();
            switch (choice) {
                case 1:
                    displayAllFiles();
                    UserInput.continueMessage();
                    break;
                case 2:
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
                case 6:
                    createStudentSummaryReport();
                    break;
                case 7:
                    createAllStudentsReport();
                    break;

                case 0:
                    UserInput.displayMessage("Goodbye");
                    System.exit(0);
                default:
                    UserInput.displayMessage("Please make a valid selection");
            }
        }
    }

    private void displayAllFiles() {
        // todo: 1 - get and display all student file names

        String[] files = gradesServices.getFileNames();
//        var files = gradesServices.getFileNames(); // would like to make this work for indexing
        AtomicInteger counter = new AtomicInteger(1);

        UserInput.displayAllFiles(files, counter);
    }

    private void displayFileScores() {
        // todo: 2 - allow the user to select a file name
        // load all student assignment scores from the file - display all files

        while (viewing) {
            displayAllFiles();

            int choice = UserInput.chooseFile();
            String[] files = gradesServices.getFileNames();
            Arrays.sort(files);

            if (choice > 0 && choice <= files.length) {
                var choiceFile = files[choice - 1];
                var showFile = gradesServices.getAssignments(choiceFile);
                UserInput.displayChoice(choiceFile, showFile);
                UserInput.displayChoiceAssignments(showFile);

                String userResponse = UserInput.returnToDirectory();

                if (userResponse.equalsIgnoreCase("n")) {
                    viewing = false;
                }
            } else {
                System.out.println("Invalid choice. Please select a valid file.");
            }
        }
    }

    private void displayStudentAverages() {
        // todo: 3 - allow the user to select a file name
        // load all student assignment scores from the file - display student statistics (low score, high score, average score)
        while (viewing) {
            displayAllFiles();

            int choice = UserInput.chooseFile();
            String[] files = gradesServices.getFileNames();
            Arrays.sort(files);

            if (choice > 0 && choice <= files.length) {
                var choiceFile = files[choice - 1];
                var showFile = gradesServices.getAssignments(choiceFile);

                UserInput.displayChoice(choiceFile, showFile);

                String studentName = parseStudentName(choiceFile);
//                    System.out.println(studentName.toUpperCase()); // debugger is it working?

                List<Assignment> assignments = gradesServices.getAssignments(choiceFile);
                AssignmentStatistics assignmentStatistics = new AssignmentStatistics(studentName, assignments);

                int minimum = assignmentStatistics.getLowestScore();
                int maximum = assignmentStatistics.getHighestScore();
                int average = assignmentStatistics.getAvgScore();

                UserInput.displayStudentAvg(average);
                UserInput.displayStudentMin(minimum);
                UserInput.displayStudentMax(maximum);

                String userResponse = UserInput.returnToDirectory();
                isViewing(userResponse);
            } else {
                UserInput.displayMessage("No valid scores were found");
            }
        }
    }


    private void displayAllStudentStatistics() {
        // todo: 4 - Optional / Challenge - load all scores from all student and all assignments
        // display the statistics for all scores (low score, high score, average score, number of students, number of assignments)
    }

    private void displayAssignmentStatistics() {
        // todo: 5 - Optional / Challenge - load all scores from all student and all assignments
        // display the statistics for each assignment (assignment name, low score, high score, average score)
        // this one could take some time
    }

    private void createStudentSummaryReport() {
        while (viewing) {
            displayAllFiles();
            int choice = UserInput.chooseFile() - 1;

            var files = gradesServices.getAllFiles();

            String fileName = files.get(choice);
            var studentName = parseStudentName(fileName);

            List<Assignment> assignments = gradesServices.getAssignments(fileName);
            AssignmentStatistics assignmentStatistics = new AssignmentStatistics(studentName, assignments);

            ReportsService service = new ReportsService((GradesFileService) gradesServices);
            service.createStudentSummaryReport(assignmentStatistics);
            UserInput.displayMessage("Report has been created for " + studentName);

            String userResponse = UserInput.returnToDirectory();
            isViewing(userResponse);
        }

    }

    private void createAllStudentsReport() {
        while (viewing) {
            ReportsService service = new ReportsService((GradesFileService) gradesServices);

            String[] files = gradesServices.getFileNames();
            List<Integer> scores = service.allScores(files);

            ReportsStatistics reportsStatistics = new ReportsStatistics(scores);
            service.createAllStudentsReport((GradesFileService) gradesServices, reportsStatistics);
            UserInput.displayMessage("Report has been made for all students");

            UserInput.continueMessage();


        }
    }

    private String parseStudentName(String fileName) {
        return fileName.replace(".csv", "")
                .replace("_", " ")
                .substring(10);
    }

    private Boolean isViewing(String userResponse) {

        if (userResponse.equalsIgnoreCase("n")) {
            viewing = false;
            UserInput.homeScreenSelection();

        }
        return viewing;
    }

}
