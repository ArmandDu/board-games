package org.github.armanddu.boardgame.rule;

import org.github.armanddu.boardgame.board.Board;
import org.github.armanddu.boardgame.stone.StoneType;

public interface RuleSet {

  void update(Rule rules);

  boolean applies(int nPlayers);
  boolean applies(Board board);
  boolean applies(Board board, StoneType stone, int x, int y);

  public String ReadableRule();


}
