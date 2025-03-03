package Controllers;

import Models.Player;
import Services.GameService;

import java.util.Scanner;

public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void startGame() {
        gameService.startGame();
    }

    public boolean makeMove(int x, int y, Player player) {
        return gameService.makeMove(x, y, player);
    }

    public void displayBoard() {
        gameService.getGame().getBoard().displayBoard();
    }

    public void endGame() {
        System.out.println("Game Over!");
    }

    public void playGame(Scanner scanner) {
        while (true) {
            // Get Current Player
            Player currentPlayer = gameService.getCurrentPlayer();
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + ")");

            // Input Move
            System.out.print("Enter row and column (0-based index, e.g., '1 2'): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            // Make Move
            boolean validMove = makeMove(x, y, currentPlayer);
            if (!validMove) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            // Display Updated Board
            displayBoard();

            // Check Win Condition
            if (gameService.checkWin()) {
                System.out.println(currentPlayer.getName() + " wins! 🎉");
                break;
            }

            // Check Draw Condition
            if (gameService.checkDraw()) {
                System.out.println("It's a draw! 😐");
                break;
            }

            // Switch Player
            gameService.switchPlayer();
        }

        endGame();
    }
}
