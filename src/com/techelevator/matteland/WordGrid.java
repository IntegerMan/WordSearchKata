package com.techelevator.matteland;

import java.util.HashSet;

public class WordGrid {

    private final char letters[][];

    public WordGrid(int sizeX, int sizeY) {
        letters = new char[sizeY][sizeX];
    }

    public void writeToConsole() {
        for (char[] row : letters) {
            for (char letter : row) {
                // TODO: If we have matches, show them in lower case
                System.out.print(letter);
            }
            System.out.println(); // Finish the row
        }
    }

    public HashSet<String> analyze(WordProvider words) {
        HashSet<String> matches = new HashSet<String>();

        // TODO: Actually search it

        return matches;
    }

    public void setCharacter(int x, int y, char value) {
        letters[y][x] = value;
    }
}
