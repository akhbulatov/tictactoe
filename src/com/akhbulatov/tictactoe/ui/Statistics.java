package com.akhbulatov.tictactoe.ui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Created with Intellij IDEA.
 * User: Alidibir
 * Date: 03.10.2014
 * Time: 16:57
 */

/**
 * A modal dialog window with the statistics of the game
 */
class Statistics extends JDialog {

    /**
     * Counters for the introduction of the game statistics
     */
    private static int countAllGames = 0;
    private static int countWinCrosses = 0;
    private static int countWinNoughts = 0;
    private static int countDraws = 0;
    private static double percentageWinCrosses = 0.0;
    private static double percentageWinNoughts = 0.0;
    private static double percentageDraws = 0.0;

    /**
     * Components for UI
     */
    private JButton closeButton;
    private JButton resetButton;
    private JLabel allGamesLabel;
    private JLabel numberAllGamesLabel;
    private JLabel winCrossesLabel;
    private JLabel numberWinCrossesLabel;
    private JLabel winNoughtsLabel;
    private JLabel numberWinNoughtsLabel;
    private JLabel drawsLabel;
    private JLabel numberDrawsLabel;
    private JLabel percentageCrossesLabel;
    private JLabel numberPercentageCrossesLabel;
    private JLabel percentageNoughtsLabel;
    private JLabel numberPercentageNoughtsLabel;
    private JLabel percentageDrawsLabel;
    private JLabel numberPercentageDrawsLabel;
    private JPanel mainPanel;
    private JPanel allGamesPanel;
    private JPanel winCrossesPanel;
    private JPanel winNoughtsPanel;
    private JPanel drawsPanel;
    private JPanel percentageCrossesPanel;
    private JPanel percentageNoughtsPanel;
    private JPanel percentageDrawsPanel;
    private JPanel buttonsPanel;

    Statistics() {
        initComponents();
    }

