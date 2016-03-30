package com.github.armanddu.boardgame.gomoku.board;

import com.github.armanddu.boardgame.gomoku.stone.GomokuStone;
import com.github.armanddu.boardgame.gomoku.stone.GomokuStoneMove;
import com.github.armanddu.boardgame.lib.board.Board;
import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.rule.GameRules;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StoneMove;
import org.junit.Test;
import resources.com.github.armanddu.boardgame.gomoku.stone.TestGomokuStoneMove;
import resources.com.github.armanddu.boardgame.rule.TestGameRules;

import static org.junit.Assert.*;

public class GomokuBoardTest {

  @Test
  public void test() {
    GameRules rules = new TestGameRules(null);
    Board map = new GomokuBoard(rules);
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
      Board map = new GomokuBoard(rules);

      map.applyMove(new GomokuStoneMove(new GomokuStone(StoneColor.BLACK, 0, 0), 0, 0));
      assertEquals(1, map.getStones().size());
      assertNotNull(map.get(0, 0));
      map.clear();
      assertTrue(map.getStones().isEmpty());
      assertNull((map.get(0, 0)));
  }

}
