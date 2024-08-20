package com.niantic.shapes;

public class Square extends Rectangle
{
    public Square(double sideLength)
    {
        //setting specifics that makes the square unique from the parent it extends from
//        setWidth(2.5);
//        setHeight(2.5);
        super(sideLength, sideLength);
    }



}
