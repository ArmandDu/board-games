package com.github.armanddu.boardgame.gomoku.rules;

import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.rule.EndGameRule;
import com.github.armanddu.boardgame.lib.rule.EndGameRuleSet;
import com.github.armanddu.boardgame.lib.stone.StoneMove;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GomokuDrawRuleSet implements EndGameRuleSet {
    private final Map<String, EndGameRule> set;

    public GomokuDrawRuleSet() {
        set = new HashMap<>();
        set.put("isDrawRule", new GomokuDrawRule());

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
