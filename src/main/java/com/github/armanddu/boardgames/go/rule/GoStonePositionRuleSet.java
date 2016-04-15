package com.github.armanddu.boardgames.go.rule;

import com.github.armanddu.boardgames.go.rule.rules.GoDoubleThreeRule;
import com.github.armanddu.boardgames.go.rule.rules.GoFirstMoveInCenterRule;
import com.github.armanddu.boardgames.go.rule.rules.GoIsNextToOtherStoneRule;
import com.github.armanddu.boardgames.go.rule.rules.GoIsPositionAvailableRule;
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

public class GoStonePositionRuleSet implements StoneRuleSet {

    private final Map<String, StoneRule> set;

    public GoStonePositionRuleSet() {
        set = new HashMap<>();
        set.put("isAvailable", new GoIsPositionAvailableRule());
        set.put("isNextToOtherStone", new GoIsNextToOtherStoneRule());
        set.put("isValidFirstMove", new GoFirstMoveInCenterRule());
        set.put("isNotDoubleThree", new GoDoubleThreeRule());

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
