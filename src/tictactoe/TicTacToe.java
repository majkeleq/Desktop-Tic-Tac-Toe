package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.util.logging.*;

public class TicTacToe extends JFrame{
    public enum State {
        NOT_STARTED, IN_PROGRESS, X_WINS, O_WINS, DRAW
    }
    public static State gameState = State.NOT_STARTED;
    public static boolean isNextMoveX = true;

    public TicTacToe() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        setResizable(false);
        setSize(450, 500);
        setLocationRelativeTo(null); // added
        //JPanel board = new Board();
        //add(board);

        initComponents();


        //setLayout(new GridLayout(3,3, 10, 10));
        setLayout(new FlowLayout());

        setVisible(true);
    }
    private void initComponents() {
        Logger logger = Logger.getLogger(TicTacToe.class.getName());

        JLabel labelStatus = new JLabel();
        labelStatus.setName("LabelStatus");
        setStatusLabel(labelStatus);
        labelStatus.setPreferredSize(new Dimension(300, 50));
        Cell[][] board = new Cell[3][3];

        for (int i = 3; i > 0; i--) {
            for (int j = 0; j < 3; j++) {
                board[i - 1][j] = new Cell((char) ('A' + j) + String.valueOf(i));
                board[i - 1][j].setPreferredSize(new Dimension(120,120));
                //board[i - 1][j].addActionListener(this);
                board[i - 1][j].addActionListener(e -> {
                    if (e.getSource() instanceof Cell clickedCell && (gameState == State.NOT_STARTED || gameState == State.IN_PROGRESS)) {
                        if (isNextMoveX && clickedCell.getText().equals(" ")) {
                            gameState = State.IN_PROGRESS;
                            isNextMoveX = false;
                            clickedCell.setText("X");
                        } else if (!isNextMoveX && clickedCell.getText().equals(" ")){
                            clickedCell.setText("O");
                            isNextMoveX = true;
                        }
                        logger.info(clickedCell.getName() + " clicked");
                        setDrawOrWinningState(board);
                        setStatusLabel(labelStatus);


                    }
                });
                add(board[i - 1][j]);
                //board[i - 1][j].setText(i-1 +""+j);
            }
        }

        add(labelStatus);
        JButton buttonReset = new JButton("Reset");
        buttonReset.setName("ButtonReset");
        buttonReset.addActionListener(e -> {
            for (int temp1 = 3; temp1 > 0; temp1--) {
                for (int temp2 = 0; temp2 < 3; temp2++) {
                    board[temp1 -1][temp2].setText(" ");
                }
            }
            logger.info(buttonReset.getName() + " clicked");
            gameState = State.NOT_STARTED;
            isNextMoveX = true;
            setStatusLabel(labelStatus);
        });
        add(buttonReset);
    }
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
        return "   ";
    }
    public boolean isDraw(Cell[][] board) {
        for (int i = 0; i < 9; i++) {
            if (board[i / 3][i % 3].getText().equals(" ") ) return false;
        }
        return true;
    }

    public void setDrawOrWinningState(Cell[][] board) {
        if (isDraw(board)) {
            gameState = State.DRAW;
        } else {
            switch (isWon(board)) {
                case "X" -> gameState = State.X_WINS;
                case "O" -> gameState = State.O_WINS;
                default -> {
                }
            }
        }
    }

    public void setStatusLabel(JLabel label) {
        switch (gameState) {
            case NOT_STARTED -> label.setText("Game is not started");
            case IN_PROGRESS -> label.setText("Game in progress");
            case X_WINS -> label.setText("X wins");
            case O_WINS -> label.setText("O wins");
            case DRAW -> label.setText("Draw");
        }
    }
}