package tictactoe;

import java.util.Scanner;

public class Main {
    static char[][] matrix = new char[3][3];
    static int countX = 0;
    static int countO = 0;

    private static void generate() {
        System.out.print("Enter the cells: ");
        char[] chars = new Scanner(System.in).next().toCharArray();
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (chars[k] == 'X') {
                    countX++;
                } else if (chars[k] == 'O') {
                    countO++;
                }
                matrix[i][j] = chars[k++];

            }
        }
    }
    private static void print() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println(" |");
        }
        System.out.println("---------");
    }

    private static void inputCoordinates() {
        while (true) {
            System.out.print("Enter the coordinates: ");
            String[] strings = new Scanner(System.in).nextLine().split(" ");
            try {
                int x = Integer.parseInt(strings[0]) - 1;
                int y = Integer.parseInt(strings[1]) - 1;
                if (x >= 0 && x <= 2 && y >= 0 && y <= 2) {
                    if (matrix[x][y] == '_') {
                        if (countX > countO) {
                            matrix[x][y] = 'O';
                            countO++;
                        } else {
                            matrix[x][y] = 'X';
                            countX++;
                        }
                        return;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }
        }

    }

    public static void check() {
        for (int i = 0; i < 3; i++) {
            if (matrix[i][0] == matrix[i][1] && matrix[i][0] == matrix[i][2] && matrix[i][0] != '_') {
                System.out.println(matrix[i][0] + " wins");
                return;
            }
            if (matrix[0][i] == matrix[1][i] && matrix[0][i] == matrix[2][i] && matrix[0][i] != '_') {
                System.out.println(matrix[0][i] + " wins");
                return;
            }
        }
        if (((matrix[1][1] == matrix[0][0] && matrix[1][1] == matrix[2][2]) ||
                (matrix[1][1] == matrix[0][2] && matrix[1][1] == matrix[2][0])) &&
                matrix[1][1] != '_') {
            System.out.println(matrix[1][1] + " wins");
            return;
        }
        for (char[] chars : matrix) {
            for (char ch: chars) {
                if (ch == '_') {
                    System.out.println("Game not finished");
                    return;
                }
            }
        }
        System.out.println("Draw");


    }



    public static void main(String[] args) {
        generate();
        print();
        inputCoordinates();
        print();
        check();
    }


}
