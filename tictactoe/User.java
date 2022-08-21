package tictactoe;

import java.util.Scanner;

public class User extends Player{
    public User(char figure) {
        super(figure);
    }

    public char[][] turn(char[][] matrix) {
        while (true) {
            System.out.print("Enter the coordinates: ");
            String[] strings = new Scanner(System.in).nextLine().split(" ");
            try {
                int x = Integer.parseInt(strings[0]) - 1;
                int y = Integer.parseInt(strings[1]) - 1;
                if (x >= 0 && x <= 2 && y >= 0 && y <= 2) {
                    if (matrix[x][y] == ' ') {
                        matrix[x][y] = figure;
                        return matrix;
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
}
