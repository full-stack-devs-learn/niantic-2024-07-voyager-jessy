package com.niantic.services;

import com.niantic.models.Assignment;

import java.io.File;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradesFileService implements GradesService
{

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
    public List<Assignment> getAssignments(String fileName)
    {
        File file = new File("files/" + fileName);

        List<Assignment> assignments = new ArrayList<>();

        try(Scanner reader = new Scanner(file))
        {
            reader.nextLine();
            while(reader.hasNextLine())
            {
                var line = reader.nextLine();
                var columns = line.split(",");

                int assignmentNumber = Integer.parseInt(columns[0]);
                String firstName = columns[1];
                String lastName = columns[2];
                String assignmentName = columns[3];
                int score = Integer.parseInt(columns[4]);

                var assignment = new Assignment(assignmentNumber, firstName, lastName, assignmentName, score);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return assignments;
    }

    @Override
    public List<Assignment> getAllAssignments(String[] fileNames)
    {
        List<Assignment> allAssignments = new ArrayList<>();

        File directory = new File("files");
        String [] files = directory.list();

        for(String file : files){
            allAssignments.addAll(getAssignments(file));
        }

        return allAssignments;
    }
}
