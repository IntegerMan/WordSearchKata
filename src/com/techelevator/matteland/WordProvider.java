package com.techelevator.matteland;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystemException;
import java.util.HashSet;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;

public class WordProvider {

    private final HashSet<String> words = new HashSet<String>();

    public void load(String path) {
        this.words.clear();

        try {
            File file = new File(path);
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()) {
                String word = reader.nextLine().toUpperCase();
                this.words.add(word);
            }
            reader.close();
        } catch (FileNotFoundException fex) {
            System.out.println("File " + path + " could not be found");
            System.out.println("Don't be surprised if no matches are found");
        }
    }

    public WordMatch checkForMatch(String word) {
        String targetWord = word.toUpperCase();

        // Check for full word matches
        if (this.words.stream().anyMatch(w -> w.equals(targetWord))) {
            return WordMatch.FullMatch;
        }

        // Check for partial word matches
        if (this.words.stream().anyMatch(w -> w.startsWith(targetWord))) {
            return WordMatch.PartialMatch;
        }

        return WordMatch.NoMatch;
    }
}
