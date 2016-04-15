package com.github.armanddu.boardgames.go.rule.rules;

import com.github.armanddu.boardgames.lib.board.Board;
import com.github.armanddu.boardgames.lib.game.GameBox;
import com.github.armanddu.boardgames.lib.game.GameManager;
import com.github.armanddu.boardgames.go.board.GoBox;
import com.github.armanddu.boardgames.lib.rule.ConfigRule;
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
public class GoInitialStonePositionRuleTest {

    @Test
    public  void canGetRuleAsString()
    {
        ConfigRule rule = new GoInitialStonePositionRule();
        assertNotNull(rule.asString());
    }

    @Test
    public  void emptyBoardShouldBeValid()
    {
        GameBox box = new GoBox();
        ConfigRule rule = new GoInitialStonePositionRule();

        assertTrue(rule.isValid(box.getManager(null)));
    }

    @Test
    public  void nonEmptyBoardShouldNotBeValid()
    {
        Board board = new TestGomokuBoardMap();
        GameManager manager = new TestGameManager(board);
        ConfigRule rule = new GoInitialStonePositionRule();

        manager.getBoard().applyMove(new TestGomokuStoneMove(0, 0));
        assertFalse(rule.isValid(manager));
    }

    @Test
    public  void nonEmptyBoardShouldBeValidAfterSet()
    {
        Board board = new TestGomokuBoardMap();
        GameManager manager = new TestGameManager(board);
        ConfigRule rule = new GoInitialStonePositionRule();

        manager.getBoard().applyMove(new TestGomokuStoneMove(0,0));
        assertFalse(rule.isValid(manager));
        rule.set(manager);
        assertTrue(rule.isValid(manager));
    }
}