package view;

import model.Player;
import model.Score;

import javax.swing.*;
import java.awt.*;

/**
 * ScoreLabels is a JPanel class that will display the Correct, Incorrect and Coins in the MainFrame
 */
public class ScoreLabels extends JPanel {
    private final Score score;
    private final Player player;
    public static final Color darkYellow = new Color(255, 204, 0);

    public ScoreLabels(Score score, Player player) {
        this.score = score;
        this.player = player;
    }

    public void paintComponent(Graphics i) //set up the graphic
    {
        super.paintComponent(i);
        Graphics2D j = (Graphics2D) i;
        setBorder(BorderFactory.createEtchedBorder()); //set up the border for the score

        Dimension size = getPreferredSize(); //set up the variable for dimension
        size.height = 30;
        setPreferredSize(size);
        Font font = new Font("SansSerif", Font.PLAIN, 20);//sets the font for display
        j.setFont(font);
        j.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        i.setColor(Color.red);//set the color to red
        i.drawString("Incorrect: " + score.getIncorrect(), 200, 30); //set up for score board for correct
        i.setColor(Color.green);//set the color to green
        i.drawString("Correct: " + score.getCorrect() + "      ", 85, 30);//set up for score board for incorrect
        i.setColor(darkYellow);//set the color to green
        i.drawString("Coins: " + player.getCoins() + "      ", 345, 30);//set up for score board for incorrect

    }
}
