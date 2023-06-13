package tictactoe;

abstract public class Player {
    private String sign;
    private String type;

    public Player(String sign, String type) {
        this.sign = sign;
        this.type = type;
    }

    public String getSign() {
        return sign;
    }

    public String getType() {
        return type;
    }

    abstract public void move(Cell[][] board);
}
