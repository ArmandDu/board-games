package com.github.armanddu.boardgames.gomoku.game;

import java.util.List;

import com.github.armanddu.boardgames.lib.game.GameBox;
import com.github.armanddu.boardgames.lib.game.GameManager;
import com.github.armanddu.boardgames.lib.board.Board;
import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.player.Players;
import com.github.armanddu.boardgames.lib.stone.StoneMove;
import com.github.armanddu.boardgames.lib.stone.StonePack;

public class GomokuGameManager implements GameManager {

    private final Players players;
    private final Board board;
    private final List<StonePack> stonePacks;

    public GomokuGameManager(Players players, GameBox gameBox) {
        this.players = players;
        this.board = gameBox.getBoard();
        this.stonePacks = gameBox.getStonePacks();
    }

    public Board getBoard() {
        return this.board;
    }

    public Players getPlayers() {
        return this.players;
    }

    public void updateStatus(StoneMove move) {
        // TODO Auto-generated method stub

    }

    public BoardReader getMap() {
        return board.getMap();
    }

    public List<StonePack> getStonePacks() {
        return stonePacks;
    }

}
