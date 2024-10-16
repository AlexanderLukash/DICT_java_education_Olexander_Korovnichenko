package Hangman;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();

        System.out.println("HANGMAN");

        while (true) {
            System.out.print("Type \"play\" to play the game, \"exit\" to quit: ");
            String choice = scanner.nextLine();

            if (choice.equals("play")) {
                playGame(scanner, words[random.nextInt(words.length)]);
            } else if (choice.equals("exit")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please type \"play\" or \"exit\".");
            }
        }

        scanner.close();
    }

    private static void playGame(Scanner scanner, String secretWord) {
        StringBuilder guessedLetters = new StringBuilder("-".repeat(secretWord.length()));
        HashSet<Character> guessedChars = new HashSet<>();
        int attemptsLeft = 8;

        while (attemptsLeft > 0) {
            System.out.println(guessedLetters);
            System.out.print("Input a letter: ");
            String userInput = scanner.nextLine().toLowerCase();

            // Перевірка на валідність введення
            if (userInput.length() != 1) {
                System.out.println("You should input a single letter.");
                continue;
            }

            char guessedLetter = userInput.charAt(0);

            // Перевірка на введення малих англійських букв
            if (!Character.isLowerCase(guessedLetter)) {
                System.out.println("Please enter a lowercase English letter.");
                continue;
            }

            // Перевірка, чи буква вже була вгадана
            if (guessedChars.contains(guessedLetter)) {
                System.out.println("You've already guessed this letter.");
                continue;
            }

            // Додаємо букву до списку вгаданих
            guessedChars.add(guessedLetter);

            // Перевірка наявності букви в слові
            if (secretWord.indexOf(guessedLetter) >= 0) {
                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == guessedLetter) {
                        guessedLetters.setCharAt(i, guessedLetter);
                    }
                }
            } else {
                attemptsLeft--;
                System.out.println("That letter doesn't appear in the word.");
            }

            // Перевірка на перемогу
            if (guessedLetters.toString().equals(secretWord)) {
                System.out.println(guessedLetters);
                System.out.println("You guessed the word " + secretWord + "!");
                System.out.println("You survived!");
                return;
            }

            System.out.println("Attempts left: " + attemptsLeft);
        }

        System.out.println("You lost! The word was: " + secretWord);
    }
}
