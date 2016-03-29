package com.github.armanddu.boardgame.gomoku.rule;

import com.github.armanddu.boardgame.gomoku.rule.rules.GomokuDoubleThreeRule;
import com.github.armanddu.boardgame.gomoku.rule.rules.GomokuFirstMoveInCenterRule;
import com.github.armanddu.boardgame.gomoku.rule.rules.GomokuIsNextToOtherStoneRule;
import com.github.armanddu.boardgame.gomoku.rule.rules.GomokuIsPositionAvailableRule;
import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.rule.Rule;
import com.github.armanddu.boardgame.lib.rule.StoneRule;
import com.github.armanddu.boardgame.lib.rule.StoneRuleSet;
import com.github.armanddu.boardgame.lib.stone.StoneMove;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */

public class GomokuStonePositionRuleSet implements StoneRuleSet {

    private final Map<String, StoneRule> set;

    public GomokuStonePositionRuleSet() {
        set = new HashMap<>();
        set.put("isAvailable", new GomokuIsPositionAvailableRule());
        set.put("isNextToOtherStone", new GomokuIsNextToOtherStoneRule());
        set.put("isValidFirstMove", new GomokuFirstMoveInCenterRule());
        set.put("isNotDoubleThree", new GomokuDoubleThreeRule());

    }

    public Map<String, StoneRule> getSet() {
        return set;
    }

    @Override
    public Rule getLastInvalid(BoardReader map, StoneMove stoneMove) {
        Optional<StoneRule> option = getSet().values().stream().filter(rule -> !rule.isValid(map, stoneMove)).findFirst();
        return option.isPresent() ? option.get() : null;
    }

    @Override
    public boolean isValid(BoardReader map, StoneMove move) {
        return getSet().values().stream().allMatch(rule -> rule.isValid(map, move));
    }
}
