package com.github.armanddu.boardgame.gomoku.stone;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.armanddu.boardgame.player.Player;
import com.github.armanddu.boardgame.stone.Stone;
import com.github.armanddu.boardgame.stone.StoneColor;
import resources.com.github.armanddu.boardgame.gomoku.player.TestGomokuPlayer;

public class GomokuStoneTest {

  private static final String PLAYER_1 = "player 1";

  @Test
  public void test() {
    StoneColor color = StoneColor.WHITE;
    int y = 0;
    int x = 0;
    Stone stone = new GomokuStone(color, x, y);
    Player player = new TestGomokuPlayer(PLAYER_1, StoneColor.WHITE);
    stone.setOwner(player);
    assertNotNull(stone);
    assertEquals(StoneColor.WHITE, stone.getColor());
    assertEquals(GomokuStoneType.type, stone.getType().type());
    assertEquals(PLAYER_1, stone.getOwner().getName());
  }

}
