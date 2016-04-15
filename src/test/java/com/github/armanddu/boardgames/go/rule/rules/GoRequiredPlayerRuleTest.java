package com.github.armanddu.boardgames.go.rule.rules;

import com.github.armanddu.boardgames.lib.game.GameBox;
import com.github.armanddu.boardgames.lib.game.GameManager;
import com.github.armanddu.boardgames.go.board.GoBox;
import com.github.armanddu.boardgames.go.player.GomokuPlayers;
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
public class GoRequiredPlayerRuleTest {

    @Test
    public void testAsString() throws Exception {
        Rule rule = new GoRequiredPlayerRule();

        assertNotNull(rule.asString());
    }

    @Test
    public  void shouldBeValidIfHaveTwoPlayers()
    {
        GameBox box  = new GoBox();
        Player a = new TestGomokuPlayer("player 1", StoneColor.WHITE);
        Player b = new TestGomokuPlayer("player 2", StoneColor.BLACK);
        Players players = new GomokuPlayers(a, b);
        ConfigRule rule = new GoRequiredPlayerRule();

        assertTrue(rule.isValid(box.getManager(players)));
    }

    @Test
    public  void shouldNotBeValidIfHaveOnePlayers()
    {
        GameBox box  = new GoBox();
        Player a = new TestGomokuPlayer("player 1", StoneColor.WHITE);
        Players players = new GomokuPlayers();
        players.set(a);
        ConfigRule rule = new GoRequiredPlayerRule();

        assertFalse(rule.isValid(box.getManager(players)));
    }

    @Test
    public  void shouldNotBeValidIfHaveZeoPlayers()
    {
        GameBox box  = new GoBox();
        Players players = new GomokuPlayers();
        ConfigRule rule = new GoRequiredPlayerRule();

        assertFalse(rule.isValid(box.getManager(players)));
    }


    @Test
    public  void shouldBeValidIfHaveTwiceSamePlayer()
    {
        GameBox box  = new GoBox();
        Player a = new TestGomokuPlayer("player 1", StoneColor.WHITE);
        Players players = new GomokuPlayers(a, a);
        ConfigRule rule = new GoRequiredPlayerRule();

        assertFalse(rule.isValid(box.getManager(players)));
    }

    @Test
    public  void RuleSetDoesNothing()
    {
        GameBox box  = new GoBox();
        Player a = new TestGomokuPlayer("player 1", StoneColor.WHITE);
        Players players = new GomokuPlayers(a, a);
        ConfigRule rule = new GoRequiredPlayerRule();

        GameManager manager = box.getManager(players);
        assertFalse(rule.isValid(manager));
        rule.set(manager);
        assertFalse(rule.isValid(manager));
    }
}