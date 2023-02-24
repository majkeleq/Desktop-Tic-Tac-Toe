package tictactoe;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cell extends JButton implements ActionListener {
        public Cell(String number) {
        setName("Button" + number);
        setText("   ");
        setFocusPainted(false);
        //setBorderPainted(true);
        //setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //setBorder(new EmptyBorder(10,10,10,10));
        setBorder(new LineBorder(Color.BLACK,2, true));
        setBackground(new Color(251, 197, 49));
        setFont(new Font("Courier", Font.BOLD, 60));
        addActionListener(this);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        /*if (isNextMoveX && this.getText().equals("   ")) {
            Board.gameState = Board.State.IN_PROGRESS;
            isNextMoveX = false;
            this.setText("X");
        } else if (!isNextMoveX && this.getText().equals("   ")){
            this.setText("O");
            isNextMoveX = true;
        }*/
    }
}
