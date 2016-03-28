package com.github.armanddu.boardgame.gomoku.rules;

import com.github.armanddu.boardgame.game.GameBox;
import com.github.armanddu.boardgame.game.GameManager;
import com.github.armanddu.boardgame.gomoku.board.GomokuBox;
import com.github.armanddu.boardgame.rule.ConfigRule;
import org.junit.Test;
import resources.com.github.armanddu.boardgame.gomoku.stone.TestGomokuStoneMove;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GomokuInitialStonePositionRuleTest {

    @Test
    public  void canGetRuleAsString()
    {
        ConfigRule rule = new GomokuInitialStonePositionRule();
        assertNotNull(rule.asString());
    }

    @Test
    public  void emptyBoardShouldBeValid()
    {
        GameBox box = new GomokuBox();
        ConfigRule rule = new GomokuInitialStonePositionRule();

        assertTrue(rule.isValid(box.getManager(null)));
    }

    @Test
    public  void nonEmptyBoardShouldNotBeValid()
    {
        GameBox box = new GomokuBox();
        ConfigRule rule = new GomokuInitialStonePositionRule();

        box.getBoard().applyMove(new TestGomokuStoneMove(0,0));
        assertFalse(rule.isValid(box.getManager(null)));
    }

    @Test
    public  void nonEmptyBoardShouldBeValidAfterSet()
    {
        GameBox box = new GomokuBox();
        ConfigRule rule = new GomokuInitialStonePositionRule();
        GameManager manager = box.getManager(null);

        box.getBoard().applyMove(new TestGomokuStoneMove(0,0));
        assertFalse(rule.isValid(manager));
        rule.set(manager);
        assertTrue(rule.isValid(manager));
    }
}