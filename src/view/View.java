package view;

import controller.Message;
import controller.NewGameMessage;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;


public class View {
    private final BlockingQueue<Message> queue;
    GameField gameField;

    public static View init(BlockingQueue<Message> queue) {
        // Create object of type view
        return new View(queue);
    }

    private View(BlockingQueue<Message> queue) {
        this.queue = queue;
        // TODO:
        // you should initalize JFrame and show it,
        // JFrame should be able to add Messages to queue
        // JFrame can be in a separate class or created JFrame with all the elements in this class
        // or you can make View a subclass of JFrame by extending it
        JFrame gameFrame = new JFrame();

        JButton newGame = new JButton("New Game");

        newGame.addActionListener(event -> {
            try {
                this.queue.put(new NewGameMessage()); // <--- adding NewGame message to the queue
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // add everything and set layout and other standard JFrame settings
        gameFrame.add(newGame);
        gameFrame.pack();
        gameFrame.setLayout(new FlowLayout());
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        centerWindow(gameFrame);
        gameFrame.setVisible(true);
    }

    /**
     * Set window properties such that it displays on left side of screen
     *
     * @param w object is used to set window properties
     */
    public static void centerWindow(Window w) // adjust the window frame
    {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int width = 700;
        int height = 450;
        w.setBounds((d.width - width) / 2 - 200, (d.height - height) / 2,
                width, height);
    }

    /**
     * Set window properties such that it displays on right side of screen
     *
     * @param w object is used to set window properties
     */
    public static void centerLootBoxWindow(Window w) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int width = 650;
        int height = 450;
        w.setBounds((d.width - width) / 2 + 200, (d.height - height) / 2,
                width, height);
    }

    /**
     * Repaints the math equation and score
     *
     * @param scoreLabels        used to access the score labels
     * @param gameField          used to access the math equations
     * @param lootBoxButtonPanel used to access the buttons inside lootbox
     */
    public void change(ScoreLabels scoreLabels, GameField gameField, LootBoxButtonPanel lootBoxButtonPanel) {
        // TODO: do all the updates and repaint
        scoreLabels.repaint();
        gameField.repaint();
        lootBoxButtonPanel.repaint();
    }

    /**
     * Displays picture of item to the user
     *
     * @param itemImage used to set to visible
     */
    public void changeLootBox(ItemImage itemImage) {
        itemImage.setVisible(true);
        itemImage.repaint();
    }

    /**
     * Makes inventory visible to user and repaints it
     *
     * @param inventoryPanel used to set to visible
     */
    public void changeInventory(InventoryPanel inventoryPanel) {
        inventoryPanel.setVisible(true);
        inventoryPanel.repaint();
    }

    public void dispose() {

    }

}
