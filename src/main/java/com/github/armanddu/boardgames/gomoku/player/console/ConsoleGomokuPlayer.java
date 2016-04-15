package com.github.armanddu.boardgames.gomoku.player.console;

import com.github.armanddu.boardgames.gomoku.board.GomokuBox;
import com.github.armanddu.boardgames.gomoku.game.GomokuGame;
import com.github.armanddu.boardgames.gomoku.referee.GomokuReferee;
import com.github.armanddu.boardgames.gomoku.stone.GomokuStone;
import com.github.armanddu.boardgames.gomoku.stone.GomokuStoneMove;
import com.github.armanddu.boardgames.gomoku.stone.GomokuStoneType;
import com.github.armanddu.boardgames.lib.game.Game;
import com.github.armanddu.boardgames.lib.game.GameUtils;
import com.github.armanddu.boardgames.lib.player.Player;
import com.github.armanddu.boardgames.lib.stone.Stone;
import com.github.armanddu.boardgames.lib.stone.StoneColor;
import com.github.armanddu.boardgames.lib.stone.StoneMove;
import com.github.armanddu.boardgames.lib.stone.StonePack;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by armanddu on 08/04/16 for board-games.
 */
public class ConsoleGomokuPlayer implements Player {

    private final String name;
    private StonePack pack;
    private boolean giveUp;

    public ConsoleGomokuPlayer(String name) {
        this.name = name;
        this.pack = null;
        this.giveUp = false;

    }

    public static void main(String args[]) {

        Player p1 = new ConsoleGomokuPlayer("player 1");
        Player p2 = new ConsoleGomokuPlayer("player 2");
        Game game = new GomokuGame(new GomokuReferee(), new GomokuBox(), p1, Collections.singletonList(p2), null);
        game.initGame();
        game.start();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public StonePack chooseStonePack(List<StonePack> packs) {
        System.out.println("choose pack:");
        for (int i = 0; i < packs.size(); i++) {
            System.out.println(i + ") " + packs.get(i).getColor());
        }
        Scanner scanner = new Scanner(System.in);
        int id = packs.size() == 1 ? 0 : -1;
        while (id < 0 || id >= packs.size()) {
            System.out.print("choice: ");
            id = scanner.nextInt();
        }
        pack = packs.get(id);
        System.out.println("chose: "+ pack.getColor());
        return getStonePack();
    }

    @Override
    public Player chooseOpponent(List<Player> opponents) {
        System.out.println("choose opponent");
        for (int i = 0; i < opponents.size(); i++) {
            System.out.println(i + ") " + opponents.get(i).getName());
        }
        Scanner scanner = new Scanner(System.in);
        int id = opponents.size() == 1 ? 0 : -1;
        while (id < 0 || id >= opponents.size()) {
            System.out.print("choice: ");
            id = scanner.nextInt();
        }
        Player player = opponents.get(id);
        System.out.println("chose: " + player.getName());
        return player;
    }

    @Override
    public StonePack getStonePack() {
        return pack;
    }

    @Override
    public StoneColor getStoneColor() {
        return pack != null ? pack.getColor() : null;
    }

    @Override
    public StoneMove play(GameUtils utils) {
        System.out.println("Playing: " + getName());
        System.out.println(utils.getMap());
        Scanner sc = new Scanner(System.in);
        int x = -1;
        int y = -1;
        Stone stone = new GomokuStone(getStoneColor(), -1,-1);
        while (!utils.isValidMove(new GomokuStoneMove(stone, x, y))) {
            System.out.print("X: ");
            x = sc.nextInt();
            System.out.print("Y: ");
            y = sc.nextInt();
        }
        return new GomokuStoneMove(stone, x, y);
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
