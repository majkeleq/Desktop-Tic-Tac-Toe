package tictactoe;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Cell extends JButton {
    public Cell(String number) {
        setName("Button" + number);
        setText(" ");
        setFocusPainted(false);
        setBackground(new Color(251, 197, 49));
        setBorder(new LineBorder(Color.BLACK,2, true));
        setFont(new Font("Courier", Font.BOLD, 60));
        setVisible(true);
        setEnabled(false);
    }
}
