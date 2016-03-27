package com.github.armanddu.boardgame.referee;

import java.util.List;

import com.github.armanddu.boardgame.game.GameBox;
import com.github.armanddu.boardgame.player.Player;
import com.github.armanddu.boardgame.stone.StoneMove;

public interface Referee {

  void updateStatus(StoneMove stoneMove);

  void initGame(GameBox gameBox, Player player, List<Player> opponents);

  boolean isValidMove(StoneMove stoneMove);

  boolean hasCaptures(StoneMove stoneMove);

  void applyMove(StoneMove stoneMove);

  void applyCaptures(StoneMove stoneMove);

  void initStartingPlayer();

  void setNextPlayerTurn();

  Player getCurrentPlayer();

  void updateGame();

  boolean isValidGame();

  boolean isEndGame();

  StoneMove getLastMove();

}
