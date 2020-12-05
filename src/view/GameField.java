package view;

import model.GameModel;
import model.Player;
import model.Score;

import javax.swing.*;
import java.awt.*;

/**
 * Class that displays the math game to user
 */
public class GameField extends JPanel {

    private final Score score;
    private GameModel model;
    private final Player player;

    /**
     * Constructor to set up
     *
     * @param score
     * @param player
     */
    public GameField(Score score, Player player) { // set up the game field
        this.score = score;
        this.player = player;
        setVisible(true);
        setLayout(new BorderLayout()); // set up the border layout

    }

    /**
     * Displays the math game to the user
     *
     * @param i is used to dynamically paint math equations
     */
    public void paintComponent(Graphics i) { //setup the graphic
        super.paintComponent(i);
        model = new GameModel(score, player); //setup the game model
        Graphics2D j = (Graphics2D) i;
        String operand = model.getOperand(); //get the operand of the operation
        // create an array to hold all result
        int[] result = model.getFinalAnswer();//get the answer for the number

        i.setFont(new Font("AR JULIAN", Font.PLAIN, 50));
        j.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        i.setColor(new Color(230, 225, 230));
        i.fillRect(0, 0, getWidth(), getHeight());
        i.setColor(Color.BLACK);
        i.drawString("Is ", getWidth() / 7 - 60, 3 * getHeight() / 5);
        i.setColor(Color.BLUE);
        i.drawString(result[0] + " " + operand + " " + result[1] + " = "
                + result[2], getWidth() / 7, 3 * getHeight() / 5);
        i.setColor(Color.BLACK);
        i.drawString("?", getWidth() / 7 + 350, 3 * getHeight() / 5);
    }

    /**
     * Returns the game model
     *
     * @return game model
     */
    public GameModel getModel() {
        return model;
    }

}
