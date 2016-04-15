package com.github.armanddu.boardgames.gomoku.stone;

import com.github.armanddu.boardgames.lib.stone.StoneColor;
import com.github.armanddu.boardgames.lib.stone.StoneImpl;

public class GomokuStone extends StoneImpl {

    public GomokuStone(StoneColor color, int x, int y) {
        super(x, y, color, new GomokuStoneType());
    }

}
