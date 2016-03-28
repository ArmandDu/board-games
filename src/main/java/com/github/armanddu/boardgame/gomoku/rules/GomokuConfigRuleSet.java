package com.github.armanddu.boardgame.gomoku.rules;

import com.github.armanddu.boardgame.lib.game.GameManager;
import com.github.armanddu.boardgame.lib.rule.ConfigRule;
import com.github.armanddu.boardgame.lib.rule.ConfigRuleSet;
import com.github.armanddu.boardgame.lib.rule.Rule;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GomokuConfigRuleSet implements ConfigRuleSet {

    private final Map<String, ConfigRule> set;

    GomokuConfigRuleSet(){
        this.set = new HashMap<>();
        this.set.put("mapSizeRule", new GomokuMapSizeRule());
        this.set.put("nbPlayerRule", new GomokuRequiredPlayerRule());
        this.set.put("initialStonePositionRule", new GomokuInitialStonePositionRule());
        this.set.put("stonePacksRule", new GomokuStonePacksRule());
        this.set.put("startingPlayerRule", new GomokuStartingPlayerRule());
    }

    @Override
    public Map<String, ConfigRule> getSet() {
        return set;
    }

    @Override
    public ConfigRule get(String key) {
        return set.getOrDefault(key, null);
    }

    public boolean isValid(GameManager manager) {
        return set.values().stream().allMatch(rule -> rule.isValid(manager));
    }

    @Override
    public Rule getLastInvalidRule(GameManager manager) {
        return set.values().stream().filter(rule -> !isValid(manager)).findFirst().get();
    }
}
