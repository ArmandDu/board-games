package resources.com.github.armanddu.boardgame.gomoku.board;

import com.github.armanddu.boardgames.go.board.GoBoardReader;
import com.github.armanddu.boardgames.go.rule.GoStonePositionRuleSet;
import com.github.armanddu.boardgames.lib.board.Board;
import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.rule.StoneRuleSet;
import com.github.armanddu.boardgames.lib.stone.Stone;
import com.github.armanddu.boardgames.lib.stone.StoneColor;
import com.github.armanddu.boardgames.lib.stone.StoneMove;
import com.github.armanddu.boardgames.lib.stone.StonePosition;

import java.util.ArrayList;
import java.util.List;

public class TestGomokuBoardMap implements Board {

    private final StoneRuleSet rules;
    private Stone[][] map;
    private int width;
    private int height;
    private BoardReader reader;
    private List<Stone> stones;

    public TestGomokuBoardMap() {
        this.width = 7;
        this.height = 7;
        this.map = new Stone[this.width][this.height];
        this.reader = new GoBoardReader(this);
        this.stones = new ArrayList<>();
        this.rules = new GoStonePositionRuleSet();
    }

    public Stone get(int x, int y) {
        if (isInBoundaries(x, y)) {
            return this.map[x][y];
        }
        return null;
    }

    @Override
    public Stone get(StonePosition position) {
        return get(position.getX(), position.getY());
    }

    @Override
    public void clear() {
        this.map = new Stone[width][height];
        stones.clear();
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean isValidMove(StoneMove move) {
        return rules.isValid(getMap(), move);
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
        this.stones.add(stone);
    }

    public BoardReader getMap() {
        return this.reader;
    }

    @Override
    public Stone getLastStone() {
        return stones.isEmpty() ? null : stones.get(stones.size() - 1);
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

    @Override
    public List<Stone> getStones() {
        return stones;
    }

}
