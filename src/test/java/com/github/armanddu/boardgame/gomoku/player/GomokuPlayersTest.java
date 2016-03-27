package com.github.armanddu.boardgame.gomoku.player;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.armanddu.boardgame.player.Player;
import com.github.armanddu.boardgame.player.Players;
import com.github.armanddu.boardgame.stone.StoneColor;
import resources.com.github.armanddu.boardgame.gomoku.player.TestGomokuPlayer;

public class GomokuPlayersTest {

  private static final StoneColor BLACK = StoneColor.BLACK;
  private static final StoneColor WHITE = StoneColor.WHITE;
  private static final String PLAYER_1 = "player 1";
  private static final String PLAYER_2 = "player 2";

  @Test
  public void PlayersSetByConstructor() {
    Player p1 = new TestGomokuPlayer(PLAYER_1, WHITE);
    Player p2 = new TestGomokuPlayer(PLAYER_2, BLACK);

    Players players = new GomokuPlayers(p1, p2);
    assertNotNull(players);
    assertEquals(PLAYER_1, players.getWhite().getName());
    assertEquals(PLAYER_2, players.getBlack().getName());
    assertEquals(PLAYER_1, players.get(WHITE).getName());
    assertEquals(PLAYER_2, players.get(BLACK).getName());
    assertEquals(2, players.asList().size());
    assertEquals(2, players.asMap().size());
  }

  @Test
  public void PlayersSetWithSetters() {
    Player p1 = new TestGomokuPlayer(PLAYER_1, WHITE);
    Player p2 = new TestGomokuPlayer(PLAYER_2, BLACK);

    Players players = new GomokuPlayers();
    assertNotNull(players);
    players.setWhite(p1);
    players.setBlack(p2);
    assertEquals(PLAYER_1, players.getWhite().getName());
    assertEquals(PLAYER_2, players.getBlack().getName());
    assertEquals(PLAYER_1, players.get(WHITE).getName());
    assertEquals(PLAYER_2, players.get(BLACK).getName());
    assertEquals(2, players.asList().size());
    assertEquals(2, players.asMap().size());
  }

}
