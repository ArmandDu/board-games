package com.github.armanddu.boardgame.gomoku.rules;

import com.github.armanddu.boardgame.lib.board.Board;
import com.github.armanddu.boardgame.lib.rule.EndGameRule;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import org.junit.Test;
import resources.com.github.armanddu.boardgame.gomoku.board.TestGomokuBoardMap;
import resources.com.github.armanddu.boardgame.gomoku.stone.TestGomokuStoneMove;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class GomokuFiveInARowUnbreakableRuleTest {

    @Test
    public void canHaveRuleAsString()
    {
        EndGameRule rule = new GomokuFiveInARowUnbreakableRule();
        assertNotNull(rule.asString());
    }
    @Test
    public void shouldBeValidIfFiveInARowUnbreakableVertical() {
        Board board = new TestGomokuBoardMap();
        EndGameRule rule = new GomokuFiveInARowUnbreakableRule();

        TestGomokuStoneMove last = new TestGomokuStoneMove(3, 5);
        board.applyMove(new TestGomokuStoneMove(3, 1));
        board.applyMove(new TestGomokuStoneMove(3, 2));
        board.applyMove(new TestGomokuStoneMove(3, 3));
        board.applyMove(new TestGomokuStoneMove(3, 4));
        board.applyMove(last);
        System.out.println(board.getMap());
        assertTrue(rule.isValid(board.getMap(), last));
    }

    @Test
    public void shouldBeValidIfFiveInARowUnbreakableHorizontal() {
        Board board = new TestGomokuBoardMap();
        EndGameRule rule = new GomokuFiveInARowUnbreakableRule();

        TestGomokuStoneMove last = new TestGomokuStoneMove(5, 3);
        board.applyMove(new TestGomokuStoneMove(1, 3));
        board.applyMove(new TestGomokuStoneMove(2, 3));
        board.applyMove(new TestGomokuStoneMove(3, 3));
        board.applyMove(new TestGomokuStoneMove(4, 3));
        board.applyMove(last);
        System.out.println(board.getMap());
        assertTrue(rule.isValid(board.getMap(), last));
    }

    @Test
    public void shouldBeValidIfFiveInARowBreakableHorizontalCase2() {
        Board board = new TestGomokuBoardMap();
        EndGameRule rule = new GomokuFiveInARowUnbreakableRule();

        TestGomokuStoneMove last = new TestGomokuStoneMove(5, 3);
        board.applyMove(new TestGomokuStoneMove(1, 3));
        board.applyMove(new TestGomokuStoneMove(2, 3));
        board.applyMove(new TestGomokuStoneMove(3, 3));
        board.applyMove(new TestGomokuStoneMove(4, 3));
        board.applyMove(new TestGomokuStoneMove(StoneColor.BLACK, 3, 5));
        board.applyMove(new TestGomokuStoneMove(StoneColor.WHITE, 3, 4));
        board.applyMove(new TestGomokuStoneMove(StoneColor.WHITE, 3, 2));
        board.applyMove(last);
        System.out.println(board.getMap());
        assertTrue(rule.isValid(board.getMap(), last));
    }

    @Test
    public void shouldBeValidIfFiveInARowUnbreakableDiagonalLeft() {
        Board board = new TestGomokuBoardMap();
        EndGameRule rule = new GomokuFiveInARowUnbreakableRule();

        TestGomokuStoneMove last = new TestGomokuStoneMove(1, 5);
        board.applyMove(new TestGomokuStoneMove(5, 1));
        board.applyMove(new TestGomokuStoneMove(4, 2));
        board.applyMove(new TestGomokuStoneMove(3, 3));
        board.applyMove(new TestGomokuStoneMove(2, 4));
        board.applyMove(last);
        System.out.println(board.getMap());
        assertTrue(rule.isValid(board.getMap(), last));
    }

    @Test
    public void shouldBeValidIfFiveInARowUnbreakableDiagonalRight() {
        Board board = new TestGomokuBoardMap();
        EndGameRule rule = new GomokuFiveInARowUnbreakableRule();

        TestGomokuStoneMove last = new TestGomokuStoneMove(5, 5);
        board.applyMove(new TestGomokuStoneMove(1, 1));
        board.applyMove(new TestGomokuStoneMove(2, 2));
        board.applyMove(new TestGomokuStoneMove(3, 3));
        board.applyMove(new TestGomokuStoneMove(4, 4));
        board.applyMove(last);
        System.out.println(board.getMap());
        assertTrue(rule.isValid(board.getMap(), last));
    }

    @Test
    public void shouldNotBeValidIfFiveInARowBreakableVerticalCase1() {
        Board board = new TestGomokuBoardMap();
        EndGameRule rule = new GomokuFiveInARowUnbreakableRule();

        TestGomokuStoneMove last = new TestGomokuStoneMove(3, 5);
        board.applyMove(new TestGomokuStoneMove(3, 1));
        board.applyMove(new TestGomokuStoneMove(3, 2));
        board.applyMove(new TestGomokuStoneMove(3, 3));
        board.applyMove(new TestGomokuStoneMove(3, 4));
        board.applyMove(new TestGomokuStoneMove(StoneColor.BLACK, 5, 3));
        board.applyMove(new TestGomokuStoneMove(StoneColor.WHITE, 4, 4));
        board.applyMove(last);
        System.out.println(board.getMap());
        assertFalse(rule.isValid(board.getMap(), last));
    }

    @Test
    public void shouldNotBeValidIfFiveInARowBreakableVerticalCase2() {
        Board board = new TestGomokuBoardMap();
        EndGameRule rule = new GomokuFiveInARowUnbreakableRule();

        TestGomokuStoneMove last = new TestGomokuStoneMove(3, 5);
        board.applyMove(new TestGomokuStoneMove(3, 1));
        board.applyMove(new TestGomokuStoneMove(3, 2));
        board.applyMove(new TestGomokuStoneMove(3, 3));
        board.applyMove(new TestGomokuStoneMove(3, 4));
        board.applyMove(new TestGomokuStoneMove(StoneColor.BLACK, 5, 3));
        board.applyMove(new TestGomokuStoneMove(StoneColor.WHITE, 4, 2));
        board.applyMove(last);
        System.out.println(board.getMap());
        assertFalse(rule.isValid(board.getMap(), last));
    }

    @Test
    public void shouldNotBeValidIfFiveInARowBreakableVerticalCase3() {
        Board board = new TestGomokuBoardMap();
        EndGameRule rule = new GomokuFiveInARowUnbreakableRule();

        TestGomokuStoneMove last = new TestGomokuStoneMove(3, 5);
        board.applyMove(new TestGomokuStoneMove(3, 1));
        board.applyMove(new TestGomokuStoneMove(3, 2));
        board.applyMove(new TestGomokuStoneMove(3, 3));
        board.applyMove(new TestGomokuStoneMove(3, 4));
        board.applyMove(new TestGomokuStoneMove(StoneColor.BLACK, 5, 3));
        board.applyMove(new TestGomokuStoneMove(StoneColor.WHITE, 4, 3));
        board.applyMove(last);
        System.out.println(board.getMap());
        assertFalse(rule.isValid(board.getMap(), last));
    }

    @Test
    public void shouldNotBeValidIfFiveInARowBreakableHorizontalCase1() {
        Board board = new TestGomokuBoardMap();
        EndGameRule rule = new GomokuFiveInARowUnbreakableRule();

        TestGomokuStoneMove last = new TestGomokuStoneMove(5, 3);
        board.applyMove(new TestGomokuStoneMove(1, 3));
        board.applyMove(new TestGomokuStoneMove(2, 3));
        board.applyMove(new TestGomokuStoneMove(3, 3));
        board.applyMove(new TestGomokuStoneMove(4, 3));
        board.applyMove(new TestGomokuStoneMove(StoneColor.BLACK, 3, 5));
        board.applyMove(new TestGomokuStoneMove(StoneColor.WHITE, 4, 4));
        board.applyMove(last);
        System.out.println(board.getMap());
        assertFalse(rule.isValid(board.getMap(), last));
    }

    @Test
    public void shouldNotBeValidIfFiveInARowBreakableHorizontalCase2() {
        Board board = new TestGomokuBoardMap();
        EndGameRule rule = new GomokuFiveInARowUnbreakableRule();

        TestGomokuStoneMove last = new TestGomokuStoneMove(5, 3);
        board.applyMove(new TestGomokuStoneMove(1, 3));
        board.applyMove(new TestGomokuStoneMove(2, 3));
        board.applyMove(new TestGomokuStoneMove(3, 3));
        board.applyMove(new TestGomokuStoneMove(4, 3));
        board.applyMove(new TestGomokuStoneMove(StoneColor.BLACK, 3, 5));
        board.applyMove(new TestGomokuStoneMove(StoneColor.WHITE, 2, 4));
        board.applyMove(last);
        System.out.println(board.getMap());
        assertFalse(rule.isValid(board.getMap(), last));
    }

    @Test
    public void shouldNotBeValidIfFiveInARowBreakableHorizontalCase3() {
        Board board = new TestGomokuBoardMap();
        EndGameRule rule = new GomokuFiveInARowUnbreakableRule();

        TestGomokuStoneMove last = new TestGomokuStoneMove(5, 3);
        board.applyMove(new TestGomokuStoneMove(1, 3));
        board.applyMove(new TestGomokuStoneMove(2, 3));
        board.applyMove(new TestGomokuStoneMove(3, 3));
        board.applyMove(new TestGomokuStoneMove(4, 3));
        board.applyMove(new TestGomokuStoneMove(StoneColor.BLACK, 3, 5));
        board.applyMove(new TestGomokuStoneMove(StoneColor.WHITE, 3, 4));
        board.applyMove(last);
        System.out.println(board.getMap());
        assertFalse(rule.isValid(board.getMap(), last));
    }

}
