package com.github.armanddu.boardgames.go.rule.rules;

import com.github.armanddu.boardgames.go.stone.GoStone;
import com.github.armanddu.boardgames.go.stone.GoStoneNode;
import com.github.armanddu.boardgames.go.stone.StoneNode;
import com.github.armanddu.boardgames.go.stone.StoneNodeChild;
import com.github.armanddu.boardgames.lib.stone.*;
import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.rule.EndGameRule;

public class GoFiveInARowUnbreakableRule implements EndGameRule {

    @Override
    public String asString() {
        return "Winning rule: A winner is declared if one can align 5 of his stones in a row without your opponent can break it";
    }

    @Override
    public boolean isValid(final BoardReader map, final StoneMove move) {
        if (map == null || move == null) return false;
        StonePosition position = move.getSuggestedPosition();
        GoStone center = new GoStone(move.getColor(), position.getX(), position.getY());
        StoneNode node = new GoStoneNode(map, center);
        return node.hasWeight(5) && hasNoThreat(node, map);
    }

    private boolean hasNoThreat(StoneNode node, BoardReader map) {
        for (StoneNodeChild childNode : node.getChildren().values()) {
            for (Stone stone: childNode.getStones()) {
                StoneNode child = new GoStoneNode(map, stone);
                if (child.geCaptures().size() != 0 || child.getThreats().size() != 0){
                    return false;
                }
            }
        }
        return (node.geCaptures().size() == 0) && (node.getThreats().size() == 0);
    }

}
