package resources.com.github.armanddu.boardgame.rule;

import com.github.armanddu.boardgame.config.RuleConfig;
import com.github.armanddu.boardgame.game.GameManager;
import com.github.armanddu.boardgame.map.BoardReader;
import com.github.armanddu.boardgame.rule.GameRules;
import com.github.armanddu.boardgame.rule.Rule;
import com.github.armanddu.boardgame.stone.StoneMove;

public class TestGameRules implements GameRules {

  public TestGameRules(GameManager gameManager) {
    // TODO Auto-generated constructor stub
  }

  public void configGame() {
    // TODO Auto-generated method stub

  }

  public boolean isValidGame() {
    // TODO Auto-generated method stub
    return true;
  }

  public boolean isValidMove(StoneMove stoneMove) {
    // TODO Auto-generated method stub
    return true;
  }

  public boolean hasCaptures(StoneMove stoneMove) {
    // TODO Auto-generated method stub
    return true;
  }

  public boolean shouldChangeTurn(StoneMove stoneMove) {
    // TODO Auto-generated method stub
    return true;
  }

  public boolean isEndGame(StoneMove stoneMove) {
    // TODO Auto-generated method stub
    return true;
  }

  public boolean isWin(StoneMove stoneMove) {
    // TODO Auto-generated method stub
    return true;
  }

  public boolean isDraw(StoneMove stoneMove) {
    // TODO Auto-generated method stub
    return true;
  }

  public Rule getLastInvalidRule() {
    // TODO Auto-generated method stub
    return null;
  }

  public void configGame(GameManager config) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public RuleConfig getConfig() {
    return null;
  }

  public boolean isValidGame(GameManager config) {
    // TODO Auto-generated method stub
    return true;
  }

  public boolean isValidMove(BoardReader map, StoneMove stoneMove) {
    // TODO Auto-generated method stub
    return true;
  }

  public boolean hasCaptures(BoardReader map, StoneMove stoneMove) {
    // TODO Auto-generated method stub
    return true;
  }

  public boolean shouldChangeTurn(BoardReader map, StoneMove stoneMove) {
    // TODO Auto-generated method stub
    return true;
  }

  public boolean isEndGame(BoardReader map, StoneMove stoneMove) {
    // TODO Auto-generated method stub
    return true;
  }

  public boolean isWin(BoardReader map, StoneMove stoneMove) {
    // TODO Auto-generated method stub
    return true;
  }

  public boolean isDraw(BoardReader map, StoneMove stoneMove) {
    // TODO Auto-generated method stub
    return true;
  }

}
