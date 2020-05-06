package com.techelevator.matteland;

public class Main {

    public static void main(String[] args) {
        System.out.println("Word Grid Analyzer");

        GridGenerator generator = new GridGenerator();

        WordGrid grid = generator.generate(15, 15);

        grid.writeToConsole();

        System.out.println("Loading Word Database...");
        WordProvider words = new WordProvider();

        System.out.println("Analyzing grid...");
        String[] matches = grid.analyze(words);
    }
}
