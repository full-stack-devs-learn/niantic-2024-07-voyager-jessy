package com.niantic.models;

import java.util.List;

public class ReportsStatistics {


    private List<Integer> allScores;
    AssignmentStatistics statistics;

    public ReportsStatistics(List<Integer> allScores) {
        this.allScores = allScores;
    }

    public List<Integer> getAllScores() {
        return allScores;
    }

    public int getOverallLowest(){

         return allScores.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElseThrow(() -> new IllegalArgumentException("No files found"));
    }
    public int getOverallHighest(){

        return allScores.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("No files found"));
    }
    public double getOverallAverage(){

        return allScores.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("No files found"));
    }
}
