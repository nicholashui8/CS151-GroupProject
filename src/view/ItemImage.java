package view;

import model.LootBox;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * ItemImage is a JPanel that will display the item image inside the LootBoxFrame
 */
public class ItemImage extends JPanel {

    private final LootBox lootBox; //

    /**
     * Constructor used to set the lootbox
     *
     * @param lootBox
     */
    public ItemImage(LootBox lootBox) {
        this.lootBox = lootBox;
    }

    /**
     * Displays item image, name, and rarity
     *
     * @param i is used to paint image of item and
     */
    public void paintComponent(Graphics i) //set up the graphic
    {
        super.paintComponent(i);
        Graphics2D j = (Graphics2D) i;
        System.out.println("repaint" + lootBox.getRecentPNG());
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        System.out.println("Image should change");
        //https://stackoverflow.com/questions/16343098/resize-a-picture-to-fit-a-jlabel/16345968
        BufferedImage img = null;
        try {
            InputStream is = getClass().getResourceAsStream("/images/" + lootBox.getRecentPNG());
            img = ImageIO.read(is);
            //img = ImageIO.read(new File("src/images/" + lootBox.getRecentPNG()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(345, 210, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(dimg);


        System.out.println("new name: " + lootBox.getRecentItemName());
        i.drawString("Item: " + lootBox.getRecentItemName(), 100, 250);
        i.setColor(Color.black);
        i.drawString("Rarity: " + lootBox.getRecentItemRarity(), 250, 250);

        icon.paintIcon(this, i, 70, 0);
        setVisible(true);
    }
}
