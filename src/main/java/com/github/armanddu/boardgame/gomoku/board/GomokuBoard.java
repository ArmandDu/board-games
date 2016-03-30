package com.github.armanddu.boardgame.gomoku.board;

import com.github.armanddu.boardgame.gomoku.rule.rules.GomokuMapSizeRule;
import com.github.armanddu.boardgame.lib.board.Board;
import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.rule.GameRules;
import com.github.armanddu.boardgame.lib.stone.Stone;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StoneMove;
import com.github.armanddu.boardgame.lib.stone.StonePosition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GomokuBoard implements Board {


    private Stone[][] map;
    private int width;
    private int height;
    private final BoardReader manipulator;
    private final GameRules rules;
    private final Map<StoneColor, Integer> scores;
    private final List<Stone> stones;

    public GomokuBoard(GameRules rules) {
        this.width = GomokuMapSizeRule.WIDTH;
        this.height = GomokuMapSizeRule.HEIGHT;
        this.rules = rules;
        this.map = new Stone[this.width][this.height];
        this.manipulator = new GomokuBoardReader(this);
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

    public boolean isValidMove(StoneMove move) {
        return this.rules.isValidMove(this.getMap(), move);
    }

    public StoneMove applyMove(StoneMove move) {
        if (this.isValidMove(move)) {
            StonePosition suggestedPosition = move.getSuggestedPosition();
            Stone stone = move.getStone();
            put(suggestedPosition, stone);
            stone.apply(suggestedPosition);
            return move;
        }
        return  null;
    }

    private void put(StonePosition suggestedPosition, Stone stone) {
        put(suggestedPosition.getX(), suggestedPosition.getY(), stone);
    }
    private void put(int x, int y, Stone stone) {
        this.map[x][y] = stone;
        this.stones.add(stone);
    }

    public BoardReader getMap() {
        return this.manipulator;
    }

    public Stone getLastStone() {
        return stones.isEmpty() ? null : stones.get(stones.size() - 1);
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
        return stones;
    }

}
