package com.github.armanddu.boardgame.lib.board;

import com.github.armanddu.boardgame.lib.stone.Stone;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StoneMove;

public interface Board {

  Stone get(int x, int y);

  void set(int x, int y, Stone stone);

  int getWidth();

  int getHeight();

  boolean isValidMove(StoneMove move);

  StoneMove applyMove(StoneMove move);

  BoardReader getMap();

  void setHeight(int height);

  void setWidth(int width);

  int getScore(StoneColor color);

  void setScore(StoneColor color, int value);
}
