package no.finntech.kata.gameoflife.gui;

import java.util.Random;

public class GameOfLifeRandomImpl implements GameOfLife {

    private final Random random = new Random();

    public boolean[][] nextGeneration(boolean[][] previousGeneration) {
        boolean [][] result = new boolean[previousGeneration.length][previousGeneration[0].length];
        for (int x = 0; x < result.length; x++) {
            for (int y = 0; y < result[0].length; y++) {
                result[x][y] = random.nextBoolean();
            }
        }
        return result;
    }
}
