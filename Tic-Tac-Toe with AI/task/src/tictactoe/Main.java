package tictactoe;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    final static Scanner scanner = new Scanner(System.in);
    private static char[][] myBoard = new char[3][3];
    public static void main(String[] args) {
        String symbols = scanner.next();
        myBoard = initializeBoard(symbols);
        printBoard();
        move(checkPiece());
        printBoard();
        System.out.println(checkResult());
    }

    static char[][] initializeBoard(String symbols) {
        char [][] board = new char[3][3];
        for (int i = 0; i <3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = symbols.charAt(3 * i + j);
            }
        }
        return board;
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
    static void move(char piece) {
        while (true) {
            try {
                System.out.print("Enter the coordinates: ");
                int coo1 = scanner.nextInt();
                int coo2 = scanner.nextInt();
                if (coo1 > 3 || coo1 < 1 || coo2 > 3 || coo2 < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                if (myBoard[coo1 - 1][coo2 - 1] == '_') {
                    if (piece != 'U') {
                        myBoard[coo1 - 1][coo2 - 1] = piece;
                        break;
                    }
                }
                System.out.println("This cell is occupied! Choose another one!");
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                scanner.next();
            }
        }
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
}
