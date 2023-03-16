package tictactoe;

public class BoardStatusChecker {
    public String isWon(Cell[][] board) {
        for (int i = 0; i < 3; i++) {
            if (!board[i][0].getText().equals(" ") && board[i][0].getText().equals(board[i][1].getText()) && board[i][1].getText().equals(board[i][2].getText())) {
                return board[i][0].getText();
            }
        }
        for (int i = 0; i < 3; i++) {
            if (!board[0][i].getText().equals(" ") && board[0][i].getText().equals(board[1][i].getText()) && board[1][i].getText().equals(board[2][i].getText())) {
                return board[0][i].getText();
            }
        }
        if (!board[0][0].getText().equals(" ") && board[0][0].getText().equals(board[1][1].getText()) && board[1][1].getText().equals(board[2][2].getText())) {
            return board[1][1].getText();
        }
        if (!board[0][2].getText().equals(" ") && board[0][2].getText().equals(board[1][1].getText()) && board[1][1].getText().equals(board[2][0].getText())) {
            return board[1][1].getText();
        }
        return " ";
    }

    public boolean isDraw(Cell[][] board) {
        for (int i = 0; i < 9; i++) {
            if (board[i / 3][i % 3].getText().equals(" ")) return false;
        }
        return true;
    }

    public void setDrawOrWinningState(Cell[][] board) {
        switch (isWon(board)) {
            case "X" -> TicTacToe.setGameState(TicTacToe.State.X_WINS);
            case "O" -> TicTacToe.setGameState(TicTacToe.State.O_WINS);
            default -> {
                if (isDraw(board)) {
                    TicTacToe.setGameState(TicTacToe.State.DRAW);
                }
            }
        }
    }
}
