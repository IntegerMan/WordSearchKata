package com.techelevator.matteland;

import java.util.Random;

public class GridGenerator {
    public WordGrid generate(int sizeX, int sizeY) {
        WordGrid grid = new WordGrid(sizeX, sizeY);

        final int lengthOfAlphabet = 26;
        final int uppercaseLetterOffset = 65; // Where in the ASCII codes the uppercase letters start

        final Random random = new Random(42); // Seed provided for testing purposes

        // Randomly set letters in the grid
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                // Generate a good ASCII code and then convert it to a character
                char letter = (char) (random.nextInt(lengthOfAlphabet) + uppercaseLetterOffset);

                grid.setCharacter(x, y, letter);
            }
        }

        return grid;
    }
}
