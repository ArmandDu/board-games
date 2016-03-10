package org.github.armanddu.boardgame.gomoku.stone;

import java.util.List;

import org.github.armanddu.boardgame.stone.Stone;

public interface StoneNode {

  int size();

  void reset();

  void add(Stone stone);

  boolean isThreatened();

  void setThreat(boolean b);

  List<Stone> getStones();

}
