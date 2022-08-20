package tictactoe;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static char[][] matrix = new char[3][3];

    private static void generate() {
        for (int i = 0; i < 3; i++) {
            Arrays.fill(matrix[i], ' ');
        }
        print();
    }
    private static void print() {
        System.out.println("---------");
        for (char[] chars: matrix) {
            System.out.print("|");
            for (char ch: chars) {
                System.out.print(" " + ch);
            }
            System.out.println(" |");
        }
        System.out.println("---------");
    }

    private static boolean turnPlayer() {
        while (true) {
            System.out.print("Enter the coordinates: ");
            String[] strings = new Scanner(System.in).nextLine().split(" ");
            try {
                int x = Integer.parseInt(strings[0]) - 1;
                int y = Integer.parseInt(strings[1]) - 1;
                if (x >= 0 && x <= 2 && y >= 0 && y <= 2) {
                    if (matrix[x][y] == ' ') {
                        matrix[x][y] = 'X';
                        print();
                        return !isGameOver();
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

    public static boolean turnComputer() {
        System.out.println("Making move level \"easy\"");
        Random random = new Random();
        while (true) {
            int x = random.nextInt(3);
            int y = random.nextInt(3);
            if (matrix[x][y] == ' ') {
                matrix[x][y] = 'O';
                print();
                return !isGameOver();
            }
        }
    }

    public static boolean isGameOver() {
        for (int i = 0; i < 3; i++) {
            if (matrix[i][0] == matrix[i][1] && matrix[i][0] == matrix[i][2] && matrix[i][0] != ' ') {
                System.out.println(matrix[i][0] + " wins");
                return false;
            }
            if (matrix[0][i] == matrix[1][i] && matrix[0][i] == matrix[2][i] && matrix[0][i] != ' ') {
                System.out.println(matrix[0][i] + " wins");
                return false;
            }
        }
        if (((matrix[1][1] == matrix[0][0] && matrix[1][1] == matrix[2][2]) ||
                (matrix[1][1] == matrix[0][2] && matrix[1][1] == matrix[2][0])) &&
                matrix[1][1] != ' ') {
            System.out.println(matrix[1][1] + " wins");
            return false;
        }
        for (char[] chars : matrix) {
            for (char ch: chars) {
                if (ch == ' ') {
                    return true;
                }
            }
        }
        System.out.println("Draw");
        return false;
    }



    public static void main(String[] args) {
        generate();
        while (true) {
            if (turnPlayer()) break;
            if (turnComputer()) break;
        }
    }


}
