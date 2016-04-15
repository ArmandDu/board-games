package resources.com.github.armanddu.boardgame.game;

import com.github.armanddu.boardgames.lib.game.GameBox;
import com.github.armanddu.boardgames.lib.game.GameManager;
import com.github.armanddu.boardgames.lib.board.Board;
import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.player.Players;
import com.github.armanddu.boardgames.lib.stone.StoneMove;
import com.github.armanddu.boardgames.lib.stone.StonePack;

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

    public Players getPlayers() {
        // TODO Auto-generated method stub
        return null;
    }

    public void updateStatus(StoneMove move) {
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
