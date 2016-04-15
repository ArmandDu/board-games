package com.github.armanddu.boardgames.go.board;

import java.util.ArrayList;
import java.util.List;

import com.github.armanddu.boardgames.go.game.GoGameManager;
import com.github.armanddu.boardgames.lib.rule.config.RuleConfig;
import com.github.armanddu.boardgames.lib.game.GameBox;
import com.github.armanddu.boardgames.lib.game.GameManager;
import com.github.armanddu.boardgames.go.rule.GoRules;
import com.github.armanddu.boardgames.lib.board.Board;
import com.github.armanddu.boardgames.lib.player.Players;
import com.github.armanddu.boardgames.lib.rule.GameRules;
import com.github.armanddu.boardgames.lib.stone.StonePack;

public class GoBox implements GameBox {

    private final Board board;
    private final GameRules rules;
    private final List<StonePack> stonePacks;

    public GoBox() {
        this.rules = new GoRules();
        this.board = new GoBoard(rules);
        stonePacks = new ArrayList<>();
        GoGameManager manager = new GoGameManager(null, this);
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
        return new GoGameManager(players, this);
    }
}
