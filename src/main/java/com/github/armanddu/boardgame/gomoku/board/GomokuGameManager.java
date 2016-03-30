package com.github.armanddu.boardgame.gomoku.board;

import java.util.List;

import com.github.armanddu.boardgame.lib.game.GameBox;
import com.github.armanddu.boardgame.lib.game.GameManager;
import com.github.armanddu.boardgame.lib.board.Board;
import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.player.Player;
import com.github.armanddu.boardgame.lib.player.Players;
import com.github.armanddu.boardgame.lib.rule.GameRules;
import com.github.armanddu.boardgame.lib.stone.Stone;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StoneMove;
import com.github.armanddu.boardgame.lib.stone.StonePack;

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
