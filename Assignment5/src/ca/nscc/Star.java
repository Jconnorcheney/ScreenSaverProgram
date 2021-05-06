package ca.nscc;

import java.awt.*;
//Connor Cheney w0276004 Assignment 4
public class Star extends Shape{
    //Star constructor
    public Star(int width, int height,int xPosition, int yPosition,ScreenSaver screenSaver) {
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
        g.drawLine(this.getxPosition(),this.getyPosition(),this.getxPosition()+25,this.getyPosition()+25);
        g.drawLine(this.getxPosition()+25,this.getyPosition(),this.getxPosition(),this.getyPosition()+25);
        g.drawLine(this.getxPosition()+12,this.getyPosition(),this.getxPosition()+12,this.getyPosition()+25);
    }

}
