package com.github.armanddu.boardgame.gomoku.rule.rules;

import com.github.armanddu.boardgame.lib.game.GameManager;
import com.github.armanddu.boardgame.lib.rule.ConfigRule;

public class GomokuMapSizeRule implements ConfigRule {


    private static final int HEIGHT = 19;
    private static final int WIDTH = 19;

    public String asString() {
        return String.format("Board Rule: Gomoku Board is %d by %d", WIDTH, HEIGHT);
    }

    public boolean isValid(GameManager config) {
        return config.getMap().getWidth() == WIDTH
                && config.getMap().getHeight() == HEIGHT;
    }

    public void set(GameManager config) {
        config.getBoard().setWidth(WIDTH);
        config.getBoard().setHeight(HEIGHT);
    }

}
