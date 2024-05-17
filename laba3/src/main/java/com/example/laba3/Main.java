package com.example.laba3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main extends Application {

    private TextField inputField;
    private Label outputLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("String Analyzer");

        // Input Field
        inputField = new TextField();
        inputField.setPromptText("Enter strings separated by commas");

        // Buttons
        Button shortestLongestButton = new Button("Shortest & Longest");
        shortestLongestButton.setOnAction(e -> findShortestLongest());

        Button sortByLengthButton = new Button("Sort by Length");
        sortByLengthButton.setOnAction(e -> sortByLength());

        Button belowAboveAverageButton = new Button("Below/Above Average Length");
        belowAboveAverageButton.setOnAction(e -> findBelowAboveAverage());

        Button minUniqueCharsButton = new Button("Min Unique Chars");
        minUniqueCharsButton.setOnAction(e -> findMinUniqueChars());

        Button latinVowelConsonantButton = new Button("Latin Vowel/Consonant Count");
        latinVowelConsonantButton.setOnAction(e -> countLatinVowelConsonant());

        Button ascendingCharCodeButton = new Button("Ascending Char Codes");
        ascendingCharCodeButton.setOnAction(e -> findAscendingCharCode());

        Button uniqueCharsWordButton = new Button("Word with Unique Chars");
        uniqueCharsWordButton.setOnAction(e -> findUniqueCharsWord());

        Button palindromeButton = new Button("Numeric Palindrome");
        palindromeButton.setOnAction(e -> findNumericPalindrome());

        // Output Label
        outputLabel = new Label();

        // Layout
        HBox inputBox = new HBox(10, inputField);
        inputBox.setAlignment(Pos.CENTER);

        VBox buttonBox = new VBox(10, shortestLongestButton, sortByLengthButton,
                belowAboveAverageButton, minUniqueCharsButton, latinVowelConsonantButton,
                ascendingCharCodeButton, uniqueCharsWordButton, palindromeButton);
        buttonBox.setAlignment(Pos.CENTER);

        VBox root = new VBox(20, inputBox, buttonBox, outputLabel);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // --- String processing methods ---

    public void findShortestLongest() {
        String[] words = inputField.getText().split(",");
        if (words.length == 0) {
            outputLabel.setText("Please enter some strings.");
            return;
        }

        String shortest = words[0];
        String longest = words[0];

        for (String word : words) {
            word = word.trim(); // Remove leading/trailing spaces
            if (word.length() < shortest.length()) {
                shortest = word;
            }
            if (word.length() > longest.length()) {
                longest = word;
            }
        }

        outputLabel.setText("Shortest: \"" + shortest + "\" (length: " + shortest.length() + ")\n"
                + "Longest: \"" + longest + "\" (length: " + longest.length() + ")");
    }

    public void sortByLength() {
        String[] words = inputField.getText().split(",");
        if (words.length == 0) {
            outputLabel.setText("Please enter some strings.");
            return;
        }

        List<String> wordList = new ArrayList<>();
        for (String word : words) {
            wordList.add(word.trim());
        }

        wordList.sort(Comparator.comparingInt(String::length));
        outputLabel.setText("Sorted by length (ascending):\n" + String.join(", ", wordList));
    }

    public void findBelowAboveAverage() {
        String[] words = inputField.getText().split(",");
        if (words.length == 0) {
            outputLabel.setText("Please enter some strings.");
            return;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}




