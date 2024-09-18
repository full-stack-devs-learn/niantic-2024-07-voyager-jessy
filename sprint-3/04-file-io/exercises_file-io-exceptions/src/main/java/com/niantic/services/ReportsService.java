package com.niantic.services;

import com.niantic.models.Assignment;
import com.niantic.models.AssignmentStatistics;
import com.niantic.models.ReportsStatistics;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ReportsService {

    private GradesFileService gradesService;

    public ReportsService(GradesFileService gradesService) {
        this.gradesService = gradesService;
    }

    public void ensureDirectoryExists(String pathName)
    {
        File directory = new File(pathName);
        if(!directory.exists())
        {
            directory.mkdir();
        }
    }

    public void createStudentSummaryReport(AssignmentStatistics statistics){
        LocalDate today = LocalDate.now(); //get today's date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //format template. File name doesn't need timestamp

        ensureDirectoryExists("reports");

        String fileName = "reports/" + today.format(formatter) + "_" + statistics.getStudentName().replace(" ", "_") + ".txt";

        File file = new File(fileName);

        try(PrintWriter write = new PrintWriter(file))
        {
            write.println(statistics.getStudentName().toUpperCase());
            write.println("-".repeat(45));
            write.printf("Low Score:             %d\n", statistics.getLowestScore());
            write.printf("High Score:            %d\n", statistics.getHighestScore());
            write.printf("Average Score:         %d\n", statistics.getAvgScore());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }


    public void createAllStudentsReport(GradesFileService service, ReportsStatistics statistics) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        ensureDirectoryExists("reports");

        String fileName = "reports/" + today.format(formatter) + "_all_students.txt";

        File file = new File(fileName);

        try (PrintWriter write = new PrintWriter(file)) {
            write.println("All Assignments");
            write.println("-".repeat(45));
            write.printf("Total Students               %d\n", service.getAllFiles().size());
            write.printf("Total Assignments            %d\n", service.getAssignments("student_1_anna_williams.csv").size());
            write.println("-".repeat(45));
            write.printf("Lowest Score                 %d\n", statistics.getOverallLowest());
            write.printf("Highest Score                %d\n", statistics.getOverallHighest());
            write.printf("Average Score                %.2f\n", statistics.getOverallAverage());


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

        public List<Integer> allScores(String[] files){
        List<Integer> allScores = new ArrayList<>();

        for(String file: files)
        {
            List<Assignment> assignments = gradesService.getAllAssignments(files);
            for(Assignment assignment: assignments)
            {
                allScores.add(assignment.getScore());
            }

        }
        return allScores;
    }



}
