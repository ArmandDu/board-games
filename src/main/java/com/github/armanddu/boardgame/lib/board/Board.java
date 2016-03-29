package com.github.armanddu.boardgame.lib.board;

import com.github.armanddu.boardgame.lib.stone.Stone;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StoneMove;

import java.util.List;

public interface Board {

    Stone get(int x, int y);

    void forceSet(int x, int y, Stone stone);

    int getWidth();

    int getHeight();

    boolean isValidMove(StoneMove move);

    StoneMove applyMove(StoneMove move);

    BoardReader getMap();

    Stone getLastStone();

    void setHeight(int height);

    void setWidth(int width);

    int getScore(StoneColor color);

    void setScore(StoneColor color, int value);

    List<Stone> getStones();
}
