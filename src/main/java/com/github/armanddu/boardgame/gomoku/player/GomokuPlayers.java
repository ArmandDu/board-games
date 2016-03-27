package com.github.armanddu.boardgame.gomoku.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.armanddu.boardgame.player.Player;
import com.github.armanddu.boardgame.player.Players;
import com.github.armanddu.boardgame.stone.StoneColor;

public class GomokuPlayers implements Players {


  private Map<StoneColor, Player> players;

  public GomokuPlayers(Player player, Player opponent) {
    this();
    this.players.put(player.getStoneColor(), player);
    this.players.put(opponent.getStoneColor(), opponent);
  }

  public GomokuPlayers() {
    this.players = new HashMap<StoneColor, Player>();
  }

  public void setWhite(Player player) {
    this.players.put(StoneColor.WHITE, player);
  }

  public void setBlack(Player player) {
    this.players.put(StoneColor.BLACK, player);
  }

  public Player getWhite() {
    return this.players.getOrDefault(StoneColor.WHITE, null);
  }

  public Player getBlack() {
    return this.players.getOrDefault(StoneColor.BLACK, null);
  }

  public List<Player> asList() {
    return new ArrayList<Player>(this.players.values());
  }

  public Map<StoneColor, Player> asMap() {
    return this.players;
  }

  public Player get(StoneColor color) {
    return this.players.getOrDefault(color, null);
  }

}
