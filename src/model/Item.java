package model;

public class Item {
    private final String itemName;
    private final Rarity rar;
    private final String description;

    public Item(String name, Rarity r, String des) {
        itemName = name;
        rar = r;
        description = des;
    }

    public Rarity getRar() {
        return rar;
    }

    public String getDescription() {
        return description;
    }

    public String getItemName() {
        return itemName;
    }
}