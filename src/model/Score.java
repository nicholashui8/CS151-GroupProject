package model;
//Header files

import javax.swing.*;

/**
 * Class for keep track of how many questions the player has answered correctly and incorrectly
 */
public class Score extends JPanel {

    //Declaring variables
    private int correct;
    private int incorrect;
    private int wrong;

    public Score() {
        correct = 0;
        incorrect = 0;
        wrong = 0;
    }


    /**
     * Increment counter used to keep track how many times user has answered correctly
     */
    public void increment_Correct() {
        correct++;
    }

    /**
     * Increment counter used to keep track how many times user has answered incorrectly
     */
    public void incrementWrong() {
        wrong++;
    }

    /**
     * @return number of times user has answered question incorrectly
     */
    public int getWrong() {
        return wrong;
    }

    /**
     * Increment counter used to keep track how many times user has answered incorrectly
     */
    public void increment_Incorrect() {
        incorrect++;
    }

    /**
     * @return number of times user has answered question incorrectly
     */
    public int getIncorrect() {
        return incorrect;
    }

    /**
     * @return number of times user has answered question correctly
     */
    public int getCorrect() {
        return correct;
    }

    /**
     * Resets all scores to 0
     */
    public void reset() {
        correct = 0;
        incorrect = 0;
        wrong = 0;
    }

}
