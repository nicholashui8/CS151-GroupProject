package view;

import model.GameModel;
import model.Score;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    //private LeaderLabel leader=new LeaderLabel();//set up leader board
    private GameField gameField = new GameField();//set up the game frame
    private Score score = new Score();//set up score
    private boolean check;
    private static int count;
    String name = null;
    public static String name1;
    int target;

    public MainFrame() {
        super("Math Learning");
        centerWindow(this);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        target = 16;
        JButton Yes = new JButton("Yes");//create the yes button

        Yes.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                action(true);//depending on the user choice and the solution, it will give right or wrong points

            }
        });

        JButton No = new JButton("No");//create the yes button

        No.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                action(false);//depending on the user choice and the solution, it will give right or wrong points
            }
        });


        //set up the button, leaderboard, score and the game field
        Yes.setBounds(140, 305, 80, 37);
        add(Yes);
        No.setBounds(250, 305, 80, 37);
        add(No);

        //leader.setBounds(480, 0, 220, 340);
        //add(leader);

        score.setBounds(0, 0, 482, 40);
        add(score);

        gameField.setBounds(0, 40, 480, 255);
        add(gameField);


        JMenuBar menubar = new JMenuBar();//set up the menu bar for help
        setJMenuBar(menubar);

        JMenu help = new JMenu("Help");
        menubar.add(help);

        JMenuItem howToPlay = new JMenuItem("How To Play");//information on how to play
        help.add(howToPlay);

        final String how = "Two random numbers, random operant and random answer are generated\n"
                + "User will then process math operation. If its true and press Yes, the user will gain 1 correct point,\n and if its true and pressed No, you have 1 Wrong point.\n"
                + "\n"
                + "If the user have more than 5 incorrect answers, then the game is over.  "
                + "Warning: Calculations are done with integers, so when dividing only choose the whole number part. No decimal. No round-up or round-down.\n"
                + "For Example:  10/3, the result will be 3, because 3 is the integer part. For 5/7 the result will be  0.\n"
                + "Another example: 15/3 = 5,  15/4 = 3, 20/3 = 6 etc. Be careful!!!!!!";

        howToPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, how);
            }

        });

        JMenuItem aboutus = new JMenuItem("About");//information aboutus
        help.add(aboutus);

        aboutus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "- Math Learning ");
            }

        });

        JMenuItem quit = new JMenuItem("Exit");//exit button to easily quit the game
        help.add(quit);

        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Thank You for Playing. Take Care!!! ");
                System.exit(0);
            }

        });

    }


    public void checkIfWon() {//checking the leader
        if (Score.getCorrect() >= target) {// if the user passes the target score
            JOptionPane.showMessageDialog(null, "Congratulations! You have beaten the Top player");
            int info = JOptionPane.showConfirmDialog(null, "Continue with program???", "Math Learning", JOptionPane.YES_NO_OPTION);
            if (info == JOptionPane.YES_OPTION) {// if over target, ask for new target
                boolean correct = false;
                int newTarget = 0;
                while (!correct) {
                    try {
                        newTarget = Integer.parseInt(JOptionPane.showInputDialog(" Enter the New Traget Score (greater than " + target + ") : "));//obtain the new target score
                        if (target >= newTarget)
                            throw new IllegalArgumentException();
                        else {
                            target = newTarget;
                            correct = true;
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Enter an Integer greater than " + target);
                    }
                }//end while
            }// end if
            else {
                //  System.exit(0);//exit if the user decided to finish
            }
        }
    }

    public static int getCount() {//obtain the count to display the user in the leader board
        return count;
    }


    public void action(boolean y) {

        if (y) {//checking the option true or false
            check = GameModel.checkAns();
            if (check) {// if the answer is correct, and the user press yes then, it will increment correct point
                score.increment_Correct();
                score.repaint();
                gameField.repaint();
                count++;
            } else {// if the answer is wrong, and the user press yes then, it will increment wrong point
                score.increment_Incorrect();
                score.repaint();
                gameField.repaint();
                count++;
            }
        } else {
            check = GameModel.checkAns();
            if (!check) {// if the answer is correct, and the user press yes then, it will increment correct point
                score.increment_Correct();
                score.repaint();
                gameField.repaint();
                count++;
            } else {// if the answer is wrong, and the user press yes then, it will increment wrong point
                score.increment_Incorrect();
                score.repaint();
                gameField.repaint();
                count++;
            }

        }

        if (Score.getWrong() > 5) {//  if more than 5 wrong answer, the game is over
            JOptionPane.showMessageDialog(null, "Game Over.");//display the user about the game over
            int info = JOptionPane.showConfirmDialog(null, "Continue with program???", "Math Learning", JOptionPane.YES_NO_OPTION);//ask the user to replay
            if (info == JOptionPane.NO_OPTION) {
                //       System.exit(0);

            } else {
                score.reset();//reset the score
                count = 0;//reset the count
                gameField.repaint();//reset the game field
            }

        }

        checkIfWon();
    }

    public void centerWindow(Window w)// adjust the display window
    {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int width = 700;
        int height = 400;
        w.setBounds((int) (d.width - width) / 2, (int) (d.height - height) / 2,
                width, height);
    }

}
