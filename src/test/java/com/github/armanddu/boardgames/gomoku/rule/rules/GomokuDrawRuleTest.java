package com.github.armanddu.boardgames.gomoku.rule.rules;

import static org.junit.Assert.*;

import org.junit.Test;

import resources.com.github.armanddu.boardgame.gomoku.board.TestGomokuBoardMap;
import resources.com.github.armanddu.boardgame.gomoku.stone.TestGomokuStoneMove;
import com.github.armanddu.boardgames.lib.board.Board;
import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.rule.EndGameRule;
import com.github.armanddu.boardgames.lib.stone.StoneMove;

public class GomokuDrawRuleTest {

    @Test
    public void canHaveRuleAsString()
    {
        EndGameRule rule = new GomokuDrawRule();
        assertNotNull(rule.asString());
    }

    @Test
    public void drawRuleShouldReturnFalseIfMapIsEmpty() {
        Board map = new TestGomokuBoardMap();
        map.setHeight(2);
        map.setWidth(2);
        BoardReader manipulator = map.getMap();
        EndGameRule rule = new GomokuDrawRule();
        int x = 1;
        int y = 1;
        StoneMove stoneMove = new TestGomokuStoneMove(x, y);
        assertFalse(rule.isValid(manipulator, stoneMove));
    }

    @Test
    public void drawRuleShouldReturnTrueIfMapIsFull() {
        Board map = new TestGomokuBoardMap();
        map.setHeight(2);
        map.setWidth(2);
        BoardReader manipulator = map.getMap();
        EndGameRule rule = new GomokuDrawRule();
        int x = 1;
        int y = 1;
        map.applyMove(new TestGomokuStoneMove(0, 0));
        map.applyMove(new TestGomokuStoneMove(0, 1));
        map.applyMove(new TestGomokuStoneMove(1, 0));
        map.applyMove(new TestGomokuStoneMove(1, 1));
        StoneMove stoneMove = new TestGomokuStoneMove(x, y);
        assertTrue(rule.isValid(manipulator, stoneMove));
    }

    @Test
    public void drawRuleShouldReturnFalseIfMapIsHalfFull() {
        Board map = new TestGomokuBoardMap();
        map.setHeight(2);
        map.setWidth(2);
        BoardReader manipulator = map.getMap();
        EndGameRule rule = new GomokuDrawRule();
        int x = 1;
        int y = 1;
        map.applyMove(new TestGomokuStoneMove(0, 0));
        map.applyMove(new TestGomokuStoneMove(1, 1));
        StoneMove stoneMove = new TestGomokuStoneMove(x, y);
        assertFalse(rule.isValid(manipulator, stoneMove));
    }

    @Test
    public void drawRuleShouldReturnTrueIfMapIsOneSpaceLeftAndStoneIsPlaceInThatSpace() {
        Board map = new TestGomokuBoardMap();
        map.setHeight(2);
        map.setWidth(2);
        BoardReader manipulator = map.getMap();
        EndGameRule rule = new GomokuDrawRule();
        int x = 1;
        int y = 1;
        map.applyMove(new TestGomokuStoneMove(0, 0));
        map.applyMove(new TestGomokuStoneMove(0, 1));
        map.applyMove(new TestGomokuStoneMove(1, 0));
        StoneMove stoneMove = new TestGomokuStoneMove(x, y);
        assertTrue(rule.isValid(manipulator, stoneMove));
    }
}
