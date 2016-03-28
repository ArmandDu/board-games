package com.github.armanddu.boardgame.gomoku.rules;

import com.github.armanddu.boardgame.gomoku.stone.GomokuStone;
import com.github.armanddu.boardgame.gomoku.stone.GomokuStoneNode;
import com.github.armanddu.boardgame.lib.stone.Stone;
import com.github.armanddu.boardgame.lib.stone.StoneNode;
import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.rule.EndGameRule;
import com.github.armanddu.boardgame.lib.stone.StoneMove;
import com.github.armanddu.boardgame.lib.stone.StonePosition;

import java.util.List;

public class GomokuFiveInARowUnbreakableRule implements EndGameRule {

    @Override
    public String asString() {
        return "Winning rule: A winner is declared if one can align 5 of his stones in a row without your opponent can break it";
    }

    @Override
    public boolean isValid(BoardReader map, StoneMove move) {
        StonePosition position = move.getSuggestedPosition();
        GomokuStone center = new GomokuStone(move.getColor(), position.getX(), position.getY());
        StoneNode node = new GomokuStoneNode(map, center);
        return node.hasWeight(5) && hasNoThreat(node, map);
    }

    private boolean hasNoThreat(StoneNode node, BoardReader map) {
        for (List<Stone> stones : node.getAll().values()) {
            for (Stone stone: stones) {
                StoneNode child = new GomokuStoneNode(map, stone);
                if (child.geCaptures().size() != 0 || child.getThreats().size() != 0){
                    return false;
                }
            }
        }
        return (node.geCaptures().size() == 0) && (node.getThreats().size() == 0);
    }

}
