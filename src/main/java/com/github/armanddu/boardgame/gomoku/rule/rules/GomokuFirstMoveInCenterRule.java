package com.github.armanddu.boardgame.gomoku.rule.rules;

import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.rule.StoneRule;
import com.github.armanddu.boardgame.lib.stone.StoneMove;
import com.github.armanddu.boardgame.lib.stone.StonePosition;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GomokuFirstMoveInCenterRule implements StoneRule {
    @Override
    public boolean isValid(BoardReader map, StoneMove move) {
        return !map.getStone().isEmpty() || isCenter(map, move.getSuggestedPosition());
    }

    private boolean isCenter(BoardReader map, StonePosition position) {
        return position.getX() == map.getWidth() / 2 && position.getY() == map.getHeight() / 2;
    }

    @Override
    public String asString() {
        return String.format("Position Rule: first stone should be in center of MAP (%d:%d)", 19 /2, 19 /2);
    }
}
