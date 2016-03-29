package com.github.armanddu.boardgame.gomoku.referee;

import java.util.List;

import com.github.armanddu.boardgame.gomoku.stone.GomokuStoneMove;
import com.github.armanddu.boardgame.lib.game.GameBox;
import com.github.armanddu.boardgame.lib.game.GameManager;
import com.github.armanddu.boardgame.gomoku.player.GomokuPlayers;
import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.player.Player;
import com.github.armanddu.boardgame.lib.player.Players;
import com.github.armanddu.boardgame.lib.referee.Referee;
import com.github.armanddu.boardgame.lib.rule.GameRules;
import com.github.armanddu.boardgame.lib.stone.Stone;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StoneMove;
import com.github.armanddu.boardgame.lib.stone.StonePack;

public class GomokuReferee implements Referee {

    private GameManager manager;
    private GameRules rules;
    private StoneColor current;

    public void initGame(GameBox gameBox, Player player, List<Player> opponents) {
        Player opponent = player.chooseOpponent(opponents);
        List<StonePack> remaining = player.chooseStonePack(gameBox.getStonePack());
        opponent.chooseStonePack(remaining);
        Players players = new GomokuPlayers(player, opponent);
        this.setManager(gameBox.getManager(players));
        this.setRules(gameBox.getRules());
        this.initStartingPlayer();
    }

    public void updateStatus(StoneMove stoneMove) {
        this.manager.updateStatus(stoneMove);
    }

    public boolean isValidMove(StoneMove move) {
        return this.rules.isValidMove(manager.getMap(), move);
    }

    public boolean hasCaptures(StoneMove move) {
        return rules.hasCaptures(manager.getMap(), move);
    }

    public void applyMove(StoneMove move) {
        this.manager.getBoard().applyMove(move);
    }

    public void applyCaptures(StoneMove move) {
        // TODO :)
    }

    public void initStartingPlayer() {
        this.current = this.manager.getPlayers().getStartingPlayer().getStoneColor();
    }

    public void setNextPlayerTurn() {
        this.current = this.manager.getNextTurn();
    }

    public Player getCurrentPlayer() {
        return this.manager.getPlayers().get(this.current);
    }

    public void updateGame() {
        BoardReader map = this.manager.getBoard().getMap();
        StoneMove stoneMove = this.getCurrentPlayer().play(map);
        this.updateStatus(stoneMove);
        this.applyMove(stoneMove);
        this.applyCaptures(stoneMove);
        this.setNextPlayerTurn();
    }

    public boolean isValidGame() {
        return this.rules.isValidGame(manager);
    }

    public boolean isEndGame() {
        return this.rules.isEndGame(manager.getMap(), this.getLastMove());
    }

    public StoneMove getLastMove() {
        Stone stone = this.manager.getBoard().getLastStone();
        return  new GomokuStoneMove(stone, stone.getX(), stone.getY());
    }

    private void setManager(GameManager manager) {
        this.manager = manager;
    }

    private void setRules(GameRules rules) {
        this.rules = rules;
    }


}
