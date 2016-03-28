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
public class GomokuWinRuleSet implements EndGameRuleSet {

    private final Map<String, EndGameRule> set;

    GomokuWinRuleSet()
    {
        set = new HashMap<>();
        set.put("isAlignmentWin", new GomokuFiveInARowUnbreakableRule());
        set.put("isCaptureWin", new GomokuTenCapturesRule());
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
