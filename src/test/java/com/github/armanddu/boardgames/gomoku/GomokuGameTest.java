package com.github.armanddu.boardgames.gomoku;

import com.github.armanddu.boardgames.gomoku.board.GomokuBox;
import com.github.armanddu.boardgames.gomoku.referee.GomokuReferee;
import com.github.armanddu.boardgames.gomoku.stone.GomokuStonePosition;
import com.github.armanddu.boardgames.lib.broadcaster.Broadcaster;
import com.github.armanddu.boardgames.lib.game.Game;
import com.github.armanddu.boardgames.lib.game.GameBox;
import com.github.armanddu.boardgames.gomoku.game.GomokuGame;
import com.github.armanddu.boardgames.lib.player.Player;
import com.github.armanddu.boardgames.lib.referee.Referee;
import com.github.armanddu.boardgames.lib.stone.StoneColor;
import com.github.armanddu.boardgames.lib.stone.StonePosition;
import org.junit.Test;
import resources.com.github.armanddu.boardgame.gomoku.player.TestGomokuPlayer;
import resources.com.github.armanddu.boardgame.gomoku.referee.TestGomokuReferee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GomokuGameTest {

    @Test
    public void test() {

        Referee referee = new TestGomokuReferee();
        GameBox gameBox = null;
        Player player = null;
        List<Player> opponents = null;
        Broadcaster broadcaster = null;
        Game game = new GomokuGame(referee, gameBox, player, opponents, broadcaster);

        assertFalse(game.isEnded());
        assertFalse(game.isStarted());
        game.start();
        assertTrue(game.isStarted());
        assertTrue(game.isEnded());
        game.reset();
        assertFalse(game.isEnded());
        assertFalse(game.isStarted());
    }

    @Test
    public void ShouldBeAbleToPlayAGame()
    {
        Referee referee = new GomokuReferee();
        GameBox box = new GomokuBox();
        List<StonePosition> moves1 = new ArrayList<>();
        List<StonePosition> moves2 = new ArrayList<>();

        int x = box.getBoard().getWidth() / 2;
        int y = box.getBoard().getHeight() / 2;
        Arrays.asList(0,1,2,3,4).forEach(i -> {
            moves1.add(new GomokuStonePosition(x, y + i));
            moves2.add(new GomokuStonePosition(x + 1, y + i));
        });
        Player player1 = new TestGomokuPlayer("player 1", StoneColor.BLACK, moves1);
        Player player2 = new TestGomokuPlayer("player 1", StoneColor.WHITE, moves2);
        Game game = new GomokuGame(referee, box, player1, Collections.singletonList(player2), null);
        game.initGame();
        assertTrue(game.isValid());
        game.start();
        assertTrue(game.isEnded());
        assertTrue(game.isStarted());
    }


    @Test
    public void ShouldBeAbleToDetectNoPlay()
    {
        Referee referee = new GomokuReferee();
        GameBox box = new GomokuBox();
        Player player1 = new TestGomokuPlayer("player 1", StoneColor.BLACK);
        Player player2 = new TestGomokuPlayer("player 1", StoneColor.WHITE);
        Game game = new GomokuGame(referee, box, player1, Collections.singletonList(player2), null);
        referee.initGame(box, player1, Collections.singletonList(player2));game.start();
        game.initGame();
        assertTrue(game.isValid());
        assertFalse(game.isEnded());
        assertTrue(game.isStarted());
    }

}
