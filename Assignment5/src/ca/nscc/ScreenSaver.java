package ca.nscc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
//Connor Cheney w0276004 Assignment 4
public class ScreenSaver extends JPanel {
    //array list for all the shape that will be made during run time
    private static ArrayList<Shape> ShapeList = new ArrayList<Shape>();
    //timer set at 25 MS delay
    private Timer timer = new Timer(25, new TimerAction());
    //screen saver constructor
    public ScreenSaver(int screenWidth, int screenHeight) {
        this.setBounds(0, 0, screenWidth, screenHeight);
        //mouse listener for checking clicks.
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //getting x and y from mouse click
                int x = e.getX();
                int y = e.getY();
                //random number from 0 to 3
                int num = (int) Math.round(Math.random() * 3);
                //using polymorphism, each object can be a shape.
                Shape shape = null;
                //Based on random number generated a shape will be drawn
                //after the statement is finished the shape will be added to the ArrayList
                if (num == 0) {
                    shape = new Square(25, 25, x, y, getInstance());
                    shape.draw(getGraphics());
                } else if (num == 1) {
                    shape = new SpaceShip(x, y, getInstance());
                    shape.draw(getGraphics());
                } else if (num == 2) {
                    shape = new Circle(25, 25, x, y, getInstance());
                    shape.draw(getGraphics());
                } else if (num == 3) {
                    shape = new Star(25, 25, x, y, getInstance());
                    shape.draw(getGraphics());
                }
                ShapeList.add(shape);
                //change made
            }
        });
        //starting the timer.
        timer.start();
    }
    @Override
    public void paintComponent(Graphics g) {
        for (Shape shape : ShapeList) {
            super.paintComponent(g);
            shape.draw(g);
            this.repaint();

        }
    }

    private class TimerAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Graphics curShape = getGraphics();
            ScreenSaver.super.paintComponent(getGraphics());
            //looping through all the shapes and calling the move function from shape.
            for (Shape currentShape : ShapeList) {
                currentShape.moveShape(curShape);
            }
        }
    }
    //Returns current instance of ScreenSaver
    public ScreenSaver getInstance() {
        return this;
    }
    //Returns current instance of the ArrayList
    public static ArrayList<Shape> getList() {
        return ShapeList;
    }

}