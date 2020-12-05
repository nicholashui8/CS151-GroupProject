package view;

import model.Item;
import model.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Class is used to display all items user has in their inventory
 */
public class InventoryPanel extends JPanel {
    private Player player;

    /**
     * Constructor to set player object and set layout of window
     *
     * @param player is needed to access the inventory
     */
    public InventoryPanel(Player player) {
        this.player = player;

        setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel label = new JLabel("Player's Inventory");
        add(label);
        this.setBorder(BorderFactory.createEtchedBorder());
    }

    /**
     * Displays all items that user has in their inventory
     *
     * @param i is used to paint all the text
     */
    public void paintComponent(Graphics i) {
        super.paintComponents(i);
        Graphics2D j = (Graphics2D) i;
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setBorder(BorderFactory.createEtchedBorder()); //set up the border for the score

        Dimension size = getPreferredSize(); //set up the variable for dimension
        size.height = 30;
        setPreferredSize(size);

        Font font = new Font("Times New Roman", Font.PLAIN, 15);
        j.setFont(font);
        j.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        i.setColor(Color.BLACK);//set the color to red

        ArrayList<Item> list = player.getInventory();
        int y = 40;
        for (Item item : list) {
            i.drawString(item.getItemName(), 150, y);
            i.drawString(item.getRar(), 250, y);
            y += 15;
        }
        System.out.println("inventory is repainting");
        setVisible(true);
    }
}
