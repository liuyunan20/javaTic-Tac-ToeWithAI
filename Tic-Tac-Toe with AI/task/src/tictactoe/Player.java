package tictactoe;

import java.util.Random;

public class Player {
    int[] move(Board board) {
        return null;
    }

    int[] randomMove(Board board) {
        Random random = new Random();
        int[] coo = new int[2];
        System.out.println("Making move level \"easy\"");
        while (true) {
            coo[0] = random.nextInt(3);
            coo[1] = random.nextInt(3);
            if (board.myBoard[coo[0]][coo[1]] == '_') {
                return coo;
            }
        }
    }
}