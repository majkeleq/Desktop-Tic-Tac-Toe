package tictactoe;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Board extends JPanel {

    private final Object lock = new Object();
    public static volatile boolean isNextMoveX = true;
    Cell[][] board = new Cell[3][3];
    private final StatusLabel statusLabel;//reference
    Player player1;
    Player player2;
    Logger logger = Logger.getLogger(Board.class.getName());

    public Board(StatusLabel statusLabel) {
        BoardStatusChecker checker = new BoardStatusChecker();
        this.statusLabel = statusLabel;
        setPreferredSize(new Dimension(450, 450));
        logger.log(Level.WARNING, "Hello " + logger.getName());
        setBorder(new EmptyBorder(10, 10, 10, 10));

        for (int i = 3; i > 0; i--) {
            for (int j = 0; j < 3; j++) {
                board[i - 1][j] = new Cell((char) ('A' + j) + String.valueOf(i));

                board[i - 1][j].addActionListener(e -> {
                    synchronized (lock) {
                        if (e.getSource() instanceof Cell clickedCell
                                && (TicTacToe.getGameState().equals(TicTacToe.State.X_TURN)
                                || TicTacToe.getGameState().equals(TicTacToe.State.O_TURN))) {
                            if (isNextMoveX) {
                                clickedCell.setText("X");
                                TicTacToe.setGameState(TicTacToe.State.O_TURN);
                            } else {
                                clickedCell.setText("O");
                                TicTacToe.setGameState(TicTacToe.State.X_TURN);
                            }
                            isNextMoveX = !isNextMoveX;
                            checker.setDrawOrWinningState(board);
                            this.statusLabel.setStatusLabel();
                            makeMoveIfRobot();
                        }
                    }

                });
                add(board[i - 1][j]);

            }
        }

        setLayout(new GridLayout(3, 3, 10, 10));

        setVisible(true);
    }

    public void resetBoard() {
        TicTacToe.setGameState(TicTacToe.State.NOT_STARTED);
        Stream.of(board).flatMap(Arrays::stream).forEach(cell -> {
            cell.setText(" ");
            cell.setEnabled(true);
        });
        isNextMoveX = true;
        statusLabel.setStatusLabel();
    }

    public void makeMoveIfRobot() {

        if (TicTacToe.getGameState().equals(TicTacToe.State.X_TURN) || TicTacToe.getGameState().equals(TicTacToe.State.O_TURN)) {
            if (isNextMoveX && player1.getClass().equals(RobotPlayer.class)) {
                player1.move(board);
            } else if (!isNextMoveX && player2.getClass().equals(RobotPlayer.class)) {
                player2.move(board);
            }
        }
    }

    public void startBoard(String pl1, String pl2) {
        Stream.of(board).flatMap(Arrays::stream).forEach(cell -> cell.setEnabled(true));
        TicTacToe.setGameState(TicTacToe.State.X_TURN);
        statusLabel.setStatusLabel();
        if (pl1.equals("Human")) {
            player1 = new HumanPlayer("X");
        } else {
            player1 = new RobotPlayer("X");
        }
        if (pl2.equals("Human")) {
            player2 = new HumanPlayer("O");
        } else {
            player2 = new RobotPlayer("O");
        }
        if (player1.getClass().equals(RobotPlayer.class)) {
            player1.move(board);
        }
    }
}
