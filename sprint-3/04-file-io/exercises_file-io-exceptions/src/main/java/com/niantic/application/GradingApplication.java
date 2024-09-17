package com.niantic.application;

import com.niantic.models.Assignment;
import com.niantic.models.AssignmentStatistics;
import com.niantic.services.GradesFileService;
import com.niantic.services.GradesService;
import com.niantic.ui.UserInput;


import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class GradingApplication implements Runnable {
    private GradesService gradesServices = new GradesFileService();
    private List<Integer> studentAllScores = new ArrayList<>();
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

//                File file = new File("files/" + choiceFile);
//
//                try (Scanner reader = new Scanner(file)) {
//                    reader.nextLine();
//                    while (reader.hasNextLine()) {
//                        var line = reader.nextLine();
//                        var columns = line.split(",");
//                        if (columns.length == 5) {
//                            int assignmentNumber = Integer.parseInt(columns[0]);
//                            String firstName = columns[1];
//                            String lastName = columns[2];
//                            String assignmentName = columns[3];
//                            int score = Integer.parseInt(columns[4]);
//
//                            studentAllScores.add(score);
//                        } else {
//                            UserInput.displayMessage("Invalid Line Format: " + line); //debug
//                        }
//                    }
//                } catch (Exception e) {
//                    System.out.println("Error Reading file: " + e.getMessage());
//                }
                //math: min,max, avg score
//                if(!studentAllScores.isEmpty()) {
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
                if (userResponse.equalsIgnoreCase("n")) {
                    viewing = false;
                }
                else {
                    UserInput.displayMessage("No valid scores were found");
                }
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

    private void createStudentSummaryReport(){
        displayAllFiles();
        int choice = UserInput.chooseFile() - 1;

        var files = gradesServices.getAllFiles();


        String fileName = files.get(choice);
        var studentName = parseStudentName(fileName);

        List<Assignment> assignments = gradesServices.getAssignments(fileName);


//        List<Assignment> scores = assignments.stream()
//                .filter(assignment -> assignment.getScore() > 0)
//                .collect(Collectors.toList());
//

//        AssignmentStatistics statistics = new AssignmentStatistics(studentName, )





    }

    private String parseStudentName(String fileName) {
        return fileName.replace(".csv", "")
                .replace("_", " ")
                .substring(10);
    }
}
