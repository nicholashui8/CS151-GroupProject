package model;

/**
 * A class for representing each item and its qualities
 */
public class Item {
    private String itemName;
    private String rarity;
    private String png;

    /**
     * Constructor that sets all the values of the item
     *
     * @param name is the item's name
     * @param r    is the item's rarity
     * @param png  is the png file of the item
     */
    public Item(String name, String r, String png) {
        this.itemName = name;
        this.rarity = r;
        this.png = png;
    }

    /**
     * Returns the rarity of the item
     *
     * @return item's rarity
     */
    public String getRar() {
        return rarity;
    }

    /**
     * Returns item's png
     *
     * @return item's png
     */
    public String getPNG() {
        return this.png;
    }

    /**
     * Returns the items name
     *
     * @return item name
     */
    public String getItemName() {
        return itemName;
    }
}
