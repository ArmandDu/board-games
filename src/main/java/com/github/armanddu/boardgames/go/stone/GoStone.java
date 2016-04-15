package com.github.armanddu.boardgames.go.stone;

import com.github.armanddu.boardgames.lib.stone.StoneColor;
import com.github.armanddu.boardgames.lib.stone.StoneImpl;

public class GoStone extends StoneImpl {

    public GoStone(StoneColor color, int x, int y) {
        super(x, y, color, new GoStoneType());
    }

}
