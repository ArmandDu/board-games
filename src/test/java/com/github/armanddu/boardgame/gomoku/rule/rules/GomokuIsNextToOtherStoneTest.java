package com.github.armanddu.boardgame.gomoku.rule.rules;

import com.github.armanddu.boardgame.gomoku.rule.rules.GomokuIsNextToOtherStoneRule;
import com.github.armanddu.boardgame.lib.board.Board;
import com.github.armanddu.boardgame.lib.rule.StoneRule;
import org.junit.Test;
import resources.com.github.armanddu.boardgame.gomoku.board.TestGomokuBoardMap;
import resources.com.github.armanddu.boardgame.gomoku.stone.TestGomokuStoneMove;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GomokuIsNextToOtherStoneTest {

    public static final int X0 = 2;
    private static final int Y0 = 2;
    StoneRule rule = new GomokuIsNextToOtherStoneRule();

    @Test
    public void testAsString() throws Exception {
        assertNotNull(rule.asString());
    }

    @Test
    public void shouldBeValidIfMapIsEmpty()
    {
        Board board = new TestGomokuBoardMap();
        TestGomokuStoneMove last = new TestGomokuStoneMove(3, 5);

        assertTrue(rule.isValid(board.getMap(), last));
    }

    @Test
    public void shouldBeValidIfNewStoneNextToAnOtherAllCases()
    {
        Board board = new TestGomokuBoardMap();
        TestGomokuStoneMove cases[] = {new TestGomokuStoneMove(X0 - 1, Y0 - 1),
                new TestGomokuStoneMove(X0 - 1, Y0 - 0),
                new TestGomokuStoneMove(X0 - 1, Y0 + 1),
                new TestGomokuStoneMove(X0, Y0 + 1),
                new TestGomokuStoneMove(X0, Y0 - 1),
                new TestGomokuStoneMove(X0 + 1, Y0 - 1),
                new TestGomokuStoneMove(X0 + 1, Y0 + 0),
                new TestGomokuStoneMove(X0 + 1, Y0 + 1)
        };

        board.applyMove(new TestGomokuStoneMove(X0, Y0));
        for (TestGomokuStoneMove aCase : cases) {
            assertTrue(rule.isValid(board.getMap(), aCase));
        }
    }

    @Test
    public void shouldNotBeValidIfNewStoneIsNotNextToAnOtherAllCase()
    {
        Board board = new TestGomokuBoardMap();
        TestGomokuStoneMove cases[] = {new TestGomokuStoneMove(X0 + -2, Y0 + -2),
            new TestGomokuStoneMove(X0 + -2, Y0 + -1),
            new TestGomokuStoneMove(X0 + -2, Y0 + 0),
            new TestGomokuStoneMove(X0 + -2, Y0 + 1),
            new TestGomokuStoneMove(X0 + -2, Y0 + 2),
            new TestGomokuStoneMove(X0 + -1, Y0 + -2),
            new TestGomokuStoneMove(X0 + -1, Y0 + 2),
            new TestGomokuStoneMove(X0 + 0, Y0 + -2),
            new TestGomokuStoneMove(X0 + 0, Y0 + 2),
            new TestGomokuStoneMove(X0 + 1, Y0 + -2),
            new TestGomokuStoneMove(X0 + 1, Y0 + 2),
            new TestGomokuStoneMove(X0 + 2, Y0 + -2),
            new TestGomokuStoneMove(X0 + 2, Y0 + -1),
            new TestGomokuStoneMove(X0 + 2, Y0 + 0),
            new TestGomokuStoneMove(X0 + 2, Y0 + 1),
            new TestGomokuStoneMove(X0 + 2, Y0 + 2)};

        board.applyMove(new TestGomokuStoneMove(X0, Y0));
        for (TestGomokuStoneMove aCase : cases) {
            assertFalse(rule.isValid(board.getMap(), aCase));
        }
    }

}