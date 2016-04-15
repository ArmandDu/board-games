package com.github.armanddu.boardgames.go.player.gui;

import com.github.armanddu.boardgames.lib.game.GameUtils;
import com.github.armanddu.boardgames.lib.player.Player;
import com.github.armanddu.boardgames.lib.stone.StoneColor;
import com.github.armanddu.boardgames.lib.stone.StoneMove;
import com.github.armanddu.boardgames.lib.stone.StonePack;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.List;

/**
 * Created by armanddu on 07/04/16 for board-games.
 */
public class GuiPlayer extends Application implements Player{

    private final String name;

    GuiPlayer(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        launch(GUI.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public StonePack chooseStonePack(List<StonePack> packs) {
        return null;
    }

    @Override
    public Player chooseOpponent(List<Player> opponents) {
        return null;
    }

    @Override
    public StonePack getStonePack() {
        return null;
    }

    @Override
    public StoneColor getStoneColor() {
        return null;
    }

    @Override
    public StoneMove play(GameUtils utils) {
        return null;
    }

    @Override
    public boolean isAbandon() {
        return false;
    }

    @Override
    public void abandon() {

    }

}
