package ca.nscc;

import java.awt.*;
//Connor Cheney w0276004 Assignment 4
public class SpaceShip extends Shape{
    //SpaceShip Constructor
    public SpaceShip(int xPosition, int yPosition, ScreenSaver screenSaver) {
        setShapeColor(getRandomColor());
        this.setxPosition(xPosition);
        this.setyPosition(yPosition);
        setScreenSaver(screenSaver);
    }
    //Override for draw from parent class
    @Override
    public void draw(Graphics g) {
        g.setColor(this.getShapeColor());
        g.fillOval(this.getxPosition(),this.getyPosition(),35,7);
        g.fillOval(this.getxPosition()+15,this.getyPosition()-5,10,10);

    }


}
