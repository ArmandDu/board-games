package com.github.armanddu.boardgames.lib.player;

import java.util.List;
import java.util.Map;

import com.github.armanddu.boardgames.lib.stone.StoneColor;

/** Players interface
 *
 */
public interface Players {

    void set(Player player1);

    Player getWhite();

    Player getBlack();

    List<Player> asList();

    Map<StoneColor, Player> asMap();

    Player get(StoneColor color);

    Player getStartingPlayer();

    void setStartingPlayer(StoneColor color);
}
