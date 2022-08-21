package tictactoe;

import java.util.Random;

public class ComputerEasy extends Player {
    public ComputerEasy(char figure) {
        super(figure);
    }

    public char[][] turn(char[][] matrix) {
        System.out.println("Making move level \"easy\"");
        Random random = new Random();
        while (true) {
            int x = random.nextInt(3);
            int y = random.nextInt(3);
            if (matrix[x][y] == ' ') {
                matrix[x][y] = figure;
                return matrix;
            }
        }
    }
}
