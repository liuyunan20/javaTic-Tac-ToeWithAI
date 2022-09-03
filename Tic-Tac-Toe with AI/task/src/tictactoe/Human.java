package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Human extends Player {



    public Human(char piece) {
        this.piece = piece;
    }
    final static Scanner scanner = new Scanner(System.in);
    @Override
    public int[] move(Board board, char piece) {
        while (true) {
            try {
                System.out.print("Enter the coordinates: ");
                int coo1 = scanner.nextInt();
                int coo2 = scanner.nextInt();
                if (coo1 > 3 || coo1 < 1 || coo2 > 3 || coo2 < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                if (board.myBoard[coo1 - 1][coo2 - 1] == '_') {
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
