package com.github.armanddu.boardgame.gomoku.referee;

import com.github.armanddu.boardgame.gomoku.board.GomokuBox;
import com.github.armanddu.boardgame.gomoku.rule.rules.GomokuMapSizeRule;
import com.github.armanddu.boardgame.gomoku.rule.rules.GomokuStartingPlayerRule;
import com.github.armanddu.boardgame.gomoku.rule.rules.GomokuTenCapturesRule;
import com.github.armanddu.boardgame.gomoku.stone.GomokuStone;
import com.github.armanddu.boardgame.gomoku.stone.GomokuStoneMove;
import com.github.armanddu.boardgame.lib.board.Board;
import com.github.armanddu.boardgame.lib.player.Player;
import com.github.armanddu.boardgame.lib.referee.Referee;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import org.junit.Test;
import resources.com.github.armanddu.boardgame.gomoku.player.TestGomokuPlayer;
import resources.com.github.armanddu.boardgame.gomoku.stone.TestGomokuStoneMove;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by armanddu on 29/03/16 for board-games.
 */
public class GomokuRefereeTest {

    @Test
    public void shouldInvalidateGameIfNotGameSet()
    {
        Referee referee = new GomokuReferee();

        assertFalse(referee.isValidGame());
    }

    @Test
    public void shouldValidateGameIfGameIsValid()
    {
        Referee referee = new GomokuReferee();

        GomokuBox gameBox = new GomokuBox();
        Player player1 = new TestGomokuPlayer("player 1", StoneColor.BLACK);
        TestGomokuPlayer opponent = new TestGomokuPlayer("player 2", StoneColor.WHITE);
        List<Player> opponents = new ArrayList<>();
        opponents.add(opponent);
        referee.initGame(gameBox, player1, opponents);
        assertTrue(referee.isValidGame());
    }

    @Test
    public void shouldBeAbleToInitGame()
    {
        Referee referee = new GomokuReferee();

        GomokuBox gameBox = new GomokuBox();
        Player player1 = new TestGomokuPlayer("player 1", StoneColor.BLACK);
        TestGomokuPlayer opponent = new TestGomokuPlayer("player 2", StoneColor.WHITE);
        List<Player> opponents = new ArrayList<>();
        opponents.add(opponent);

        assertNull(referee.getCurrentPlayer());
        assertNull(player1.getStonePack());
        assertNull(opponent.getStonePack());

        referee.initGame(gameBox, player1, opponents);


        assertEquals(StoneColor.BLACK, player1.getStonePack().getColor());
        assertEquals(StoneColor.WHITE, opponent.getStonePack().getColor());
        assertEquals("player 1", referee.getCurrentPlayer().getName());
        assertEquals(GomokuStartingPlayerRule.COLOR, referee.getCurrentPlayer().getStoneColor());
        assertEquals(GomokuStartingPlayerRule.COLOR, referee.getCurrentPlayer().getStonePack().getColor());
        assertTrue(gameBox.getStonePacks().isEmpty());
        assertEquals(GomokuMapSizeRule.WIDTH, gameBox.getBoard().getWidth());
        assertEquals(GomokuMapSizeRule.HEIGHT, gameBox.getBoard().getHeight());
        assertTrue(gameBox.getBoard().getStones().isEmpty());
    }

    @Test
    public void applyInvalidMoveShouldNotUpdateBoard()
    {
        Referee referee = new GomokuReferee();

        GomokuBox gameBox = new GomokuBox();
        Player player1 = new TestGomokuPlayer("player 1", StoneColor.BLACK);
        TestGomokuPlayer opponent = new TestGomokuPlayer("player 2", StoneColor.WHITE);
        List<Player> opponents = new ArrayList<>();
        opponents.add(opponent);
        referee.initGame(gameBox, player1, opponents);
        assertTrue(referee.isValidGame());

        assertTrue(gameBox.getBoard().getStones().isEmpty());
        referee.applyMove(new TestGomokuStoneMove(StoneColor.WHITE, 0, 0));
        assertTrue(gameBox.getBoard().getStones().isEmpty());
    }

    @Test
    public void applyValidMoveShouldUpdateBoard()
    {
        Referee referee = new GomokuReferee();

        GomokuBox gameBox = new GomokuBox();
        Player player1 = new TestGomokuPlayer("player 1", StoneColor.BLACK);
        TestGomokuPlayer opponent = new TestGomokuPlayer("player 2", StoneColor.WHITE);
        List<Player> opponents = new ArrayList<>();
        opponents.add(opponent);
        referee.initGame(gameBox, player1, opponents);
        assertTrue(referee.isValidGame());

        Board board = gameBox.getBoard();
        int x = board.getWidth() / 2;
        int y = board.getHeight() / 2;
        assertTrue(board.getStones().isEmpty());
        referee.applyMove(new TestGomokuStoneMove(StoneColor.BLACK, x, y));
        assertFalse(board.getStones().isEmpty());
        assertEquals(1, board.getStones().size());
        assertEquals(x, board.getStones().get(0).getX());
        assertEquals(y, board.getStones().get(0).getY());
        assertNotNull(board.get(x, y));
        assertEquals(StoneColor.BLACK, board.get(x, y).getColor());
    }

