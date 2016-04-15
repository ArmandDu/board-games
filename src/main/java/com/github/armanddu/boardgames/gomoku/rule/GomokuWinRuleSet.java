package com.github.armanddu.boardgames.gomoku.rule;

import com.github.armanddu.boardgames.gomoku.rule.rules.GomokuFiveInARowUnbreakableRule;
import com.github.armanddu.boardgames.gomoku.rule.rules.GomokuOpponentAbandonRule;
import com.github.armanddu.boardgames.gomoku.rule.rules.GomokuTenCapturesRule;
import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.rule.EndGameRule;
import com.github.armanddu.boardgames.lib.rule.EndGameRuleSet;
import com.github.armanddu.boardgames.lib.stone.StoneMove;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GomokuWinRuleSet implements EndGameRuleSet {

    private final Map<String, EndGameRule> set;

    GomokuWinRuleSet()
    {
        set = new HashMap<>();
        set.put("isAlignmentWin", new GomokuFiveInARowUnbreakableRule());
        set.put("isCaptureWin", new GomokuTenCapturesRule());
        set.put("isByAbandonWin", new GomokuOpponentAbandonRule());
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
