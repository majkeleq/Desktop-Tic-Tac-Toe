package tictactoe;

import javax.swing.*;
import java.awt.*;

public class TaskBarButton extends JButton {
    public TaskBarButton(String text) {
        setPreferredSize(new Dimension(120,40));
        setFocusPainted(false);
        setText(text);
    }
}
