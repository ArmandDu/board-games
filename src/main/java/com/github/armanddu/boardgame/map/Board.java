package com.github.armanddu.boardgame.map;

import com.github.armanddu.boardgame.stone.Stone;
import com.github.armanddu.boardgame.stone.StoneMove;

public interface Board {

  Stone get(int x, int y);

  int getWidth();

  int getHeight();

  boolean isValidMove(StoneMove stoneMove);

  void applyMove(StoneMove stoneMove);

  BoardReader getMap();

  void setHeight(int height);

  void setWidth(int width);

}
