package ca.nscc;

import java.awt.*;
//Connor Cheney w0276004 Assignment 4
public class Square extends Shape{
    //Square constructor
    public Square(int width, int height, int xPosition, int yPosition,ScreenSaver screenSaver) {
    setSize(width);
    setSize(height);
    setShapeColor(getRandomColor());
    setScreenSaver(screenSaver);
    this.setxPosition(xPosition);
    this.setyPosition(yPosition);
    }
    //Override for draw from parent class
    @Override
    public void draw(Graphics g) {
        g.setColor(this.getShapeColor());
        g.fillRect(this.getxPosition(),this.getyPosition(),getSize(),getSize());

    }

}
