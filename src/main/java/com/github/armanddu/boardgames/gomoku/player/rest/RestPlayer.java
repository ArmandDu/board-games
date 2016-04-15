package com.github.armanddu.boardgames.gomoku.player.rest;

import com.github.armanddu.boardgames.lib.game.GameUtils;
import com.github.armanddu.boardgames.lib.player.Player;
import com.github.armanddu.boardgames.lib.stone.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by armanddu on 04/04/16 for board-games.
 */
public class RestPlayer implements Player {

    private final String name;
    private StonePack pack;
    private boolean giveUp;
    private final RestEndpoint endpoint;

    public RestPlayer(String name) {
        this.name = name;
        this.giveUp = false;
        this.pack = null;
        this.endpoint = new RestEndpoint(this);
    }

    @Override
    public String getName() {
        return "REST-" + name;
    }

    @Override
    public StonePack chooseStonePack(List<StonePack> packs) {
        try {
            pack = this.endpoint.pushChooseStonePack(packs).get();
        } catch (InterruptedException | ExecutionException e) {
           pack = null;
        }
        return pack;
    }

    @Override
    public Player chooseOpponent(List<Player> opponents) {
        try {
            return this.endpoint.pushChooseOpponent(opponents).get();
        } catch (InterruptedException | ExecutionException e) {
           return null;
        }
    }

    @Override
    public StonePack getStonePack() {
        return pack;
    }

    @Override
    public StoneColor getStoneColor() {
        return pack == null ? null : pack.getColor();
    }

    @Override
    public StoneMove play(GameUtils utils) {
        try {
            return this.endpoint.pushPlay(utils).get();
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }

    @Override
    public boolean isAbandon() {
        return giveUp;
    }

    @Override
    public void abandon() {
        giveUp = true;
    }
}
