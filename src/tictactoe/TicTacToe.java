package tictactoe;

import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {
    public enum State {
        NOT_STARTED, IN_PROGRESS, X_WINS, O_WINS, DRAW
    }

    public static State gameState = State.NOT_STARTED;

    public static State getGameState() {
        return gameState;
    }
    public StatusLabel statusLabel = new StatusLabel();

    public TicTacToe() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        setResizable(false);
        setSize(450, 600);
        setLocationRelativeTo(null); // added
        Board board = new Board(statusLabel);
        JPanel taskBar = new TaskBar(board, statusLabel);
        add(taskBar);
        add(board);
        add(statusLabel);

        setLayout(new FlowLayout());

        setVisible(true);
    }

    public static void setGameState(State state) {
        gameState = state;
    }
}