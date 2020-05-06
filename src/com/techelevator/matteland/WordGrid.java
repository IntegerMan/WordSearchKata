package com.techelevator.matteland;

import java.util.ArrayList;
import java.util.HashSet;

import static com.techelevator.matteland.WordMatch.*;
import static com.techelevator.matteland.WordMatch.FullMatch;

public class WordGrid {

    private final int sizeX;
    private final int sizeY;
    private final char letters[][];
    private final boolean isPartOfWord[][];

    public WordGrid(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.letters = new char[sizeY][sizeX];
        this.isPartOfWord = new boolean[sizeY][sizeX];
    }

    public void writeToConsole() {
        for (int y = 0; y < this.sizeY; y++) {
            for (int x = 0; x < this.sizeX; x++) {
                final char letter = this.letters[y][x];

                // Display the letter differently if it's part of a word
                if (isPartOfWord[y][x]) {
                    System.out.print(Character.toLowerCase(letter));
                } else {
                    System.out.print(letter);
                }
            }

            System.out.println(); // Finish the row
        }
    }

    public HashSet<String> analyze(WordProvider words) {
        HashSet<String> matches = new HashSet<String>();

        // Find Horizontal Words
        for (int y = 0; y < this.sizeY; y++) {
            for (int x = 0; x < this.sizeX - 1; x++) { // Don't look at words that start in the last column
                // Look for horizontal words starting at x / y
                ArrayList<String> foundWords = findHorizontalWord(x, y, words);

                // If we found a word, we need to mark it as a match
                for (String word : foundWords) {
                    matches.add(word);

                    // Mark all letters as being part of a word
                    for (int l = 0; l < word.length(); l++) {
                        this.isPartOfWord[y][x+l] = true;
                    }
                }
            }
        }

        // TODO: Find Vertical Words

        return matches;
    }

    private ArrayList<String> findHorizontalWord(int xStart, int y, WordProvider provider) {

        String word = "";
        ArrayList<String> words = new ArrayList<String>();

        for (int x = xStart; x < sizeX; x++) {
            word += letters[y][x];

            switch (provider.checkForMatch(word)) {
                case FullMatch:
                    words.add(word); // Add the word
                    break; // Keep going - there could be a large word that starts with a smaller word (BEE / BEEKEEPER)

                case PartialMatch:
                    break; // Okay, this COULD be a word, it's not a full match yet, but keep checking it

                case NoMatch:
                    return words; // Early exit since we're done here
            }
        }

        return words;
    }

    public void setCharacter(int x, int y, char value) {
        letters[y][x] = value;
        isPartOfWord[y][x] = false;
    }
}
