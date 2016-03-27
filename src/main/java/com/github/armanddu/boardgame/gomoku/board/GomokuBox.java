package com.github.armanddu.boardgame.gomoku.board;

import java.util.ArrayList;
import java.util.List;

import com.github.armanddu.boardgame.config.RuleConfig;
import com.github.armanddu.boardgame.game.GameBox;
import com.github.armanddu.boardgame.game.GameManager;
import com.github.armanddu.boardgame.gomoku.rules.GomokuRules;
import com.github.armanddu.boardgame.map.Board;
import com.github.armanddu.boardgame.player.Players;
import com.github.armanddu.boardgame.rule.GameRules;
import com.github.armanddu.boardgame.stone.StonePack;

public class GomokuBox implements GameBox {

  private Board board;
  private GameRules rules;
  private List<StonePack> stonePacks;

  public GomokuBox() {
    this.rules = new GomokuRules();
    this.board = new GomokuBoardMap(rules);
    stonePacks = new ArrayList<StonePack>();
    GomokuGameManager manager = new GomokuGameManager(null, this);
    RuleConfig config = rules.getConfig();
    config.setStonePacks(manager);
    config.setBoard(manager);
  }

  public Board getBoard() {
    return board;
  }

  public GameRules getRules() {
    return this.rules;
  }

  public List<StonePack> getStonePack() {
    return stonePacks;
  }

  public GameManager getManager(Players players) {
    return new GomokuGameManager(players, this);
  }
}
