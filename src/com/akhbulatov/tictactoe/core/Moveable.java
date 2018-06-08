package com.akhbulatov.tictactoe.core;

import javax.swing.JButton;

/**
 * Created with Intellij IDEA.
 * User: Alidibir
 * Date: 01.10.2014
 * Time: 22:44
 */

/**
 * Move in the game
 */
public interface Moveable {

    // Marks a cell in the cells at the specified index
    // Returns: code win, a draw or a no win
    int markCell(JButton[] cells, int index);
}
