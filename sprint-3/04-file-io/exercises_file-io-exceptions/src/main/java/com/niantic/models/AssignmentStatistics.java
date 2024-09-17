package com.niantic.models;

import java.util.List;

public class AssignmentStatistics {

    private List<Assignment> studentScores;
    private String studentName;

    public AssignmentStatistics(String studentName, List<Assignment> studentScores) {
        this.studentName = studentName;
        this.studentScores = studentScores;
    }

    public String getStudentName() {
        return studentName;
    }

    public List<Assignment> getStudentScores() {
        return studentScores;
    }

    public int getLowestScore(){
//        return studentScores.stream().mapToInt(Integer::intValue).min().getAsInt();
        return studentScores.stream()
                .mapToInt(Assignment::getScore)
                .min()
                .orElseThrow(() -> new IllegalArgumentException("No Scores Found"));
    }


    public int getHighestScore(){
//        return studentAllScores.stream().mapToInt(Integer::intValue).max().getAsInt();
        return studentScores.stream()
                .mapToInt(Assignment::getScore)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("No Scores Found"));
    }

    public int getAvgScore(){
    var totalScore = studentScores.stream().mapToInt(Assignment::getScore).reduce(0, Integer::sum);

        return totalScore/studentScores.size();
    }
}
