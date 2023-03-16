package tictactoe;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class RobotPlayer extends Player {

    public RobotPlayer(String sign) {
        super(sign);
    }

    @Override
    public void move(Cell[][] board) {
        Random random = new Random();
        List<Cell> emptyCells =
                Stream.of(board)
                        .flatMap(Arrays::stream)
                        .filter(cell -> cell.getText().equals(" "))
                        .toList();
        int rand = random.nextInt(0, emptyCells.size());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        emptyCells.get(rand).doClick();
    }
}
