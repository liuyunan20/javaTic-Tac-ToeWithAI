package tictactoe;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Player createPlayer(String player, char piece) {
        switch (player) {
            case "easy" -> {return new Computer(piece);}
            case "user" -> {return new Human(piece);}
            case "medium" -> {return new Medium(piece);}
            case "hard" -> {return new Hard(piece);}
        }
        return null;
    }
    private static Game menu() {
        Scanner scanner = new Scanner(System.in);
        String[] commands;
        String[] modes = {"easy", "user", "medium", "hard"};
        do {
            System.out.print("Input command: ");
            String input = scanner.nextLine();
            commands = input.split("\\s+");
            if ("exit".equals(commands[0])) {
                break;
            }
            if (commands.length != 3 || !"start".equals(commands[0])) {
                System.out.println("Bad parameters!");
            } else {
                if (!Arrays.asList(modes).contains(commands[1]) || !Arrays.asList(modes).contains(commands[2])){
                    System.out.println("Bad parameters!");
                    continue;
                }
                return new Game(createPlayer(commands[1], 'X'), createPlayer(commands[2], 'O'), new Board());
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
