package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    // Метод для друку ігрового поля
    public static void printBoard(String input) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(input.charAt(i * 3 + j) + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення рядка користувачем
        System.out.print("Enter cells: ");
        String input = scanner.nextLine();

        // Перевірка довжини рядка
        if (input.length() != 9) {
            System.out.println("Invalid input. The input must be exactly 9 characters.");
            return;
        }

        // Перевірка символів у рядку
        if (!input.matches("[XO_]+")) {
            System.out.println("Invalid input. Only characters 'X', 'O', and '_' are allowed.");
            return;
        }

        // Виведення ігрового поля
        printBoard(input);
    }
}
