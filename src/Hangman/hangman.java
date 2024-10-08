package Hangman;

import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String secretWord = "java"; // слово, яке гравець повинен вгадати

        System.out.println("HANGMAN");
        System.out.print("Guess the word:> ");
        String userGuess = scanner.nextLine();

        if (userGuess.equalsIgnoreCase(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }

        scanner.close();
    }
}
