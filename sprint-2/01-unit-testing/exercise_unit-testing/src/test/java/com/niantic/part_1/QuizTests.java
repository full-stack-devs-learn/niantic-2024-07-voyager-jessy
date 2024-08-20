package com.niantic.part_1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuizTests
{
    //because I have to set possible points and studentName for each instance of quiz, I think it best to not @BeforeEach in case this were an actual teacher's program
    // (it would be hardcoded just for that one student rather than having any flexibility in use).
    @Test
    public void quiz_shouldReturn_quizPercent()
    {
        //arrange
        Quiz quiz = new Quiz(80, "Rachael");
        quiz.setScore(50);
        int possiblePoints = quiz.getPossiblePoints();
        int expected = 62;

        //act
        int actual = quiz.getPercent();



        //assert
        assertEquals(expected, actual, "Because it should have calculated (50/65) * 100");

    }
    @Test
    public void quiz_shouldReturn_letterGrade()
    {
        //arrange
        Quiz quiz = new Quiz(100, "Willy");
        quiz.setScore(86);
        String expected = "B";

        //act
       String actual = quiz.getLetterGrade();


        //assert
        assertEquals(expected, actual, "Because the grade was 86, it should be a B");
    }


}