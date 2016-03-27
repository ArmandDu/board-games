package com.github.armanddu.boardgame.game;

import java.util.List;

import com.github.armanddu.boardgame.map.Board;
import com.github.armanddu.boardgame.map.BoardReader;
import com.github.armanddu.boardgame.player.Player;
import com.github.armanddu.boardgame.player.Players;
import com.github.armanddu.boardgame.stone.Stone;
import com.github.armanddu.boardgame.stone.StoneColor;
import com.github.armanddu.boardgame.stone.StoneMove;
import com.github.armanddu.boardgame.stone.StonePack;

public interface GameManager {

  Board getBoard();

  void applyMove(StoneMove stoneMove);

  void applyCaptures(StoneMove stoneMove);

  Player getStartingPlayer();

  Players getPlayers();

  StoneColor getNextTurn();

  StoneMove getLastMove();

  void updateStatus(StoneMove stoneMove);

  void setMapWidth(int width);

  void setMapHeight(int height);

  void setMap(int i, int j, Stone stone);

  BoardReader getMap();

  List<StonePack> getStonePacks();

}
