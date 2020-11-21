package model;

import java.util.Random;

public class GameModel { // class to set up the game model and operation

    private static Random rand; //set up a static variable to keep count of how many time the game has ran
    private String operand = " ";//string variable to hold the operands (adding, subtracting, multiplying, dividing)
    private static int[] finalAns;// variable to hold the answer
    public static boolean check; //variable to hold the user input and verify

    public GameModel() {
        Chances();
        solution();
    }

    public static String getOperator() { // the process to get which operation to do
        String[] listoperator = {"+", "-", "*", "/"};
        String operator = "";
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

    public String getOperand() {//get the operand
        return operand;
    }

    // @edu.umd.cs.findbugs.annotations.SuppressFBWarnings("ST_WRITE_TO_STATIC_FROM_INSTANCE_METHOD")
    public int[] ranNumbers() {//create two random number generator and return an array
        int[] numbers = new int[2];
        rand = new Random();
        numbers[0] = rand.nextInt(15) + 1;
        rand = new Random();
        numbers[1] = rand.nextInt(15) + 1;
        return numbers;
    }


    public int[] Chances() {
        int rand = new Random().nextInt(2) + 1;//we want to have two cases: one case for right answer and one case for wrong answer
        int[] randNumbers = ranNumbers();
        int answer = 0; //variable to hold the answer
        operand = getOperator();
        finalAns = new int[3];

        switch (rand) {// for the right case: add two random numbers and store the data
            case 1:
                if (operand == "+") {
                    answer = randNumbers[0] + randNumbers[1];
                } else if (operand == "-") {
                    answer = randNumbers[0] - randNumbers[1];
                } else if (operand == "*") {
                    answer = randNumbers[0] * randNumbers[1];
                } else {

                    answer = randNumbers[0] / randNumbers[1];
                }
                break;

            case 2: // for the wrong case: add two random numbers with additional random number and store the data
                if (operand == "+") {
                    answer = randNumbers[0] + randNumbers[1] + new Random().nextInt(50);//add some other random number to create false answer
                } else if (operand == "-") {
                    answer = randNumbers[0] - randNumbers[1] + new Random().nextInt(50);
                } else if (operand == "*") {
                    answer = randNumbers[0] * randNumbers[1] + new Random().nextInt(50);
                } else {

                    answer = randNumbers[0] / randNumbers[1] + new Random().nextInt(50);
                }
                break;
        }
        finalAns[2] = answer;
        finalAns[0] = randNumbers[0];// putting all the three numbers into an array
        finalAns[1] = randNumbers[1];
        return finalAns;
    }

    public int[] getFinalAnswer() {

        return finalAns;
    }

    public boolean solution() { // this function will check the actual answer whether it is right or wrong based on the data
        int[] solutionCalc = new int[3];
        solutionCalc = getFinalAnswer();

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
        }
        return check;
    }

    public static boolean checkAns() {// check the solution
        return check;
    }

}