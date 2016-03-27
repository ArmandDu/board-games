package resources.com.github.armanddu.boardgame.referee;

import java.util.List;

import com.github.armanddu.boardgame.game.GameBox;
import com.github.armanddu.boardgame.game.GameManager;
import com.github.armanddu.boardgame.player.Player;
import com.github.armanddu.boardgame.referee.Referee;
import com.github.armanddu.boardgame.stone.StoneMove;

public class TestReferee implements Referee {

  public TestReferee(GameManager gameManager) {
    // TODO Auto-generated constructor stub
  }

  public void updateStatus(StoneMove stoneMove) {
    // TODO Auto-generated method stub
    
  }

  public void initGame(GameBox gameBox, Player player, List<Player> opponents) {
    // TODO Auto-generated method stub
    
  }

  public boolean isValidMove(StoneMove stoneMove) {
    // TODO Auto-generated method stub
    return false;
  }

  public boolean hasCaptures(StoneMove stoneMove) {
    // TODO Auto-generated method stub
    return false;
  }

  public void applyMove(StoneMove stoneMove) {
    // TODO Auto-generated method stub
    
  }

  public void applyCaptures(StoneMove stoneMove) {
    // TODO Auto-generated method stub
    
  }

  public void initStartingPlayer() {
    // TODO Auto-generated method stub
    
  }

  public void setNextPlayerTurn() {
    // TODO Auto-generated method stub
    
  }

  public Player getCurrentPlayer() {
    // TODO Auto-generated method stub
    return null;
  }

  public void updateGame() {
    // TODO Auto-generated method stub
    
  }

  public boolean isValidGame() {
    // TODO Auto-generated method stub
    return false;
  }

  public boolean isEndGame() {
    // TODO Auto-generated method stub
    return false;
  }

  public StoneMove getLastMove() {
    // TODO Auto-generated method stub
    return null;
  }


}
