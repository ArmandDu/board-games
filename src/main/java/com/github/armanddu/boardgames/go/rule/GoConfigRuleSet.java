package com.github.armanddu.boardgames.go.rule;

import com.github.armanddu.boardgames.go.rule.rules.*;
import com.github.armanddu.boardgames.lib.game.GameManager;
import com.github.armanddu.boardgames.lib.rule.ConfigRule;
import com.github.armanddu.boardgames.lib.rule.ConfigRuleSet;
import com.github.armanddu.boardgames.lib.rule.Rule;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GoConfigRuleSet implements ConfigRuleSet {

    private final Map<String, ConfigRule> set;

    GoConfigRuleSet(){
        this.set = new HashMap<>();
        this.set.put("mapSizeRule", new GoMapSizeRule());
        this.set.put("nbPlayerRule", new GoRequiredPlayerRule());
        this.set.put("initialStonePositionRule", new GoInitialStonePositionRule());
        this.set.put("startingPlayerRule", new GoStartingPlayerRule());
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
        Optional<ConfigRule> first = set.values().stream().filter(rule -> !rule.isValid(manager)).findFirst();
        set.entrySet().stream().forEach(set -> {
            if (!set.getValue().isValid(manager)) {
                System.out.println("set.getKey() = " + set.getKey());
            }
        });
        return first.isPresent() ? first.get() : null;
    }
}
