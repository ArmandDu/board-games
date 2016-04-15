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
public class GomokuRequiredPlayerRuleTest {

    @Test
    public void testAsString() throws Exception {
        Rule rule = new GomokuRequiredPlayerRule();

        assertNotNull(rule.asString());
    }

    @Test
    public  void shouldBeValidIfHaveTwoPlayers()
    {
        GameBox box  = new GomokuBox();
        Player a = new TestGomokuPlayer("player 1", StoneColor.WHITE);
        Player b = new TestGomokuPlayer("player 2", StoneColor.BLACK);
        Players players = new GomokuPlayers(a, b);
        ConfigRule rule = new GomokuRequiredPlayerRule();

        assertTrue(rule.isValid(box.getManager(players)));
    }

    @Test
    public  void shouldNotBeValidIfHaveOnePlayers()
    {
        GameBox box  = new GomokuBox();
        Player a = new TestGomokuPlayer("player 1", StoneColor.WHITE);
        Players players = new GomokuPlayers();
        players.set(a);
        ConfigRule rule = new GomokuRequiredPlayerRule();

        assertFalse(rule.isValid(box.getManager(players)));
    }

    @Test
    public  void shouldNotBeValidIfHaveZeoPlayers()
    {
        GameBox box  = new GomokuBox();
        Players players = new GomokuPlayers();
        ConfigRule rule = new GomokuRequiredPlayerRule();

        assertFalse(rule.isValid(box.getManager(players)));
    }


    @Test
    public  void shouldBeValidIfHaveTwiceSamePlayer()
    {
        GameBox box  = new GomokuBox();
        Player a = new TestGomokuPlayer("player 1", StoneColor.WHITE);
        Players players = new GomokuPlayers(a, a);
        ConfigRule rule = new GomokuRequiredPlayerRule();

        assertFalse(rule.isValid(box.getManager(players)));
    }

    @Test
    public  void RuleSetDoesNothing()
    {
        GameBox box  = new GomokuBox();
        Player a = new TestGomokuPlayer("player 1", StoneColor.WHITE);
        Players players = new GomokuPlayers(a, a);
        ConfigRule rule = new GomokuRequiredPlayerRule();

        GameManager manager = box.getManager(players);
        assertFalse(rule.isValid(manager));
        rule.set(manager);
        assertFalse(rule.isValid(manager));
    }
}