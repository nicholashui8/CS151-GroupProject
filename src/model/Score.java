package model;
//Header files

import javax.swing.*;
import java.awt.*;

public class Score extends JPanel {
    //Declaring variables
    protected static int correct;
    private static int incorrect;


    public void paintComponent(Graphics i) //set up the graphic
    {
        super.paintComponent(i);
        Graphics2D j = (Graphics2D) i;
        setBorder(BorderFactory.createEtchedBorder()); //set up the border for the score

        Dimension size = getPreferredSize(); //set up the variable for dimension
        size.height = 30;
        setPreferredSize(size);
        Font font = new Font("Times New Roman", Font.BOLD, 20);//sets the font for display
        j.setFont(font);
        j.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        i.setColor(Color.red);//set the color to red
        i.drawString("Incorrect: " + incorrect, 260, 30); //set up for score board for correct
        i.setColor(Color.green);//set the color to green
        i.drawString("Correct: " + correct + " ;     ", 145, 30);//set up for score board for incorrect
    }


    //The function tracks number of correct answers
    public void increment_Correct() {
        correct++;
    }

    //The function tracks number of incorrect answers
    public void increment_Incorrect() {
        incorrect++;
    }

    //executes if answer is incorrect
    public static int getWrong() {
        return incorrect;
    }

    //executes if answer is correct
    public static int getCorrect() {
        return correct;
    }

    //The function resets the score to 0
    public void reset() {
        repaint();
        correct = 0;
        incorrect = 0;
    }

}