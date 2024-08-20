package com.niantic.shapes;

public class Circle extends Square
{
    public double getRadius()
    {
        return getHeight() / 2;
    }

    public Circle(double radius)
    {
        super(radius *2);
        //because the radius is diameter/2
        //at this point it would be calculating area and perimeter in the way for a rectangle and square rather than a circle

    }

    @Override
    public double getArea()
    {
        return Math.PI * Math.pow(getRadius(),2);

        //another way to do it:
        //return super.getArea() * Math.PI / 4 will ensure that we are calling the parent most function
        //and calculating W*H / 4
        // im not going to do this, but it is a good way to learn how to call parents BY USE OF SUPER.
    }

    @Override
    public double getPerimeter()
    {
        return 2 * Math.PI * getRadius();
    }
}
