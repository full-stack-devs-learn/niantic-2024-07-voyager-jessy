package com.niantic.application;

import com.niantic.models.Assignment;
import com.niantic.services.GradesFileService;
import com.niantic.services.GradesService;
import com.niantic.ui.UserInput;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class GradingApplication implements Runnable {
    private GradesService gradesService = new GradesFileService();
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
        String[] files = gradesService.getFileNames();
        AtomicInteger counter = new AtomicInteger(1);

        UserInput.displayAllFiles(files, counter);

//        System.out.println();
//        System.out.println("File Names: ");
//        System.out.println("-".repeat(30));
//        Arrays.stream(files)
//                .sorted()
//                .forEach(file -> {
//                    System.out.println(counter.getAndIncrement() + ". " + file);
//                });

    }

    private void displayFileScores() {
        // todo: 2 - allow the user to select a file name
        // load all student assignment scores from the file - display all files
//        boolean viewing = true;

        while (viewing) {
            displayAllFiles();
            System.out.println("-".repeat(30));

            int choice = UserInput.chooseFile();
            String[] files = gradesService.getFileNames();
            Arrays.sort(files);

            if (choice > 0 && choice <= files.length) {
                var choiceFile = files[choice - 1];
//                System.out.println("User Selected: " + choiceFile);
//                System.out.println();
                var showFile = gradesService.getAssignments(choiceFile);
//                System.out.println("Assignments for : " + showFile.getFirst().getFirstName().toUpperCase() + " " + showFile.getLast().getLastName().toUpperCase()); //debug
                UserInput.displayChoice(choiceFile, showFile);
                showFile.forEach(assignment -> {
                    System.out.println(assignment);
                });
                System.out.println("-".repeat(30));

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
//        while (viewing) {
            displayAllFiles();
//            System.out.println("-".repeat(30));

            int choice = UserInput.chooseFile();
            String[] files = gradesService.getFileNames();
            Arrays.sort(files);
            if (choice > 0 && choice <= files.length) {
                var choiceFile = files[choice - 1];
//                System.out.println("User Selected: " + choiceFile);
//                System.out.println();
                var showFile = gradesService.getAssignments(choiceFile);
//                System.out.println("Assignments for : " + showFile.getFirst().getFirstName().toUpperCase() + " " + showFile.getLast().getLastName().toUpperCase()); //debug
                UserInput.displayChoice(choiceFile, showFile);
                File file = new File("files/" + choiceFile);

                try (Scanner reader = new Scanner(file)) {
                    reader.nextLine();
                    while (reader.hasNextLine()) {
                        var line = reader.nextLine();
                        var columns = line.split(",");
                        if (columns.length == 5) {
                            int assignmentNumber = Integer.parseInt(columns[0]);
                            String firstName = columns[1];
                            String lastName = columns[2];
                            String assignmentName = columns[3];
                            int score = Integer.parseInt(columns[4]);

                            studentAllScores.add(score);
                        } else {
                            System.out.println("Invalid Line Format: " + line); //debug
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error Reading file: " + e.getMessage());
                }
                //math: min,max, avg score
                var min = studentAllScores.stream().min((s1, s2) -> s1.compareTo(s2));
                var max = studentAllScores.stream().max((s1, s2) -> s1.compareTo(s2));
                var totalScore = studentAllScores.stream().mapToInt(Integer::intValue).reduce(0, (num1, num2) -> num1 + num2);
                var avg = totalScore / studentAllScores.size();

                System.out.println("-".repeat(30));
                System.out.println("Assignment lowest score: " + min);
                System.out.println("-".repeat(30));
                System.out.println("Assignment highest score: " + max);
                System.out.println("-".repeat(30));
                System.out.println("Avg Assignment Score: " + avg);
                System.out.println();
                System.out.println("-".repeat(30));

                String userResponse = UserInput.returnToDirectory();

//                if (userResponse.equalsIgnoreCase("n")) {
//                    viewing = false;
//                }
            }

//        }



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

    private String parseStudentName(String fileName) {
        return fileName.replace(".csv", "")
                .replace("_", " ")
                .substring(10);
    }
}
