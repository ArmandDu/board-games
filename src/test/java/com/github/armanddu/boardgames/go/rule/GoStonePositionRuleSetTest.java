package com.github.armanddu.boardgames.go.rule;

import com.github.armanddu.boardgames.go.rule.rules.GoDoubleThreeRule;
import com.github.armanddu.boardgames.go.rule.rules.GoFirstMoveInCenterRule;
import com.github.armanddu.boardgames.go.rule.rules.GoIsNextToOtherStoneRule;
import com.github.armanddu.boardgames.go.rule.rules.GoIsPositionAvailableRule;
import com.github.armanddu.boardgames.lib.board.Board;
import com.github.armanddu.boardgames.lib.rule.Rule;
import com.github.armanddu.boardgames.lib.rule.StoneRuleSet;
import com.github.armanddu.boardgames.lib.stone.StoneColor;
import com.github.armanddu.boardgames.lib.stone.StoneMove;
import org.junit.Test;
import resources.com.github.armanddu.boardgame.gomoku.board.TestGomokuBoardMap;
import resources.com.github.armanddu.boardgame.gomoku.stone.TestGomokuStoneMove;

import static org.junit.Assert.*;

/**
 * Created by armanddu on 29/03/16 for board-games.
 */
public class GoStonePositionRuleSetTest {

    StoneRuleSet set = new GoStonePositionRuleSet();

    @Test
    public void shouldBeValidIfFirstStoneAndPutInCenter()
    {
        Board board = new TestGomokuBoardMap();
        StoneMove last = new TestGomokuStoneMove(board.getWidth() / 2, board.getHeight() / 2);
        assertTrue(set.isValid(board.getMap(), last));
    }

    @Test
    public void shouldBeValidIfSecondStoneAndPutNextToCenter()
    {
        Board board = new TestGomokuBoardMap();
        int x0 = board.getWidth() / 2;
        int y0 = board.getHeight() / 2;
        StoneMove last = new TestGomokuStoneMove(x0, y0 + 1);
        board.applyMove(new TestGomokuStoneMove(x0, y0));
        assertTrue(set.isValid(board.getMap(), last));
    }

    @Test
    public void shouldBeValidIfIsNotDoubleThree()
    {
        Board board = new TestGomokuBoardMap();
        int x0 = board.getWidth() / 2;
        int y0 = board.getHeight() / 2;

        TestGomokuStoneMove last = new TestGomokuStoneMove(x0, y0 - 2);
        board.applyMove(new TestGomokuStoneMove(x0, y0));
        board.applyMove(new TestGomokuStoneMove(StoneColor.BLACK, x0 - 3, y0));
        board.applyMove(new TestGomokuStoneMove(x0, y0 - 1));
        board.applyMove(new TestGomokuStoneMove(x0 - 2, y0));
        board.applyMove(new TestGomokuStoneMove(y0 - 1, y0));
        System.out.println(board.getMap());
        assertTrue(set.isValid(board.getMap(), last));
    }

    @Test
    public void shouldNotBeValidIfFirstStoneAndNotPutInCenter()
    {
        Board board = new TestGomokuBoardMap();
        StoneMove last = new TestGomokuStoneMove(0, 0);
        assertFalse(set.isValid(board.getMap(), last));
        Rule rule = set.getLastInvalid(board.getMap(), last);
        assertEquals(GoFirstMoveInCenterRule.class, rule.getClass());
    }

    @Test
    public void shouldNotBeValidIfStoneIsNotNextToOtherStone()
    {
        Board board = new TestGomokuBoardMap();
        int x0 = board.getWidth() / 2;
        int y0 = board.getHeight() / 2;
        StoneMove last = new TestGomokuStoneMove(x0, y0 + 2);
        board.applyMove(new TestGomokuStoneMove(x0, y0));
        assertFalse(set.isValid(board.getMap(), last));
        Rule rule = set.getLastInvalid(board.getMap(), last);
        assertEquals(GoIsNextToOtherStoneRule.class, rule.getClass());
    }

    @Test
    public void shouldNotBeValidIfSpaceIsNotFree()
    {
        Board board = new TestGomokuBoardMap();
        int x0 = board.getWidth() / 2;
        int y0 = board.getHeight() / 2;
        StoneMove last = new TestGomokuStoneMove(x0, y0);
        board.applyMove(new TestGomokuStoneMove(x0, y0));
        assertFalse(set.isValid(board.getMap(), last));
        Rule rule = set.getLastInvalid(board.getMap(), last);
        assertEquals(GoIsPositionAvailableRule.class, rule.getClass());
    }

    @Test
    public void shouldNotBeValidIfDoubleThreeOccurred()
    {
        Board board = new TestGomokuBoardMap();
        int x0 = board.getWidth() / 2;
        int y0 = board.getHeight() / 2;

        TestGomokuStoneMove last = new TestGomokuStoneMove(x0, y0 - 2);
        board.applyMove(new TestGomokuStoneMove(x0, y0));
        board.applyMove(new TestGomokuStoneMove(x0, y0 - 1));
        board.applyMove(new TestGomokuStoneMove(x0 - 2, y0));
        board.applyMove(new TestGomokuStoneMove(x0 - 1, y0));
        System.out.println(board.getMap());
        assertFalse(set.isValid(board.getMap(), last));
        Rule rule = set.getLastInvalid(board.getMap(), last);
        assertEquals(GoDoubleThreeRule.class, rule.getClass());
    }

}