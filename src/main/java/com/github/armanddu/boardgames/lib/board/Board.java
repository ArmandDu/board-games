package com.github.armanddu.boardgames.lib.board;

import com.github.armanddu.boardgames.lib.stone.Stone;
import com.github.armanddu.boardgames.lib.stone.StoneColor;
import com.github.armanddu.boardgames.lib.stone.StoneMove;
import com.github.armanddu.boardgames.lib.stone.StonePosition;

import java.util.List;

public interface Board {

    Stone get(int x, int y);

    Stone get(StonePosition position);

    void clear();

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
