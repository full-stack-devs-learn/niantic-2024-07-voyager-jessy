package com.niantic.part_2_objects;

public class MathTest
{
    private int score;
    private int possiblePoints;
    private String studentName;

// parameterless constructor is not required for this exercise
    public MathTest(int possiblePoints, String studentName)
    {
        this.possiblePoints = possiblePoints;
        this.studentName = studentName;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public int getPossiblePoints()
    {
        return possiblePoints;
    }

    public String getStudentName()
    {
        return studentName;
    }
    public int getPercent()
    {
        return score % possiblePoints;
    }

    public String getLetterGrade()
    {
        if((getPercent()) >= 90)
        {
            return "A";}
        if (getPercent() >= 80 && (getPercent()<=89))
        {
            return "B";
        }
        if(getPercent() >= 70 && (getPercent() <= 79))
        {
            return "C";
        }
        if(getPercent() >= 60 && (getPercent() <= 69))
        {
            return "D";
        }
        else{
            return "F";
        }

    }



}
