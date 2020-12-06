import model.Item;
import model.LootBox;
import model.Player;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LootBoxTester {

    Player player = new Player();
    LootBox lootBox1 = new LootBox(player);
    LootBox lootBox2 = new LootBox(player);

    public LootBoxTester() throws IOException {

    }

    @Test
    public void OpenBoxTester(){
        Item item1 = lootBox1.openBox();

        assertEquals(item1.getItemName(), lootBox1.getRecentItemName(),"The name of item1 should be the most recently created name");
        assertEquals(item1.getPNG(), lootBox1.getRecentPNG(),"The PNG of item1 should be the most recently created PNG");
        assertEquals(item1.getRar(), lootBox1.getRecentItemRarity(),"The rarity of item1 should be the most recently created rarity");

        assertTrue(player.getInventory().contains(item1),"item1 should have been added to the player's inventory");

        Item item2 = lootBox1.openBox();
        assertEquals(item2.getItemName(), lootBox1.getRecentItemName(),"The name of item2 should be the most recently created name");
        assertEquals(item2.getPNG(), lootBox1.getRecentPNG(),"The PNG of item2 should be the most recently created PNG");
        assertEquals(item2.getRar(), lootBox1.getRecentItemRarity(),"The rarity of item2 should be the most recently created rarity");

        assertTrue(player.getInventory().contains(item2),"item2 should have been added to the player's inventory");

        Item item3 = lootBox2.openBox();

        assertEquals(item3.getItemName(), lootBox2.getRecentItemName(),"The name of item3 should be the most recently created name");
        assertEquals(item3.getPNG(), lootBox2.getRecentPNG(),"The PNG of item3 should be the most recently created PNG");
        assertEquals(item3.getRar(), lootBox2.getRecentItemRarity(),"The rarity of item3 should be the most recently created rarity");

        assertTrue(player.getInventory().contains(item3),"item3 should have been added to the player's inventory");

        Item item4 = lootBox2.openBox();
        assertEquals(item4.getItemName(), lootBox2.getRecentItemName(),"The name of item4 should be the most recently created name");
        assertEquals(item4.getPNG(), lootBox2.getRecentPNG(),"The PNG of item4 should be the most recently created PNG");
        assertEquals(item4.getRar(), lootBox2.getRecentItemRarity(),"The rarity of item4 should be the most recently created rarity");

        assertTrue(player.getInventory().contains(item4),"item4 should have been added to the player's inventory");

    }


}

