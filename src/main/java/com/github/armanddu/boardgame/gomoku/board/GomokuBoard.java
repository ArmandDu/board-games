package com.github.armanddu.boardgame.gomoku.board;

import com.github.armanddu.boardgame.lib.board.Board;
import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.rule.GameRules;
import com.github.armanddu.boardgame.lib.stone.Stone;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StoneMove;
import com.github.armanddu.boardgame.lib.stone.StonePosition;

import java.util.HashMap;
import java.util.Map;

public class GomokuBoard implements Board {


    private Stone[][] map;
    private int width;
    private int height;
    private final BoardReader manipulator;
    private final GameRules rules;
    private final Map<StoneColor, Integer> scores;

    public GomokuBoard(GameRules rules) {
        this.width = 19;
        this.height = 19;
        this.rules = rules;
        this.map = new Stone[this.width][this.height];
        this.manipulator = new GomokuBoardReader(this);
        scores = new HashMap<>();
        scores.put(StoneColor.WHITE, 0);
        scores.put(StoneColor.BLACK, 0);
    }

    public Stone get(int x, int y) {
        if (isInBoundaries(x, y)) {
            return this.map[x][y];
        }
        return null;
    }

    @Override
    public void set(int x, int y, Stone stone) {
        if (isInBoundaries(x, y)) {
            put(x, y, stone);
        }
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
    }

    public BoardReader getMap() {
        return this.manipulator;
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
    public int getScore(StoneColor color) {
        return scores.getOrDefault(color, 0);
    }

    public void setScore(StoneColor color, int value) {
        if (scores.containsKey(color)) scores.put(color, value);
    }

}
