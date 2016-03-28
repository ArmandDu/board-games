package com.github.armanddu.boardgame.lib.board;

import com.github.armanddu.boardgame.lib.stone.Stone;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StoneMove;

public interface BoardReader {

  Stone get(int x, int y);

  int getWidth();

  int getHeight();

  boolean isValidMove(StoneMove stoneMove);

  int getScore(StoneColor color);
}
