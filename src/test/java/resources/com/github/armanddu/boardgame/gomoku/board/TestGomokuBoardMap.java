package resources.com.github.armanddu.boardgame.gomoku.board;

import com.github.armanddu.boardgame.gomoku.board.GomokuBoardReader;
import com.github.armanddu.boardgame.lib.board.Board;
import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.stone.Stone;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StoneMove;
import com.github.armanddu.boardgame.lib.stone.StonePosition;

public class TestGomokuBoardMap implements Board {

    private Stone[][] map;
    private int width;
    private int height;
    private BoardReader reader;

    public TestGomokuBoardMap() {
        this.width = 7;
        this.height = 7;
        this.map = new Stone[this.width][this.height];
        this.reader = new GomokuBoardReader(this);
    }

    public Stone get(int x, int y) {
        if (isInBoundaries(x, y)) {
            return this.map[x][y];
        }
        return null;
    }

    @Override
    public void set(int x, int y, Stone stone) {
        map[x][y] = stone;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean isValidMove(StoneMove move) {
        return true;
    }

    public StoneMove applyMove(StoneMove move) {
        StonePosition suggestedPosition = move.getSuggestedPosition();
        Stone stone = move.getStone();
        put(suggestedPosition, stone);
        stone.apply(suggestedPosition);
        return move;
    }

    private void put(StonePosition suggestedPosition, Stone stone) {
        this.map[suggestedPosition.getX()][suggestedPosition.getY()] = stone;
    }

    public BoardReader getMap() {
        return this.reader;
    }

    private boolean isInBoundaries(int x, int y) {
        return x >= 0 && y >= 0 && x < this.width && y < this.height;
    }

    public void setHeight(int height) {
        this.height = height;
        this.map = new Stone[this.width][this.height];
    }

    public void setWidth(int width) {
        this.width = width;
        this.map = new Stone[this.width][this.height];
    }

    @Override
    public int getScore(StoneColor color) {
        return 0;
    }

    @Override
    public void setScore(StoneColor color, int value) {

    }

}
