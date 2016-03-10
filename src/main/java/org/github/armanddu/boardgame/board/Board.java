package org.github.armanddu.boardgame.board;

import java.util.List;

import org.github.armanddu.boardgame.stone.Stone;
import org.github.armanddu.boardgame.stone.StoneType;

public interface Board {

  void setStone(StoneType stone, int i, int j);

  List<Stone> getStones();

   Stone[][] getBoard();

  boolean isInBoundaries(int i, int j);

  Stone getLastStone();

  BoardDimension getBoardSize();
}
