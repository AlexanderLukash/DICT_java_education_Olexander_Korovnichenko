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

    // Метод для оновлення поля з урахуванням ходу
    public static String makeMove(String input, int row, int col) {
        char[] board = input.toCharArray();
        board[(row - 1) * 3 + (col - 1)] = 'X';
        return String.valueOf(board);
    }

    // Метод для перевірки введених координат
    public static boolean isCellOccupied(String input, int row, int col) {
        return input.charAt((row - 1) * 3 + (col - 1)) != '_';
    }

    // Метод для перевірки чи є введення числом
    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення ігрової сітки користувачем
        System.out.print("Enter cells: ");
        String input = scanner.nextLine();

        // Виведення початкового поля
        printBoard(input);

        // Цикл для запиту координат, поки не буде введено коректні
        while (true) {
            System.out.print("Enter the coordinates: ");
            String coord1 = scanner.next();
            String coord2 = scanner.next();

            // Перевірка чи введені координати є числами
            if (!isNumber(coord1) || !isNumber(coord2)) {
                System.out.println("You should enter numbers!");
                continue;
            }

            int row = Integer.parseInt(coord1);
            int col = Integer.parseInt(coord2);

            // Перевірка чи координати в межах від 1 до 3
            if (row < 1 || row > 3 || col < 1 || col > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            // Перевірка чи клітинка зайнята
            if (isCellOccupied(input, row, col)) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            // Якщо координати коректні, робимо хід і виводимо оновлене поле
            input = makeMove(input, row, col);
            printBoard(input);
            break;
        }
    }
}
