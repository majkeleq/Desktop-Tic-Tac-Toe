package tictactoe;

abstract public class Player {
    private String sign;
    public Player(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    abstract public void move(Cell[][] board);
}
