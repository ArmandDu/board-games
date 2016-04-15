package com.github.armanddu.boardgames.gomoku.referee;

import java.util.Collections;
import java.util.List;

import com.github.armanddu.boardgames.gomoku.stone.GomokuStoneMove;
import com.github.armanddu.boardgames.lib.game.GameBox;
import com.github.armanddu.boardgames.lib.game.GameManager;
import com.github.armanddu.boardgames.gomoku.player.GomokuPlayers;
import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.game.GameUtilsImpl;
import com.github.armanddu.boardgames.lib.player.Player;
import com.github.armanddu.boardgames.lib.player.Players;
import com.github.armanddu.boardgames.lib.referee.Referee;
import com.github.armanddu.boardgames.lib.rule.GameRules;
import com.github.armanddu.boardgames.lib.stone.Stone;
import com.github.armanddu.boardgames.lib.stone.StoneColor;
import com.github.armanddu.boardgames.lib.stone.StoneMove;
import com.github.armanddu.boardgames.lib.stone.StonePack;

public class GomokuReferee implements Referee {

    private GameManager manager;
    private GameRules rules;
    private StoneColor current;

    public void initGame(GameBox gameBox, Player player, List<Player> opponents) {
        Player opponent = getOpponent(player, opponents);
        List<StonePack> remaining = makeChooseStonePack(gameBox.getStonePacks(), player);
        if (opponent == null ||
                remaining == null ||
                makeChooseStonePack(remaining, opponent) == null) return ;
        Players players = new GomokuPlayers(player, opponent);
        this.setManager(gameBox.getManager(players));
        this.setRules(gameBox.getRules());
        this.initStartingPlayer();
    }

    private List<StonePack> makeChooseStonePack(List<StonePack> stonePacks, Player player) {
        player.chooseStonePack(Collections.unmodifiableList(stonePacks));
        return stonePacks.remove(player.getStonePack()) ? stonePacks : null;
    }

    private Player getOpponent(Player player, List<Player> opponents) {
        Player opponent = player.chooseOpponent(Collections.unmodifiableList(opponents));
        return opponents.contains(opponent) ? opponent : null;
    }

    public boolean isValidGame() {
        return this.rules != null && this.manager != null && this.rules.isValidGame(manager);
    }

    public void updateStatus(StoneMove stoneMove) {
        this.manager.updateStatus(stoneMove);
    }

    public boolean isValidMove(StoneMove move) {
        return this.rules.isValidMove(manager.getMap(), move);
    }

    public void applyMove(StoneMove move) {
        if (isValidMove(move)) this.manager.getBoard().applyMove(move);
    }

    public void initStartingPlayer() {
        this.current = this.manager.getPlayers().getStartingPlayer().getStoneColor();
    }

    public void setNextPlayerTurn() {
        StoneMove lastMove = getLastMove();
        if (lastMove != null && lastMove.getColor() == current && this.rules.shouldChangeTurn(manager.getMap(), lastMove)) {
            this.current = this.manager.getPlayers().asMap().keySet().stream()
                    .filter(key -> key != current).findFirst().get();
        }

    }

    public Player getCurrentPlayer() {
        return manager != null ? this.manager.getPlayers().get(this.current) : null;
    }

    public void updateGame() {
        BoardReader map = this.manager.getBoard().getMap();
        StoneMove stoneMove = getPlay(map);
        this.updateStatus(stoneMove);
        this.applyMove(stoneMove);
        this.setNextPlayerTurn();
    }

    private StoneMove getPlay(BoardReader map) {
        Player player = this.getCurrentPlayer();
        StoneMove move = player.play(new GameUtilsImpl(rules, map));
        if (move != null) move.getStone().setOwner(player);
        return move;
    }

    public boolean isEndGame() {
        return isEndGameAccordingToRules() || hasAbandon();
    }

    private boolean hasAbandon() {
        return manager.getPlayers().asList().stream().anyMatch(Player::isAbandon);
    }

    private boolean isEndGameAccordingToRules() {
        return this.rules.isEndGame(manager.getMap(), this.getLastMove());
    }

    public StoneMove getLastMove() {
        Stone stone = this.manager.getBoard().getLastStone();
        return  stone == null ? null : new GomokuStoneMove(stone, stone.getX(), stone.getY());
    }

    private void setManager(GameManager manager) {
        this.manager = manager;
    }

    private void setRules(GameRules rules) {
        this.rules = rules;
    }


}
