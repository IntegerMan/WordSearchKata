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
        words.load("C:\\words.txt"); // TODO: This should not require an absolute path

        System.out.println("Analyzing grid...");
        HashSet<String> matches = grid.analyze(words);

        System.out.println(); // Blank Line

        // Display matching words
        for (String match : matches) {
            System.out.println("Word Match: " + match);
        }

        System.out.println(); // Blank Line

        // Display the grid again, now that we've searched it
        grid.writeToConsole();
    }
}
