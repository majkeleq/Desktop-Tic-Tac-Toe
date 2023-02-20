package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cell extends JButton implements ActionListener {
    public Cell(String number) {
        setName("Button" + number);
        setText("   ");
        setFocusPainted(false);
        //setBorderPainted(true);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(new Color(251, 197, 49));
        setFont(new Font("Courier", Font.BOLD, 30));
        addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.setText("X");
    }
}
