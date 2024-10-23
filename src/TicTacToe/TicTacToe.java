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

    // Метод для перевірки виграшних комбінацій
    public static boolean checkWinner(char[][] board, char symbol) {
        // Перевірка рядків, стовпчиків та діагоналей
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) return true;
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) return true;
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) return true;
        return board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol;
    }

    // Метод для перевірки стану гри
    public static String analyzeGame(String input) {
        char[][] board = new char[3][3];
        int xCount = 0;
        int oCount = 0;

        // Заповнюємо дошку і рахуємо кількість "X" та "O"
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = input.charAt(i * 3 + j);
                if (board[i][j] == 'X') xCount++;
                if (board[i][j] == 'O') oCount++;
            }
        }

        boolean xWins = checkWinner(board, 'X');
        boolean oWins = checkWinner(board, 'O');
        boolean hasEmptyCells = input.contains("_");

        // Перевірка на неможливий стан гри
        if ((xWins && oWins) || Math.abs(xCount - oCount) > 1) {
            return "Impossible";
        }

        // Перевірка на перемогу X
        if (xWins) {
            return "X wins";
        }

        // Перевірка на перемогу O
        if (oWins) {
            return "O wins";
        }

        // Перевірка на незавершену гру
        if (hasEmptyCells) {
            return "Game not finished";
        }

        // Якщо всі клітинки заповнені й немає переможця
        return "Draw";
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

        // Аналіз стану гри
        String result = analyzeGame(input);
        System.out.println(result);
    }
}
