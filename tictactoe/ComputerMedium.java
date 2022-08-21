package tictactoe;

import java.util.Random;

public class ComputerMedium extends Player{

    public ComputerMedium(char figure) {
        super(figure);
    }
    public char[][] turn(char[][] matrix) {
        System.out.println("Making move level \"medium\"");
        Random random = new Random();
        while (true) {
            for (int i = 0; i < 3; i++) {
                if (matrix[i][0] == matrix[i][1] && matrix[i][2] == ' ' && matrix[i][1] != ' ') {
                    matrix[i][2] = this.figure;
                    return matrix;
                } else if (matrix[i][1] == matrix[i][2] && matrix[i][0] == ' ' && matrix[i][1] != ' ') {
                    matrix[i][0] = this.figure;
                    return matrix;
                } else if (matrix[i][0] == matrix[i][2] && matrix[i][1] == ' ' && matrix[i][0] != ' ') {
                    matrix[i][1] = this.figure;
                    return matrix;
                }
                if (matrix[0][i] == matrix[1][i] && matrix[2][i] == ' ' && matrix[1][i] != ' ') {
                    matrix[2][i] = this.figure;
                    return matrix;
                } else if (matrix[1][i] == matrix[2][i] && matrix[0][i] == ' ' && matrix[1][i] != ' ') {
                    matrix[0][i] = this.figure;
                    return matrix;
                } else if (matrix[0][i] == matrix[2][i] && matrix[1][i] == ' ' && matrix[0][i] != ' ') {
                    matrix[1][i] = this.figure;
                    return matrix;
                }
            }
            if (matrix[0][0] == matrix[1][1] && matrix[2][2] == ' ' && matrix[1][1] != ' ') {
                matrix[2][2] = this.figure;
                return matrix;
            } else if (matrix[1][1] == matrix[2][2] && matrix[0][0] == ' ' && matrix[1][1] != ' ') {
                matrix[0][0] = this.figure;
                return matrix;
            } else if (matrix[0][0] == matrix[2][2] && matrix[1][1] == ' '  && matrix[0][0] != ' ') {
                matrix[1][1] = this.figure;
                return matrix;
            } else if (matrix[0][2] == matrix[1][1] && matrix[2][0] == ' ' && matrix[1][1] != ' ') {
                matrix[2][0] = this.figure;
                return matrix;
            } else if (matrix[1][1] == matrix[2][0] && matrix[0][2] == ' ' && matrix[1][1] != ' ') {
                matrix[0][2] = this.figure;
                return matrix;
            } else if (matrix[0][2] == matrix[2][0] && matrix[1][1] == ' ' && matrix[0][2] != ' ') {
                matrix[1][1] = this.figure;
                return matrix;
            }
            int x = random.nextInt(3);
            int y = random.nextInt(3);
            if (matrix[x][y] == ' ') {
                matrix[x][y] = figure;
                return matrix;
            }
        }
    }
}
