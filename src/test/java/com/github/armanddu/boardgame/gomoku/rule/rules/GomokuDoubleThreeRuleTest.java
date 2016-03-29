package com.github.armanddu.boardgame.gomoku.rule.rules;

import com.github.armanddu.boardgame.gomoku.stone.GomokuStone;
import com.github.armanddu.boardgame.gomoku.stone.GomokuStoneNode;
import com.github.armanddu.boardgame.lib.board.Board;
import com.github.armanddu.boardgame.lib.rule.StoneRule;
import com.github.armanddu.boardgame.lib.stone.Stone;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StoneNode;
import com.github.armanddu.boardgame.lib.stone.StonePosition;
import org.junit.Test;
import resources.com.github.armanddu.boardgame.gomoku.board.TestGomokuBoardMap;
import resources.com.github.armanddu.boardgame.gomoku.stone.TestGomokuStoneMove;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GomokuDoubleThreeRuleTest {

    StoneRule rule = new GomokuDoubleThreeRule();

    @Test
    public void testAsString() throws Exception {
        assertNotNull(rule.asString());
    }

    @Test
    public void shouldBeValidIfNoDoubleThree()
    {
        Board board = new TestGomokuBoardMap();

        TestGomokuStoneMove last = new TestGomokuStoneMove(4, 4);
        assertTrue(rule.isValid(board.getMap(), last));
    }

    @Test
    public void shouldBeValidIfNoDoubleThreeCase2()
    {
        Board board = new TestGomokuBoardMap();

        TestGomokuStoneMove last = new TestGomokuStoneMove(4, 4);
        board.applyMove(new TestGomokuStoneMove(4, 3));
        board.applyMove(new TestGomokuStoneMove(2, 4));
        board.applyMove(new TestGomokuStoneMove(3, 4));
        System.out.println(board.getMap());
        assertTrue(rule.isValid(board.getMap(), last));
    }

    @Test
    public void shouldNotBeValidIfSimpleCaseDoubleThreeOccurred()
    {
        Board board = new TestGomokuBoardMap();

        TestGomokuStoneMove last = new TestGomokuStoneMove(4, 4);
        board.applyMove(new TestGomokuStoneMove(4, 2));
        board.applyMove(new TestGomokuStoneMove(4, 3));
        board.applyMove(new TestGomokuStoneMove(2, 4));
        board.applyMove(new TestGomokuStoneMove(3, 4));
        System.out.println(board.getMap());
        assertFalse(rule.isValid(board.getMap(), last));
    }

    @Test
    public void shouldNotBeValidIfMediumCaseDoubleThreeOccurred()
    {
        Board board = new TestGomokuBoardMap();

        TestGomokuStoneMove last = new TestGomokuStoneMove(4, 3);
        board.applyMove(new TestGomokuStoneMove(4, 2));
        board.applyMove(new TestGomokuStoneMove(4, 4));
        board.applyMove(new TestGomokuStoneMove(2, 4));
        board.applyMove(new TestGomokuStoneMove(3, 4));
        System.out.println(board.getMap());
        assertFalse(rule.isValid(board.getMap(), last));

    }

    @Test
    public void shouldNotBeValidIfMediumCase2DoubleThreeOccurred()
    {
        Board board = new TestGomokuBoardMap();

        TestGomokuStoneMove last = new TestGomokuStoneMove(4, 2);
        board.applyMove(new TestGomokuStoneMove(4, 4));
        board.applyMove(new TestGomokuStoneMove(4, 3));
        board.applyMove(new TestGomokuStoneMove(2, 4));
        board.applyMove(new TestGomokuStoneMove(3, 4));
        System.out.println(board.getMap());
        assertFalse(rule.isValid(board.getMap(), last));
    }

    @Test
    public void shouldBeValidIfIsNotFree()
    {
        Board board = new TestGomokuBoardMap();

        TestGomokuStoneMove last = new TestGomokuStoneMove(4, 2);
        board.applyMove(new TestGomokuStoneMove(StoneColor.BLACK, 1, 4));
        board.applyMove(new TestGomokuStoneMove(4, 4));
        board.applyMove(new TestGomokuStoneMove(4, 3));
        board.applyMove(new TestGomokuStoneMove(2, 4));
        board.applyMove(new TestGomokuStoneMove(3, 4));
        System.out.println(board.getMap());
        assertTrue(rule.isValid(board.getMap(), last));
    }

    @Test
    public void shouldBeValidIfIsNotFreeCase2()
    {
        Board board = new TestGomokuBoardMap();

        TestGomokuStoneMove last = new TestGomokuStoneMove(4, 2);
        board.applyMove(new TestGomokuStoneMove(StoneColor.BLACK, 4, 1));
        board.applyMove(new TestGomokuStoneMove(4, 4));
        board.applyMove(new TestGomokuStoneMove(4, 3));
        board.applyMove(new TestGomokuStoneMove(2, 4));
        board.applyMove(new TestGomokuStoneMove(3, 4));
        System.out.println(board.getMap());
        assertTrue(rule.isValid(board.getMap(), last));
    }

}