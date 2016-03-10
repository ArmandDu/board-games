package org.github.armanddu.boardgame.game;

import java.util.ArrayList;
import java.util.List;

import org.github.armanddu.boardgame.player.Player;
import org.github.armanddu.boardgame.referee.Referee;
import org.github.armanddu.boardgame.rule.Rule;

public class Game {

  private String name;
  private Rule rules;
  private Referee referee;
  private List<Player> players;

  public Game(String name) {
    this.name = name;
    this.players = new ArrayList<Player>();
    this.rules = null;
    this.referee = null;
  }

  public void start() throws GameException {
    if (this.rules == null) {
      throw new GameException("Rules is required");
    }
    if (this.referee == null) {
      throw new GameException("Referee is required");
    }
    if (!this.rules.isEnoughPlayers(this.players.size())) {
      throw new GameException(this.rules.getPlayersRules());
    }
  }

  public void setRules(Rule rules) {
    this.rules = rules;

  }

  public void setReferee(Referee referee) {
    this.referee = referee;

  }

  public String getName() {
    return this.name;
  }

  public void addPlayer(Player player) {
    this.players.add(player);

  }

  public List<Player> getPlayers() {
    return this.players;
  }

}
