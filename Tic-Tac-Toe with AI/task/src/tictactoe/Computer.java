package tictactoe;

public class Computer extends Player {
    @Override
    int[] move(Board board) {
        return randomMove(board);
    }
}
