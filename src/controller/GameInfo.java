package controller;

import model.LootBox;
import model.Player;
import view.*;

/**
 * GameInfo is used to tell View when and what to repaint
 */
public class GameInfo {
    // the state of the Game/Application
    // information that is needed to repaint the View
    View view;
    GameField gameField;
    ScoreLabels scoreLabel;
    LootBoxButtonPanel lootBoxButtonPanel;
    Player player;
    LootBox lootBox;
    ItemImage itemImage;
    InventoryPanel inventoryPanel;

    /**
     * @param gameField
     * @param scoreLabel
     * @param view
     * @param lootBoxButtonPanel
     * @param player
     * @param lootbox
     * @param itemImage          is used to update image of lootbox item
     * @param inventoryPanel
     */
    public GameInfo(GameField gameField, ScoreLabels scoreLabel, View view, LootBoxButtonPanel lootBoxButtonPanel, Player player, LootBox lootbox, ItemImage itemImage, InventoryPanel inventoryPanel) {
        this.gameField = gameField;
        this.scoreLabel = scoreLabel;
        this.view = view;
        this.lootBoxButtonPanel = lootBoxButtonPanel;
        this.player = player;
        this.lootBox = lootbox;
        this.itemImage = itemImage;
        this.inventoryPanel = inventoryPanel;
    }

    /**
     * Handles when user clicks "yes" Generate new equation and repaints view
     */
    public void yesButtonClick() {
        gameField.getModel().action(true);
        repaint();
    }

    /**
     * Handles when user clicks "no" Generate new equation and repaints view
     */
    public void noButtonClick() {
        gameField.getModel().action(false);
        repaint();
    }

    /**
     * Tells the score, math game, and inventory to repaint their views
     */
    public void repaint() {
        view.change(scoreLabel, gameField, lootBoxButtonPanel);
    }

    /**
     * Checks if user has enough coins to open box, and opens box if usre has enough coins
     *
     * @param lootBoxFrame used to access the lootbox in order to display "cannot open"
     */
    public void openBoxClick(LootBoxFrame lootBoxFrame) {
        if (player.getCoins() >= 15) {
            player.subtract15Coins();
            //Item item = lootBox.openBox();
            lootBox.openBox();
            scoreLabel.repaint();
            lootBoxButtonPanel.repaint();
            repaintLootBox();

            //repaint();
        } else {
            lootBoxFrame.notEnoughCoins();
        }
    }

    /**
     * Tells the lootbox to repaint the item image
     */
    public void repaintLootBox() {
        view.changeLootBox(itemImage);
    }

    /**
     * Tells the inventory to repaint what is inside the player's inventory
     */
    public void repaintInventory() {
        view.changeInventory(inventoryPanel);
        inventoryPanel.repaint();
    }
}
