package com.github.armanddu.boardgame.gomoku.rule.rules;

import com.github.armanddu.boardgame.gomoku.rule.rules.GomokuInitialStonePositionRule;
import com.github.armanddu.boardgame.lib.board.Board;
import com.github.armanddu.boardgame.lib.game.GameBox;
import com.github.armanddu.boardgame.lib.game.GameManager;
import com.github.armanddu.boardgame.gomoku.board.GomokuBox;
import com.github.armanddu.boardgame.lib.rule.ConfigRule;
import org.junit.Test;
import resources.com.github.armanddu.boardgame.game.TestGameManager;
import resources.com.github.armanddu.boardgame.gomoku.board.TestGomokuBoardMap;
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
        Board board = new TestGomokuBoardMap();
        GameManager manager = new TestGameManager(board);
        ConfigRule rule = new GomokuInitialStonePositionRule();

        manager.getBoard().applyMove(new TestGomokuStoneMove(0, 0));
        assertFalse(rule.isValid(manager));
    }

    @Test
    public  void nonEmptyBoardShouldBeValidAfterSet()
    {
        Board board = new TestGomokuBoardMap();
        GameManager manager = new TestGameManager(board);
        ConfigRule rule = new GomokuInitialStonePositionRule();

        manager.getBoard().applyMove(new TestGomokuStoneMove(0,0));
        assertFalse(rule.isValid(manager));
        rule.set(manager);
        assertTrue(rule.isValid(manager));
    }
}