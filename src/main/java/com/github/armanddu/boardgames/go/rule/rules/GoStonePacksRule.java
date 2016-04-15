package com.github.armanddu.boardgames.go.rule.rules;

import java.util.List;

import com.github.armanddu.boardgames.lib.game.GameManager;
import com.github.armanddu.boardgames.go.stone.GoStonePack;
import com.github.armanddu.boardgames.go.stone.GoStoneType;
import com.github.armanddu.boardgames.lib.rule.ConfigRule;
import com.github.armanddu.boardgames.lib.stone.StoneColor;
import com.github.armanddu.boardgames.lib.stone.StonePack;

public class GoStonePacksRule implements ConfigRule {

  public String asString() {
    return "Stone Packs Rule:" + "\t" + "Packs of BLACK and WHITE Stones with unlimited amount.";
  }

  public boolean isValid(GameManager config) {
    List<StonePack> stonePacks = config.getStonePacks();
    GoStoneType type = new GoStoneType();
    return (!stonePacks.isEmpty() && stonePacks.size() == 2)
            && (isValidColor(StoneColor.WHITE, stonePacks)
            && isValidColor(StoneColor.BLACK, stonePacks))
            && (isValidType(type, stonePacks));
  }

  private boolean isValidType(GoStoneType type, List<StonePack> packs) {
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
    StonePack whites = new GoStonePack(StoneColor.WHITE);
    StonePack blacks = new GoStonePack(StoneColor.BLACK);
    List<StonePack> stonePacks = manager.getStonePacks();
    stonePacks.clear();
    stonePacks.add(whites);
    stonePacks.add(blacks);
  }

}
