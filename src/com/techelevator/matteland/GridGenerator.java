package com.techelevator.matteland;

public class GridGenerator {
    public WordGrid generate(int sizeX, int sizeY) {
        WordGrid grid = new WordGrid(sizeX, sizeY);

        // TODO: Randomly set letters in the grid
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                grid.setCharacter(x, y, 'A');
            }
        }

        return grid;
    }
}
