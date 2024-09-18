package com.niantic.services;

import com.niantic.models.Assignment;
import com.niantic.ui.UserInput;

import java.io.File;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GradesFileService implements GradesService {

    @Override
    public String[] getFileNames() {
        File directory = new File("files");
        String[] files = null;


        if (directory.exists() && directory.isDirectory()) {
            files = directory.list();
        }

        return files;
    }

    @Override
    public List<Assignment> getAssignments(String fileName) {
        List<Assignment> assignments = new ArrayList<>();
        File file = new File("files/" + fileName);

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

                    var assignment = new Assignment(assignmentNumber, firstName, lastName, assignmentName, score);
                    assignments.add(assignment);
                } else {
                    System.out.println("Invalid Line Format: " + line); //debug
                }
            }
        } catch (Exception e) {
            System.out.println("Error Reading file: " + e.getMessage());
        }

        return assignments;
    }

    @Override
    public List<Assignment> getAllAssignments(String[] fileNames) {
        List<Assignment> allAssignments = new ArrayList<>();

        File directory = new File("files");
        String[] files = directory.list();
//        List<String> files = List.of(directory.list());

        assert files != null;
        for (String file : files) {
            allAssignments.addAll(getAssignments(file));
        }

        return allAssignments;
    }

    @Override
    public List<String> getAllFiles() {
        File directory = new File("files");
        String[] files = directory.list();

        return Arrays.stream(files).sorted().toList();
    }


}
