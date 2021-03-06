package com.github.armanddu.boardgames.go.rule.rules;

import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.rule.StoneRule;
import com.github.armanddu.boardgames.lib.stone.StoneMove;
import com.github.armanddu.boardgames.lib.stone.StonePosition;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */

public class GoIsPositionAvailableRule implements StoneRule {
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
