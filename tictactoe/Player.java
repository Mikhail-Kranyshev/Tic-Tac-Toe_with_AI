package tictactoe;

public abstract class Player {
    protected char figure;

    public Player(char figure) {
        this.figure = figure;
    }

    protected abstract char[][] turn(char[][] matrix);
}
