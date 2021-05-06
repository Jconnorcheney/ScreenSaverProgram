package ca.nscc;

import java.awt.*;
//Connor Cheney w0276004 Assignment 4
public class Circle extends Shape {
    //Circle constructor
    public Circle(int width, int height, int xPosition, int yPosition, ScreenSaver screenSaver) {
        setSize(width);
        setSize(height);
        setShapeColor(getRandomColor());
        this.setxPosition(xPosition);
        this.setyPosition(yPosition);
        setScreenSaver(screenSaver);
    }
    //Override for draw from parent class
    @Override
    public void draw(Graphics g) {
        g.setColor(this.getShapeColor());
        g.fillOval(this.getxPosition(), this.getyPosition(), getSize(), getSize());

    }

}
