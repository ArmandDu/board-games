package com.github.armanddu.boardgames.go.board;

import com.github.armanddu.boardgames.go.stone.GoStone;
import com.github.armanddu.boardgames.go.stone.GoStoneMove;
import com.github.armanddu.boardgames.lib.board.Board;
import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.rule.GameRules;
import com.github.armanddu.boardgames.lib.stone.StoneColor;
import com.github.armanddu.boardgames.lib.stone.StoneMove;
import org.junit.Test;
import resources.com.github.armanddu.boardgame.gomoku.stone.TestGomokuStoneMove;
import resources.com.github.armanddu.boardgame.rule.TestGameRules;

import static org.junit.Assert.*;

public class GoBoardTest {

  @Test
  public void test() {
    GameRules rules = new TestGameRules(null);
    Board map = new GoBoard(rules);
    BoardReader manipulator = map.getMap();

    assertEquals(19, map.getHeight());
    assertEquals(19, map.getWidth());
    assertNotNull(manipulator);
    int x = 1;
    int y = 0;
    StoneMove stoneMove = new TestGomokuStoneMove(x, y);
    map.applyMove(stoneMove);
    assertNotNull(map.get(x, y));
  }

  @Test
    public void shouldBeAbleToClean()
  {
      GameRules rules = new TestGameRules(null);
      Board map = new GoBoard(rules);

      map.applyMove(new GoStoneMove(new GoStone(StoneColor.BLACK, 0, 0), 0, 0));
      assertEquals(1, map.getStones().size());
      assertNotNull(map.get(0, 0));
      map.clear();
      assertTrue(map.getStones().isEmpty());
      assertNull((map.get(0, 0)));
  }

}
