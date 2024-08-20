package com.niantic.part_1;

import org.junit.jupiter.api.Test;
import org.w3c.dom.css.Rect;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTests
{

    @Test
    public void rectangle_shouldBe5x5_whenCreated()
    {
        //arrange
        Rectangle rectangle = new Rectangle();
        int width = rectangle.getWidth();
        int height = rectangle.getHeight();
        int expected = 5 * 5;

        //act
        int actual = rectangle.getArea(width, height);

        //assert
        assertEquals(expected, actual, "Because it should calculate out 5*5");



    }

    @Test
    public void rectangle_shouldReturn_areaOfRectangle()
    {

        //arrange
        Rectangle rectangle = new Rectangle();
        int width = 6;
        int height = 6;
        int expected = 36;

        //act
        int actual = rectangle.getArea(width, height);


        //assert
       assertEquals(expected, actual, "Because it should have calculated area with 5*5");

    }


    @Test
    public void rectangle_shouldReturn_perimeterOfRectangle()
    {

        //arrange
        Rectangle rectangle = new Rectangle();
        int width = 6;
        int height = 6;
        int expected = 24;


        //act
        int actual = rectangle.getPerimeter(width, height);


        //assert
        assertEquals(expected, actual, "Because it should have calculated 2*5 + 2*5");


    }



}