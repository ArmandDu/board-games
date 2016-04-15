package com.github.armanddu.boardgames.go.rule;

import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.rule.Rule;
import com.github.armanddu.boardgames.lib.rule.StoneRule;
import com.github.armanddu.boardgames.lib.rule.StoneRuleSet;
import com.github.armanddu.boardgames.lib.stone.StoneMove;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GoStoneCaptureRuleSet implements StoneRuleSet {
    private final  Map<String, StoneRule> set;

    public GoStoneCaptureRuleSet() {
        set = new HashMap<>();
    }

    @Override
    public Map<String, StoneRule> getSet() {
        return set;
    }

    @Override
    public Rule getLastInvalid(BoardReader map, StoneMove move) {
        Optional<StoneRule> first = set.values().stream()
                .filter(rule -> !rule.isValid(map, move))
                .findFirst();
        return first.isPresent() ? first.get() : null;
    }

    @Override
    public boolean isValid(BoardReader map, StoneMove move) {
        return null == getLastInvalid(map, move);
    }
}
