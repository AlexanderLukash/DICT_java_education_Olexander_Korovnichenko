package TicTacToe;

import java.util.Scanner;

// Клас для ігрової сітки
class Board {
    private String grid;

    public Board() {
        // Ініціалізуємо порожню сітку
        this.grid = "_________";
    }

    // Виводить ігрову сітку
    public void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid.charAt(i * 3 + j) + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    // Оновлює сітку відповідно до ходу гравця
    public void updateBoard(int row, int col, char player) {
        char[] boardArr = grid.toCharArray();
        boardArr[(row - 1) * 3 + (col - 1)] = player;
        grid = new String(boardArr);
    }

    // Перевіряє, чи зайнята клітинка
    public boolean isCellOccupied(int row, int col) {
        return grid.charAt((row - 1) * 3 + (col - 1)) != '_';
    }

    // Повертає поточний стан гри
    public String getGrid() {
        return grid;
    }
}

// Клас для гравців
class Player {
    private final char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}

// Клас для валідації введення користувача
class InputValidator {
    // Перевіряє чи введене значення є числом
    public boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Перевіряє чи координати в межах 1-3
    public boolean areCoordinatesValid(int row, int col) {
        return row >= 1 && row <= 3 && col >= 1 && col <= 3;
    }
}

// Основний клас для гри
class Game {
    private final Board board;
    private final Player playerX;
    private final Player playerO;
    private Player currentPlayer;
    private final InputValidator validator;

    public Game() {
        this.board = new Board();
        this.playerX = new Player('X');
        this.playerO = new Player('O');
        this.currentPlayer = playerX; // X починає першим
        this.validator = new InputValidator();
    }

    // Метод для зміни черги ходу між гравцями
    private void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    // Перевіряє стан гри після кожного ходу
    private String checkGameState() {
        String grid = board.getGrid();
        String[] lines = {
                grid.substring(0, 3), // Рядок 1
                grid.substring(3, 6), // Рядок 2
                grid.substring(6, 9), // Рядок 3
                "" + grid.charAt(0) + grid.charAt(3) + grid.charAt(6), // Стовпець 1
                "" + grid.charAt(1) + grid.charAt(4) + grid.charAt(7), // Стовпець 2
                "" + grid.charAt(2) + grid.charAt(5) + grid.charAt(8), // Стовпець 3
                "" + grid.charAt(0) + grid.charAt(4) + grid.charAt(8), // Діагональ 1
                "" + grid.charAt(2) + grid.charAt(4) + grid.charAt(6)  // Діагональ 2
        };

        boolean hasEmptyCells = grid.contains("_");
        boolean xWins = false, oWins = false;

        for (String line : lines) {
            if (line.equals("XXX")) xWins = true;
            if (line.equals("OOO")) oWins = true;
        }

        if (xWins) {
            return "X wins";
        } else if (oWins) {
            return "O wins";
        } else if (!hasEmptyCells) {
            return "Draw";
        } else {
            return "Game not finished";
        }
    }

    // Основний ігровий цикл
    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        board.printBoard();

        while (true) {
            // Цикл для запиту правильних координат
            while (true) {
                System.out.print("Enter the coordinates: ");
                String coord1 = scanner.next();
                String coord2 = scanner.next();

                // Перевірка чи введені координати є числами
                if (!validator.isNumber(coord1) || !validator.isNumber(coord2)) {
                    System.out.println("You should enter numbers!");
                    continue;
                }

                int row = Integer.parseInt(coord1);
                int col = Integer.parseInt(coord2);

                // Перевірка чи координати в межах ігрового поля
                if (!validator.areCoordinatesValid(row, col)) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }

                // Перевірка чи клітинка зайнята
                if (board.isCellOccupied(row, col)) {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }

                // Якщо координати коректні, робимо хід
                board.updateBoard(row, col, currentPlayer.getSymbol());
                break;
            }

            board.printBoard();

            // Перевірка стану гри після ходу
            String gameState = checkGameState();
            if (!gameState.equals("Game not finished")) {
                System.out.println(gameState);
                break;
            }

            // Перемикаємо гравця
            switchPlayer();
        }
    }
}

// Головний клас програми
public class TicTacToe {
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
