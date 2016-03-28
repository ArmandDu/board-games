package com.github.armanddu.boardgame.game;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import com.github.armanddu.boardgame.broadcaster.Broadcaster;
import com.github.armanddu.boardgame.map.Board;
import com.github.armanddu.boardgame.map.BoardReader;
import com.github.armanddu.boardgame.player.Player;
import com.github.armanddu.boardgame.player.Players;
import com.github.armanddu.boardgame.referee.Referee;
import com.github.armanddu.boardgame.rule.*;
import com.github.armanddu.boardgame.stone.*;
import org.junit.Test;
import resources.com.github.armanddu.boardgame.broadcaster.TestBroadcaster;
import resources.com.github.armanddu.boardgame.game.*;
import resources.com.github.armanddu.boardgame.player.TestPlayer;
import resources.com.github.armanddu.boardgame.player.TestPlayers;
import resources.com.github.armanddu.boardgame.referee.TestReferee;
import resources.com.github.armanddu.boardgame.rule.*;
import resources.com.github.armanddu.boardgame.stone.*;


public class TDD {

  private static final StoneColor STONE_WHITE = StoneColor.WHITE;
  private static final StoneColor STONE_BLACK = StoneColor.BLACK;
  private static final String PLAYER_TWO_NAME = "player 2";
  private static final String PLAYER_ONE_NAME = "player 1";


  @Test
  public void startGame() {


    GameBox gameBox = new TestGameBox();
    Referee referee = null;
    Player player = null;
    List<Player> opponents = null;
    Broadcaster broadcaster = null;
    Game game = new TestGame(referee, gameBox, player, opponents, broadcaster);

    assertTrue(game.isValidRequirements());
    assertFalse(game.isStarted());
    assertFalse(game.isEnded());
    game.start();
    game.reset();
  }

  @Test
  public void GameBoxTest() throws Exception {
    GameBox gameBox = new TestGameBox();
    Players players = new TestPlayers();

    GameRules rules = gameBox.getRules();
    List<StonePack> stonePack = gameBox.getStonePack();
    GameManager config = gameBox.getManager(players);
    BoardReader map = config.getMap();
  }

  @Test
  public void PlayersTest() throws Exception {
    Players players = new TestPlayers();
    Player player1 = new TestPlayer(PLAYER_ONE_NAME);
    Player player2 = new TestPlayer(PLAYER_TWO_NAME);

    players.setWhite(player1);
    players.setBlack(player2);

    Player t_p1 = players.getWhite();
    Player t_p2 = players.getBlack();
    List<Player> t_asList = players.asList();
    Map<StoneColor, Player> t_asMap = players.asMap();
  }

  @Test
  public void GameConfiguratorTest() throws Exception {
    Players players = new TestPlayers();
    GameBox gameBox = new TestGameBox();
    GameManager gameManager = new TestGameManager(gameBox, players);

  }

  @Test
  public void StonePackTest() throws Exception {
    StonePack stonePack = new TestStonePack();


  }

  @Test
  public void StoneTypeTest() throws Exception {

    StoneType pawn = new TestPawnStone();
    StoneType king = new TestKingStone();

    System.out.println(king.type());
    assertEquals("king", king.type());
    assertEquals("pawn", pawn.type());
  }

  @Test
  public void StoneColorTest() throws Exception {
    assertNotNull(StoneColor.BLACK);
    assertNotNull(StoneColor.WHITE);
  }

  @Test
  public void StoneTest() throws Exception {
    StoneType type = new TestStoneType();
    StoneColor color = STONE_WHITE;
    Player owner = new TestPlayer(PLAYER_ONE_NAME);
    StonePosition position = new TestStonePosition(0, 0);
    Stone stone = new TestStone(type, color, owner, position);

    StoneStatus t_status = stone.getStatus();
    StoneColor t_color = stone.getColor();
    StoneType t_type = stone.getType();
    Player t_owner = stone.getOwner();
    List<StonePosition> t_moves = stone.getMovesHistory();
    int t_x = stone.getX();
    int t_y = stone.getY();
    StonePosition t_position = stone.getPosition();
  }

  @Test
  public void StoneMoveTest() throws Exception {
    StoneType type = new TestStoneType();
    StoneColor color = STONE_WHITE;
    Player owner = new TestPlayer(PLAYER_ONE_NAME);
    StonePosition position = new TestStonePosition(0, 0);
    Stone stone = new TestStone(type, color, owner, position);
    StonePosition suggested = new TestStonePosition(0, 0);
    StoneMove stoneMove = new TestStoneMove(stone, suggested);

    StonePosition t_current = stoneMove.getCurrentPosition();
    StonePosition t_suggested = stoneMove.getSuggestedPosition();
    StoneStatus t_status = stoneMove.getStatus();
    StoneColor t_color = stoneMove.getColor();
    StoneType t_type = stoneMove.getType();
    Player t_owner = stoneMove.getOwner();
  }

