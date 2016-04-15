package com.github.armanddu.boardgames.gomoku.player.gui;

import com.github.armanddu.boardgames.lib.player.Player;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by armanddu on 07/04/16 for board-games.
 */
public class GuiPlayerTest {

    @Test
    public void test()
    {
        Player player = new GuiPlayer("player 1");

        assertEquals("player 1", player.getName());
    }

}