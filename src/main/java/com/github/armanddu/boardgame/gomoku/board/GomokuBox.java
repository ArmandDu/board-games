package com.github.armanddu.boardgame.gomoku.board;

import java.util.ArrayList;
import java.util.List;

import com.github.armanddu.boardgame.lib.rule.config.RuleConfig;
import com.github.armanddu.boardgame.lib.game.GameBox;
import com.github.armanddu.boardgame.lib.game.GameManager;
import com.github.armanddu.boardgame.gomoku.rule.GomokuRules;
import com.github.armanddu.boardgame.lib.board.Board;
import com.github.armanddu.boardgame.lib.player.Players;
import com.github.armanddu.boardgame.lib.rule.GameRules;
import com.github.armanddu.boardgame.lib.stone.StonePack;

public class GomokuBox implements GameBox {

  private final Board board;
  private final GameRules rules;
  private final List<StonePack> stonePacks;

  public GomokuBox() {
    this.rules = new GomokuRules();
    this.board = new GomokuBoard(rules);
    stonePacks = new ArrayList<>();
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