    @Test
    public void shouldBeAbleToChangeTurn()
    {
        Referee referee = new GomokuReferee();

        GomokuBox gameBox = new GomokuBox();
        Player player1 = new TestGomokuPlayer("player 1", StoneColor.BLACK);
        TestGomokuPlayer opponent = new TestGomokuPlayer("player 2", StoneColor.WHITE);
        List<Player> opponents = new ArrayList<>();
        opponents.add(opponent);
        referee.initGame(gameBox, player1, opponents);
        assertTrue(referee.isValidGame());
        assertEquals(player1.getStoneColor(), referee.getCurrentPlayer().getStoneColor());
        Board board = gameBox.getBoard();
        int x = board.getWidth() / 2;
        int y = board.getHeight() / 2;
        assertTrue(board.getStones().isEmpty());
        referee.applyMove(new TestGomokuStoneMove(StoneColor.BLACK, x, y));
        referee.setNextPlayerTurn();
        assertEquals(opponent.getStoneColor(), referee.getCurrentPlayer().getStoneColor());
        referee.setNextPlayerTurn();
        assertEquals(opponent.getStoneColor(), referee.getCurrentPlayer().getStoneColor());
    }

    @Test
    public void canValidateStoneMove()
    {
        Referee referee = new GomokuReferee();

        GomokuBox gameBox = new GomokuBox();
        Player player1 = new TestGomokuPlayer("player 1", StoneColor.BLACK);
        TestGomokuPlayer opponent = new TestGomokuPlayer("player 2", StoneColor.WHITE);
        List<Player> opponents = new ArrayList<>();
        opponents.add(opponent);
        referee.initGame(gameBox, player1, opponents);
        assertTrue(referee.isValidGame());

    }

    @Test
    public void isEndGameIfPlayerAbandoned()
    {
        Referee referee = new GomokuReferee();

        GomokuBox gameBox = new GomokuBox();
        Player player1 = new TestGomokuPlayer("player 1", StoneColor.BLACK);
        TestGomokuPlayer opponent = new TestGomokuPlayer("player 2", StoneColor.WHITE);
        List<Player> opponents = new ArrayList<>();
        opponents.add(opponent);
        referee.initGame(gameBox, player1, opponents);
        assertTrue(referee.isValidGame());
        assertFalse(referee.isEndGame());
        player1.abandon();
        assertTrue(referee.isEndGame());
        assertTrue(referee.isValidGame());
        int y = gameBox.getBoard().getHeight() / 2;
        int x = gameBox.getBoard().getWidth() / 2;
        GomokuStoneMove move = new GomokuStoneMove(new GomokuStone(player1.getStoneColor(), 0, 0), x, y);
        assertTrue(referee.isValidMove(move));
        move = new GomokuStoneMove(new GomokuStone(player1.getStoneColor(), 0, 0), 0, 0);
        assertFalse(referee.isValidMove(move));
    }

    @Test
    public void isEndGameIfFiveInARowUnBreakable()
    {
        Referee referee = new GomokuReferee();

        GomokuBox gameBox = new GomokuBox();
        Player player1 = new TestGomokuPlayer("player 1", StoneColor.BLACK);
        TestGomokuPlayer opponent = new TestGomokuPlayer("player 2", StoneColor.WHITE);
        List<Player> opponents = new ArrayList<>();
        opponents.add(opponent);
        referee.initGame(gameBox, player1, opponents);
        assertTrue(referee.isValidGame());
        int y = gameBox.getBoard().getHeight() / 2;
        int x = gameBox.getBoard().getWidth() / 2;
        referee.applyMove(new GomokuStoneMove(new GomokuStone(player1.getStoneColor(), 0, 0), x, y));
        referee.applyMove(new GomokuStoneMove(new GomokuStone(player1.getStoneColor(), 0, 0), x + 1, y));
        referee.applyMove(new GomokuStoneMove(new GomokuStone(player1.getStoneColor(), 0, 0), x + 2, y));
        referee.applyMove(new GomokuStoneMove(new GomokuStone(player1.getStoneColor(), 0, 0), x + 3, y));
        referee.applyMove(new GomokuStoneMove(new GomokuStone(player1.getStoneColor(), 0, 0), x + 4, y));
        assertTrue(referee.isEndGame());
    }

    @Test
    public void isEndGameIfFiveCaptures()
    {
        Referee referee = new GomokuReferee();

        GomokuBox gameBox = new GomokuBox();
        Player player1 = new TestGomokuPlayer("player 1", StoneColor.BLACK);
        TestGomokuPlayer opponent = new TestGomokuPlayer("player 2", StoneColor.WHITE);
        List<Player> opponents = new ArrayList<>();
        opponents.add(opponent);
        referee.initGame(gameBox, player1, opponents);
        assertTrue(referee.isValidGame());
        gameBox.getBoard().setScore(StoneColor.BLACK, GomokuTenCapturesRule.MIN_CAPTURES);
        int y = gameBox.getBoard().getHeight() / 2;
        int x = gameBox.getBoard().getWidth() / 2;
        referee.applyMove(new GomokuStoneMove(new GomokuStone(StoneColor.BLACK, 0, 0), x, y));
        assertTrue(referee.isEndGame());
    }
}