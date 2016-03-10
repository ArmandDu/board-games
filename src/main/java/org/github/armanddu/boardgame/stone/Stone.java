package org.github.armanddu.boardgame.stone;

import java.util.List;

import org.github.armanddu.boardgame.gomoku.stone.StoneNode;

public interface Stone {

  StoneType getType();

  StoneNode getMaxWeight();

  void computeWeight(Stone[][] board);

  List<StoneNode> getNodes();

  int getY();

  int getX();

}
