package com.github.armanddu.boardgame.gomoku.board;

import java.util.List;

import com.github.armanddu.boardgame.lib.game.GameBox;
import com.github.armanddu.boardgame.lib.game.GameManager;
import com.github.armanddu.boardgame.lib.board.Board;
import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.player.Player;
import com.github.armanddu.boardgame.lib.player.Players;
import com.github.armanddu.boardgame.lib.rule.GameRules;
import com.github.armanddu.boardgame.lib.stone.Stone;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StoneMove;
import com.github.armanddu.boardgame.lib.stone.StonePack;

public class GomokuGameManager implements GameManager {

  private final Players players;
  private final Board board;
  private final GameRules rules;
  private final List<StonePack> stonePacks;
  private StoneMove lastMove;

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

  public void applyMove(StoneMove move) {
    lastMove = this.board.applyMove(move);
  }

  public void applyCaptures(StoneMove move) {
    if (this.rules.hasCaptures(board.getMap(), move)) {
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

  public void updateStatus(StoneMove move) {
    // TODO Auto-generated method stub

  }

  public void setMapWidth(int width) {
    this.getBoard().setWidth(width);
  }

  public void setMapHeight(int height) {
    this.getBoard().setHeight(height);
  }

  public void setMap(int x, int y, Stone stone) {
    getBoard().forceSet(x, y, stone);
  }

  public BoardReader getMap() {
    return board.getMap();
  }

  public List<StonePack> getStonePacks() {
    return stonePacks;
  }

}
