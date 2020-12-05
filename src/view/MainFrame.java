package view;

import controller.LootBoxHitMessage;
import controller.Message;
import controller.NoHitMessage;
import controller.YesHitMessage;
import model.Player;

import javax.swing.*;
import java.util.concurrent.BlockingQueue;

/**
 * MainFrame is a JFrame class that will display components like GameField, Loot Box, Yes or No Buttons
 */
public class MainFrame extends JFrame {
    private final BlockingQueue<Message> queue;

    /**
     * Constructor for MainFrame
     *
     * @param queue
     * @param gameField  is sued to display math equations
     * @param scoreLabel is used to display score
     * @param player     is sued to access to access name
     */
    public MainFrame(BlockingQueue<Message> queue, GameField gameField, ScoreLabels scoreLabel, Player player) {
        super("Math Learning");
        this.queue = queue;
        JLabel playerLabel = new JLabel("Player : " + player.getPlayerName());
        View.centerWindow(this);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        JButton Yes = new JButton("Yes");//create the yes button
        Yes.addActionListener(event -> {
            try {
                this.queue.put(new YesHitMessage()); // <--- adding YesHitMessage message to the queue

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        JButton No = new JButton("No");//create the No button
        No.addActionListener(event -> {
            try {
                this.queue.put(new NoHitMessage()); // <--- adding NoHitMessage message to the queue

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        JButton LootBoxButton = new JButton("Loot Box");//create the LootBoxButton button
        LootBoxButton.addActionListener(event -> {
            try {
                this.queue.put(new LootBoxHitMessage());// <--- adding LootBoxHitMessage message to the queue
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Yes.setBounds(140, 305, 80, 37);
        add(Yes);

        No.setBounds(250, 305, 80, 37);
        add(No);

        LootBoxButton.setBounds(480, 50, 220, 37);
        add(LootBoxButton);

        playerLabel.setBounds(480, 0, 220, 37);
        playerLabel.setBorder(BorderFactory.createEtchedBorder()); //set up the border
        add(playerLabel);

        scoreLabel.setBounds(0, 0, 482, 40);
        add(scoreLabel);

        gameField.setBounds(0, 40, 480, 255);
        add(gameField);


        JMenuBar menubar = new JMenuBar();//set up the menu bar for help
        setJMenuBar(menubar);

        JMenu help = new JMenu("Help");
        menubar.add(help);

        JMenuItem howToPlay = new JMenuItem("How To Play");//information on how to play
        help.add(howToPlay);

        final String how = "Two random numbers, random operand and random answer are generated\n"
                + "User will then process math operation. If its true and press Yes, the user will gain 1 correct point and gain 3 coins, \n"
                + "and if its true and pressed No, you have 1 Wrong point and loose 1 coin.\n"
                + "\n"
                + "If the user have more than 5 incorrect answers, then the game is over. \n"
                + "Warning: Calculations are done with integers, so when dividing only choose the whole number part.\n"
                + " No decimal. No round-up or round-down.\n"
                + "For Example:  10/3, the result will be 3, because 3 is the integer part. For 5/7 the result will be  0.\n"
                + "Another example: 15/3 = 5,  15/4 = 3, 20/3 = 6 etc. Be careful!!!!!!";

        howToPlay.addActionListener(e -> JOptionPane.showMessageDialog(null, how));

        JMenuItem aboutus = new JMenuItem("About");//information aboutus
        help.add(aboutus);

        aboutus.addActionListener(e -> JOptionPane.showMessageDialog(null, "- Math Learning "));

        JMenuItem quit = new JMenuItem("Exit");//exit button to easily quit the game
        help.add(quit);

        quit.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Thank You for Playing. Take Care!!! ");
            System.exit(0);
        });

    }

    /**
     * playAgain() will ask the users if they want to play the game again or not.
     *
     * @return boolean
     */
    public static boolean playAgain() {
        int info = JOptionPane.showConfirmDialog(null, "Game Over\nYou gave 6 incorrect answers\n"
                + "Want to play again???", "Math Learning", JOptionPane.YES_NO_OPTION);//ask the user to replay
        return info != JOptionPane.NO_OPTION;
    }

}
