package com.niantic.exercises;

import com.niantic.models.TestScore;

import java.util.ArrayList;

public class TestScores
{

    /*
    1.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores and the name of a test - return all scores for the
        requested tests.
     */
    public ArrayList<TestScore> getScoresByTest(ArrayList<TestScore> testScores, String testName)
    {
        ArrayList<TestScore> scoresByTest = new ArrayList<>();
        for(int i=0 ; i< testScores.size(); i++)
            if(testScores.get(i).getTestName().equals(testName))
            {
                scoresByTest.add(testScores.get(i));
            }

        return scoresByTest;
    }

    /*
    2.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores and the name of a student - return all scores for the
        requested student.
     */
    public ArrayList<TestScore> getScoresByStudent(ArrayList<TestScore> testScores, String student)
    {
        ArrayList<TestScore> scoreByStudent = new ArrayList<>();
        for(int i = 0; i< testScores.size(); i++)
        {
            if(testScores.get(i).getStudentName().equals(student))
            {
                scoreByStudent.add(testScores.get(i));
            }
        }

        return scoreByStudent;
    }

    /*
    3.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the highest score.
     */
    public int getHighestScore(ArrayList<TestScore> testScores)
    {
        int highestScore = 0;
        for(int i=0; i<testScores.size(); i++)
        {
            if(testScores.get(i).getScore() > highestScore)
            {
                highestScore = testScores.get(i).getScore();
            }
        }
        return highestScore;
    }

    /*
    4.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score.
     */
    public int getLowestScore(ArrayList<TestScore> testScores)
    {
        int lowestScore = testScores.get(0).getScore();
        for(int i = 0; i < testScores.size(); i++)
        {
            if(testScores.get(i).getScore() < lowestScore)
            {
                lowestScore = testScores.get(i).getScore();
            }
        }
        return lowestScore;
    }

    /*
    5.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score.
     */
    public int getAverageScore(ArrayList<TestScore> testScores)
    {
        int sum = 0;
        for(var test : testScores) // after : it needs to reference a list, no .gets are allowed here
        {
            sum += test.getScore();
        }
        int avg = sum/testScores.size();
//        i understand for(i) loops... i need to start practicing for each loops ^^
//        int sum = 0;
//        for(int i = 0 ; i < testScores.size() ; i++)
//            {
//                sum += testScores.get(i).getScore();
//            }
//        int avg = sum/testScores.size();


        return avg;
    }

    /*
    6.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the highest score for the specified test name.
     */
    public int getHighestScoreByTest(ArrayList<TestScore> testScores, String testName)
    {
        int highestScoreByTest = 0;
        for(int i = 0; i < testScores.size(); i++)
        {
            if(testScores.get(i).getTestName().equals(testName) && testScores.get(i).getScore()> highestScoreByTest)
            {
                highestScoreByTest = testScores.get(i).getScore();
            }
        }

        return highestScoreByTest;
    }

    /*
    7.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score for the specified test name.
     */
    public int getLowestScoreByTest(ArrayList<TestScore> testScores, String testName)
    {
        int lowestScore = testScores.get(0).getScore();
        for(int i = 1; i< testScores.size(); i++)
        {
            if( testScores.get(i).getTestName().equals(testName))
            {
                if(testScores.get(i).getScore() < lowestScore)
                {
                    lowestScore = testScores.get(i).getScore();
                }
            }
        }
        return lowestScore;
    }

    /*
    8.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the average score for the specified test name.
     */
    public int getAverageScoreByTest(ArrayList<TestScore> testScores, String testName)
    {
        ArrayList<Integer> scoresByTestName = new ArrayList<>();
        int sumByTest = 0;
        for(var test : testScores)
        {
            if(test.getTestName().equals(testName))
            {
                sumByTest += test.getScore();
                scoresByTestName.add(test.getScore());
            }
        }
        int avgByTest = sumByTest / scoresByTestName.size();


//        for(int i = 0; i < testScores.size(); i++)
//        {
//            if(testScores.get(i).getTestName().equals(testName))
//            {
//                sumByTest += testScores.get(i).getScore();
//            }
//        }
//        int avgByTest = sumByTest / testScores.size();

        return avgByTest;
    }

    /*
    9.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the highest score for the specified student.
     */
    public int getHighestScoreByStudent(ArrayList<TestScore> testScores, String student)
    {
        int studentHighScore = 0;
        for(int i = 0; i < testScores.size(); i++)
        {
            if(testScores.get(i).getStudentName().equals(student))
            {
                if (testScores.get(i).getScore() > studentHighScore)
                {
                    studentHighScore = testScores.get(i).getScore();
                }

            }
        }
        return studentHighScore;
    }

    /*
    10.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score for the specified student.
     */
    public int getLowestScoreByStudent(ArrayList<TestScore> testScores, String student)
    {
        int studentLowScore = testScores.get(0).getScore();
        for(int i = 0; i < testScores.size(); i++)
        {
            if(testScores.get(i).getStudentName().equals(student))
            {
                if (testScores.get(i).getScore() < studentLowScore)
                {
                    studentLowScore = testScores.get(i).getScore();
                }

            }
        }

        return studentLowScore;
    }

    /*
    11.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the average score for the specified student.
     */
    public int getAverageScoreByStudent(ArrayList<TestScore> testScores, String student)
    {
        ArrayList<Integer> student1Tests = new ArrayList<>();
        int sumPerStudent= 0;
        for( var test: testScores)
        {
            if(test.getStudentName().equals(student))
            {
                sumPerStudent += test.getScore();
                student1Tests.add(test.getScore());
            }
        }
        int avgPerStudent = sumPerStudent/student1Tests.size();
//
        //here are two ways of solving this. for practice I have completed both a for:each loop and for:i loop to accomplish the task
//        for(int i = 0; i < testScores.size(); i++)
//        {
//            if(testScores.get(i).getStudentName().equals(student))
//            {
//                sumPerStudent += testScores.get(i).getScore();
//                student1Tests.add(testScores.get(i).getScore());
//            }
//        }
//        int avgPerStudent = sumPerStudent /student1Tests.size()  ; // how do i get the number of tests per student?;
        return avgPerStudent;
    }
}
