package com.niantic.services;

import com.niantic.models.AssignmentStatistics;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ReportsService {

    public void createStudentSummaryReport(AssignmentStatistics statistics){
        LocalDate today = LocalDate.now(); //get today's date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //format template. File name doesn't need timestamp
        String fileName = "reports/" + today.format(formatter) + "_" + statistics.getStudentName().replace(" ", "_");

        File file = new File(fileName);

        try(PrintWriter write = new PrintWriter(file))
        {
            write.println(statistics.getStudentName().toUpperCase());
            write.println("-".repeat(45));
            write.println("Low Score:        %d\n" + statistics.getLowestScore());
            write.println("High Score:       %d\n" + statistics.getHighestScore());
            write.println("Average Score:    %d\n" + statistics.getAvgScore());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

}
