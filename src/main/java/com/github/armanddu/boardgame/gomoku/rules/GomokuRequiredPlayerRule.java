package com.github.armanddu.boardgame.gomoku.rules;

import com.github.armanddu.boardgame.lib.game.GameManager;
import com.github.armanddu.boardgame.lib.player.Players;
import com.github.armanddu.boardgame.lib.rule.ConfigRule;

public class GomokuRequiredPlayerRule implements ConfigRule {

    public String asString() {
        return "Required players: Gomoku require 2 players, 1 black and 1 white";
    }

    public boolean isValid(GameManager config) {
        Players players = config.getPlayers();
        return players.asList().size() == 2 && players.getBlack() != null && players.getWhite() != null;
    }

    public void set(GameManager config) {
    }

}
