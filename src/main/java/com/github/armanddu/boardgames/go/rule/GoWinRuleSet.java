package com.github.armanddu.boardgames.go.rule;

import com.github.armanddu.boardgames.go.rule.rules.GoFiveInARowUnbreakableRule;
import com.github.armanddu.boardgames.go.rule.rules.GoOpponentAbandonRule;
import com.github.armanddu.boardgames.go.rule.rules.GoTenCapturesRule;
import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.rule.EndGameRule;
import com.github.armanddu.boardgames.lib.rule.EndGameRuleSet;
import com.github.armanddu.boardgames.lib.stone.StoneMove;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GoWinRuleSet implements EndGameRuleSet {

    private final Map<String, EndGameRule> set;

    GoWinRuleSet()
    {
        set = new HashMap<>();
        set.put("isAlignmentWin", new GoFiveInARowUnbreakableRule());
        set.put("isCaptureWin", new GoTenCapturesRule());
        set.put("isByAbandonWin", new GoOpponentAbandonRule());
    }

    @Override
    public boolean isValid(BoardReader map, StoneMove move) {
     return getSet().values().stream().anyMatch(rule -> rule.isValid(map, move));
    }

    @Override
    public Map<String, EndGameRule> getSet() {
        return set;
    }
}
