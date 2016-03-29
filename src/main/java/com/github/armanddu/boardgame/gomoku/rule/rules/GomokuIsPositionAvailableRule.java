package com.github.armanddu.boardgame.gomoku.rule.rules;

import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.rule.StoneRule;
import com.github.armanddu.boardgame.lib.stone.StoneMove;
import com.github.armanddu.boardgame.lib.stone.StonePosition;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */

public class GomokuIsPositionAvailableRule implements StoneRule {
    @Override
    public boolean isValid(BoardReader map, StoneMove move) {
        return move != null && isFreePosition(map, move);
    }

    private boolean isFreePosition(BoardReader map, StoneMove move) {
        StonePosition position = move.getSuggestedPosition();
        return map.get(position.getX(), position.getY()) == null;
    }

    @Override
    public String asString() {
        return "Stone Position: Stone must be placed on a free space";
    }
}
