package com.github.armanddu.boardgame.gomoku.board;

import com.github.armanddu.boardgame.map.Board;
import com.github.armanddu.boardgame.map.BoardReader;
import com.github.armanddu.boardgame.rule.GameRules;
import com.github.armanddu.boardgame.stone.StoneMove;
import org.junit.Test;
import resources.com.github.armanddu.boardgame.gomoku.stone.TestGomokuStoneMove;
import resources.com.github.armanddu.boardgame.rule.TestGameRules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

}
