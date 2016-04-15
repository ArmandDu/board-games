package com.github.armanddu.boardgames.lib.stone;

import java.util.List;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public interface StoneNodeChild {
    int getWeight();

    List<Stone> getStones();

    boolean isFree();
}
