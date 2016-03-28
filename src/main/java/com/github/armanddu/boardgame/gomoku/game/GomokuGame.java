package com.github.armanddu.boardgame.gomoku.game;

import java.util.List;

import com.github.armanddu.boardgame.broadcaster.Broadcaster;
import com.github.armanddu.boardgame.game.GameBox;
import com.github.armanddu.boardgame.game.Game;
import com.github.armanddu.boardgame.player.Player;
import com.github.armanddu.boardgame.referee.Referee;
import com.github.armanddu.boardgame.stone.StoneMove;

public class GomokuGame implements Game {


  private GameBox gameBox;
  private Referee referee;
  private Player player;
  private List<Player> opponents;
  private boolean started;
  private boolean ended;
  private Broadcaster broadcaster;

  public GomokuGame(Referee referee, GameBox gameBox, Player player, List<Player> opponents,
      Broadcaster broadcaster) {
    this.setGameBox(gameBox);
    this.setReferee(referee);
    this.setPlayer(player);
    this.setOpponents(opponents);
    this.setBroadcaster(broadcaster);
    this.started = false;
    this.ended = false;
  }

  private void setBroadcaster(Broadcaster broadcaster) {
    this.broadcaster = broadcaster;
  }

  private void setOpponents(List<Player> opponents) {
    this.opponents = opponents;
  }

  private void setPlayer(Player player) {
    this.player = player;
  }

  private void setReferee(Referee referee) {
    this.referee = referee;
  }

  private void setGameBox(GameBox gameBox) {
    this.gameBox = gameBox;
  }

  public boolean isValidRequirements() {
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
