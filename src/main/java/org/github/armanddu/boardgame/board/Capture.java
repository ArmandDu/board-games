package org.github.armanddu.boardgame.board;

import java.util.List;

import org.github.armanddu.boardgame.gomoku.stone.StoneNode;
import org.github.armanddu.boardgame.stone.Stone;
import org.github.armanddu.boardgame.stone.StoneType;

public interface Capture {

  StoneType getStoneType();

  List<Stone> getStones();

  void setCapture(StoneNode node);

}
