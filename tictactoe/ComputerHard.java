package tictactoe;

public class ComputerHard extends Player{

    public ComputerHard(char figure) {
        super(figure);
    }

    public char[][] turn(char[][] matrix) {
        int[] coordinate = findBestMove(matrix);
        matrix[coordinate[0]][coordinate[1]] = this.figure;
        return matrix;
    }


    private static Boolean isMovesLeft(char[][] matrix) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (matrix[i][j] == ' ')
                    return true;
        return false;
    }
    private int evaluate(char[][] matrix)
    {
        for (int row = 0; row < 3; row++)
        {
            if (matrix[row][0] == matrix[row][1] &&
                    matrix[row][1] == matrix[row][2])
            {
                if (matrix[row][0] == this.figure)
                    return +10;
                else if (matrix[row][0] != ' ')
                    return -10;
            }
        }

        for (int col = 0; col < 3; col++)
        {
            if (matrix[0][col] == matrix[1][col] &&
                    matrix[1][col] == matrix[2][col])
            {
                if (matrix[0][col] == this.figure)
                    return +10;
                else if (matrix[0][col] != ' ')
                    return -10;
            }
        }

        if (matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2])
        {
            if (matrix[0][0] == this.figure)
                return +10;
            else if (matrix[0][0] != ' ')
                return -10;
        }

        if (matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0])
        {
            if (matrix[0][2] == this.figure)
                return +10;
            else if (matrix[0][2] != ' ')
                return -10;
        }
        return 0;
    }

    private int minimax(char[][] matrix, int depth, Boolean isMax)
    {
        int score = evaluate(matrix);

        if (score == 10) {
            return score;
        }
        if (score == -10) {
            return score;
        }

        if (!isMovesLeft(matrix)) {
            return 0;
        }

        int best;
        if (isMax) {
            best = -1000;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (matrix[i][j]==' ') {

                        matrix[i][j] = this.figure;

                        best = Math.max(best, minimax(matrix, depth + 1, false));

                        matrix[i][j] = ' ';
                    }
                }
            }
        } else {
            best = 1000;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (matrix[i][j] == ' ') {
                        if (this.figure == 'X') {
                            matrix[i][j] = 'O';
                        } else {
                            matrix[i][j] = 'X';
                        }
                        best = Math.min(best, minimax(matrix, depth + 1, !isMax));
                        matrix[i][j] = ' ';
                    }
                }
            }
        }
        return best;
    }

    private int[] findBestMove(char[][] matrix)
    {
        int bestVal = -1000;
        int[] bestMove = {-1, -1};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == ' ') {
                    matrix[i][j] = this.figure;

                    int moveVal = minimax(matrix, 0, false);

                    matrix[i][j] = ' ';

                    if (moveVal > bestVal) {
                        bestMove = new int[]{i, j};
                        bestVal = moveVal;
                    }
                }
            }
        }
        return bestMove;
    }
}
