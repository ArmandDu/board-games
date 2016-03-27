package resources.com.github.armanddu.boardgame.game;

import com.github.armanddu.boardgame.game.GameBox;
import com.github.armanddu.boardgame.game.GameManager;
import com.github.armanddu.boardgame.map.Board;
import com.github.armanddu.boardgame.map.BoardReader;
import com.github.armanddu.boardgame.player.Player;
import com.github.armanddu.boardgame.player.Players;
import com.github.armanddu.boardgame.stone.Stone;
import com.github.armanddu.boardgame.stone.StoneColor;
import com.github.armanddu.boardgame.stone.StoneMove;
import com.github.armanddu.boardgame.stone.StonePack;

import java.util.List;

public class TestGameManager implements GameManager {

  public TestGameManager(GameBox gameBox, Players players) {
  }

  public TestGameManager() {

  }

  public Board getBoard() {
    // TODO Auto-generated method stub
    return null;
  }

  public void applyMove(StoneMove stoneMove) {
    // TODO Auto-generated method stub
    
  }

  public void applyCaptures(StoneMove stoneMove) {
    // TODO Auto-generated method stub
    
  }

  public Player getStartingPlayer() {
    // TODO Auto-generated method stub
    return null;
  }

  public Players getPlayers() {
    // TODO Auto-generated method stub
    return null;
  }

  public StoneColor getNextTurn() {
    // TODO Auto-generated method stub
    return null;
  }

  public StoneMove getLastMove() {
    // TODO Auto-generated method stub
    return null;
  }

  public void updateStatus(StoneMove stoneMove) {
    // TODO Auto-generated method stub
    
  }

  public void setMapWidth(int width) {
    // TODO Auto-generated method stub
    
  }

  public void setMapHeight(int height) {
    // TODO Auto-generated method stub
    
  }

  public void setMap(int i, int j, Stone stone) {
    // TODO Auto-generated method stub
    
  }

  public BoardReader getMap() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<StonePack> getStonePacks() {
    return null;
  }

}
