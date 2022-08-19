package tictactoe;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Player createPlayer(String player) {
        switch (player) {
            case "easy":
                return new Computer();
            case "user":
                return new Human();
        }
        return null;
    }
    private static Game menu() {
        Scanner scanner = new Scanner(System.in);
        String[] commands;
        String[] modes = {"easy", "user"};
        do {
            System.out.print("Input command: ");
            String input = scanner.nextLine();
            commands = input.split("\\s+");
            if (commands.length != 3 || !"start".equals(commands[0])) {
                System.out.println("Bad parameters!");
            } else {
                if (!Arrays.asList(modes).contains(commands[1]) || !Arrays.asList(modes).contains(commands[2])){
                    System.out.println("Bad parameters!");
                    continue;
                }
                return new Game(createPlayer(commands[1]), createPlayer(commands[2]), new Board());
            }
        } while (!"exit".equals(commands[0]));
        return null;
    }
    public static void main(String[] args) {
        Game game = menu();
        while (game != null) {
            game.play();
            game = menu();
        }
    }
}
