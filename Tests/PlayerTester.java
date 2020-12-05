import model.Item;
import org.junit.jupiter.api.Test;
import model.Player;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTester {

    Player player = new Player();
    Item item = new Item("lil Chuck","Rare","thingy");

    @Test
    public void setPlayerNameTester(){

        String name = "Chuck Finley";
        player.setPlayerName(name);
        assertEquals(player.getPlayerName(), name, "Player name should be set to Chuck Finley");

    }

    @Test public void addItemToInventoryTester(){
        player.addItemToInventory(item);
        ArrayList<Item> inventory = player.getInventory();
        assertTrue( inventory.contains(item),"The lil Chuck item should have been added to the inventory");

    }

    @Test public void incrementCoinsTester(){
        player.incrementCoins();
        assertEquals(player.getCoins(), 118, "Coins should have been incremented by 3");
        player.incrementCoins();
        assertEquals(player.getCoins(), 121, "Coins should have been incremented by 3");
    }

    @Test public void decrementCoinsTester(){
        player.decrementCoins();
        assertEquals(player.getCoins(), 114, "Coins should have been decreased by 1");
        player.decrementCoins();
        assertEquals(player.getCoins(), 113, "Coins should have been decreased by 1");
    }

    @Test public void subtract15CoinsTester(){
        player.subtract15Coins();
        assertEquals(player.getCoins(), 100, "Coins should have been decreased by 15");
        player.subtract15Coins();
        assertEquals(player.getCoins(), 85, "Coins should have been decreased by 15");

    }
}
