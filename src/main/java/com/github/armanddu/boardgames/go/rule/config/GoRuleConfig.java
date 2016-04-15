package com.github.armanddu.boardgames.go.rule.config;

import com.github.armanddu.boardgames.go.rule.rules.GoStonePacksRule;
import com.github.armanddu.boardgames.lib.rule.ConfigRuleSet;
import com.github.armanddu.boardgames.lib.rule.config.RuleConfig;
import com.github.armanddu.boardgames.go.game.GoGameManager;
import com.github.armanddu.boardgames.lib.rule.ConfigRule;

public class GoRuleConfig implements RuleConfig {

    private final ConfigRuleSet rules;
    private final ConfigRule packsRule;

    public GoRuleConfig(ConfigRuleSet configRules) {
        this.rules = configRules;
        packsRule = new GoStonePacksRule();
    }

    public void setStonePacks(GoGameManager manager) {
        ConfigRule rule = packsRule;
        rule.set(manager);
    }

    public void setBoard(GoGameManager manager) {
        ConfigRule rule = rules.get("mapSizeRule");
        rule.set(manager);
    }

}
