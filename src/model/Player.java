package model;

import java.util.ArrayList;

public class Player {
    private String playerName;
    private int coins;
    private ArrayList<Item> itemArrayList;

    public Player() {

    }

    public String getPlayerName() {
        return playerName;
    }

    public int getCoins() {
        return coins;
    }

    public ArrayList<Item> getItemArrayList() {
        return itemArrayList;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void setItemArrayList(ArrayList<Item> itemArrayList) {
        this.itemArrayList = itemArrayList;
    }
}
