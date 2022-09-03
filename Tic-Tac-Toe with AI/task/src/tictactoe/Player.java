package tictactoe;

import java.util.Random;

public class Player {

    char piece;
    char opPiece;
    int[] move(Board board, char piece) {
        return null;
    }

    int[] randomMove(Board board) {
        Random random = new Random();
        int[] coo = new int[2];
        while (true) {
            coo[0] = random.nextInt(3);
            coo[1] = random.nextInt(3);
            if (board.myBoard[coo[0]][coo[1]] == '_') {
                return coo;
            }
        }
    }
}
