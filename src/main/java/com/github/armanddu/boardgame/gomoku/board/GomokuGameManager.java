package com.github.armanddu.boardgame.gomoku.board;

import java.util.List;

import com.github.armanddu.boardgame.game.GameBox;
import com.github.armanddu.boardgame.game.GameManager;
import com.github.armanddu.boardgame.map.Board;
import com.github.armanddu.boardgame.map.BoardReader;
import com.github.armanddu.boardgame.player.Player;
import com.github.armanddu.boardgame.player.Players;
import com.github.armanddu.boardgame.rule.GameRules;
import com.github.armanddu.boardgame.stone.Stone;
import com.github.armanddu.boardgame.stone.StoneColor;
import com.github.armanddu.boardgame.stone.StoneMove;
import com.github.armanddu.boardgame.stone.StonePack;

public class GomokuGameManager implements GameManager {

  private Players players;
  private Board board;
  private GameRules rules;
  private StoneMove lastMove;
  private List<StonePack> stonePacks;

  public GomokuGameManager(Players players, GameBox gameBox) {
    this.players = players;
    this.board = gameBox.getBoard();
    this.rules = gameBox.getRules();
    this.stonePacks = gameBox.getStonePack();
    this.lastMove = null;
  }

  public Board getBoard() {
    return this.board;
  }

  public void applyMove(StoneMove stoneMove) {
    lastMove = this.board.applyMove(stoneMove);
  }

  public void applyCaptures(StoneMove stoneMove) {
    if (this.rules.hasCaptures(board.getMap(), stoneMove)) {
      // TODO Auto-generated method stub
    }
  }

  public Player getStartingPlayer() {
    return this.players.getStartingPlayer();
  }

  public Players getPlayers() {
    return this.players;
  }

  public StoneColor getNextTurn() {
    // TODO Auto-generated method stub
    return null;
  }

  public StoneMove getLastMove() {
    return this.lastMove;
  }

  public void updateStatus(StoneMove stoneMove) {
    // TODO Auto-generated method stub

  }

  public void setMapWidth(int width) {
    this.getBoard().setWidth(width);
  }

  public void setMapHeight(int height) {
    this.getBoard().setHeight(height);
  }

  public void setMap(int i, int j, Stone stone) {
    getBoard().set(i, j, stone);
  }

  public BoardReader getMap() {
    return board.getMap();
  }

  public List<StonePack> getStonePacks() {
    return stonePacks;
  }

}
