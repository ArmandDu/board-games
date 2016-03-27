package com.github.armanddu.boardgame.gomoku.referee;

import java.util.List;

import com.github.armanddu.boardgame.game.GameBox;
import com.github.armanddu.boardgame.game.GameManager;
import com.github.armanddu.boardgame.gomoku.player.GomokuPlayers;
import com.github.armanddu.boardgame.player.Player;
import com.github.armanddu.boardgame.player.Players;
import com.github.armanddu.boardgame.referee.Referee;
import com.github.armanddu.boardgame.rule.GameRules;
import com.github.armanddu.boardgame.stone.StoneColor;
import com.github.armanddu.boardgame.stone.StoneMove;
import com.github.armanddu.boardgame.stone.StonePack;

public class GomokuReferee implements Referee {

  private GameManager config;
  private GameRules rules;
  private StoneColor current;

  public GomokuReferee() {}

  public void initGame(GameBox gameBox, Player player, List<Player> opponents) {
    Player opponent = player.chooseOponent(opponents);
    List<StonePack> remaining = player.chooseStonePack(gameBox.getStonePack());
    opponent.chooseStonePack(remaining);
    Players players = new GomokuPlayers(player, opponent);
    this.setConfig(gameBox.getManager(players));
    this.setRules(gameBox.getRules());
    this.initStartingPlayer();
  }

  public void updateStatus(StoneMove stoneMove) {
    this.config.updateStatus(stoneMove);
  }

  public boolean isValidMove(StoneMove stoneMove) {
    return this.rules.isValidMove(config.getMap(), stoneMove);
  }

  public boolean hasCaptures(StoneMove stoneMove) {
    return rules.hasCaptures(config.getMap(), stoneMove);
  }

  public void applyMove(StoneMove stoneMove) {
    this.config.applyMove(stoneMove);
  }

  public void applyCaptures(StoneMove stoneMove) {
    this.config.applyCaptures(stoneMove);
  }

  public void initStartingPlayer() {
    this.current = this.config.getStartingPlayer().getStoneColor();
  }

  public void setNextPlayerTurn() {
    this.current = this.config.getNextTurn();
  }

  public Player getCurrentPlayer() {
    return this.config.getPlayers().get(this.current);
  }

  public void updateGame() {
    StoneMove stoneMove = this.getCurrentPlayer().play(this.config.getBoard().getMap());
    this.updateStatus(stoneMove);
    this.applyMove(stoneMove);
    this.applyCaptures(stoneMove);
    this.setNextPlayerTurn();
  }

  public boolean isValidGame() {
    return this.rules.isValidGame(config);
  }

  public boolean isEndGame() {
    return this.rules.isEndGame(config.getMap(), this.getLastMove());
  }

  public StoneMove getLastMove() {
    return this.config.getLastMove();
  }

  private void setConfig(GameManager config) {
    this.config = config;
  }

  private void setRules(GameRules rules) {
    this.rules = rules;
  }


}
