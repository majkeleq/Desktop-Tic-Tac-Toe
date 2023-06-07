package tictactoe;

import javax.swing.*;
import java.awt.*;

public class StatusLabel extends JPanel {

    JLabel statusLabel = new JLabel();
    public StatusLabel() {
        statusLabel.setName("LabelStatus");
        setStatusLabel();
        statusLabel.setPreferredSize(new Dimension(300, 30));
        add(statusLabel);
        setVisible(true);
    }
    public void setStatusLabel() {
        switch (TicTacToe.getGameState()) {
            case NOT_STARTED -> statusLabel.setText("Game is not started");
            case X_TURN -> statusLabel.setText("Player X turn");
            case O_TURN -> statusLabel.setText("Player O turn");
            case X_WINS -> statusLabel.setText("X wins");
            case O_WINS -> statusLabel.setText("O wins");
            case DRAW -> statusLabel.setText("Draw");
        }
    }
    public JLabel getStatusLabel() {
        return statusLabel;
    }
}
