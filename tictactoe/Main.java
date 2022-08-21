package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        while (game.start()) {
            game.process();
        }
    }
}
