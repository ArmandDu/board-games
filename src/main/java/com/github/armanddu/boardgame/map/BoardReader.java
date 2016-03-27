package com.github.armanddu.boardgame.map;

import com.github.armanddu.boardgame.stone.Stone;
import com.github.armanddu.boardgame.stone.StoneMove;

public interface BoardReader {

  Stone get(int x, int y);

  int getWidth();

  int getHeight();

  boolean isValidMove(StoneMove stoneMove);
}
