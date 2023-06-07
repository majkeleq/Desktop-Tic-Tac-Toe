package tictactoe;

import tictactoe.menus.MenuBar;

import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {
    public enum State {
        NOT_STARTED, X_WINS, O_WINS, DRAW, X_TURN, O_TURN
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
        TaskBar taskBar = new TaskBar(board, statusLabel);
        JMenuBar menuBar = new MenuBar(taskBar);
        setJMenuBar(menuBar);
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