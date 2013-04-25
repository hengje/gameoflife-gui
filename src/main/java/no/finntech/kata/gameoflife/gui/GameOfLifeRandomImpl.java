package no.finntech.kata.gameoflife.gui;

import java.util.Random;

public class GameOfLifeRandomImpl implements GameOfLife {

    private final Random random = new Random();

    private boolean[][] initialBoard;

    public boolean[][] nextGeneration() {
        boolean [][] result = new boolean[initialBoard.length][initialBoard[0].length];
        for (int x = 0; x < result.length; x++) {
            for (int y = 0; y < result[0].length; y++) {
                result[x][y] = random.nextBoolean();
            }
        }
        return result;
    }

    public void init(boolean[][] initialBoard) {
        this.initialBoard = initialBoard;
    }
}
