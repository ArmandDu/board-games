package com.github.armanddu.boardgames.go.referee;

import com.github.armanddu.boardgames.go.board.GoBox;
import com.github.armanddu.boardgames.go.rule.rules.GoMapSizeRule;
import com.github.armanddu.boardgames.go.rule.rules.GoStartingPlayerRule;
import com.github.armanddu.boardgames.go.rule.rules.GoTenCapturesRule;
import com.github.armanddu.boardgames.go.stone.GoStone;
import com.github.armanddu.boardgames.go.stone.GoStoneMove;
import com.github.armanddu.boardgames.lib.board.Board;
import com.github.armanddu.boardgames.lib.player.Player;
import com.github.armanddu.boardgames.lib.referee.Referee;
import com.github.armanddu.boardgames.lib.stone.StoneColor;
import org.junit.Test;
import resources.com.github.armanddu.boardgame.gomoku.player.TestGomokuPlayer;
import resources.com.github.armanddu.boardgame.gomoku.stone.TestGomokuStoneMove;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by armanddu on 29/03/16 for board-games.
 */
public class GoRefereeTest {

    @Test
    public void shouldInvalidateGameIfNotGameSet()
    {
        Referee referee = new GoReferee();

        assertFalse(referee.isValidGame());
    }

    @Test
    public void shouldValidateGameIfGameIsValid()
    {
        Referee referee = new GoReferee();

        GoBox gameBox = new GoBox();
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
        Referee referee = new GoReferee();

        GoBox gameBox = new GoBox();
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
        assertEquals(GoStartingPlayerRule.COLOR, referee.getCurrentPlayer().getStoneColor());
        assertEquals(GoStartingPlayerRule.COLOR, referee.getCurrentPlayer().getStonePack().getColor());
        assertTrue(gameBox.getStonePacks().isEmpty());
        assertEquals(GoMapSizeRule.WIDTH, gameBox.getBoard().getWidth());
        assertEquals(GoMapSizeRule.HEIGHT, gameBox.getBoard().getHeight());
        assertTrue(gameBox.getBoard().getStones().isEmpty());
    }

    @Test
    public void applyInvalidMoveShouldNotUpdateBoard()
    {
        Referee referee = new GoReferee();

        GoBox gameBox = new GoBox();
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
        Referee referee = new GoReferee();

        GoBox gameBox = new GoBox();
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
        Referee referee = new GoReferee();

        GoBox gameBox = new GoBox();
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
        Referee referee = new GoReferee();

        GoBox gameBox = new GoBox();
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
        Referee referee = new GoReferee();

        GoBox gameBox = new GoBox();
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
        GoStoneMove move = new GoStoneMove(new GoStone(player1.getStoneColor(), 0, 0), x, y);
        assertTrue(referee.isValidMove(move));
        move = new GoStoneMove(new GoStone(player1.getStoneColor(), 0, 0), 0, 0);
        assertFalse(referee.isValidMove(move));
    }

    @Test
    public void isEndGameIfFiveInARowUnBreakable()
    {
        Referee referee = new GoReferee();

        GoBox gameBox = new GoBox();
        Player player1 = new TestGomokuPlayer("player 1", StoneColor.BLACK);
        TestGomokuPlayer opponent = new TestGomokuPlayer("player 2", StoneColor.WHITE);
        List<Player> opponents = new ArrayList<>();
        opponents.add(opponent);
        referee.initGame(gameBox, player1, opponents);
        assertTrue(referee.isValidGame());
        int y = gameBox.getBoard().getHeight() / 2;
        int x = gameBox.getBoard().getWidth() / 2;
        referee.applyMove(new GoStoneMove(new GoStone(player1.getStoneColor(), 0, 0), x, y));
        referee.applyMove(new GoStoneMove(new GoStone(player1.getStoneColor(), 0, 0), x + 1, y));
        referee.applyMove(new GoStoneMove(new GoStone(player1.getStoneColor(), 0, 0), x + 2, y));
        referee.applyMove(new GoStoneMove(new GoStone(player1.getStoneColor(), 0, 0), x + 3, y));
        referee.applyMove(new GoStoneMove(new GoStone(player1.getStoneColor(), 0, 0), x + 4, y));
        assertTrue(referee.isEndGame());
    }

    @Test
    public void isEndGameIfFiveCaptures()
    {
        Referee referee = new GoReferee();

        GoBox gameBox = new GoBox();
        Player player1 = new TestGomokuPlayer("player 1", StoneColor.BLACK);
        TestGomokuPlayer opponent = new TestGomokuPlayer("player 2", StoneColor.WHITE);
        List<Player> opponents = new ArrayList<>();
        opponents.add(opponent);
        referee.initGame(gameBox, player1, opponents);
        assertTrue(referee.isValidGame());
        gameBox.getBoard().setScore(StoneColor.BLACK, GoTenCapturesRule.MIN_CAPTURES);
        int y = gameBox.getBoard().getHeight() / 2;
        int x = gameBox.getBoard().getWidth() / 2;
        referee.applyMove(new GoStoneMove(new GoStone(StoneColor.BLACK, 0, 0), x, y));
        assertTrue(referee.isEndGame());
    }
}