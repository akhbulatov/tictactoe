package com.akhbulatov.tictactoe.core;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Created with Intellij IDEA.
 * User: Alidibir
 * Date: 01.10.2014
 * Time: 23:23
 */

/**
 * Game controller, which implements the basic functions of the game
 */
public class GameController implements Moveable {

    private boolean flagSwitch;

    private ImageIcon crossIcon;
    private ImageIcon noughtIcon;

    public GameController() {
        flagSwitch = false;
        crossIcon = new ImageIcon(getClass().getResource("/res/images/cross.png"));
        noughtIcon = new ImageIcon(getClass().getResource("/res/images/nought.png"));
    }

    public void resetFlagSwitch() {
        flagSwitch = false;
    }

    // Marks a cell in the cells at the specified index
    // Returns: -1 - no win, 0 - draw, 1 - win crosses, 2 - win noughts
    public int markCell(JButton[] cells, int index) {
        int countIcons = 0;

        if (!flagSwitch) {
            if (cells[index].getIcon() == null) {
                cells[index].setIcon(crossIcon);
                flagSwitch = true;

                if (checkWin(cells)) {
                    return 1;
                }
            }
        } else {
            if (cells[index].getIcon() == null) {
                cells[index].setIcon(noughtIcon);
                flagSwitch = false;

                if (checkWin(cells)) {
                    return 2;
                }
            }
        }
        for (JButton cell : cells) {
            if (cell.getIcon() != null) {
                countIcons++;
            }
        }
        if (countIcons == cells.length) {
            return 0;
        }
        return -1;
    }

    // Goes through all the way to test win
    private boolean checkWin(JButton[] cells) {
        int countCrosses = 0;
        int countNoughts = 0;
        int begin = 0;
        int end = 3;
        int jumpDiagonally = 4;

        // Board 3x3
        if (cells.length == 9) {
            // 3 rows
            for (int i = 0; i < 3; i++) {
                for (int j = begin; j < end; j++) {
                    if (cells[j].getIcon() == crossIcon) {
                        countCrosses++;
                        if (countCrosses == 3) {
                            return true;
                        }
                    } else if (cells[j].getIcon() == noughtIcon) {
                        countNoughts++;
                        if (countNoughts == 3) {
                            return true;
                        }
                    }
                }

                countCrosses = 0;
                countNoughts = 0;
                begin += 3;
                end += 3;
            }

            countCrosses = 0;
            countNoughts = 0;
            begin = 0;
            end = 7;
            // 3 columns
            for (int i = 0; i < 3; i++) {
                for (int j = begin; j < end; j += 3) {
                    if (cells[j].getIcon() == crossIcon) {
                        countCrosses++;
                        if (countCrosses == 3) {
                            return true;
                        }
                    } else if (cells[j].getIcon() == noughtIcon) {
                        countNoughts++;
                        if (countNoughts == 3) {
                            return true;
                        }
                    }
                }

                countCrosses = 0;
                countNoughts = 0;
                begin++;
                end++;
            }

            countCrosses = 0;
            countNoughts = 0;
            begin = 0;
            end = 9;
            // 2 diagonals
            for (int i = 0; i < 2; i++) {
                for (int j = begin; j < end; j += jumpDiagonally) {
                    if (cells[j].getIcon() == crossIcon) {
                        countCrosses++;
                        if (countCrosses == 3) {
                            return true;
                        }
                    } else if (cells[j].getIcon() == noughtIcon) {
                        countNoughts++;
                        if (countNoughts == 3) {
                            return true;
                        }
                    }
                }

                countCrosses = 0;
                countNoughts = 0;
                begin = 2;
                end = 7;
                jumpDiagonally = 2;
            }
        } else if (cells.length == 25) {  // Board 5x5
            countCrosses = 0;
            countNoughts = 0;
            begin = 0;
            end = 5;
            // 5 rows
            for (int i = 0; i < 5; i++) {
                for (int j = begin; j < end; j++) {
                    if (cells[j].getIcon() == crossIcon) {
                        countCrosses++;
                        if (countCrosses == 5) {
                            return true;
                        }
                    } else if (cells[j].getIcon() == noughtIcon) {
                        countNoughts++;
                        if (countNoughts == 5) {
                            return true;
                        }
                    }
                }

                countCrosses = 0;
                countNoughts = 0;
                begin += 5;
                end += 5;
            }

            countCrosses = 0;
            countNoughts = 0;
            begin = 0;
            end = 21;
            // 5 columns
            for (int i = 0; i < 5; i++) {
                for (int j = begin; j < end; j += 5) {
                    if (cells[j].getIcon() == crossIcon) {
                        countCrosses++;
                        if (countCrosses == 5) {
                            return true;
                        }
                    } else if (cells[j].getIcon() == noughtIcon) {
                        countNoughts++;
                        if (countNoughts == 5) {
                            return true;
                        }
                    }
                }

                countCrosses = 0;
                countNoughts = 0;
                begin++;
                end++;
            }

            countCrosses = 0;
            countNoughts = 0;
            begin = 0;
            end = 25;
            jumpDiagonally = 6;
            // 2 diagonals
            for (int i = 0; i < 2; i++) {
                for (int j = begin; j < end; j += jumpDiagonally) {
                    if (cells[j].getIcon() == crossIcon) {
                        countCrosses++;
                        if (countCrosses == 5) {
                            return true;
                        }
                    } else if (cells[j].getIcon() == noughtIcon) {
                        countNoughts++;
                        if (countNoughts == 5) {
                            return true;
                        }
                    }
                }

                countCrosses = 0;
                countNoughts = 0;
                begin = 4;
                end = 21;
                jumpDiagonally = 4;
            }
        }
        return false;
    }
}
