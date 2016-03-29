package com.github.armanddu.boardgame.gomoku.game;

import java.util.List;

import com.github.armanddu.boardgame.lib.broadcaster.Broadcaster;
import com.github.armanddu.boardgame.lib.game.GameBox;
import com.github.armanddu.boardgame.lib.game.Game;
import com.github.armanddu.boardgame.lib.player.Player;
import com.github.armanddu.boardgame.lib.referee.Referee;

public class GomokuGame implements Game {


  private final GameBox gameBox;
  private final Referee referee;
  private final Player player;
  private final  List<Player> opponents;
  private final Broadcaster broadcaster;
  private boolean started;
  private boolean ended;

  public GomokuGame(Referee referee, GameBox gameBox, Player player, List<Player> opponents,
                    Broadcaster broadcaster) {
    this.started = false;
    this.ended = false;
    this.gameBox = gameBox;
    this.referee = referee;
    this.player = player;
    this.opponents = opponents;
    this.broadcaster = broadcaster;
  }

  public boolean isValid() {
    return referee.isValidGame();
  }

  public boolean isStarted() {
    return this.started;
  }

  public boolean isEnded() {
    return this.ended;
  }

  public void start() {
    this.started = true;
    referee.initGame(this.gameBox, this.player, this.opponents);
    while (!referee.isEndGame()) {
      referee.updateGame();
      broadcaster.broadcast(gameBox.getBoard().getMap(), referee.getLastMove());
    }
    this.ended = referee.isEndGame();
  }

  public void reset() {
    this.started = false;
    this.ended = false;
  }

}
