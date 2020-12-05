package model;

import java.util.ArrayList;

/**
 * A class for representing the player and their progress in the game
 */
public class Player {
    private String playerName;
    private int coins;
    private ArrayList<Item> inventory;

    /**
     * Constructor that initializes inventory list and sets starting number of coins
     */
    public Player() {
        this.inventory = new ArrayList<Item>();
        coins = 115;
    }

    /**
     * Returns the user's name.
     *
     * @return String that is current name of user
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Sets users name to parameter
     *
     * @param name
     * @return none
     */
    public void setPlayerName(String name) {
        playerName = name;
    }

    /**
     * Returns the number of coins the user currently has
     *
     * @return the number of coins the user has
     */
    public int getCoins() {
        return coins;
    }

    /**
     * Adding an item to the user's inventory list
     *
     * @param item is an object we are adding to inventory
     */
    public void addItemToInventory(Item item) {
        inventory.add(item);
        System.out.println("Added " + item.getItemName() + " to inventory");
    }

    /**
     * Adds 3 coins to user's total coins
     *
     */
    public void incrementCoins() {
        coins += 3;
    }

    /**
     * Subtracts 1 coin from user's total coins
     */
    public void decrementCoins() {
        coins -= 1;
    }

    /**
     * Subtracts 15 coins from user's total coins
     */
    public void subtract15Coins() {
        coins = coins - 15;
    }

    /**
     * Returns list containing items user has.
     *
     * @return the arraylist containing all items that user has
     */
    public ArrayList<Item> getInventory() {
        return inventory;
    }
}
