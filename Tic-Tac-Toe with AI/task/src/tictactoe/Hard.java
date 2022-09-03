package tictactoe;
import java.util.List;

class PositionScore {
    int[] position;
    int score;

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public PositionScore(int[] position, int score) {
        this.position = position;
        this.score = score;
    }
}
public class Hard extends Player{

    public Hard(char piece) {
        this.piece = piece;
        switch (piece) {
            case 'X' -> this.opPiece = 'O';
            case 'O' -> this.opPiece = 'X';
        }
    }

    @Override
    int[] move(Board board, char playerPiece) {
        System.out.println("Making move level \"hard\"");
        return minimax(board, piece).getPosition();
    }

    PositionScore minimax(Board board, char playerPiece) {
        PositionScore bestScore;
        if (playerPiece == piece) {
            bestScore = new PositionScore(new int[2], -100);
        } else {
            bestScore = new PositionScore(new int[2], 100);
        }

        List<int[]> availableSpots = board.availableSpot();
        for (int[] availableSpot : availableSpots) {

            PositionScore curScore;
            Board newBoard = board.copy();
            newBoard.myBoard[availableSpot[0]][availableSpot[1]] = playerPiece;
            String result = newBoard.checkResult();
            if ("Draw".equals(result)) {
                return new PositionScore(availableSpot, 0);
            } else if ((piece + " wins").equals(result)) {
                return new PositionScore(availableSpot, 10);
            } else if ("Game not finished".equals(result)) {
                if (playerPiece == piece) {
                    curScore = minimax(newBoard, opPiece);
                    if (curScore.getScore() == 10) {
                        return curScore;
                    } else {
                        if (curScore.getScore() > bestScore.getScore()) {
                            bestScore.setScore(curScore.score);
                            bestScore.setPosition(availableSpot);
                        }
                    }
                } else {
                    curScore = minimax(newBoard, piece);
                    if (curScore.getScore() == -10) {
                        return curScore;
                    } else {
                        if (curScore.getScore() < bestScore.getScore()) {
                            bestScore.setScore(curScore.score);
                            bestScore.setPosition(availableSpot);
                        }
                    }
                }
            } else {
                return new PositionScore(availableSpot, -10);
            }
        }
        return bestScore;
    }


}
