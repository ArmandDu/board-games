package com.github.armanddu.boardgame.gomoku.rules;

import com.github.armanddu.boardgame.game.GameManager;
import com.github.armanddu.boardgame.rule.ConfigRule;

public class GomokuMapSizeRule implements ConfigRule {

  private static final int HEIGHT = 19;
  private static final int WIDTH = 19;

  public String asString() {
    // TODO Auto-generated method stub
    return null;
  }

  public boolean isValid(GameManager config) {
    return config.getMap().getWidth() == WIDTH
        && config.getMap().getHeight() == HEIGHT;
  }

  public void set(GameManager config) {
    config.setMapWidth(WIDTH);
    config.setMapHeight(HEIGHT);
  }

}
