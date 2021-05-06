package ca.nscc;
import javax.swing.*;
import java.awt.*;
//Connor Cheney w0276004 Assignment 4
public class MainFrame extends JFrame {
    public MainFrame() {
        //Setting the size,colour, title of the Frame
        this.setBounds(0, 0, 1000, 800);
        this.setTitle("Screen Saver of Shapes");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //creating new ScreenSaver object and adding it to Frame.
        ScreenSaver screen = new ScreenSaver(this.getWidth(), this.getHeight());
        screen.setBackground(Color.darkGray);
        this.add(screen);


    }



}

