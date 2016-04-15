package com.github.armanddu.boardgames.gomoku.board;

import java.util.ArrayList;
import java.util.List;

import com.github.armanddu.boardgames.gomoku.game.GomokuGameManager;
import com.github.armanddu.boardgames.lib.rule.config.RuleConfig;
import com.github.armanddu.boardgames.lib.game.GameBox;
import com.github.armanddu.boardgames.lib.game.GameManager;
import com.github.armanddu.boardgames.gomoku.rule.GomokuRules;
import com.github.armanddu.boardgames.lib.board.Board;
import com.github.armanddu.boardgames.lib.player.Players;
import com.github.armanddu.boardgames.lib.rule.GameRules;
import com.github.armanddu.boardgames.lib.stone.StonePack;

public class GomokuBox implements GameBox {

    private final Board board;
    private final GameRules rules;
    private final List<StonePack> stonePacks;

    public GomokuBox() {
        this.rules = new GomokuRules();
        this.board = new GomokuBoard(rules);
        stonePacks = new ArrayList<>();
        GomokuGameManager manager = new GomokuGameManager(null, this);
        RuleConfig config = rules.getConfig();
        config.setStonePacks(manager);
        config.setBoard(manager);
    }

    public Board getBoard() {
        return board;
    }

    public GameRules getRules() {
        return this.rules;
    }

    public List<StonePack> getStonePacks() {
        return stonePacks;
    }

    public GameManager getManager(Players players) {
        return new GomokuGameManager(players, this);
    }
}
