package com.github.armanddu.boardgame.gomoku;

import com.github.armanddu.boardgame.broadcaster.Broadcaster;
import com.github.armanddu.boardgame.game.Game;
import com.github.armanddu.boardgame.game.GameBox;
import com.github.armanddu.boardgame.gomoku.game.GomokuGame;
import com.github.armanddu.boardgame.player.Player;
import com.github.armanddu.boardgame.referee.Referee;
import org.junit.Test;
import resources.com.github.armanddu.boardgame.gomoku.referee.TestGomokuReferee;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GomokuTest {

  @Test
  public void GomokuGameTest() {

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

}
