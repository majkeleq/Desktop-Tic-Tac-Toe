package tictactoe;

import javax.swing.*;
import java.awt.*;

public class StatusLabel extends JPanel {

    String player;

    JLabel statusLabel = new JLabel();
    public StatusLabel() {
        statusLabel.setName("LabelStatus");
        setStatusLabel();
        statusLabel.setPreferredSize(new Dimension(300, 30));
        add(statusLabel);
        setVisible(true);
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public void setStatusLabel() {
        switch (TicTacToe.getGameState()) {
            case NOT_STARTED -> statusLabel.setText("Game is not started");
            case X_TURN -> statusLabel.setText("The turn of " + player + " Player (X)");
            case O_TURN -> statusLabel.setText("The turn of " + player + " Player (O)");
            case X_WINS -> statusLabel.setText("The " + player + " Player (X) wins");
            case O_WINS -> statusLabel.setText("The " + player + " Player (O) wins");
            case DRAW -> statusLabel.setText("Draw");
        }
    }

    public JLabel getStatusLabel() {
        return statusLabel;
    }
}
