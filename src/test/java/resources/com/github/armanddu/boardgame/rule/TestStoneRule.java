package resources.com.github.armanddu.boardgame.rule;

import com.github.armanddu.boardgame.map.BoardReader;
import com.github.armanddu.boardgame.rule.StoneRule;
import com.github.armanddu.boardgame.stone.StoneMove;

public class TestStoneRule implements StoneRule {

  public String asString() {
    return "Rule";
  }

  public boolean isValid(BoardReader map, StoneMove stoneMove) {
    return true;
  }

}
