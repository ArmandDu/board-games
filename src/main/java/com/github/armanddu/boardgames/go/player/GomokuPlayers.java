package com.github.armanddu.boardgames.go.player;

import java.util.*;

import com.github.armanddu.boardgames.lib.player.Player;
import com.github.armanddu.boardgames.lib.player.Players;
import com.github.armanddu.boardgames.lib.stone.StoneColor;

public class GomokuPlayers implements Players {


    private final Map<StoneColor, Player> players;
    private StoneColor starting;

    public GomokuPlayers(Player player, Player opponent) {
        this();
        this.players.put(player.getStoneColor(), player);
        this.players.put(opponent.getStoneColor(), opponent);
    }

    public GomokuPlayers() {
        this.players = new HashMap<>();
        this.starting = StoneColor.BLACK;
    }

    public void set(Player player) {
        this.players.put(player.getStoneColor(), player);
    }

    public List<Player> asList() {
        return new ArrayList<>(this.players.values());
    }

    public Map<StoneColor, Player> asMap() {
        return Collections.unmodifiableMap(this.players);
    }

    public Player get(StoneColor color) {
        return this.players.getOrDefault(color, null);
    }

    public Player getWhite() {
        return get(StoneColor.WHITE);
    }

    public Player getBlack() {
        return get(StoneColor.BLACK);
    }

    @Override
    public Player getStartingPlayer() {
        return players.get(starting);
    }

    @Override
    public void setStartingPlayer(StoneColor color) {
        starting = color;
    }

}
