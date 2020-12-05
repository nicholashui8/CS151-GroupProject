import model.Score;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScoreTester {

    Score score = new Score();

    @Test public void increment_CorrectTester(){

        assertEquals(score.getCorrect(),0,"Correct score should be 0");
        score.increment_Correct();
        assertEquals(score.getCorrect(),1,"Correct score should be incremented by 1");
        score.increment_Correct();
        assertEquals(score.getCorrect(),2,"Correct score should be incremented by 1");

    }

    @Test public void increment_IncorrectTester(){

        assertEquals(score.getIncorrect(),0,"Incorrect score should be 0");
        score.increment_Incorrect();
        assertEquals(score.getIncorrect(),1,"Incorrect score should be incremented by 1");
        score.increment_Incorrect();
        assertEquals(score.getIncorrect(),2,"Incorrect score should be incremented by 1");

    }

    @Test public void increment_WrongTester(){

        assertEquals(score.getWrong(),0,"Wrong should be 0");
        score.incrementWrong();
        assertEquals(score.getWrong(),1,"Wrong should be incremented by 1");
        score.incrementWrong();
        assertEquals(score.getWrong(),2,"Wrong should be incremented by 1");

    }

    @Test public void resetTester(){

        for(int i =0; i<=3; i++){
            score.increment_Correct();
            score.increment_Incorrect();
            score.incrementWrong();
        }


        score.reset();

        assertTrue(score.getCorrect()==0 && score.getIncorrect() == 0 && score.getWrong() == 0, "Correct scores, Incorrect scores, and Wrong should be made 0");

        }

}
