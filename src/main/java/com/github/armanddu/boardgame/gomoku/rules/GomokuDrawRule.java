package com.github.armanddu.boardgame.gomoku.rules;

import com.github.armanddu.boardgame.map.BoardReader;
import com.github.armanddu.boardgame.rule.EndGameRule;
import com.github.armanddu.boardgame.stone.StoneMove;
import com.github.armanddu.boardgame.stone.StonePosition;

public class GomokuDrawRule implements EndGameRule {

  public String asString() {
    return "Draw Rule: the game is drawn if the map is full";
  }

  public boolean isValid(BoardReader map, StoneMove stoneMove) {
    for (int i = 0; i < map.getWidth(); i++) {
      for (int j = 0; j < map.getHeight(); j++) {
        if (map.get(i, j) == null && !positionIsSuggested(i, j, stoneMove)) {
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
