package com.akhbulatov.tictactoe.ui;

import com.akhbulatov.tictactoe.core.GameController;
import com.akhbulatov.tictactoe.core.BoardConstants;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

/**
 * Created with Intellij IDEA.
 * User: Alidibir
 * Date: 01.10.2014
 * Time: 22:16
 */

/**
 * The main window of the game TicTacToe
 */
public class TicTacToe extends JFrame {

    private boolean flagStartGame;

    private ImageIcon programIcon;
    private GameController gameController;

    /**
     * Sounds
     */
    private URL soundDrawUrl;
    private URL soundMarkUrl;
    private URL soundWinUrl;
    private URL soundConfirmExitUrl;

    /**
     * Components for UI
     */
    private GridLayout threeByThreeLayout;
    private GridLayout fiveByFiveLayout;
    private JButton[] threeByThreeCells;
    private JButton[] fiveByFiveCells;
    private JCheckBoxMenuItem soundsItem;
    private JMenu fileMenu;
    private JMenu helpMenu;
    private JMenu newGameMenu;
    private JMenu boardMenu;
    private JMenuBar menuBar;
    private JMenuItem twoPlayersItem;
    private JMenuItem threeByThreeItem;
    private JMenuItem fiveByFiveItem;
    private JMenuItem statisticsItem;
    private JMenuItem exitItem;
    private JMenuItem aboutItem;
    private JPanel mainPanel;

    public TicTacToe() {
        flagStartGame = false;
        programIcon = new ImageIcon(getClass().getResource("/res/images/icon.png"));
        gameController = new GameController();
        enableSounds();
        initComponents();
    }

