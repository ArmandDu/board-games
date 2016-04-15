package com.github.armanddu.boardgames.gomoku.rule.rules;

import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.rule.EndGameRule;
import com.github.armanddu.boardgames.lib.stone.StoneMove;
import com.github.armanddu.boardgames.lib.stone.StonePosition;

public class GomokuDrawRule implements EndGameRule {

  public String asString() {
    return "Draw Rule: the game is drawn if the map is full";
  }

  public boolean isValid(final BoardReader map, final StoneMove move) {
    for (int i = 0; i < map.getWidth(); i++) {
      for (int j = 0; j < map.getHeight(); j++) {
        if (map.get(i, j) == null && !positionIsSuggested(i, j, move)) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean positionIsSuggested(int x, int y, StoneMove stoneMove) {
    StonePosition position = stoneMove.getSuggestedPosition();
    return (position.getX() == x && position.getY() == y);
  }

}
