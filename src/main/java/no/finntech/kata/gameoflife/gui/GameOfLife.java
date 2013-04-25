package no.finntech.kata.gameoflife.gui;

public interface GameOfLife {

    boolean [][] nextGeneration();

    void init(final boolean [][] initialBoard);

}
