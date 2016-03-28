package com.github.armanddu.boardgame.gomoku.referee;

import java.util.List;

import com.github.armanddu.boardgame.game.GameBox;
import com.github.armanddu.boardgame.game.GameManager;
import com.github.armanddu.boardgame.gomoku.player.GomokuPlayers;
import com.github.armanddu.boardgame.map.BoardReader;
import com.github.armanddu.boardgame.player.Player;
import com.github.armanddu.boardgame.player.Players;
import com.github.armanddu.boardgame.referee.Referee;
import com.github.armanddu.boardgame.rule.GameRules;
import com.github.armanddu.boardgame.stone.StoneColor;
import com.github.armanddu.boardgame.stone.StoneMove;
import com.github.armanddu.boardgame.stone.StonePack;

public class GomokuReferee implements Referee {

  private GameManager manager;
  private GameRules rules;
  private StoneColor current;

  public GomokuReferee() {}

  public void initGame(GameBox gameBox, Player player, List<Player> opponents) {
    Player opponent = player.chooseOpponent(opponents);
    List<StonePack> remaining = player.chooseStonePack(gameBox.getStonePack());
    opponent.chooseStonePack(remaining);
    Players players = new GomokuPlayers(player, opponent);
    this.setManager(gameBox.getManager(players));
    this.setRules(gameBox.getRules());
    this.initStartingPlayer();
  }

  public void updateStatus(StoneMove stoneMove) {
    this.manager.updateStatus(stoneMove);
  }

  public boolean isValidMove(StoneMove stoneMove) {
    return this.rules.isValidMove(manager.getMap(), stoneMove);
  }

  public boolean hasCaptures(StoneMove stoneMove) {
    return rules.hasCaptures(manager.getMap(), stoneMove);
  }

  public void applyMove(StoneMove stoneMove) {
    this.manager.applyMove(stoneMove);
  }

  public void applyCaptures(StoneMove stoneMove) {
    this.manager.applyCaptures(stoneMove);
  }

  public void initStartingPlayer() {
    this.current = this.manager.getStartingPlayer().getStoneColor();
  }

  public void setNextPlayerTurn() {
    this.current = this.manager.getNextTurn();
  }

  public Player getCurrentPlayer() {
    return this.manager.getPlayers().get(this.current);
  }

  public void updateGame() {
    BoardReader map = this.manager.getBoard().getMap();
    StoneMove stoneMove = this.getCurrentPlayer().play(map);
    this.updateStatus(stoneMove);
    this.applyMove(stoneMove);
    this.applyCaptures(stoneMove);
    this.setNextPlayerTurn();
  }

  public boolean isValidGame() {
    return this.rules.isValidGame(manager);
  }

  public boolean isEndGame() {
    return this.rules.isEndGame(manager.getMap(), this.getLastMove());
  }

  public StoneMove getLastMove() {
    return this.manager.getLastMove();
  }

  private void setManager(GameManager manager) {
    this.manager = manager;
  }

  private void setRules(GameRules rules) {
    this.rules = rules;
  }


}
