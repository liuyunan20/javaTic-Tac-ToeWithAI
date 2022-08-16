package tictactoe;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class computer {
    static int[] easyMove(char[][] board) {
        Random random = new Random();
        int[] coo = new int[2];
        System.out.println("Making move level \"easy\"");
        while (true) {
            coo[0] = random.nextInt(3);
            coo[1] = random.nextInt(3);
            if (board[coo[0]][coo[1]] == '_') {
                return coo;
            }
        }
    }
}

class player {
    final static Scanner scanner = new Scanner(System.in);
    static int[] playerMove(char[][] board) {
        while (true) {
            try {
                System.out.print("Enter the coordinates: ");
                int coo1 = scanner.nextInt();
                int coo2 = scanner.nextInt();
                if (coo1 > 3 || coo1 < 1 || coo2 > 3 || coo2 < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                if (board[coo1 - 1][coo2 - 1] == '_') {
                    return new int[]{coo1 - 1, coo2 - 1};
                }
                System.out.println("This cell is occupied! Choose another one!");
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                scanner.next();
            }
        }
    }
}
public class Main {
    final static Scanner scanner = new Scanner(System.in);
    private static final char[][] myBoard = new char[3][3];

    static void initializeBoard() {
        for (int i = 0; i <3; i++) {
            for (int j = 0; j < 3; j++) {
                myBoard[i][j] = '_';
            }
        }
    }
    static void printBoard() {
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

    static String checkResult() {
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
    static void makeMove(int[] coo, char piece) {
        myBoard[coo[0]][coo[1]] = piece;
    }
    static char checkPiece() {
        int numX = 0, numO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (myBoard[i][j] == 'X') {
                    numX++;
                } else if (myBoard[i][j] == 'O') {
                    numO++;
                }
            }
        }
        if (numO == numX) {
            return 'X';
        } else if (numX - numO == 1) {
            return 'O';
        } else {
            return 'U';
        }
    }
    public static void main(String[] args) {
        initializeBoard();
        printBoard();
        char piece = 'X';
        while (checkResult().equals("Game not finished")) {
            if (piece == 'X') {
                makeMove(player.playerMove(myBoard), piece);
                printBoard();
                piece = 'O';
            } else if (piece == 'O') {
                makeMove(computer.easyMove(myBoard), piece);
                printBoard();
                piece = 'X';
            }
        }
        System.out.println(checkResult());
    }
}
