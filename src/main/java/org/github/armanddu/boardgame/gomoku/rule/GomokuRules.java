package org.github.armanddu.boardgame.gomoku.rule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.github.armanddu.boardgame.board.Board;
import org.github.armanddu.boardgame.board.BoardDimension;
import org.github.armanddu.boardgame.board.Capture;
import org.github.armanddu.boardgame.rule.Rule;
import org.github.armanddu.boardgame.rule.RuleSet;
import org.github.armanddu.boardgame.stone.Stone;
import org.github.armanddu.boardgame.stone.StoneType;

public class GomokuRules implements Rule {

  private static final int BOARD_WIDTH = 19;
  private static final int BOARD_HEIGHT = 19;

  private BoardDimension boardSize;
  private boolean isFiveInARow;
  private boolean isFiveInaRowUnbreakable;
  private StoneType winningStone;
  private List<RuleSet> postComputeRules;
  private List<RuleSet> preComputeRules;
  private Map<String, RuleSet> allRules;
  private List<Capture> captures;

  public GomokuRules() {
    this.boardSize = new BoardDimension(BOARD_WIDTH, BOARD_HEIGHT);
    this.winningStone = null;
    this.isFiveInARow = false;
    this.isFiveInaRowUnbreakable = false;
    this.postComputeRules = new ArrayList<RuleSet>();
    this.preComputeRules = new ArrayList<RuleSet>();
    this.allRules = new HashMap<String, RuleSet>();
    this.allRules.put("playerRule", new PlayerRuleSet());
    this.allRules.put("fiveInARow", new FiveInARowRule());
    this.allRules.put("fiveInARowUnbreakable", new FiveInaRowUnbreakableRule());

    this.allRules.put("blackPlaysFirst", new BlackPlaysFirstRule());
    this.allRules.put("FirstStoneInCenterRule", new FirstStoneInCenterRule());
    this.allRules.put("stonePositionRule", new StonePositionRule());
    this.allRules.put("doubleThreeRule", new DoubleThreeRule());
    this.allRules.put("captureRule", new CaptureRule());

    this.preComputeRules.add(allRules.get("captureRule"));

    this.postComputeRules.add(allRules.get("fiveInARowUnbreakable"));
    this.postComputeRules.add(allRules.get("fiveInARow"));

  }

  public boolean isEnoughPlayers(int nPlayers) {
    return this.allRules.get("playerRule").applies(nPlayers);
  }

  public String getPlayersRules() {
    return this.allRules.get("playerRule").ReadableRule();
  }

  public String getReadableRules() {
    StringBuilder builder = new StringBuilder();
    builder.append("Gomoku Rules:\n\n");
    for (RuleSet ruleSet : this.allRules.values()) {

      builder.append(ruleSet.ReadableRule()).append("\n");
    }
    return builder.toString();
  }

  public BoardDimension getBoardSize() {
    return this.boardSize;
  }

  public boolean isWinningSet(Board board) {
    return this.isFiveInaRowUnbreakable(board);
  }

  public boolean isFiveInaRow(Board board) {
    return this.isFiveInARow;
  }

  public StoneType getWinningStoneType(Board board) {
    return this.winningStone;
  }

  public boolean isFiveInaRowUnbreakable(Board board) {
    return this.isFiveInaRowUnbreakable;
  }

  public void update(Board board) {
    for (RuleSet ruleSet : this.preComputeRules) {
      if (ruleSet.applies(board)) {
        ruleSet.update(this);
      }
    }
    for (Stone stone : board.getStones()) {
      stone.computeWeight(board.getBoard());
    }
    for (RuleSet ruleSet : this.postComputeRules) {
      if (ruleSet.applies(board)) {
        ruleSet.update(this);
      }
    }
  }

  public void setIsFiveInARow(boolean isFiveInARow) {
    this.isFiveInARow = isFiveInARow;

  }

  public void setIsFiveInARowUnbreakable(boolean isFiveInARowUnbreakable) {
    this.isFiveInaRowUnbreakable = isFiveInARowUnbreakable;

  }

  public void setWinningStoneType(StoneType stone) {
    this.winningStone = stone;

  }

  public boolean isValidMove(Board board, StoneType stone, int x, int y) {

    boolean res = this.allRules.get("blackPlaysFirst").applies(board, stone, x, y)
        && this.allRules.get("FirstStoneInCenterRule").applies(board, stone, x, y)
        && this.allRules.get("stonePositionRule").applies(board, stone, x, y)
        && !this.allRules.get("doubleThreeRule").applies(board, stone, x, y);
    return res;
  }

  public List<Capture> getCaptures() {
    return this.captures;
  }

  public void setCaptures(List<Capture> captures) {
    this.captures = captures;

  }

}
