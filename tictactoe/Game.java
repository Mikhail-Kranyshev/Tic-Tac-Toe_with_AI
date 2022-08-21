package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private static char[][] matrix;
    static Player player1;
    static Player player2;

    public Game() {
        matrix = new char[3][3];
    }

    private static void fill() {
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

    public boolean start() {
        while (true) {
            System.out.print("Input command: ");
            Scanner scanner = new Scanner(System.in);
            String string = scanner.nextLine();
            String[] command = string.split(" ");
            if (command.length == 3) {
                if ("start".equals(command[0])) {
                    switch (command[1]) {
                        case "easy" -> player1 = new ComputerEasy('X');
                        case "medium" -> player1 = new ComputerMedium('X');
                        case "hard" -> player1 = new ComputerHard('X');
                        case "user" -> player1 = new User('X');
                    }
                    switch (command[2]) {
                        case "easy" -> player2 = new ComputerEasy('O');
                        case "medium" -> player2 = new ComputerMedium('O');
                        case "hard" -> player2 = new ComputerHard('O');
                        case "user" -> player2 = new User('O');
                    }
                }
                if (player1 != null && player2 != null) {
                    fill();
                    return true;
                }
            } else if ("exit".equals(command[0]) && command.length == 1) {
                return false;
            }
            System.out.println("Bad parameters!");
        }
    }

    public static void process() {
        while (true) {
            matrix = player1.turn(matrix);
            print();
            if (isGameOver()) {
                return;
            }
            matrix = player2.turn(matrix);
            print();
            if (isGameOver()) {
                return;
            }
        }
    }

    public static boolean isGameOver() {
        for (int i = 0; i < 3; i++) {
            if (matrix[i][0] == matrix[i][1] && matrix[i][0] == matrix[i][2] && matrix[i][0] != ' ') {
                System.out.println(matrix[i][0] + " wins\n");
                return true;
            }
            if (matrix[0][i] == matrix[1][i] && matrix[0][i] == matrix[2][i] && matrix[0][i] != ' ') {
                System.out.println(matrix[0][i] + " wins\n");
                return true;
            }
        }
        if (((matrix[1][1] == matrix[0][0] && matrix[1][1] == matrix[2][2]) ||
                (matrix[1][1] == matrix[0][2] && matrix[1][1] == matrix[2][0])) &&
                matrix[1][1] != ' ') {
            System.out.println(matrix[1][1] + " wins\n");
            return true;
        }
        for (char[] chars : matrix) {
            for (char ch: chars) {
                if (ch == ' ') {
                    return false;
                }
            }
        }
        System.out.println("Draw\n");
        return true;
    }
}
