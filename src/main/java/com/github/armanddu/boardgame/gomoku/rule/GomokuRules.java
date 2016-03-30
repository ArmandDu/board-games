package com.github.armanddu.boardgame.gomoku.rule;

import com.github.armanddu.boardgame.gomoku.rule.rules.GomokuChangeTurnRule;
import com.github.armanddu.boardgame.lib.rule.*;
import com.github.armanddu.boardgame.lib.rule.config.RuleConfig;
import com.github.armanddu.boardgame.lib.game.GameManager;
import com.github.armanddu.boardgame.gomoku.rule.config.GomokuRuleConfig;
import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.stone.StoneMove;

import java.util.ArrayList;
import java.util.List;

public class GomokuRules implements GameRules {

    private final StoneRule changeTurnRule;
    private final RuleConfig config;
    private final StoneRuleSet validStonePositionRuleSet;
    private final StoneRuleSet stoneCapturesRuleSet;
    private final ConfigRuleSet configRuleSet;
    private final EndGameRuleSet winRuleSet;
    private final EndGameRuleSet drawRuleSet;
    private Rule lastInvalidRule;
    private final List<EndGameRuleSet> endGameRules;

    public GomokuRules() {
        this.configRuleSet = new GomokuConfigRuleSet();
        this.validStonePositionRuleSet = new GomokuStonePositionRuleSet();
        this.winRuleSet = new GomokuWinRuleSet();
        this.drawRuleSet = new GomokuDrawRuleSet();
        this.stoneCapturesRuleSet = new GomokuStoneCaptureRuleSet();
        this.endGameRules = new ArrayList<>();

        this.endGameRules.add(winRuleSet);
        this.endGameRules.add(drawRuleSet);
        this.changeTurnRule = new GomokuChangeTurnRule();
        this.config = new GomokuRuleConfig(configRuleSet);
    }

    public void configGame(GameManager config) {
        this.configRuleSet.getSet().values().stream().filter(rule -> !rule.isValid(config)).forEach(rule -> rule.set(config));
    }

    public boolean isValidGame(GameManager manager) {
        return null == (this.lastInvalidRule = configRuleSet.getLastInvalidRule(manager));
    }

    public boolean isValidMove(BoardReader map, StoneMove move) {
       return null == (lastInvalidRule = validStonePositionRuleSet.getLastInvalid(map, move));
    }

    public boolean hasCaptures(BoardReader map, StoneMove move) {
        return this.stoneCapturesRuleSet.isValid(map, move);
    }

    public boolean shouldChangeTurn(BoardReader map, StoneMove move) {
        return changeTurnRule.isValid(map, move);
    }

    public boolean isEndGame(BoardReader map, StoneMove move) {
        return endGameRules.stream()
                .anyMatch(ruleSet -> ruleSet.isValid(map, move));
    }

    public boolean isWin(BoardReader map, StoneMove move) {
        return winRuleSet.isValid(map, move);
    }

    public boolean isDraw(BoardReader map, StoneMove move) {
        return drawRuleSet.isValid(map, move);
    }

    public Rule getLastInvalidRule() {
        return this.lastInvalidRule;
    }

    public RuleConfig getConfig() {
        return this.config;
    }

}
