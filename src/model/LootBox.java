package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class is used to contain all items that can be obtained from the lootbox
 * Open and read files that contains items and stores into a list
 */
public class LootBox {
    private ArrayList<Item> itemArrayList;
    private Player player;
    private String recentPNG;
    private String recentItemName;
    private String recentRarity;

    /**
     * Constructor that calls method to open file and creates list for holding possible lootbox items
     *
     * @param p1 is object of player, we need access to their inventory
     * @throws IOException when file of items cannot be opened
     */
    public LootBox(Player p1) throws IOException {
        this.player = p1;
        itemArrayList = new ArrayList<>();
        this.recentPNG = "loot-box.png";
        this.recentRarity = "";
        this.recentItemName = "";
        getItemsFromFile();
    }

    /**
     * Opens file containing all items and stores into a list
     *
     * @throws IOException if file is not able to be opened
     */
    private void getItemsFromFile() throws IOException {
        //File file = new File("src/lootboxItems/items.txt");
        InputStream in = getClass().getResourceAsStream("/lootboxItems/items.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        //BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {

            String[] item = st.split("-");
            for (int i = 0; i < item.length; i++) {
                System.out.print(item[i] + " ");
            }

            itemArrayList.add(new Item(item[0], item[1], item[2]));
            System.out.println();
        }
    }

    /**
     * Opens lootbox and generates a random item.
     *
     * @return a randomly generated item object
     */
    public Item openBox() {
        //generate random index;
        Random rand = new Random();

        int index = rand.nextInt((19) + 1);

        Item item = itemArrayList.get(index);
        player.addItemToInventory(item);
        this.recentPNG = item.getPNG();
        this.recentItemName = item.getItemName();
        this.recentRarity = item.getRar();
        System.out.println("recent png: " + this.recentPNG);
        return item;
    }

    /**
     * Returns most recently opened item's name
     *
     * @return name of most recently opened item
     */
    public String getRecentItemName() {
        return this.recentItemName;
    }

    /**
     * Returns most recently opened item's png file
     *
     * @return the png file name of most recently opened item
     */
    public String getRecentPNG() {
        return this.recentPNG;
    }

    /**
     * Returns most recently opened item's rarity
     *
     * @return the rarity of most recently item
     */
    public String getRecentItemRarity() {
        return this.recentRarity;
    }
}
