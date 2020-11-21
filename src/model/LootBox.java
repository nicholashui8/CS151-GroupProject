package model;

import java.util.ArrayList;

public class LootBox {
    private ArrayList<Item> itemArrayList;
    private Player player;

    public LootBox() {
        player = new Player();
        getItemsFromFile();
    }

    private void getItemsFromFile() {

    }

    protected Item getRandomItem() {
        //generate random index
        int index = 0;
        return itemArrayList.get(index);
    }
}
