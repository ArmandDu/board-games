package resources.com.github.armanddu.boardgame.game;

import java.util.List;

import com.github.armanddu.boardgames.lib.game.GameBox;
import com.github.armanddu.boardgames.lib.game.GameManager;
import com.github.armanddu.boardgames.lib.board.Board;
import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.player.Players;
import com.github.armanddu.boardgames.lib.rule.GameRules;
import com.github.armanddu.boardgames.lib.stone.StoneMove;
import com.github.armanddu.boardgames.lib.stone.StonePack;

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

  public List<StonePack> getStonePacks() {
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


}
