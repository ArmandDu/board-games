package com.github.armanddu.boardgame.gomoku.stone;

import java.util.ArrayList;
import java.util.List;

import com.github.armanddu.boardgame.player.Player;
import com.github.armanddu.boardgame.stone.Stone;
import com.github.armanddu.boardgame.stone.StoneColor;
import com.github.armanddu.boardgame.stone.StonePosition;
import com.github.armanddu.boardgame.stone.StoneStatus;
import com.github.armanddu.boardgame.stone.StoneType;

public class GomokuStone implements Stone {

  private StonePosition position;
  private List<StonePosition> history;
  private Player owner;
  private StoneType type;
  private StoneColor color;
  private StoneStatus status;

  public GomokuStone(StoneColor color, int x, int y) {
    this.type = new GomokuStoneType();
    this.color = color;
    this.status = null;
    this.owner = null;
    this.history = new ArrayList<StonePosition>();
    this.position = new GomokuStonePosition(x, y);
  }

  public StoneStatus getStatus() {
    return this.status;
  }

  public StoneColor getColor() {
    return this.color;
  }

  public StoneType getType() {
    return this.type;
  }

  public Player getOwner() {
    return this.owner;
  }

  public List<StonePosition> getMovesHistory() {
    return this.history;
  }

  public int getX() {
    return this.getPosition().getX();
  }

  public int getY() {
    return this.getPosition().getY();
  }

  public StonePosition getPosition() {
    return this.position;
  }

  public void apply(StonePosition suggestedPosition) {
    this.history.add(this.position);
    this.position = suggestedPosition;
  }

  public void setOwner(Player owner) {
    this.owner = owner;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append("GomokuStone [").append(color).append("/").append(type.type()).append("] in position: ")
        .append(getX()).append("/").append(getY());
    return builder.toString();
  }

}
