package org.github.armanddu.boardgame.gomoku.rule;

import org.github.armanddu.boardgame.board.Board;
import org.github.armanddu.boardgame.gomoku.stone.StoneNode;
import org.github.armanddu.boardgame.rule.Rule;
import org.github.armanddu.boardgame.rule.RuleSet;
import org.github.armanddu.boardgame.stone.Stone;
import org.github.armanddu.boardgame.stone.StoneType;

public class FiveInaRowUnbreakableRule implements RuleSet {

  private StoneType stone;

  public void update(Rule rules) {
    rules.setIsFiveInARow(true);
    rules.setIsFiveInARowUnbreakable(true);
    rules.setWinningStoneType(this.stone);
  }

  public boolean applies(Board board) {
    for (Stone stone : board.getStones()) {
      StoneNode maxWeight = stone.getMaxWeight();
      if (maxWeight.size() >= 5) {
        for (StoneNode node : stone.getNodes()) {
          for (Stone nodeStone : node.getStones()) {
            for (StoneNode childNode : nodeStone.getNodes()) {
              if (childNode.size() == 2) {
                System.out.println(childNode);
              }
              if (childNode.isThreatened()) {
                return false;
              }
            }
          }
        }
        this.stone = stone.getType();
        return true;
      }
    }
    return false;
  }

  public String ReadableRule() {
    return "Five in a row unbreakable rule: ";
  }

  public boolean applies(int nPlayers) {
    return false;
  }

  public boolean applies(Board board, StoneType stone, int x, int y) {
    // TODO Auto-generated method stub
    return false;
  }

}
