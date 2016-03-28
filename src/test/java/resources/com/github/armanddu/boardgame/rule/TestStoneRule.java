package resources.com.github.armanddu.boardgame.rule;

import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.rule.StoneRule;
import com.github.armanddu.boardgame.lib.stone.StoneMove;

public class TestStoneRule implements StoneRule {

  public String asString() {
    return "Rule";
  }

  public boolean isValid(BoardReader map, StoneMove move) {
    return true;
  }

}
