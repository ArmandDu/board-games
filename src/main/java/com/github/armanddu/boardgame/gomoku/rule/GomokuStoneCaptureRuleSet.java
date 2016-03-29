package com.github.armanddu.boardgame.gomoku.rule;

import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.rule.Rule;
import com.github.armanddu.boardgame.lib.rule.StoneRule;
import com.github.armanddu.boardgame.lib.rule.StoneRuleSet;
import com.github.armanddu.boardgame.lib.stone.StoneMove;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GomokuStoneCaptureRuleSet implements StoneRuleSet {
    private final  Map<String, StoneRule> set;

    public GomokuStoneCaptureRuleSet() {
        set = new HashMap<>();
    }

    @Override
    public Map<String, StoneRule> getSet() {
        return set;
    }

    @Override
    public Rule getLastInvalid(BoardReader map, StoneMove move) {
        return set.values().stream()
                .filter(rule -> !rule.isValid(map, move))
                .findFirst()
                .get();
    }

    @Override
    public boolean isValid(BoardReader map, StoneMove move) {
        return null == getLastInvalid(map, move);
    }
}
