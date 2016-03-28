package com.github.armanddu.boardgame.lib.referee;

import java.util.List;

import com.github.armanddu.boardgame.lib.game.GameBox;
import com.github.armanddu.boardgame.lib.player.Player;
import com.github.armanddu.boardgame.lib.stone.StoneMove;

public interface Referee {

  void updateStatus(StoneMove stoneMove);

  void initGame(GameBox gameBox, Player player, List<Player> opponents);

  boolean isValidMove(StoneMove move);

  boolean hasCaptures(StoneMove move);

  void applyMove(StoneMove move);

  void applyCaptures(StoneMove move);

  void initStartingPlayer();

  void setNextPlayerTurn();

  Player getCurrentPlayer();

  void updateGame();

  boolean isValidGame();

  boolean isEndGame();

  StoneMove getLastMove();

}
