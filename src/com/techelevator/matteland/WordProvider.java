package com.techelevator.matteland;

import java.util.HashSet;

public class WordProvider {

    private final HashSet<String> words = new HashSet<String>();

    public void load() {
        this.words.clear();
        this.words.add("LET");
    }

    public WordMatch checkForMatch(String word) {
        String targetWord = word.toUpperCase();

        // Check for full word matches
        for (String sourceWord : this.words) {
            if (sourceWord.equals(targetWord)) {
                return WordMatch.FullMatch;
            }
        }

        // Check for partial word matches
        for (String sourceWord : this.words) {
            if (sourceWord.startsWith(targetWord)) {
                return WordMatch.PartialMatch;
            }
        }

        return WordMatch.NoMatch;
    }
}
