package com.github.armanddu.boardgame.gomoku.board;

import com.github.armanddu.boardgame.map.Board;
import com.github.armanddu.boardgame.map.BoardReader;
import com.github.armanddu.boardgame.rule.GameRules;
import com.github.armanddu.boardgame.stone.Stone;
import com.github.armanddu.boardgame.stone.StoneMove;
import com.github.armanddu.boardgame.stone.StonePosition;

public class GomokuBoard implements Board {


    private Stone[][] map;
    private int width;
    private int height;
    private BoardReader manipulator;
    private GameRules rules;

    public GomokuBoard(GameRules rules) {
        this.width = 19;
        this.height = 19;
        this.rules = rules;
        this.map = new Stone[this.width][this.height];
        this.manipulator = new GomokuBoardReader(this);
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

    public boolean isValidMove(StoneMove stoneMove) {
        return this.rules.isValidMove(this.getMap(), stoneMove);
    }

    public StoneMove applyMove(StoneMove stoneMove) {
        if (this.isValidMove(stoneMove)) {
            StonePosition suggestedPosition = stoneMove.getSuggestedPosition();
            Stone stone = stoneMove.getStone();
            put(suggestedPosition, stone);
            stone.apply(suggestedPosition);
            return stoneMove;
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

}
