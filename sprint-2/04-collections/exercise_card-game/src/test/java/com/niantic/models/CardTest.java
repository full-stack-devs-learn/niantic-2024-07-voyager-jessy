package com.niantic.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest
{
    private Card current;

    @BeforeEach
    public void setup() { current = new Card("J", "Spades");}

    @Test
    public void card_shouldReturn_FaceValue()
    {
        //arrange
        int expected = 11;
        //act
        int actual = current.getCardFaceValue();

        //assert
        assertEquals(expected, actual, "Because the face value of J is 11.");

    }

}