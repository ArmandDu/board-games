package com.github.armanddu.boardgame.gomoku.config;

import java.util.Map;

import com.github.armanddu.boardgame.rule.config.RuleConfig;
import com.github.armanddu.boardgame.gomoku.board.GomokuGameManager;
import com.github.armanddu.boardgame.rule.ConfigRule;

public class GomokuRuleConfig implements RuleConfig {

  private Map<String, ConfigRule> rules;

  public GomokuRuleConfig(Map<String, ConfigRule> configRules) {
    this.rules = configRules;
  }

  public void setStonePacks(GomokuGameManager manager) {
    this.rules.get("stonePacksRule").set(manager);
  }

  public void setBoard(GomokuGameManager manager) {
    rules.get("mapSizeRule").set(manager);
  }

}
