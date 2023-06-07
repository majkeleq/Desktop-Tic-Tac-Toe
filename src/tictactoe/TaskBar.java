package tictactoe;

import javax.swing.*;
import java.awt.*;

public class TaskBar extends JPanel {
    private final JButton buttonPlayer1 = new TaskBarButton("Human");
    private final JButton buttonPlayer2 = new TaskBarButton("Human");
    private final JButton buttonStartReset = new TaskBarButton("Start");
    public TaskBar(Board board, StatusLabel statusLabel) {
        setPreferredSize(new Dimension(450,50));

        buttonPlayer1.setName("ButtonPlayer1");

        buttonPlayer2.setName("ButtonPlayer2");

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
    private void setButtonPlayer1(String text) {
        buttonPlayer1.setText(text);
    }
    private void setButtonPlayer2(String text) {
        buttonPlayer2.setText(text);
    }
    public void doStart(String player1, String player2) {
        if( buttonStartReset.getText().equals("Start")) {
            setButtonPlayer1(player1);
            setButtonPlayer2(player2);
            buttonStartReset.doClick();
        }
    }
}
