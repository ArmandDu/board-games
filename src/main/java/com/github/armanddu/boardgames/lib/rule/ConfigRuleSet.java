package com.github.armanddu.boardgames.lib.rule;

import com.github.armanddu.boardgames.lib.game.GameManager;

import java.util.Map;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public interface ConfigRuleSet{

    Map<String, ConfigRule> getSet();

    ConfigRule get(String key);

    boolean isValid(GameManager manager);

    Rule getLastInvalidRule(GameManager manager);
}
