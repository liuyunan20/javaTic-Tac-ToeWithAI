package tictactoe;

import java.util.Scanner;

public class Game {
    private final Player playerX;
    private final Player playerO;
    private final Board board;

    public Game(Player playerX, Player playerO, Board board) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.board = board;
    }


    public void play() {
        board.printBoard();
        char piece = 'X';
        while (board.checkResult().equals("Game not finished")) {
            if (piece == 'X') {
                board.makeMove(playerX.move(board), piece);
                board.printBoard();
                piece = 'O';
            } else {
                board.makeMove(playerO.move(board), piece);
                board.printBoard();
                piece = 'X';
            }
        }
        System.out.println(board.checkResult());
    }
}
