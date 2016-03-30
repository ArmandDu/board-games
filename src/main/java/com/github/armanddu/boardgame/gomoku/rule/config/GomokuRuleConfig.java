package com.github.armanddu.boardgame.gomoku.rule.config;

import com.github.armanddu.boardgame.gomoku.rule.rules.GomokuStonePacksRule;
import com.github.armanddu.boardgame.lib.rule.ConfigRuleSet;
import com.github.armanddu.boardgame.lib.rule.config.RuleConfig;
import com.github.armanddu.boardgame.gomoku.board.GomokuGameManager;
import com.github.armanddu.boardgame.lib.rule.ConfigRule;

public class GomokuRuleConfig implements RuleConfig {

    private final ConfigRuleSet rules;
    private final ConfigRule packsRule;

    public GomokuRuleConfig(ConfigRuleSet configRules) {
        this.rules = configRules;
        packsRule = new GomokuStonePacksRule();
    }

    public void setStonePacks(GomokuGameManager manager) {
        ConfigRule rule = packsRule;
        rule.set(manager);
    }

    public void setBoard(GomokuGameManager manager) {
        ConfigRule rule = rules.get("mapSizeRule");
        rule.set(manager);
    }

}
