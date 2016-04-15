package com.github.armanddu.boardgames.gomoku.rule.rules;

import com.github.armanddu.boardgames.lib.game.GameBox;
import com.github.armanddu.boardgames.lib.game.GameManager;
import com.github.armanddu.boardgames.gomoku.board.GomokuBox;
import com.github.armanddu.boardgames.gomoku.player.GomokuPlayers;
import com.github.armanddu.boardgames.lib.player.Player;
import com.github.armanddu.boardgames.lib.player.Players;
import com.github.armanddu.boardgames.lib.rule.ConfigRule;
import com.github.armanddu.boardgames.lib.rule.Rule;
import com.github.armanddu.boardgames.lib.stone.StoneColor;
import org.junit.Test;
import resources.com.github.armanddu.boardgame.gomoku.player.TestGomokuPlayer;

import static org.junit.Assert.*;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GomokuStartingPlayerRuleTest {

    @Test
    public void testAsString() throws Exception {
        Rule rule = new GomokuStartingPlayerRule();
        assertNotNull(rule.asString());
    }

    @Test
    public  void shouldBeValidIfBlackPlaysFirst()
    {
        ConfigRule rule = new GomokuStartingPlayerRule();
        GameBox box = new GomokuBox();
        Player p2 = new TestGomokuPlayer("player 1", StoneColor.BLACK);
        Player p1 = new TestGomokuPlayer("player 2", StoneColor.WHITE);
        Players players = new GomokuPlayers(p1, p2);
        GameManager manager = box.getManager(players);
        assertTrue(rule.isValid(manager));
        assertEquals(StoneColor.BLACK, players.getStartingPlayer().getStoneColor());
    }

    @Test
    public  void shouldNotBeValidIfWhitePlaysFirst()
    {
        ConfigRule rule = new GomokuStartingPlayerRule();
        GameBox box = new GomokuBox();
        Player p2 = new TestGomokuPlayer("player 1", StoneColor.BLACK);
        Player p1 = new TestGomokuPlayer("player 2", StoneColor.WHITE);
        Players players = new GomokuPlayers(p1, p2);
        players.setStartingPlayer(StoneColor.WHITE);
        GameManager manager = box.getManager(players);
        assertFalse(rule.isValid(manager));
        assertEquals(StoneColor.WHITE, players.getStartingPlayer().getStoneColor());
    }

    @Test
    public  void shouldBeValidIfWhitePlaysFirstButThenSet()
    {
        ConfigRule rule = new GomokuStartingPlayerRule();
        GameBox box = new GomokuBox();
        Player p2 = new TestGomokuPlayer("player 1", StoneColor.BLACK);
        Player p1 = new TestGomokuPlayer("player 2", StoneColor.WHITE);
        Players players = new GomokuPlayers(p1, p2);
        players.setStartingPlayer(StoneColor.WHITE);
        GameManager manager = box.getManager(players);
        assertFalse(rule.isValid(manager));
        rule.set(manager);
        assertTrue(rule.isValid(manager));
        assertEquals(StoneColor.BLACK, players.getStartingPlayer().getStoneColor());
    }

}