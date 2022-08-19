package tictactoe;

import java.util.Arrays;

public class Board {
    public final char[][] myBoard = new char[3][3];
    public Board() {
        initializeBoard();
    }
    void initializeBoard() {
        for (int i = 0; i <3; i++) {
            for (int j = 0; j < 3; j++) {
                myBoard[i][j] = '_';
            }
        }
    }
    void printBoard() {
        String dashes = "---------";
        System.out.println(dashes);
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(myBoard[i][j] + " ");
            }
            System.out.print("|\n");
        }
        System.out.println(dashes);
    }

    String checkResult() {
        int numX = 0, numO = 0;
        boolean boardNotFull = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (myBoard[i][j] == 'X') {
                    numX++;
                } else if (myBoard[i][j] == 'O') {
                    numO++;
                } else if (myBoard[i][j] == '_') {
                    boardNotFull = true;
                }
            }
        }
        if (numO - numX > 1 || numX - numO > 1) {
            return "Impossible";
        }
        char [] winPatternX = {'X', 'X', 'X'};
        char [] winPatternO = {'O', 'O', 'O'};
        boolean xWin = false, oWin  = false;
        for (int i = 0; i <3; i++) {
            if (Arrays.equals(myBoard[i], winPatternX)) {
                xWin = true;
            } else if (Arrays.equals(myBoard[i], winPatternO)) {
                oWin = true;
            }
            char [] column = { myBoard[0][i], myBoard[1][i], myBoard[2][i]};
            if (Arrays.equals(column, winPatternX)) {
                xWin = true;
            } else if (Arrays.equals(column, winPatternO)) {
                oWin = true;
            }
        }
        char [] diagonal1 = {myBoard[0][0], myBoard[1][1], myBoard[2][2]};
        char [] diagonal2 = {myBoard[0][2], myBoard[1][1], myBoard[2][0]};
        if (Arrays.equals(diagonal1, winPatternX) || Arrays.equals(diagonal2, winPatternX)) {
            xWin = true;
        } else if (Arrays.equals(diagonal1, winPatternO) || Arrays.equals(diagonal2, winPatternO)) {
            oWin = true;
        }
        if (oWin && xWin) {
            return "Impossible";
        } else if (oWin) {
            return "O wins";
        } else if (xWin) {
            return "X wins";
        } else if (boardNotFull) {
            return "Game not finished";
        }
        return "Draw";
    }
    void makeMove(int[] coo, char piece) {
        myBoard[coo[0]][coo[1]] = piece;
    }
}
