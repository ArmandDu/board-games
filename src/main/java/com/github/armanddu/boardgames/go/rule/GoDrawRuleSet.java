package com.github.armanddu.boardgames.go.rule;

import com.github.armanddu.boardgames.go.rule.rules.GoDrawRule;
import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.rule.EndGameRule;
import com.github.armanddu.boardgames.lib.rule.EndGameRuleSet;
import com.github.armanddu.boardgames.lib.stone.StoneMove;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GoDrawRuleSet implements EndGameRuleSet {
    private final Map<String, EndGameRule> set;

    public GoDrawRuleSet() {
        set = new HashMap<>();
        set.put("isDrawRule", new GoDrawRule());

    }

    @Override
    public Map<String, EndGameRule> getSet() {

        return set;
    }

    @Override
    public boolean isValid(BoardReader map, StoneMove move) {
        return false;
    }
}
