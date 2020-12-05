package view;

import controller.Message;
import controller.ViewInventoryHitMessage;
import model.Player;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

/**
 * LootBoxButtonPanel is the JPanel class for displaying two buttons and Coins
 */
public class LootBoxButtonPanel extends JPanel {
    private BlockingQueue<Message> queue; //Direct reference to the Message BlockingQueue
    private final Player player;
    public static final Color darkYellow = new Color(255, 204, 0);

    /**
     * Constructor to set the reference and add components to the Panel
     *
     * @param queue
     * @param player         is used to access the number of coins the player has
     * @param inventoryPanel is used to display the user's inventory
     * @param lootBoxPanel
     * @param itemImage      is used to display image from lootbox
     */
    public LootBoxButtonPanel(BlockingQueue<Message> queue, Player player, InventoryPanel inventoryPanel, LootBoxPanel lootBoxPanel, ItemImage itemImage) {
        this.player = player;
        this.queue = queue;
        setLayout(new FlowLayout(FlowLayout.LEFT)); //setting the layout of the Panel
        JButton OpenLootBoxButton = new JButton("Open Loot Box");//create the Open Loot Box button
        OpenLootBoxButton.addActionListener(event -> {
            try {
                inventoryPanel.setVisible(false);
                lootBoxPanel.setVisible(true);
                itemImage.setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        this.add(OpenLootBoxButton);
        JButton InventoryButton = new JButton("Player's Inventory");//create the yes button
        InventoryButton.addActionListener(event -> {
            try {
                this.queue.put(new ViewInventoryHitMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        InventoryButton.addActionListener(event -> {
            lootBoxPanel.setVisible(false);
            itemImage.setVisible(false);
            inventoryPanel.setVisible(true);
        });

        this.add(InventoryButton);
    }

    /**
     * Paints the number of coins the user has
     *
     * @param i is used to paint the total coins the user has
     */
    public void paintComponent(Graphics i) { //setup the graphic
        super.paintComponent(i);
        Graphics2D j = (Graphics2D) i;
        setBorder(BorderFactory.createEtchedBorder()); //set up the border for the score

        Dimension size = getPreferredSize(); //set up the variable for dimension
        size.height = 10;
        setPreferredSize(size);
        Font font = new Font("Times New Roman", Font.BOLD, 20);//sets the font for display
        j.setFont(font);
        j.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        i.setColor(darkYellow);//set the color to red
        i.drawString("Coins: " + player.getCoins() + "      ", 500, 30);//set up for coins
    }

}
