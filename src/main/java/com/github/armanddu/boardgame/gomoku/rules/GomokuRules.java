package com.github.armanddu.boardgame.gomoku.rules;

import java.util.HashMap;
import java.util.Map;

import com.github.armanddu.boardgame.rule.config.RuleConfig;
import com.github.armanddu.boardgame.game.GameManager;
import com.github.armanddu.boardgame.gomoku.config.GomokuRuleConfig;
import com.github.armanddu.boardgame.map.BoardReader;
import com.github.armanddu.boardgame.rule.ConfigRule;
import com.github.armanddu.boardgame.rule.EndGameRule;
import com.github.armanddu.boardgame.rule.Rule;
import com.github.armanddu.boardgame.rule.StoneRule;
import com.github.armanddu.boardgame.rule.GameRules;
import com.github.armanddu.boardgame.stone.StoneMove;

public class GomokuRules implements GameRules {

    private Map<String, ConfigRule> configRules;
    private Map<String, StoneRule> stoneRules;
    private Map<String, EndGameRule> endGameRules;
    private Rule lastInvalidRule;
    private StoneRule changeTurnRule;
    private RuleConfig config;

    public GomokuRules() {
        this.configRules = new HashMap<>();
        this.stoneRules = new HashMap<>();
        this.endGameRules = new HashMap<>();

        this.configRules.put("mapSizeRule", new GomokuMapSizeRule());
        this.configRules.put("nbPlayerRule", new GomokuRequiredPlayerRule());
        this.configRules.put("initialStonePositionRule", new GomokuInitialStonePositionRule());
        this.configRules.put("stonePacksRule", new GomokuStonePacksRule());

        this.endGameRules.put("isDrawRule", new GomokuDrawRule());
        this.endGameRules.put("isAlignmentWin", new GomokuFiveInARowUnbreakableRule());

        this.changeTurnRule = new GomokuChangeTurnRule();
        this.config = new GomokuRuleConfig(configRules);
    }

    public void configGame(GameManager config) {
        this.configRules.values().stream().filter(rule -> !rule.isValid(config)).forEach(rule -> rule.set(config));
    }

    public boolean isValidGame(GameManager config) {
        for (ConfigRule rule : this.configRules.values()) {
            if (!rule.isValid(config)) {
                this.lastInvalidRule = rule;
                return false;
            }
        }
        return true;
    }

    public boolean isValidMove(BoardReader map, StoneMove stoneMove) {
        for (StoneRule rule : this.stoneRules.values()) {
            if (!rule.isValid(map, stoneMove)) {
                this.lastInvalidRule = rule;
                return false;
            }
        }
        return true;
    }

    public boolean hasCaptures(BoardReader map, StoneMove stoneMove) {
        return this.stoneRules.get("hasCapturesRule").isValid(map, stoneMove);
    }

    public boolean shouldChangeTurn(BoardReader map, StoneMove stoneMove) {
        return this.changeTurnRule.isValid(map, stoneMove);
    }

    public boolean isEndGame(BoardReader map, StoneMove stoneMove) {
        for (EndGameRule rule : this.endGameRules.values()) {
            if ((rule.isValid(map, stoneMove))) {
                return true;
            }
        }
        return false;
    }

    public boolean isWin(BoardReader map, StoneMove stoneMove) {
        return this.endGameRules.get("isWinRule").isValid(map, stoneMove);
    }

    public boolean isDraw(BoardReader map, StoneMove stoneMove) {
        return this.endGameRules.get("isDrawRule").isValid(map, stoneMove);
    }

    public Rule getLastInvalidRule() {
        return this.lastInvalidRule;
    }

    public RuleConfig getConfig() {
        return this.config;
    }

}
