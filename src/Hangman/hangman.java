package Hangman;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Список слів для гри
        String[] words = {"python", "java", "javascript", "kotlin"};

        // Вибір випадкового слова зі списку
        Random random = new Random();
        String secretWord = words[random.nextInt(words.length)];

        // Створення масиву для збереження вгаданих букв
        StringBuilder guessedLetters = new StringBuilder("-".repeat(secretWord.length()));
        HashSet<Character> guessedChars = new HashSet<>(); // Множина для збереження вгаданих букв
        int attemptsLeft = 8; // Кількість помилок, які можна допустити

        System.out.println("HANGMAN");

        while (attemptsLeft > 0) {
            System.out.println(guessedLetters);
            System.out.print("Input a letter: > ");
            String userInput = scanner.nextLine().toLowerCase();

            // Перевірка на валідність введення
            if (userInput.length() != 1) {
                System.out.println("Please enter a single letter.");
                continue;
            }

            char guessedLetter = userInput.charAt(0);

            // Перевірка, чи буква вже була вгадана
            if (guessedChars.contains(guessedLetter)) {
                System.out.println("No improvements");
                continue;
            }

            // Додаємо букву до списку вгаданих
            guessedChars.add(guessedLetter);

            // Перевірка наявності букви в слові
            if (secretWord.indexOf(guessedLetter) >= 0) {
                // Якщо буква є в слові, розкриваємо її
                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == guessedLetter) {
                        guessedLetters.setCharAt(i, guessedLetter);
                    }
                }
            } else {
                // Якщо буква відсутня, зменшуємо кількість спроб
                attemptsLeft--;
                System.out.println("That letter doesn't appear in the word");
            }

            // Перевірка на перемогу
            if (guessedLetters.toString().equals(secretWord)) {
                System.out.println(guessedLetters);
                System.out.println("You guessed the word!");
                System.out.println("You survived!");
                break;
            }

            // Вивід кількості спроб, що залишилися
            System.out.println("Attempts left: " + attemptsLeft);
        }

        if (attemptsLeft == 0) {
            System.out.println("You lost! The word was: " + secretWord);
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
