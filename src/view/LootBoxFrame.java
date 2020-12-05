package view;

import controller.Message;
import model.Player;

import javax.swing.*;
import java.util.concurrent.BlockingQueue;

/**
 * Class is used to display the lootbox feature. Here you can open lootboxes and look at items you have received
 */
public class LootBoxFrame extends JFrame {
    /**
     * Adds lootbox, inventory, and buttons to JFrame
     *
     * @param queue
     * @param player             is used for accessing items inside inventory
     * @param lootBoxButtonPanel is used to display the buttons inside lootbox frame
     * @param lootBoxPanel       is used to display panel that allows user to open lootbox
     * @param inventoryPanel     is used to display items inside inventroy
     * @param itemImage          is used to display image of item
     */
    public LootBoxFrame(BlockingQueue<Message> queue, Player player, LootBoxButtonPanel lootBoxButtonPanel, LootBoxPanel lootBoxPanel, InventoryPanel inventoryPanel, ItemImage itemImage) {
        super("Loot Box");
        setResizable(true);
        setLayout(null);

        lootBoxPanel.setBounds(10, 50, 700, 40);
        lootBoxPanel.setVisible(true);
        add(lootBoxPanel);

        lootBoxButtonPanel.setBounds(0, 0, 690, 40);
        add(lootBoxButtonPanel);

        inventoryPanel.setBounds(0, 40, 480, 255);
        inventoryPanel.setVisible(false);
        add(inventoryPanel);

        itemImage.setBounds(120, 120, 500, 500);
        itemImage.setVisible(true);
        add(itemImage);

        View.centerLootBoxWindow(this);
        setVisible(true);

    }

    /**
     * Displays popup if user tries to open box and they don't have at least 15 coins
     *
     * @return false if user does not have 15 coins ot open box
     */
    public boolean notEnoughCoins() {
        int info = JOptionPane.showConfirmDialog(null, "You need at least 15 coins to open a box!\nPlay the game to get more coins\n"
                + "Want to play again?", "Math Learning", JOptionPane.YES_NO_OPTION);//ask the user to replay
        this.setVisible(false);
        return info != JOptionPane.NO_OPTION;
    }
}
