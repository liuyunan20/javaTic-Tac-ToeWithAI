package tictactoe;

import java.util.Arrays;

public class Medium extends Player{

    public Medium(char piece) {
        this.piece = piece;
    }

    @Override
    int[] move(Board board, char piece) {
        System.out.println("Making move level \"medium\"");
        char[][] toWinX = {{'_', 'X', 'X'}, {'X', '_', 'X'}, {'X', 'X', '_'}};
        char[][] toWinO = {{'_', 'O', 'O'}, {'O', '_', 'O'}, {'O', 'O', '_'}};
        char [] diagonal1 = {board.myBoard[0][0], board.myBoard[1][1], board.myBoard[2][2]};
        char [] diagonal2 = {board.myBoard[0][2], board.myBoard[1][1], board.myBoard[2][0]};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Arrays.equals(board.myBoard[i], toWinX[j]) || Arrays.equals(board.myBoard[i], toWinO[j])) {
                    return new int[] {i, j};
                }
                char[] column = {board.myBoard[0][i], board.myBoard[1][i], board.myBoard[2][i]};
                if (Arrays.equals(column, toWinX[j]) || Arrays.equals(column, toWinO[j])) {
                    return new int[] {j, i};
                }
            }
            if (Arrays.equals(diagonal1, toWinX[i]) || Arrays.equals(diagonal1, toWinO[i])) {
                return new int[] {i, i};
            } else if (Arrays.equals(diagonal2, toWinX[i]) || Arrays.equals(diagonal2, toWinO[i])) {
                return new int[] {i, 2 - i};
            }
        }
        return randomMove(board);
    }
}
