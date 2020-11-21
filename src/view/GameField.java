package view;

import model.GameModel;

import javax.swing.*;
import java.awt.*;

public class GameField extends JPanel {

    private int[] result;// create an array to hold all result

    private boolean check;//hold the answer to check the value of the user input

    public GameField() { // set up the game field
        setVisible(true);
        setLayout(new BorderLayout()); // set up the border layout

    }

    public void paintComponent(Graphics i) { //setup the graphic
        super.paintComponent(i);
        GameModel model = new GameModel(); //setup the game model
        Graphics2D j = (Graphics2D) i;
        String operand = model.getOperand(); //get the operand of the operation
        result = model.getFinalAnswer();//get the answer for the number

        //check = model.checkAns(); //check the answer using the model and user input

        i.setFont(new Font("AR JULIAN", Font.TRUETYPE_FONT, 55));
        j.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        i.setColor(new Color(230, 225, 230));
        i.fillRect(0, 0, getWidth(), getHeight());
        i.setColor(Color.BLUE);
        i.drawString(result[0] + " " + operand + " " + result[1] + " = "
                + result[2], getWidth() / 7, 3 * getHeight() / 5);
    }

    public int[] getResult() { //get the overall result from the user
        result = (new GameModel()).getFinalAnswer();//collect the user input to store
        return result;
    }

    public boolean getCheck() { //check and print out the answer
        System.out.println(check);
        return check;
    }
}
