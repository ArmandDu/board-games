package com.github.armanddu.boardgame.gomoku.rule.rules;

import com.github.armanddu.boardgame.gomoku.rule.rules.GomokuChangeTurnRule;
import com.github.armanddu.boardgame.lib.board.Board;
import com.github.armanddu.boardgame.lib.rule.Rule;
import com.github.armanddu.boardgame.lib.rule.StoneRule;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import org.junit.Test;
import resources.com.github.armanddu.boardgame.gomoku.board.TestGomokuBoardMap;
import resources.com.github.armanddu.boardgame.gomoku.stone.TestGomokuStoneMove;

import static org.junit.Assert.*;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GomokuChangeTurnRuleTest {

    @Test
    public void testAsString() throws Exception {
        Rule rule = new GomokuChangeTurnRule();

        assertNotNull(rule.asString());
    }

    @Test
    public  void shouldChangeTurn()
    {
        StoneRule rule = new GomokuChangeTurnRule();
        Board board = new TestGomokuBoardMap();

        TestGomokuStoneMove last = new TestGomokuStoneMove(StoneColor.BLACK, 0, 0);
        board.applyMove(last);
        assertTrue(rule.isValid(board.getMap(), last));
        last = new TestGomokuStoneMove(StoneColor.WHITE, 1, 0);
        board.applyMove(last);
        assertTrue(rule.isValid(board.getMap(), last));
        last = new TestGomokuStoneMove(StoneColor.BLACK, 2, 0);
        board.applyMove(last);
        assertTrue(rule.isValid(board.getMap(), last));
    }

    @Test
    public  void shouldNotChangeTurnIfNotMovedAnyStone()
    {
        StoneRule rule = new GomokuChangeTurnRule();
        Board board = new TestGomokuBoardMap();

        TestGomokuStoneMove last = new TestGomokuStoneMove(StoneColor.BLACK, 0, 0);
        board.applyMove(last);
        assertTrue(rule.isValid(board.getMap(), last));
        last = new TestGomokuStoneMove(StoneColor.WHITE, 0, 0);
        assertFalse(rule.isValid(board.getMap(), last));
    }
}