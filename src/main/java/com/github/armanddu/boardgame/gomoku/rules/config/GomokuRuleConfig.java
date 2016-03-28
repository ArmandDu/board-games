package com.github.armanddu.boardgame.gomoku.rules.config;

import com.github.armanddu.boardgame.lib.rule.ConfigRuleSet;
import com.github.armanddu.boardgame.lib.rule.config.RuleConfig;
import com.github.armanddu.boardgame.gomoku.board.GomokuGameManager;
import com.github.armanddu.boardgame.lib.rule.ConfigRule;

public class GomokuRuleConfig implements RuleConfig {

  private final ConfigRuleSet rules;

  public GomokuRuleConfig(ConfigRuleSet configRules) {
    this.rules = configRules;
  }

  public void setStonePacks(GomokuGameManager manager) {
    ConfigRule rule = this.rules.get("stonePacksRule");
    rule.set(manager);
  }

  public void setBoard(GomokuGameManager manager) {
    ConfigRule rule = rules.get("mapSizeRule");
    rule.set(manager);
  }

}
