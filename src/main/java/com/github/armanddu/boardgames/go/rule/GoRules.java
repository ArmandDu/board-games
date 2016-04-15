package com.github.armanddu.boardgames.go.rule;

import com.github.armanddu.boardgames.go.rule.rules.GoChangeTurnRule;
import com.github.armanddu.boardgames.lib.rule.*;
import com.github.armanddu.boardgames.lib.rule.config.RuleConfig;
import com.github.armanddu.boardgames.lib.game.GameManager;
import com.github.armanddu.boardgames.go.rule.config.GoRuleConfig;
import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.stone.StoneMove;

import java.util.ArrayList;
import java.util.List;

public class GoRules implements GameRules {

    private final StoneRule changeTurnRule;
    private final RuleConfig config;
    private final StoneRuleSet validStonePositionRuleSet;
    private final StoneRuleSet stoneCapturesRuleSet;
    private final ConfigRuleSet configRuleSet;
    private final EndGameRuleSet winRuleSet;
    private final EndGameRuleSet drawRuleSet;
    private Rule lastInvalidRule;
    private final List<EndGameRuleSet> endGameRules;

    public GoRules() {
        this.configRuleSet = new GoConfigRuleSet();
        this.validStonePositionRuleSet = new GoStonePositionRuleSet();
        this.winRuleSet = new GoWinRuleSet();
        this.drawRuleSet = new GoDrawRuleSet();
        this.stoneCapturesRuleSet = new GoStoneCaptureRuleSet();
        this.endGameRules = new ArrayList<>();

        this.endGameRules.add(winRuleSet);
        this.endGameRules.add(drawRuleSet);
        this.changeTurnRule = new GoChangeTurnRule();
        this.config = new GoRuleConfig(configRuleSet);
    }

    public void configGame(GameManager game) {
        this.configRuleSet.getSet().values().stream().filter(rule -> !rule.isValid(game)).forEach(rule -> rule.set(game));
    }

    public boolean isValidGame(GameManager manager) {
        return null == (this.lastInvalidRule = configRuleSet.getLastInvalidRule(manager));
    }

    public boolean isValidMove(BoardReader map, StoneMove move) {
       return null == (lastInvalidRule = validStonePositionRuleSet.getLastInvalid(map, move));
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
