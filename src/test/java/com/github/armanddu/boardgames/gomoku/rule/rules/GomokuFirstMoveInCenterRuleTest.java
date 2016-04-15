package com.github.armanddu.boardgames.gomoku.rule.rules;

import com.github.armanddu.boardgames.lib.board.Board;
import com.github.armanddu.boardgames.lib.rule.StoneRule;
import org.junit.Test;
import resources.com.github.armanddu.boardgame.gomoku.board.TestGomokuBoardMap;
import resources.com.github.armanddu.boardgame.gomoku.stone.TestGomokuStoneMove;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GomokuFirstMoveInCenterRuleTest {

    StoneRule rule = new GomokuFirstMoveInCenterRule();

    @Test
    public void shouldHaveRuleHasString()
    {
        assertNotNull(rule.asString());
    }

    @Test
    public void shouldBeValidIfFirstMoveInCenter()
    {
        Board board = new TestGomokuBoardMap();

        TestGomokuStoneMove move = new TestGomokuStoneMove(board.getHeight() / 2, board.getWidth() / 2);
        assertTrue(rule.isValid(board.getMap(), move));
    }

    @Test
    public void shouldBeValidIfMapIsNotEmpty()
    {
        Board board = new TestGomokuBoardMap();

        TestGomokuStoneMove move = new TestGomokuStoneMove(board.getHeight() / 2, board.getWidth() / 2);
        board.applyMove(move);
        move = new TestGomokuStoneMove(0, 0);
        assertTrue(rule.isValid(board.getMap(), move));
    }

    @Test
    public void shouldNotBeValidIfFirstMoveNotInCenter()
    {
        Board board = new TestGomokuBoardMap();

        TestGomokuStoneMove move;
        move = new TestGomokuStoneMove(0, 0);
        assertFalse(rule.isValid(board.getMap(), move));
    }
}