package resources.com.github.armanddu.boardgame.game;

import java.util.List;

import com.github.armanddu.boardgame.game.GameBox;
import com.github.armanddu.boardgame.game.GameManager;
import com.github.armanddu.boardgame.map.Board;
import com.github.armanddu.boardgame.map.BoardReader;
import com.github.armanddu.boardgame.player.Players;
import com.github.armanddu.boardgame.rule.GameRules;
import com.github.armanddu.boardgame.stone.StoneMove;
import com.github.armanddu.boardgame.stone.StonePack;

public class TestGameBox implements GameBox {

  public TestGameBox() {
    // TODO Auto-generated constructor stub
  }

  public BoardReader getMap() {
    // TODO Auto-generated method stub
    return null;
  }

  public GameRules getRules() {
    // TODO Auto-generated method stub
    return null;
  }

  public List<StonePack> getStonePack() {
    // TODO Auto-generated method stub
    return null;
  }

  public GameManager getManager(Players players) {
    return new TestGameManager();
  }

  @Override
  public Board getBoard() {
    return null;
  }

  public void applyMove(StoneMove stoneMove) {
    // TODO Auto-generated method stub
    
  }

  public void setHeight(int height) {
    // TODO Auto-generated method stub
    
  }

  public void setWidth(int width) {
    // TODO Auto-generated method stub
    
  }

}
