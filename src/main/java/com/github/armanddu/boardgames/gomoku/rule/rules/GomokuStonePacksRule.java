package com.github.armanddu.boardgames.gomoku.rule.rules;

import java.util.List;

import com.github.armanddu.boardgames.lib.game.GameManager;
import com.github.armanddu.boardgames.gomoku.stone.GomokuStonePack;
import com.github.armanddu.boardgames.gomoku.stone.GomokuStoneType;
import com.github.armanddu.boardgames.lib.rule.ConfigRule;
import com.github.armanddu.boardgames.lib.stone.StoneColor;
import com.github.armanddu.boardgames.lib.stone.StonePack;
import com.github.armanddu.boardgames.lib.stone.StoneType;

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
      for (String stoneType : stonePack.getTypes()) {
        if (!(type.type().equals(stoneType))) {
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
