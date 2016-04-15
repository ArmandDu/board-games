package com.github.armanddu.boardgames.lib.board;

import com.github.armanddu.boardgames.lib.stone.Stone;
import com.github.armanddu.boardgames.lib.stone.StoneColor;

import java.util.List;

public interface BoardReader {

  Stone get(int x, int y);

  int getWidth();

  int getHeight();

  int getScore(StoneColor color);

  List<Stone> getStones();
}
