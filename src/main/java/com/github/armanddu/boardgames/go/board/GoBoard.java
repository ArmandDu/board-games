package com.github.armanddu.boardgames.go.board;

import com.github.armanddu.boardgames.go.rule.rules.GoMapSizeRule;
import com.github.armanddu.boardgames.lib.board.Board;
import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.rule.GameRules;
import com.github.armanddu.boardgames.lib.stone.Stone;
import com.github.armanddu.boardgames.lib.stone.StoneColor;
import com.github.armanddu.boardgames.lib.stone.StoneMove;
import com.github.armanddu.boardgames.lib.stone.StonePosition;

import java.util.*;

public class GoBoard implements Board {


    private Stone[][] map;
    private int width;
    private int height;
    private final BoardReader reader;
    private final GameRules rules;
    private final Map<StoneColor, Integer> scores;
    private final List<Stone> stones;

    public GoBoard(GameRules rules) {
        this.width = GoMapSizeRule.WIDTH;
        this.height = GoMapSizeRule.HEIGHT;
        this.rules = rules;
        this.map = new Stone[this.width][this.height];
        this.reader = new GoBoardReader(this);
        stones = new ArrayList<>();
        scores = new HashMap<>();
        scores.put(StoneColor.WHITE, 0);
        scores.put(StoneColor.BLACK, 0);
    }

    private void reset() {
        this.map = new Stone[this.width][this.height];
        this.stones.clear();
        scores.put(StoneColor.WHITE, 0);
        scores.put(StoneColor.BLACK, 0);
    }

    public Stone get(int x, int y) {
        if (isInBoundaries(x, y)) {
            return this.map[x][y];
        }
        return null;
    }

    public Stone get(StonePosition position) {
       return get(position.getX(), position.getY());
    }

    public void clear()
    {
        reset();
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public StoneMove applyMove(StoneMove move) {
        if (move != null && isInBoundaries(move.getSuggestedPosition())) {
            StonePosition suggestedPosition = move.getSuggestedPosition();
            Stone stone = move.getStone();
            put(suggestedPosition, stone);
            stone.apply(suggestedPosition);
            return move;
        }
        return  null;
    }

    public boolean isValidMove(StoneMove move) { return rules.isValidMove(getMap(), move);}

    private void put(StonePosition suggestedPosition, Stone stone) {
        put(suggestedPosition.getX(), suggestedPosition.getY(), stone);
    }
    private void put(int x, int y, Stone stone) {
        this.map[x][y] = stone;
        this.stones.add(stone);
    }

    public BoardReader getMap() {
        return this.reader;
    }

    public Stone getLastStone() {
        return stones.isEmpty() ? null : stones.get(stones.size() - 1);
    }

    private boolean isInBoundaries(StonePosition pos) {
        return isInBoundaries(pos.getX(), pos.getY());
    }
    private boolean isInBoundaries(int x, int y) {
        return x >= 0 && y >= 0 && x < this.width && y < this.height;
    }

    public void setHeight(int height) {
        this.height = height;
        reset();
    }

    public void setWidth(int width) {
        this.width = width;
        reset();
    }
    public int getScore(StoneColor color) {
        return scores.getOrDefault(color, 0);
    }

    public void setScore(StoneColor color, int value) {
        if (scores.containsKey(color)) scores.put(color, value);
    }

    @Override
    public List<Stone> getStones() {
        return Collections.unmodifiableList(stones);
    }

}
