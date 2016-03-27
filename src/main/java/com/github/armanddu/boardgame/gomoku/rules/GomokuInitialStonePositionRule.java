package com.github.armanddu.boardgame.gomoku.rules;

import com.github.armanddu.boardgame.game.GameManager;
import com.github.armanddu.boardgame.map.BoardReader;
import com.github.armanddu.boardgame.rule.ConfigRule;

public class GomokuInitialStonePositionRule implements ConfigRule {

  public String asString() {
    // TODO Auto-generated method stub
    return null;
  }

  public boolean isValid(GameManager config) {
    BoardReader map = config.getBoard().getMap();
    for (int i = 0; i < map.getWidth(); i++) {
      for (int j = 0; j < map.getHeight(); j++) {
        if (map.get(i, j) != null) {
          return false;
        }
      }
    }
    return true;
  }

  public void set(GameManager config) {
    BoardReader map = config.getBoard().getMap();
    for (int i = 0; i < map.getWidth(); i++) {
      for (int j = 0; j < map.getHeight(); j++) {
        config.setMap(i, j, null);
      }
    }
  }

}
