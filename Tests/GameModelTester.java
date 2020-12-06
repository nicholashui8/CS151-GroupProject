import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import model.GameModel;
import model.Score;
import model.Player;

public class GameModelTester {
    Score score = new Score();
    Player player = new Player();
    GameModel gamemodel = new GameModel(score,player);


    @Test public void getOperatorTester(){
        //private final Score score;
        String operator = gamemodel.getOperator();
        assertTrue(operator.equals("+") || operator.equals("-")||
                operator.equals("*")|| operator.equals("/"),
                "Operator should be +, -, *, or /");
    }

    @Test public void ranNumbersTester(){
        int[] rannums1 = new int[2];
        int[] rannums2 = new int[2];
        int[] rannums3 = new int[2];
        rannums1 = gamemodel.ranNumbers();
        rannums2 = gamemodel.ranNumbers();
        rannums3 = gamemodel.ranNumbers();

        assertTrue(rannums1[1] != rannums2[1] || rannums1[1] != rannums3[1] || rannums1[0] != rannums2[0] ||
                rannums1[0] != rannums3[0],"The randomly generated numbers should be different from each other" );
    }

    @Test public void chancesTester(){
        gamemodel.chances();
        int[] finalans1 = gamemodel.getFinalAnswer();
        gamemodel.chances();
        int[] finalans2 = gamemodel.getFinalAnswer();
        gamemodel.getOperand();

        assertTrue(finalans1[0] != finalans2[0] || finalans1[1]!= finalans2[1] || finalans1[2] != finalans2[2],
                "The numbers generated should be random");
    }


    @Test public void actionTester(){

        score.reset();
        int coins = player.getCoins();
        gamemodel.chances();
        gamemodel.solution();
        gamemodel.action(true);

        assertTrue(player.getCoins() == (coins+3) || player.getCoins() == (coins - 1),
                "Coins should either be increased or decreased");
        assertTrue(score.getCorrect() == 1 || score.getIncorrect() == 1,
                "Either correct or Incorrect should be increased");
        if(score.getIncorrect() == 1){
            assertTrue(score.getWrong() == 1,"If the input was incorrect Wrong should be increased");
        }

        gamemodel.action(false);
        assertTrue(player.getCoins() == 117,
                "Coins values should be the same after one correct and one incorrect input");
        assertTrue(score.getCorrect() == 1 && score.getIncorrect() == 1,
                "Either Correct or Incorrect should be increased, bringing both up to 1");
        if(score.getIncorrect() == 1){
            assertTrue(score.getWrong() == 1,
                    "If the input was incorrect Wrong should be increased to one, or stay at one if the input was correct");
        }
    }
}
