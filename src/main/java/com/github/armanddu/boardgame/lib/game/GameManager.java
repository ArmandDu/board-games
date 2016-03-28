package com.github.armanddu.boardgame.lib.game;

import java.util.List;

import com.github.armanddu.boardgame.lib.board.Board;
import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.player.Player;
import com.github.armanddu.boardgame.lib.player.Players;
import com.github.armanddu.boardgame.lib.stone.Stone;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StoneMove;
import com.github.armanddu.boardgame.lib.stone.StonePack;

public interface GameManager {

  Board getBoard();

  void applyMove(StoneMove move);

  void applyCaptures(StoneMove move);

  Player getStartingPlayer();

  Players getPlayers();

  StoneColor getNextTurn();

  StoneMove getLastMove();

  void updateStatus(StoneMove move);

  void setMapWidth(int width);

  void setMapHeight(int height);

  void setMap(int i, int j, Stone stone);

  BoardReader getMap();

  List<StonePack> getStonePacks();

}
