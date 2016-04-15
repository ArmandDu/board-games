package com.github.armanddu.boardgames.lib.rule;

import java.util.Map;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public interface EndGameRuleSet extends RuleSet {

    Map<String, EndGameRule> getSet();
}
