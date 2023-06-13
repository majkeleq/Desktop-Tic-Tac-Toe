package tictactoe;

import java.util.Arrays;
import java.util.stream.Stream;

public class HumanPlayer extends Player {
    public HumanPlayer(String sign, String type) {
        super(sign, type);
    }

    @Override
    public void move(Cell[][] board){
        Stream.of(board)
                .flatMap(Arrays::stream)
                .filter(cell -> cell.getText().equals(" ")).forEach(cell -> cell.setEnabled(true));
    }

}
