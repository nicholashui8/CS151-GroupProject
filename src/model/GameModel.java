package model;


import view.MainFrame;

import java.util.Random;

/**
 * Class is handles the logic of creating random math problems
 */

public class GameModel {

    private String operand = " ";//string variable to hold the operands (adding, subtracting, multiplying, dividing)
    private int[] finalAns;// variable to hold the answer
    public boolean check; //variable to hold the user input and verify
    private final Score score;
    private final Player player;

    public GameModel(Score score, Player player) {
        this.score = score;
        this.player = player;
        chances();
        solution();
    }

    /**
     * Used to generate a random operator for math equation
     *
     * @return an operator
     */
    public String getOperator() { // the process to get which operation to do
        String[] listoperator = {"+", "-", "*", "/"};
        String operator;
        int num = new Random().nextInt(4);//get a random number for 0-3; each representing an operator

        if (num == 0)// if random generated number is zero, it will do subtraction
        {
            operator = listoperator[0];
        } else if (num == 1)//if random generated number is zero, it will do addition
        {
            operator = listoperator[1];
        } else if (num == 2)//if random generated number is zero, it will do multiplication
        {
            operator = listoperator[2];
        } else {//if random generated number is zero, it will do division
            operator = listoperator[3];
        }

        return operator; //return which one of the four operations
    }

    /**
     * Gets and returns the operand
     *
     * @return the operand
     */
    public String getOperand() {//get the operand
        return operand;
    }

    /**
     * Generates two random numbers for math equation
     *
     * @return an array of two numbers for math equation
     */
    public int[] ranNumbers() {//create two random number generator and return an array
        int[] numbers = new int[2];
        //set up a static variable to keep count of how many time the game has ran
        Random rand = new Random();
        numbers[0] = rand.nextInt(15) + 1;
        rand = new Random();
        numbers[1] = rand.nextInt(15) + 1;
        return numbers;
    }

    /**
     * Generates a random math equation
     */
    public void chances() {
        int rand = new Random().nextInt(2);//we want to have two cases: one case for right answer and one case for wrong answer

        //int rand = new Random().nextInt(2) + 1;//we want to have two cases: one case for right answer and one case for wrong answer
        int[] randNumbers = ranNumbers();
        int answer; //variable to hold the answer
        operand = getOperator();
        finalAns = new int[3];

        // for the right case: add two random numbers and store the data
        // for the wrong case: add two random numbers with additional random number and store the data
        if (rand == 1) {
            switch (operand) {
                case "+":
                    answer = randNumbers[0] + randNumbers[1];
                    break;
                case "-":
                    answer = randNumbers[0] - randNumbers[1];
                    break;
                case "*":
                    answer = randNumbers[0] * randNumbers[1];
                    break;
                default:
                    answer = randNumbers[0] / randNumbers[1];
                    break;
            }
        } else {
            switch (operand) {
                case "+":
                    answer = randNumbers[0] + randNumbers[1] + new Random().nextInt(50);//add some other random number to create false answer
                    break;
                case "-":
                    answer = randNumbers[0] - randNumbers[1] + new Random().nextInt(50);
                    break;
                case "*":
                    answer = randNumbers[0] * randNumbers[1] + new Random().nextInt(50);
                    break;
                default:
                    answer = randNumbers[0] / randNumbers[1] + new Random().nextInt(50);
                    break;
            }
        }
        finalAns[2] = answer;
        finalAns[0] = randNumbers[0];// putting all the three numbers into an array
        finalAns[1] = randNumbers[1];
    }

    /**
     * Returns an array of answers
     *
     * @return an array of answers
     */
    public int[] getFinalAnswer() {
        return finalAns;
    }

    /**
     * Function will check the actual answer whether it is right or wrong based on the data
     */
    public void solution() {
        int[] solutionCalc;
        solutionCalc = finalAns;
        switch (operand) {
            case "+":
                check = (solutionCalc[0] + solutionCalc[1]) == solutionCalc[2];//comparing the addition solution
                break;
            case "-":
                check = (solutionCalc[0] - solutionCalc[1]) == solutionCalc[2];//comparing the subtraction solution
                break;
            case "*":
                check = (solutionCalc[0] * solutionCalc[1]) == solutionCalc[2];//comparing the multiplication solution
                break;
            case "/":
                check = (solutionCalc[0] / solutionCalc[1]) == solutionCalc[2];//comparing the division solution
                break;
            default:
                break;
        }
    }

    /**
     * Updates score and coins depending if user clicks "yes" or "no"
     *
     * @param y is true if user clicks "yes" and false when user clicks "false"
     */
    public void action(boolean y) {
        if (y) {//checking the option true or false
            if (check) {// if the answer is correct, and the user press yes then, it will increment correct point
                score.increment_Correct();
                player.incrementCoins();
            } else {// if the answer is wrong, and the user press yes then, it will increment wrong point
                score.increment_Incorrect();
                score.incrementWrong();
                player.decrementCoins();
            }
        } else {
            if (!check) {// if the answer is correct, and the user press yes then, it will increment correct point
                score.increment_Correct();
                player.incrementCoins();
            } else {// if the answer is wrong, and the user press yes then, it will increment wrong point
                score.increment_Incorrect();
                score.incrementWrong();
                player.decrementCoins();
            }

        }
        if (score.getWrong() > 5) {//  if more than 5 wrong answer, the game is over
            if (MainFrame.playAgain()) {
                score.reset();//reset the score and wrong
            } else {
                System.exit(0);
            }
        }
    }

}
