package com.github.armanddu.boardgame.gomoku.rules;

import com.github.armanddu.boardgame.gomoku.stone.GomokuStone;
import com.github.armanddu.boardgame.gomoku.stone.GomokuStoneNode;
import com.github.armanddu.boardgame.stone.Stone;
import com.github.armanddu.boardgame.stone.StoneNode;
import com.github.armanddu.boardgame.map.BoardReader;
import com.github.armanddu.boardgame.rule.EndGameRule;
import com.github.armanddu.boardgame.stone.StoneMove;
import com.github.armanddu.boardgame.stone.StonePosition;

import java.util.List;

public class GomokuFiveInARowUnbreakableRule implements EndGameRule {

    @Override
    public String asString() {
        return "Winning rule: A winner is declared if one can align 5 of his stones in a row without your opponent can break it";
    }

    @Override
    public boolean isValid(BoardReader map, StoneMove stoneMove) {
        StonePosition position = stoneMove.getSuggestedPosition();
        GomokuStone center = new GomokuStone(stoneMove.getColor(), position.getX(), position.getY());
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
