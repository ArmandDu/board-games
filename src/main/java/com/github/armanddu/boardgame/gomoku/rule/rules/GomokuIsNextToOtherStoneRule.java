package com.github.armanddu.boardgame.gomoku.rule.rules;

import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.rule.StoneRule;
import com.github.armanddu.boardgame.lib.stone.StoneMove;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GomokuIsNextToOtherStoneRule implements StoneRule {
    @Override
    public boolean isValid(BoardReader map, StoneMove move) {
        return map.getStones().isEmpty() || isNextToOther(map, move);
    }

    private boolean isNextToOther(BoardReader map, StoneMove move) {
        int x = move.getSuggestedPosition().getX();
        int y = move.getSuggestedPosition().getY();
        return isNextTo(map, x + 1, y + 1) ||
                isNextTo(map, x + 1, y + 0) ||
                isNextTo(map, x + 1, y + -1) ||
                isNextTo(map, x + 0, y + 1) ||
                isNextTo(map, x + 0, y + -1) ||
                isNextTo(map, x + -1, y + 1) ||
                isNextTo(map, x + -1, y + 0) ||
                isNextTo(map, x + -1, y + -1);
    }

    private boolean isNextTo(BoardReader map, int x, int y) {
        return map.get(x, y) != null;
    }

    @Override
    public String asString() {
        return "Stone Position: Stone should be next to an other stone if not first to be placed";
    }
}
