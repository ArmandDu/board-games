package com.github.armanddu.boardgames.gomoku.rule.rules;

import com.github.armanddu.boardgames.lib.board.Board;
import com.github.armanddu.boardgames.lib.rule.StoneRule;
import org.junit.Test;
import resources.com.github.armanddu.boardgame.gomoku.board.TestGomokuBoardMap;
import resources.com.github.armanddu.boardgame.gomoku.stone.TestGomokuStoneMove;

import static org.junit.Assert.*;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GomokuIsPositionAvailableRuleTest {

    private  final StoneRule rule = new GomokuIsPositionAvailableRule();
    @Test
    public void shouldHaveRuleAsString()
    {
        assertNotNull(rule.asString());
    }

    @Test
    public void shouldBeValidIfSpaceIsFree()
    {
        Board board = new TestGomokuBoardMap();

        TestGomokuStoneMove move = new TestGomokuStoneMove(0, 0);
        assertNotNull(move);
        assertEquals(0, move.getSuggestedPosition().getX());
        assertEquals(0, move.getSuggestedPosition().getY());
        assertNull(board.getMap().get(0, 0));
        assertTrue(rule.isValid(board.getMap(), move));
    }


    @Test
    public void shouldNotBeValidIfSpaceIsNotFree()
    {
        Board board = new TestGomokuBoardMap();

        board.applyMove(new TestGomokuStoneMove(0, 0));
        TestGomokuStoneMove test = new TestGomokuStoneMove(0, 0);
        assertFalse(rule.isValid(board.getMap(), test));
    }
}