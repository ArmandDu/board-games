package com.github.armanddu.boardgames.gomoku.rule.rules;

import com.github.armanddu.boardgames.gomoku.board.GomokuBoard;
import com.github.armanddu.boardgames.gomoku.rule.GomokuRules;
import com.github.armanddu.boardgames.lib.board.Board;
import com.github.armanddu.boardgames.lib.rule.EndGameRule;
import com.github.armanddu.boardgames.lib.stone.StoneColor;
import org.junit.Test;
import resources.com.github.armanddu.boardgame.gomoku.stone.TestGomokuStoneMove;

import static org.junit.Assert.*;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GomokuTenCapturesRuleTest {

    private static final EndGameRule rule = new GomokuTenCapturesRule();

    @Test
    public void testAsString() throws Exception {
        assertNotNull(rule.asString());
    }

    @Test
    public void isValidIfScoreIs10()
    {
        Board board = new GomokuBoard(new GomokuRules());
        board.setScore(StoneColor.WHITE, 10);
        board.setScore(StoneColor.BLACK, 10);
        assertTrue(rule.isValid(board.getMap(), new TestGomokuStoneMove(StoneColor.WHITE, 0, 0)));
        assertTrue(rule.isValid(board.getMap(), new TestGomokuStoneMove(StoneColor.BLACK, 0, 0)));
    }
    @Test
    public void isValidIfScoreIsGreaterThan10()
    {
        Board board = new GomokuBoard(new GomokuRules());
        board.setScore(StoneColor.WHITE, 11);
        board.setScore(StoneColor.BLACK, 11);
        assertTrue(rule.isValid(board.getMap(), new TestGomokuStoneMove(StoneColor.WHITE, 0, 0)));
        assertTrue(rule.isValid(board.getMap(), new TestGomokuStoneMove(StoneColor.BLACK, 0, 0)));
    }

    @Test
    public void isNotValidIfScoreIsLessGreatThan10()
    {
        Board board = new GomokuBoard(new GomokuRules());
        board.setScore(StoneColor.WHITE, 9);
        board.setScore(StoneColor.BLACK, 9);
        assertFalse(rule.isValid(board.getMap(), new TestGomokuStoneMove(StoneColor.WHITE, 0, 0)));
        assertFalse(rule.isValid(board.getMap(), new TestGomokuStoneMove(StoneColor.BLACK, 0, 0)));
    }

    @Test
    public void isNotValidIfScoreIs0()
    {
        Board board = new GomokuBoard(new GomokuRules());
        board.setScore(StoneColor.WHITE, 0);
        board.setScore(StoneColor.BLACK, 0);
        assertFalse(rule.isValid(board.getMap(), new TestGomokuStoneMove(StoneColor.WHITE, 0, 0)));
        assertFalse(rule.isValid(board.getMap(), new TestGomokuStoneMove(StoneColor.BLACK, 0, 0)));

    }

    @Test
    public void isNotValidIfOnBoardCreation()
    {
        Board board = new GomokuBoard(new GomokuRules());
        assertFalse(rule.isValid(board.getMap(), new TestGomokuStoneMove(StoneColor.WHITE, 0, 0)));
        assertFalse(rule.isValid(board.getMap(), new TestGomokuStoneMove(StoneColor.BLACK, 0, 0)));
    }
}