    // Starts the game
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TicTacToe().setVisible(true);
            }
        });
    }

    // Creates UI
    private void initComponents() {
        threeByThreeLayout = new GridLayout(3, 3);
        fiveByFiveLayout = new GridLayout(5, 5);
        threeByThreeCells = new JButton[9];
        fiveByFiveCells = new JButton[25];
        soundsItem = new JCheckBoxMenuItem();
        fileMenu = new JMenu();
        helpMenu = new JMenu();
        newGameMenu = new JMenu();
        boardMenu = new JMenu();
        menuBar = new JMenuBar();
        twoPlayersItem = new JMenuItem();
        threeByThreeItem = new JMenuItem();
        fiveByFiveItem = new JMenuItem();
        statisticsItem = new JMenuItem();
        exitItem = new JMenuItem();
        aboutItem = new JMenuItem();
        mainPanel = new JPanel();

        setTitle("Tic-tac-toe");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/res/images/icon.png")));
        setSize(300, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setJMenuBar(menuBar);
        addWindowListener(new WindowListener());

        mainPanel.setLayout(threeByThreeLayout);
        add(mainPanel);

        for (int i = 0; i < threeByThreeCells.length; i++) {
            threeByThreeCells[i] = new JButton();
            threeByThreeCells[i].setActionCommand(String.valueOf(i));
            threeByThreeCells[i].addActionListener(new CellsListener());
            mainPanel.add(threeByThreeCells[i]);
        }
        // Creates 25 cells, but not add them to the board
        for (int i = 0; i < fiveByFiveCells.length; i++) {
            fiveByFiveCells[i] = new JButton();
            fiveByFiveCells[i].setActionCommand(String.valueOf(i));
            fiveByFiveCells[i].addActionListener(new CellsListener());
        }

        fileMenu.setText("File");
        menuBar.add(fileMenu);

        helpMenu.setText("Help");
        menuBar.add(helpMenu);

        newGameMenu.setText("New game");
        fileMenu.add(newGameMenu);

        twoPlayersItem.setText("2 players");
        twoPlayersItem.addActionListener(new TwoPlayersItemListener());
        newGameMenu.add(twoPlayersItem);

        fileMenu.addSeparator();

        boardMenu.setText("Board");
        fileMenu.add(boardMenu);

        threeByThreeItem.setText("3x3");
        threeByThreeItem.addActionListener(new ThreeByThreeListener());
        boardMenu.add(threeByThreeItem);

        fiveByFiveItem.setText("5x5");
        fiveByFiveItem.addActionListener(new FiveByFiveListener());
        boardMenu.add(fiveByFiveItem);

        soundsItem.setText("Sounds");
        soundsItem.setSelected(true);
        soundsItem.addActionListener(new SoundsItemListener());
        fileMenu.add(soundsItem);

        statisticsItem.setText("Statistics");
        statisticsItem.addActionListener(new StatisticsItemListener());
        fileMenu.add(statisticsItem);

        fileMenu.addSeparator();

        exitItem.setText("Exit");
        exitItem.addActionListener(new ExitItemListener());
        fileMenu.add(exitItem);

        aboutItem.setText("About");
        aboutItem.addActionListener(new AboutItemListener());
        helpMenu.add(aboutItem);
    }

    private void startNewGame() {
        if (mainPanel.getLayout() == threeByThreeLayout) {
            for (JButton cell : threeByThreeCells) {
                cell.setIcon(null);
            }
            enableCells(threeByThreeCells, true);
        } else if (mainPanel.getLayout() == fiveByFiveLayout) {
            for (JButton cell : fiveByFiveCells) {
                cell.setIcon(null);
            }
            enableCells(fiveByFiveCells, true);
        }

        flagStartGame = false;
        gameController.resetFlagSwitch();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void resizeBoard(BoardConstants size) {
        if (size == BoardConstants.THREE_BY_THREE) {
            if (mainPanel.getLayout() == fiveByFiveLayout) {
                for (JButton cell : fiveByFiveCells) {
                    mainPanel.remove(cell);
                }

                setSize(300, 300);
                mainPanel.setLayout(threeByThreeLayout);
                for (JButton cell : threeByThreeCells) {
                    mainPanel.add(cell);
                }
            }
        } else if (size == BoardConstants.FIVE_BY_FIVE) {
            if (mainPanel.getLayout() == threeByThreeLayout) {
                for (JButton cell : threeByThreeCells) {
                    mainPanel.remove(cell);
                }

                setSize(500, 500);
                mainPanel.setLayout(fiveByFiveLayout);
                for (JButton cell : fiveByFiveCells) {
                    mainPanel.add(cell);
                }
            }
        }
    }

    private void enableCells(JButton[] cells, boolean enable) {
        if (cells == threeByThreeCells) {
            if (enable) {
                for (JButton cell : threeByThreeCells) {
                    cell.setEnabled(true);
                }
            } else {
                for (JButton cell : threeByThreeCells) {
                    cell.setEnabled(false);
                }
            }
        } else if (cells == fiveByFiveCells) {
            if (enable) {
                for (JButton cell : fiveByFiveCells) {
                    cell.setEnabled(true);
                }
            } else {
                for (JButton cell : fiveByFiveCells) {
                    cell.setEnabled(false);
                }
            }
        }
    }

    private void enableSounds() {
        if (soundDrawUrl == null) {
            soundDrawUrl = getClass().getResource("/res/sounds/draw.wav");
        }
        if (soundMarkUrl == null) {
            soundMarkUrl = getClass().getResource("/res/sounds/mark.aiff");
        }
        if (soundWinUrl == null) {
            soundWinUrl = getClass().getResource("/res/sounds/win.wav");
        }
        if (soundConfirmExitUrl == null) {
            soundConfirmExitUrl = getClass().getResource("/res/sounds/confirm_exit.wav");
        }
    }

    private synchronized void playSoundDraw() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundDrawUrl);
                    clip.open(audioInputStream);
                    clip.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private synchronized void playSoundMark() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundMarkUrl);
                    clip.open(audioInputStream);
                    clip.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private synchronized void playSoundWin() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundWinUrl);
                    clip.open(audioInputStream);
                    clip.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private synchronized void playSoundConfirmExit() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundConfirmExitUrl);
                    clip.open(audioInputStream);
                    clip.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * Event handling for components
     */
    private class CellsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!flagStartGame) {
                flagStartGame = true;
                Statistics.incrementAllGames();
            }

            int code = -2;
            int index = Integer.parseInt(e.getActionCommand());
            // Marks a cell and return code win
            if (mainPanel.getLayout() == threeByThreeLayout) {
                code = gameController.markCell(threeByThreeCells, index);
            } else if (mainPanel.getLayout() == fiveByFiveLayout) {
                code = gameController.markCell(fiveByFiveCells, index);
            }
            // There is a win or a draw?
            if ((code != -2) && (code > -1)) {
                int confirm = 0;
                String playAgain = "Do you want to play again?";
                String[] options = {"Yes", "No"};

                switch (code) {
                    case 0:
                        if (soundsItem.isSelected()) {
                            playSoundDraw();
                        }
                        Statistics.incrementDraws();
                        confirm = JOptionPane.showOptionDialog(mainPanel, "Draw!\n\n" + playAgain,
                                "Draw!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                                null, options, options[0]);
                        break;
                    case 1:
                        if (soundsItem.isSelected()) {
                            playSoundWin();
                        }
                        Statistics.incrementWinCrosses();
                        confirm = JOptionPane.showOptionDialog(mainPanel, "The crosses won!\n\n" + playAgain,
                                "The crosses won!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                                null, options, options[0]);
                        break;
                    case 2:
                        if (soundsItem.isSelected()) {
                            playSoundWin();
                        }
                        Statistics.incrementWinNoughts();
                        confirm = JOptionPane.showOptionDialog(mainPanel, "The zeros won!\n\n" + playAgain,
                                "The zeros won!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                                null, options, options[0]);
                        break;
                }

                if (confirm == JOptionPane.OK_OPTION) {
                    startNewGame();
                } else {
                    if (mainPanel.getLayout() == threeByThreeLayout) {
                        enableCells(threeByThreeCells, false);
                    } else if (mainPanel.getLayout() == fiveByFiveLayout) {
                        enableCells(fiveByFiveCells, false);
                    }
                }

                flagStartGame = false;
            } else {
                if (soundsItem.isSelected()) {
                    playSoundMark();
                }
            }
        }
    }

    private class TwoPlayersItemListener implements ActionListener {

        // Creates a new game for 2 players
        @Override
        public void actionPerformed(ActionEvent e) {
            startNewGame();
        }
    }

    private class ThreeByThreeListener implements ActionListener {

        // Installs the 3x3 board
        @Override
        public void actionPerformed(ActionEvent e) {
            resizeBoard(BoardConstants.THREE_BY_THREE);
            setLocationRelativeTo(null);
            startNewGame();
        }
    }

    private class FiveByFiveListener implements ActionListener {

        // Installs the 5x5 board
        @Override
        public void actionPerformed(ActionEvent e) {
            resizeBoard(BoardConstants.FIVE_BY_FIVE);
            setLocationRelativeTo(null);
            startNewGame();
        }
    }

    private class SoundsItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            enableSounds();
        }
    }

    private class StatisticsItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new Statistics().setVisible(true);
        }
    }

    private class ExitItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class AboutItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(mainPanel, "Tic-tac-toe\nVersion: 1.0\n" +
                            "Developer: Alidibir Akhbulatov\n", "About",
                    JOptionPane.INFORMATION_MESSAGE, programIcon);
        }
    }

    private class WindowListener extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            if (flagStartGame) {
                String[] options = {"Yes", "No"};

                if (soundsItem.isSelected()) {
                    playSoundConfirmExit();
                }
                int confirm = JOptionPane.showOptionDialog(mainPanel, "Do you really want to quit the game?",
                        "Confirm exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, options, options[0]);
                if (confirm == JOptionPane.OK_OPTION) {
                    System.exit(0);
                } else {
                    setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                }
            } else {
                System.exit(0);
            }
        }
    }
}
