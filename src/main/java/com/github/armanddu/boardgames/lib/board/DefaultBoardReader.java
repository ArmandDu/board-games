package com.github.armanddu.boardgames.lib.board;

import com.github.armanddu.boardgames.lib.stone.*;

import java.util.Collections;
import java.util.List;

/**
 * Created by armanddu on 30/03/16 for board-games.
 */
public class DefaultBoardReader implements BoardReader {
    protected final Board board;

    public DefaultBoardReader(Board board) {
        this.board = board;
    }

    public final Stone get(int x, int y) {
        return this.board.get(x, y);
    }

    public int getWidth() {
        return this.board.getWidth();
    }

    public int getHeight() {
        return this.board.getHeight();
    }

    @Override
    public int getScore(StoneColor color) {
        return board.getScore(color);
    }

    @Override
    public final List<Stone> getStones() {
        return Collections.unmodifiableList(board.getStones());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int width = this.getWidth();
        int height = this.getHeight();
        drawInfo(builder, width, height);
        drawXAxis(builder, height);

        for (int i = 0; i < width; i++) {
            drawLine(builder, height);

            drawYAxis(builder, i);
            for (int j = 0; j < height; j++) {
                Stone stone = this.get(j, i);
                builder.append("| ").append(stone != null ? stone.getColor().toString().charAt(0) : getFreeCaseString(j, i))
                        .append(" ");
            }
            builder.append("|\n");
        }
        drawLine(builder, height);

        return builder.toString();
    }

    private String getFreeCaseString(int x, int y) {
        StoneMove white = new StoneMoveImpl(x, y, new StoneImpl(0, 0, StoneColor.WHITE, null));
        StoneMove black = new StoneMoveImpl(x, y, new StoneImpl(0, 0, StoneColor.BLACK, null));
        int v = board.isValidMove(white) ? 1 : 0;
        v += board.isValidMove(black) ? 10 : 0;
        return v == 11 ? "_" : v == 10 ? "b" : v == 1 ? "w" : " ";
    }

    private void drawYAxis(StringBuilder builder, int y) {
        builder.append(y < 10 ? "  " : " ").append(y).append(" ");
    }

    private void drawLine(StringBuilder builder, int height) {
        builder.append("    .");
        for (int j = 0; j < height; j++) {
            builder.append("---.");
        }
        builder.append("\n");
    }

    private void drawXAxis(StringBuilder builder, int height) {
        builder.append(" y\\x ");
        for (int x = 0; x < height; x++) {
            builder.append(x >= 10 ? "" : " ").append(x).append("  ");
        }
        builder.append("\n");
    }

    private void drawInfo(StringBuilder builder, int width, int height) {
        builder.append(this.getClass().getSimpleName()).append(" ").append(width).append(":").append(height)
                .append("\n");
    }
}