  @Test
  public void PlayerTest() throws Exception {
    String name = PLAYER_ONE_NAME;
    Player player = new TestPlayer(name);
    List<StonePack> stonePacks = null;
    List<Player> oponents = null;
    BoardReader map = new TestMapManipulator(null);

    String t_name = player.getName();
    List<StonePack> remaining = player.chooseStonePack(stonePacks);
    Player t_oponent = player.chooseOpponent(oponents);
    StonePack t_pack = player.getStonePack();
    StoneColor t_color = player.getStoneColor();
    assertEquals(name, t_name);

    StoneMove move = player.play(map);
  }

  @Test
  public void RefereeTest() throws Exception {
    StoneMove stoneMove = null;
    GameManager gameManager = null;
    Referee referee = new TestReferee(gameManager);

    referee.initGame(null, null, null);
    referee.isValidGame();
    referee.updateStatus(stoneMove);
    assertFalse(referee.isValidMove(stoneMove));
    assertFalse(referee.hasCaptures(stoneMove));
    referee.applyMove(stoneMove);
    referee.applyCaptures(stoneMove);
    referee.initStartingPlayer();
    referee.setNextPlayerTurn();
    Player t_currentPlayer = referee.getCurrentPlayer();
    referee.updateGame();
    StoneMove t_stoneMove = referee.getLastMove();

  }

  @Test
  public void BroadcasterTest() throws Exception {
    Broadcaster broadcaster = new TestBroadcaster();
  }

  @Test
  public void GameRulesTest() throws Exception {
    StonePosition suggested = null;
    Stone stone = null;
    StoneMove stoneMove = new TestStoneMove(stone, suggested);
    GameManager gameManager = null;
    GameRules gameRules = new TestGameRules(gameManager);

    gameRules.configGame(gameManager);
    BoardReader map = null;
    assertTrue(gameRules.isValidGame(gameManager));
    assertTrue(gameRules.isValidMove(map, stoneMove));
    assertTrue(gameRules.hasCaptures(map, stoneMove));
    assertTrue(gameRules.shouldChangeTurn(map, stoneMove));
    assertTrue(gameRules.isEndGame(map, stoneMove));
    assertTrue(gameRules.isWin(map, stoneMove));
    assertTrue(gameRules.isDraw(map, stoneMove));
    Rule t_last = gameRules.getLastInvalidRule();

  }

  @Test
  public void RuleTest() throws Exception {
    Rule rule = new TestRule();

    String ruleString = rule.asString();
    assertNotNull(ruleString);
  }

  @Test
  public void StoneRuleTest() throws Exception {
    BoardReader map = null;
    StoneMove stoneMove = null;
    StoneRule rule = new TestStoneRule();

    assertTrue(rule.isValid(map, stoneMove));
    String ruleString = rule.asString();
    assertNotNull(ruleString);
  }

  @Test
  public void ConfigRuleTest() throws Exception {
    ConfigRule rule = new TestConfigRule();
    GameManager config = new TestGameManager();

    assertFalse(rule.isValid(config));
    String ruleString = rule.asString();
    assertNotNull(ruleString);
    rule.set(config);
  }

  @Test
  public void EndGameRule() throws Exception {
    BoardReader map = new TestMapManipulator(null);
    StoneMove stoneMove = new TestStoneMove(null, null);
    EndGameRule rule = new TestEndGameRule();

    assertFalse(rule.isValid(map, stoneMove));
    String ruleString = rule.asString();
  }

  @Test
  public void BoardMapTest() throws Exception {
    Board map = new TestBoard();
    StoneMove stoneMove = null;

    int x = 0;
    int y = 0;
    Stone stone = map.get(x, y);
    int width = map.getWidth();
    int height = map.getHeight();
    assertFalse(map.isValidMove(stoneMove));

    map.applyMove(stoneMove);
    BoardReader boardReader = map.getMap();
  }

  @Test
  public void MapManipulatorTest() throws Exception {
    StoneMove stoneMove = null;
    Board board = null;
    BoardReader map = new TestMapManipulator(board);
    int x = 0;
    int y = 0;

    Stone stone = map.get(x, y);
    int width = map.getWidth();
    int height = map.getHeight();
    assertFalse(map.isValidMove(stoneMove));
  }

  @Test
  public void StonePositionTest() throws Exception {
    int x = 0;
    int y = 0;

    StonePosition position = new TestStonePosition(x, y);

    int t_x = position.getX();
    int t_y = position.getY();
    assertEquals(x, t_x);
    assertEquals(y, t_y);
  }

}
