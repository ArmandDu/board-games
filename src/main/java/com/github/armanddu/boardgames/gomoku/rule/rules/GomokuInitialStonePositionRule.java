package com.github.armanddu.boardgames.gomoku.rule.rules;

import com.github.armanddu.boardgames.lib.game.GameManager;
import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.rule.ConfigRule;

public class GomokuInitialStonePositionRule implements ConfigRule {

    public String asString() {
        return "Initial Stone Position: The board must be empty before the game starts";
    }

    public boolean isValid(GameManager config) {
        BoardReader map = config.getBoard().getMap();
        for (int i = 0; i < map.getWidth(); i++) {
            for (int j = 0; j < map.getHeight(); j++) {
                if (map.get(i, j) != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void set(GameManager config) {
        config.getBoard().clear();
    }

}
