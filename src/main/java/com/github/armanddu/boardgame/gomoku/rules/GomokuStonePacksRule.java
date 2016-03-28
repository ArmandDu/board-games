package com.github.armanddu.boardgame.gomoku.rules;

import java.util.List;

import com.github.armanddu.boardgame.lib.game.GameManager;
import com.github.armanddu.boardgame.gomoku.stone.GomokuStonePack;
import com.github.armanddu.boardgame.gomoku.stone.GomokuStoneType;
import com.github.armanddu.boardgame.lib.rule.ConfigRule;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StonePack;
import com.github.armanddu.boardgame.lib.stone.StoneType;

public class GomokuStonePacksRule implements ConfigRule {

  public String asString() {
    return "Stone Packs Rule:" + "\t" + "Packs of BLACK and WHITE Stones with unlimited amount.";
  }

  public boolean isValid(GameManager config) {
    List<StonePack> stonePacks = config.getStonePacks();
    GomokuStoneType type = new GomokuStoneType();
    return (!stonePacks.isEmpty() && stonePacks.size() == 2)
            && (isValidColor(StoneColor.WHITE, stonePacks)
            && isValidColor(StoneColor.BLACK, stonePacks))
            && (isValidType(type, stonePacks));
  }

  private boolean isValidType(GomokuStoneType type, List<StonePack> packs) {
    for (StonePack stonePack : packs) {
      for (StoneType stoneType : stonePack.getTypes()) {
        if (!(type.type().equals(stoneType.type()))) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean isValidColor(StoneColor color, List<StonePack> stonePacks) {
    for (StonePack stonePack : stonePacks) {
      if (color.equals(stonePack.getColor())) {
        return true;
      }
    }
    return false;
  }

  public void set(GameManager manager) {
    StonePack whites = new GomokuStonePack(StoneColor.WHITE);
    StonePack blacks = new GomokuStonePack(StoneColor.BLACK);
    List<StonePack> stonePacks = manager.getStonePacks();
    stonePacks.clear();
    stonePacks.add(whites);
    stonePacks.add(blacks);
  }

}
