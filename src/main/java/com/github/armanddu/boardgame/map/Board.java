package com.github.armanddu.boardgame.map;

import com.github.armanddu.boardgame.stone.Stone;
import com.github.armanddu.boardgame.stone.StoneMove;

public interface Board {

  Stone get(int x, int y);

  void set(int i, int j, Stone stone);

  int getWidth();

  int getHeight();

  boolean isValidMove(StoneMove stoneMove);

  StoneMove applyMove(StoneMove stoneMove);

  BoardReader getMap();

  void setHeight(int height);

  void setWidth(int width);

}
