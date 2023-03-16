package tictactoe;

import javax.swing.*;
import java.awt.*;

public class TaskBar extends JPanel {
    public TaskBar(Board board, StatusLabel statusLabel) {
        setPreferredSize(new Dimension(450,50));
        JButton buttonPlayer1 = new TaskBarButton("Human");
        buttonPlayer1.setName("ButtonPlayer1");
        JButton buttonPlayer2 = new TaskBarButton("Human");
        buttonPlayer2.setName("ButtonPlayer2");
        JButton buttonStartReset = new TaskBarButton("Start");
        buttonStartReset.setName("ButtonStartReset");

        addPlayerChangeListener(buttonPlayer1);
        addPlayerChangeListener(buttonPlayer2);
        buttonStartReset.addActionListener(e -> {
            if (TicTacToe.getGameState().equals(TicTacToe.State.NOT_STARTED)) {
                buttonStartReset.setText("Reset");
                buttonPlayer1.setEnabled(false);
                buttonPlayer2.setEnabled(false);
                board.startBoard(buttonPlayer1.getText(), buttonPlayer2.getText());

            } else {
                board.resetBoard();
                buttonStartReset.setText("Start");
                buttonPlayer1.setEnabled(true);
                buttonPlayer2.setEnabled(true);

            }
        });


        add(buttonPlayer1);
        add(buttonStartReset);
        add(buttonPlayer2);
        setVisible(true);
    }

    private void addPlayerChangeListener(JButton button) {
        button.addActionListener(e -> {
            if (button.getText().equals("Human")) {
                button.setText("Robot");
            } else if (button.getText().equals("Robot")) {
                button.setText("Human");
            }
        });
    }
}
