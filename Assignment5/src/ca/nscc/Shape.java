package ca.nscc;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
//Connor Cheney w0276004 Assignment 4
public abstract class Shape {
    //random colour Array, used to set the colours of the shapes.
    Color[] randomColours = new Color[]{Color.RED, Color.BLUE, Color.ORANGE, Color.green, Color.MAGENTA,
            Color.YELLOW, Color.CYAN, Color.WHITE, Color.PINK};
    private ScreenSaver screenSaver;
    private int size = 25;
    private Color shapeColor = null;
    private int xPosition;
    private int yPosition;
    //random speed to be generated for each shape.
    private int xSpeed = (int) Math.round(Math.random() * 10);
    private int ySpeed = (int) Math.round(Math.random() * 10);

    //Move shape function
    public void moveShape(Graphics g) {
        int newX = this.getxPosition() + this.getxSpeed();
        int newY = this.getyPosition() + this.getySpeed();
        //if the object X position plus its size are greater than the width of the screen saver
        //or equal to or less than 0, reverse the movement.
        if ((newX + this.getSize()) > getScreenSaver().getWidth() || newX <= 0) {
            this.setxSpeed(this.getxSpeed() * -1);
        }
        //if the object Y position plus its size are greater than the width of the screen saver
        //or equal to or less than 0, reverse the movement.
        if ((newY + this.getSize()) > getScreenSaver().getHeight() || newY <= 0) {
            this.setySpeed(this.getySpeed() * -1);
        }
        //setting the x and y position based on speed.
        this.setxPosition(this.getxPosition() + this.getxSpeed());
        this.setyPosition(this.getyPosition() + this.getySpeed());
        //getting the rectangle for each shape.
        Rectangle shapeToCheck = this.getBounds();
        //getting the array list from the screensaver.
        ArrayList<Shape> ShapeListImport = ScreenSaver.getList();
        //looping through each array item.
        for (Shape shape : ShapeListImport) {
            //setting the bounds on other shape
            Rectangle otherShape = shape.getBounds();
            //if shape isnt itself and the other shape intersects
            if (shape != this && otherShape.intersects(shapeToCheck)) {
                //reverse the angel and change colour.
                this.setxSpeed(this.getxSpeed() * -1);
                this.setySpeed(this.getySpeed() * -1);
                this.setShapeColor(getRandomColor());
                //increase speed on other object hit
                this.setxSpeed(this.xSpeed+2);
                this.setySpeed(this.ySpeed+2);
            }
        }
        //draw them.
        draw(g);
    }

    public abstract void draw(Graphics g);

    //GETTERS AND SETTERS.
    public void setSize(int size) {
        this.size = size;
    }

    public Color getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(Color shapeColor) {
        this.shapeColor = shapeColor;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public ScreenSaver getScreenSaver() {
        return screenSaver;
    }

    public void setScreenSaver(ScreenSaver screenSaver) {
        this.screenSaver = screenSaver;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public int getSize() {
        return size;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }
    //gets bounds of the rectangle surrounding the objects.
    public Rectangle getBounds() {
        return new Rectangle(this.xPosition, this.yPosition, this.size, this.size);
    }

    protected Color getRandomColor() {
        Random randInt = new Random();
        return randomColours[randInt.nextInt(randomColours.length)];
    }
}