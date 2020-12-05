package view;

import controller.Message;
import controller.OpenBoxHitMessage;

import javax.swing.*;
import java.util.concurrent.BlockingQueue;

/**
 * Class is used to allow user to open a lootbox
 */
public class LootBoxPanel extends JPanel {
    private BlockingQueue<Message> queue;

    /**
     * Constructor sets up the GUI of the panel
     * @param queue
     */
    public LootBoxPanel(BlockingQueue<Message> queue) {
        this.queue = queue;
        //setLayout(new FlowLayout(FlowLayout.LEFT));
        setLayout(null);
        JButton openButton = new JButton("Open");//create the yes button
        openButton.setBounds(300, 0, 100, 30);
        openButton.addActionListener(event -> {
            try {
                //System.out.println("button clicked");
                this.queue.put(new OpenBoxHitMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        add(openButton);
        setVisible(true);
    }
}
