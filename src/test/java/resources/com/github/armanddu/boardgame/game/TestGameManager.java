package resources.com.github.armanddu.boardgame.game;

import com.github.armanddu.boardgame.lib.game.GameBox;
import com.github.armanddu.boardgame.lib.game.GameManager;
import com.github.armanddu.boardgame.lib.board.Board;
import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.player.Player;
import com.github.armanddu.boardgame.lib.player.Players;
import com.github.armanddu.boardgame.lib.stone.Stone;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StoneMove;
import com.github.armanddu.boardgame.lib.stone.StonePack;

import java.util.List;

public class TestGameManager implements GameManager {

    private Board board;

    public TestGameManager(GameBox gameBox, Players players) {
    }

    public TestGameManager() {

    }

    public TestGameManager(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        // TODO Auto-generated method stub
        return board;
    }

    public void applyMove(StoneMove move) {
        board.applyMove(move);
    }

    public void applyCaptures(StoneMove move) {
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

    public void updateStatus(StoneMove move) {
        // TODO Auto-generated method stub

    }

    public void setMapWidth(int width) {
        // TODO Auto-generated method stub

    }

    public void setMapHeight(int height) {
        // TODO Auto-generated method stub

    }

    public void setMap(int i, int j, Stone stone) {
        board.set(i, j, stone);
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
