package com.github.armanddu.boardgame.gomoku.rules;

import com.github.armanddu.boardgame.game.GameManager;
import com.github.armanddu.boardgame.player.Players;
import com.github.armanddu.boardgame.rule.ConfigRule;

public class GomokuRequiredPlayerRule implements ConfigRule {

  public String asString() {
    // TODO Auto-generated method stub
    return null;
  }

  public boolean isValid(GameManager config) {
    Players players = config.getPlayers();
    return players.asList().size() == 2 && players.getBlack() != null && players.getWhite() != null;
  }

  public void set(GameManager config) {
    // TODO Auto-generated method stub

  }

}
