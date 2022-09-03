package tictactoe;

public class Computer extends Player {

    public Computer(char piece) {
        this.piece = piece;
    }
    @Override
    int[] move(Board board, char piece) {
        System.out.println("Making move level \"easy\"");
        return randomMove(board);
    }
}