    // Create UI
    private void initComponents() {
        closeButton = new JButton();
        resetButton = new JButton();
        allGamesLabel = new JLabel();
        numberAllGamesLabel = new JLabel();
        winCrossesLabel = new JLabel();
        numberWinCrossesLabel = new JLabel();
        winNoughtsLabel = new JLabel();
        numberWinNoughtsLabel = new JLabel();
        drawsLabel = new JLabel();
        numberDrawsLabel = new JLabel();
        percentageCrossesLabel = new JLabel();
        numberPercentageCrossesLabel = new JLabel();
        percentageNoughtsLabel = new JLabel();
        numberPercentageNoughtsLabel = new JLabel();
        percentageDrawsLabel = new JLabel();
        numberPercentageDrawsLabel = new JLabel();
        mainPanel = new JPanel();
        allGamesPanel = new JPanel();
        winCrossesPanel = new JPanel();
        winNoughtsPanel = new JPanel();
        drawsPanel = new JPanel();
        percentageCrossesPanel = new JPanel();
        percentageNoughtsPanel = new JPanel();
        percentageDrawsPanel = new JPanel();
        buttonsPanel = new JPanel();

        setTitle("Statistics");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/res/images/icon.png")));
        setModalityType(ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        add(mainPanel);

        allGamesPanel.setLayout(new BoxLayout(allGamesPanel, BoxLayout.X_AXIS));
        mainPanel.add(allGamesPanel);

        winCrossesPanel.setLayout(new BoxLayout(winCrossesPanel, BoxLayout.X_AXIS));
        mainPanel.add(winCrossesPanel);

        winNoughtsPanel.setLayout(new BoxLayout(winNoughtsPanel, BoxLayout.X_AXIS));
        mainPanel.add(winNoughtsPanel);

        drawsPanel.setLayout(new BoxLayout(drawsPanel, BoxLayout.X_AXIS));
        mainPanel.add(drawsPanel);

        percentageCrossesPanel.setLayout(new BoxLayout(percentageCrossesPanel, BoxLayout.X_AXIS));
        mainPanel.add(percentageCrossesPanel);

        percentageNoughtsPanel.setLayout(new BoxLayout(percentageNoughtsPanel, BoxLayout.X_AXIS));
        mainPanel.add(percentageNoughtsPanel);

        percentageDrawsPanel.setLayout(new BoxLayout(percentageDrawsPanel, BoxLayout.X_AXIS));
        mainPanel.add(percentageDrawsPanel);

        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        mainPanel.add(buttonsPanel);

        allGamesLabel.setText("Total games played:");
        allGamesPanel.add(allGamesLabel);
        allGamesPanel.add(Box.createHorizontalStrut(5));

        numberAllGamesLabel.setText(String.valueOf(countAllGames));
        allGamesPanel.add(numberAllGamesLabel);
        allGamesPanel.add(Box.createHorizontalGlue());

        winCrossesLabel.setText("Winning crosses:");
        winCrossesPanel.add(winCrossesLabel);
        winCrossesPanel.add(Box.createHorizontalStrut(5));

        numberWinCrossesLabel.setText(String.valueOf(countWinCrosses));
        winCrossesPanel.add(numberWinCrossesLabel);
        winCrossesPanel.add(Box.createHorizontalGlue());

        winNoughtsLabel.setText("Winning zeros:");
        winNoughtsPanel.add(winNoughtsLabel);
        winNoughtsPanel.add(Box.createHorizontalStrut(5));

        numberWinNoughtsLabel.setText(String.valueOf(countWinNoughts));
        winNoughtsPanel.add(numberWinNoughtsLabel);
        winNoughtsPanel.add(Box.createHorizontalGlue());

        drawsLabel.setText("Draws:");
        drawsPanel.add(drawsLabel);
        drawsPanel.add(Box.createHorizontalStrut(5));

        numberDrawsLabel.setText(String.valueOf(countDraws));
        drawsPanel.add(numberDrawsLabel);
        drawsPanel.add(Box.createHorizontalGlue());

        percentageCrossesLabel.setText("Winning percentage of crosses:");
        percentageCrossesPanel.add(percentageCrossesLabel);
        percentageCrossesPanel.add(Box.createHorizontalStrut(5));

        numberPercentageCrossesLabel.setText(String.valueOf(percentageWinCrosses) + "%");
        percentageCrossesPanel.add(numberPercentageCrossesLabel);
        percentageCrossesPanel.add(Box.createHorizontalGlue());

        percentageNoughtsLabel.setText("Winning percentage of zeros:");
        percentageNoughtsPanel.add(percentageNoughtsLabel);
        percentageNoughtsPanel.add(Box.createHorizontalStrut(5));

        numberPercentageNoughtsLabel.setText(String.valueOf(percentageWinNoughts) + "%");
        percentageNoughtsPanel.add(numberPercentageNoughtsLabel);
        percentageNoughtsPanel.add(Box.createHorizontalGlue());

        percentageDrawsLabel.setText("The percentage of draws:");
        percentageDrawsPanel.add(percentageDrawsLabel);
        percentageDrawsPanel.add(Box.createHorizontalStrut(5));

        numberPercentageDrawsLabel.setText(String.valueOf(percentageDraws) + "%");
        percentageDrawsPanel.add(numberPercentageDrawsLabel);
        percentageDrawsPanel.add(Box.createHorizontalGlue());

        closeButton.setText("Close");
        closeButton.addActionListener(new CloseButtonListener());
        buttonsPanel.add(Box.createHorizontalGlue());
        buttonsPanel.add(closeButton);
        buttonsPanel.add(Box.createHorizontalStrut(5));

        resetButton.setText("Reset");
        resetButton.addActionListener(new ResetButtonListener());
        buttonsPanel.add(resetButton);

        mainPanel.add(allGamesPanel);
        mainPanel.add(Box.createVerticalStrut(5));
        mainPanel.add(winCrossesPanel);
        mainPanel.add(Box.createVerticalStrut(5));
        mainPanel.add(winNoughtsPanel);
        mainPanel.add(Box.createVerticalStrut(5));
        mainPanel.add(drawsPanel);
        mainPanel.add(Box.createVerticalStrut(5));
        mainPanel.add(percentageCrossesPanel);
        mainPanel.add(Box.createVerticalStrut(5));
        mainPanel.add(percentageNoughtsPanel);
        mainPanel.add(Box.createVerticalStrut(5));
        mainPanel.add(percentageDrawsPanel);
        mainPanel.add(Box.createVerticalStrut(17));
        mainPanel.add(buttonsPanel);

        pack();
        setLocationRelativeTo(null);
    }

    public static void incrementAllGames() {
        countAllGames++;
    }

    public static void incrementDraws() {
        countDraws++;
        calculatePercentage();
    }

    public static void incrementWinCrosses() {
        countWinCrosses++;
        calculatePercentage();
    }

    public static void incrementWinNoughts() {
        countWinNoughts++;
        calculatePercentage();
    }

    private static void calculatePercentage() {
        if (countWinCrosses != 0) {
            percentageWinCrosses = (countWinCrosses * 100) / countAllGames;
        }
        if (countWinNoughts != 0) {
            percentageWinNoughts = (countWinNoughts * 100) / countAllGames;
        }
        if (countDraws != 0) {
            percentageDraws = (countDraws * 100) / countAllGames;
        }
    }

    /**
     * Event handling for buttons
     */
    private class CloseButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            dispose();
        }
    }

    private class ResetButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            countAllGames = 0;
            countWinCrosses = 0;
            countWinNoughts = 0;
            countDraws = 0;
            percentageWinCrosses = 0.0;
            percentageWinNoughts = 0.0;
            percentageDraws = 0.0;

            numberAllGamesLabel.setText(String.valueOf(countAllGames));
            numberWinCrossesLabel.setText(String.valueOf(countWinCrosses));
            numberWinNoughtsLabel.setText(String.valueOf(countWinNoughts));
            numberDrawsLabel.setText(String.valueOf(countDraws));
            numberPercentageCrossesLabel.setText(String.valueOf(percentageWinCrosses) + "%");
            numberPercentageNoughtsLabel.setText(String.valueOf(percentageWinNoughts) + "%");
            numberPercentageDrawsLabel.setText(String.valueOf(percentageDraws) + "%");
        }
    }
}
