package com.niantic.models;

import java.util.List;

public class AssignmentStatistics {

    private List<Integer> studentAllScores;
    private String studentName;

    public AssignmentStatistics(String studentName, List<Integer> studentAllScores) {
        this.studentName = studentName;
        this.studentAllScores = studentAllScores;
    }

    public String getStudentName() {
        return studentName;
    }

    public List<Integer> getStudentAllScores() {
        return studentAllScores;
    }

    public int getLowestScore(){
        return studentAllScores.stream().mapToInt(Integer::intValue).min().getAsInt();
    }

    public int getHighestScore(){
        return studentAllScores.stream().mapToInt(Integer::intValue).max().getAsInt();
    }

    public int getAvgScore(){
    var totalScore = studentAllScores.stream().mapToInt(Integer::intValue).reduce(0, Integer::sum);

        return totalScore/studentAllScores.size();
    }
}
