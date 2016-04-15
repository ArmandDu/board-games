package com.github.armanddu.boardgames.gomoku.player.rest;

import com.github.armanddu.boardgames.gomoku.stone.GomokuStone;
import com.github.armanddu.boardgames.lib.game.GameUtils;
import com.github.armanddu.boardgames.lib.player.Player;
import com.github.armanddu.boardgames.lib.stone.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Created by armanddu on 08/04/16 for board-games.
 */
public class RestEndpoint {

    private final Player owner;

    RestEndpoint(Player owner) {
        this.owner = owner;
    }

    public Future<StonePack> pushChooseStonePack(List<StonePack> packs) {
        return CompletableFuture.supplyAsync(() -> packs.isEmpty() ? null : packs.get(0));
    }

    public Future<Player> pushChooseOpponent(List<Player> opponents) {
        return CompletableFuture.supplyAsync(() -> opponents.isEmpty() ? null : opponents.get(0));

    }

    public Future<StoneMove> pushPlay(GameUtils utils) {
        return CompletableFuture.supplyAsync(() -> {
            Stone stone = new GomokuStone(StoneColor.BLACK, 0, 0);
            stone.setOwner(owner);
            for (int i = 0; i < utils.getMap().getWidth(); i++) {
                for (int j = 0; j < utils.getMap().getHeight(); j++) {
                    StoneMoveImpl move = new StoneMoveImpl(i, j, stone);
                    if (utils.isValidMove(move)) {
                        return move;
                    }
                }
            }
            return null;
        });
    }
}
