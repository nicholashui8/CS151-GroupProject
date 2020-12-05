package controller;

import model.LootBox;
import model.Player;
import model.Score;
import view.*;

import javax.swing.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * Class is used to tell what the model and view what to do
 */
public class Controller {
    private final BlockingQueue<Message> queue;
    //  private View view; // Direct reference to view
    //  private Model model; // Direct reference to model
    private final GameInfo gameInfo; // Direct reference to the state of the Game/Application
    public GameField gameField;
    private final ScoreLabels scoreLabels;
    private final List<Valve> valves = new LinkedList<>();
    private final Player player;
    private final LootBoxButtonPanel lootBoxButtonPanel;
    private final LootBoxFrame lootBoxFrame;
    private final LootBoxPanel lootBoxPanel;
    private final InventoryPanel inventoryPanel;
    private final ItemImage itemImage;
    private final LootBox lootbox;

    /**
     * Constructor creates all the necessary objects for this program to work
     *
     * @param view  used to update the view
     * @param queue used to communicate for MVC
     * @throws IOException when item file cannot be opened
     */
    public Controller(View view, BlockingQueue<Message> queue) throws IOException {
        //    this.model = model;
        //   this.view = view;
        this.queue = queue;
        Score score = new Score();
        this.player = new Player();
        this.gameField = new GameField(score, player);
        this.scoreLabels = new ScoreLabels(score, player);
        lootBoxPanel = new LootBoxPanel(queue);
        this.lootbox = new LootBox(player);
        this.itemImage = new ItemImage(lootbox);
        this.itemImage.setVisible(false);
        this.inventoryPanel = new InventoryPanel(player);
        this.lootBoxButtonPanel = new LootBoxButtonPanel(queue, player, inventoryPanel, lootBoxPanel, itemImage);
        lootBoxButtonPanel.setVisible(false);
        this.lootBoxFrame = new LootBoxFrame(queue, player, lootBoxButtonPanel, lootBoxPanel, inventoryPanel, itemImage);
        lootBoxFrame.setVisible(false);
        this.gameInfo = new GameInfo(gameField, scoreLabels, view, lootBoxButtonPanel, player, lootbox, itemImage, inventoryPanel);
        valves.add(new DoNewGameValve());
        valves.add(new YesHitValve());
        valves.add(new NoHitValve());
        valves.add(new LootBoxHitValve());
        valves.add(new OpenBoxHitValve());
        valves.add(new ViewInventoryHitValve());
    }

    /**
     * Function deals with all user interactions (button clicks)
     */
    public void mainLoop() {
        ValveResponse response = ValveResponse.EXECUTED;
        Message message = null;
        while (response != ValveResponse.FINISH) {
            try {
                message = queue.take(); // <--- take next message from the queue
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Look for a Valve that can process a message
            for (Valve valve : valves) {
                response = valve.execute(message);
                // if successfully processed or game over, leave the loop
                if (response != ValveResponse.MISS) {
                    break;
                }
            }
        }
    }

    private void updateGameInfo(boolean yes) {
        if (yes) {
            gameInfo.yesButtonClick();
        } else gameInfo.noButtonClick();
    }

    /**
     * Used to repaint the math game and score
     */
    private void updateGameInfo() {
        gameInfo.repaint();
    }


    private interface Valve {
        /**
         * Performs certain action in response to message
         */
        ValveResponse execute(Message message);
    }

    private class DoNewGameValve implements Valve {
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != NewGameMessage.class) {
                return ValveResponse.MISS;
            }
            player.setPlayerName(JOptionPane.showInputDialog("Welcome to the game!\nPlease enter player name:\n"));
            new MainFrame(queue, gameField, scoreLabels, player);
            updateGameInfo();
            // otherwise it means that it is a NewGameMessage message
            // actions in Model
            // actions in View
            return ValveResponse.EXECUTED;
        }
    }

    private class YesHitValve implements Valve {
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != YesHitMessage.class) {
                return ValveResponse.MISS;
            }
            // otherwise it means that it is a NewGameMessage message
            // actions in Model
            updateGameInfo(true);
            // actions in View
            return ValveResponse.EXECUTED;
        }
    }

    private class NoHitValve implements Valve {
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != NoHitMessage.class) {
                return ValveResponse.MISS;
            }
            // actions in Model
            updateGameInfo(false);
            // actions in View
            return ValveResponse.EXECUTED;
        }
    }

    private class OpenBoxHitValve implements Valve {
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != OpenBoxHitMessage.class) {
                return ValveResponse.MISS;
            }
            // otherwise it means that it is a NewGameMessage message
            // actions in Model
            gameInfo.openBoxClick(lootBoxFrame);

            // actions in View
            return ValveResponse.EXECUTED;
        }
    }

    private class LootBoxHitValve implements Valve {
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != LootBoxHitMessage.class) {
                return ValveResponse.MISS;
            }
            // actions in Model
            //updateGameInfo();
            lootBoxFrame.setVisible(true);
            lootBoxButtonPanel.setVisible(true);
            // actions in View
            return ValveResponse.EXECUTED;
        }
    }

    private class ViewInventoryHitValve implements Valve {
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != ViewInventoryHitMessage.class) {
                return ValveResponse.MISS;
            }
            gameInfo.repaintInventory();
            // otherwise it means that it is a NewGameMessage message
            // actions in Model
            // actions in View
            return ValveResponse.EXECUTED;
        }
    }
}

