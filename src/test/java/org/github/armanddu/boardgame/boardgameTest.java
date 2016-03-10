package org.github.armanddu.boardgame;

import static org.junit.Assert.*;

import org.github.armanddu.boardgame.game.Game;
import org.github.armanddu.boardgame.game.GameException;
import org.github.armanddu.boardgame.gomoku.ia.IAPlayer;
import org.github.armanddu.boardgame.gomoku.referee.GomokuReferee;
import org.github.armanddu.boardgame.gomoku.rule.GomokuRules;
import org.github.armanddu.boardgame.player.Player;
import org.github.armanddu.boardgame.referee.Referee;
import org.github.armanddu.boardgame.rule.Rule;
import org.junit.Test;

public class boardgameTest {

  @Test
  public void shouldCreateNewGame() {
    String name = "game";
    Game game = new Game(name);

    assertEquals(game.getName(), name);
  }

  @Test(expected = GameException.class)
  public void cantRunGameIfNoRulesOrRefereeOrPlayersSet() throws GameException {
    Game game = new Game("game");

    game.start();
  }

  @Test(expected = GameException.class)
  public void cantRunGameIfRuleSetButNoRefereeOrPLayerSet() throws GameException {
    Game game = new Game("game");
    Rule rules = new GomokuRules();

    game.setRules(rules);
    game.start();
  }

  @Test(expected = GameException.class)
  public void cantRunGameIfRuleAndRefereeSetButNoPLayerSet() throws GameException {
    Game game = new Game("game");
    Rule rules = new GomokuRules();
    Referee referee = new GomokuReferee();

    game.setRules(rules);
    game.setReferee(referee);
    game.start();
  }

  @Test(expected = GameException.class)
  public void cantRunGameIfRuleAndRefereeAndSetButOnlyOnePlayerSet() throws GameException {
    Game game = new Game("game");
    Rule rules = new GomokuRules();
    Referee referee = new GomokuReferee();
    Player player1 = new IAPlayer();

    game.setRules(rules);
    game.setReferee(referee);
    game.addPlayer(player1);
    game.start();
  }

  @Test
  public void canRunGameIfGameHaveRulesRefereeandTwoPlayers() throws GameException {
    Game game = new Game("game");
    Rule rules = new GomokuRules();
    Referee referee = new GomokuReferee();
    Player player1 = new IAPlayer();
    Player player2 = new IAPlayer();

    game.setRules(rules);
    game.setReferee(referee);
    game.addPlayer(player1);
    game.addPlayer(player2);
    game.start();
  }

}
