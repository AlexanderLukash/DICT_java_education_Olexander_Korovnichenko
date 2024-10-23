package TicTacToe;

public class TicTacToe {
    private char[][] board = {
            {'X', 'O', 'X'},
            {'O', 'X', 'O'},
            {'X', 'X', 'O'}
    };

    // Метод для виводу поля
    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.printBoard();
    }
}
