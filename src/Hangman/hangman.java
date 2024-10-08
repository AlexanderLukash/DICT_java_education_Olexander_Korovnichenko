package Hangman;

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

        // Створення підказки з перших двох літер та дефісів
        String hint = secretWord.substring(0, 2) + "-".repeat(secretWord.length() - 2);

        System.out.println("HANGMAN");
        System.out.print("Guess the word " + hint + ": > ");
        String userGuess = scanner.nextLine();

        // Перевірка, чи вгадав гравець слово
        if (userGuess.equalsIgnoreCase(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }

        scanner.close();
    }
}
