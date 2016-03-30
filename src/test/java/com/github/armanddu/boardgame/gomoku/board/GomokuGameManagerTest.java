package com.github.armanddu.boardgame.gomoku.board;

import com.github.armanddu.boardgame.gomoku.player.GomokuPlayers;
import com.github.armanddu.boardgame.gomoku.rule.rules.GomokuMapSizeRule;
import com.github.armanddu.boardgame.lib.game.GameBox;
import com.github.armanddu.boardgame.lib.game.GameManager;
import com.github.armanddu.boardgame.lib.player.Player;
import com.github.armanddu.boardgame.lib.player.Players;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import org.junit.Test;
import resources.com.github.armanddu.boardgame.gomoku.player.TestGomokuPlayer;

import static org.junit.Assert.*;

/**
 * Created by armanddu on 30/03/16 for board-games.
 */
public class GomokuGameManagerTest {

    private GameBox box = new GomokuBox();
    private Player p1 = new TestGomokuPlayer("player 1", StoneColor.BLACK);
    private Player p2 = new TestGomokuPlayer("player 2", StoneColor.WHITE);
    private Players players = new GomokuPlayers(p1, p2);
    private GameManager manager = box.getManager(players);


    @Test
    public void shouldTestGetBoard()
    {
        assertEquals(GomokuMapSizeRule.WIDTH, manager.getBoard().getWidth());
        assertEquals(GomokuMapSizeRule.HEIGHT, manager.getBoard().getHeight());
    }

    @Test
    public void shouldTestGetStonePacks() {
        assertFalse(manager.getStonePacks().isEmpty());
        assertEquals(2, manager.getStonePacks().size());
    }

    @Test
    public void shouldTestGetMap() {
        assertEquals(GomokuMapSizeRule.WIDTH, manager.getMap().getWidth());
        assertEquals(GomokuMapSizeRule.HEIGHT, manager.getMap().getHeight());
    }

    @Test
    public void shouldTestGetPlayers() {
        assertEquals(StoneColor.BLACK, manager.getPlayers().getBlack().getStoneColor());
        assertEquals("player 1", manager.getPlayers().getBlack().getName());
        assertEquals(StoneColor.WHITE, manager.getPlayers().getWhite().getStoneColor());
        assertEquals("player 2", manager.getPlayers().getWhite().getName());
    }

}