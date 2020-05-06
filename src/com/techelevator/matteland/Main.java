package com.techelevator.matteland;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        System.out.println("Word Grid Analyzer");

        GridGenerator generator = new GridGenerator();

        WordGrid grid = generator.generate(15, 15);

        grid.writeToConsole();

        System.out.println(); // Blank Line
        System.out.println("Loading Word Database...");
        WordProvider words = new WordProvider();
        words.load();

        System.out.println("Analyzing grid...");
        HashSet<String> matches = grid.analyze(words);

        System.out.println(); // Blank Line

        // Display matching words
        for (String match : matches) {
            System.out.println("Word Match: " + match);
        } // TODO: Handle no matches

        // Display the grid again, now that we've searched it
        grid.writeToConsole(); // TODO: Should this take in a parameter indicating that it should show matches?
    }
}
