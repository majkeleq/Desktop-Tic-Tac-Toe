package tictactoe;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Board extends JPanel {
    public Board(){
        setBorder(new EmptyBorder(10,10,10,10));

        for (int i = 3; i > 0; i--) {
            for (int j = 0; j < 3; j++) {
                add(new Cell((char) ('A' + j) + String.valueOf(i)));

            }
        }

        setLayout(new GridLayout(3,3, 10, 10));

        setVisible(true);
    }
}
