
package Controllers;
import java.util.Scanner;
import Services.GameService;

public class GameController {
    private final GameService gameService;
    private final Scanner scanner;
    private char currentPlayer;

    public GameController(GameService gameService) {
        this.gameService = gameService;
        this.scanner = new Scanner(System.in);
        this.currentPlayer = 'X';
    }

    public void startGame() {
        while (true) {
            gameService.printBoard();
            System.out.println("Player " + currentPlayer + ", enter row (0-2) and column (0-2):");

            int row = getInput("Enter row: ");
            int col = getInput("Enter column: ");

            if (gameService.makeMove(row, col, currentPlayer)) {
                if (gameService. (currentPlayer)) {
                    gameService.printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                } else if (gameService.isBoardFull()) {
                    gameService.printBoard();
                    System.out.println("It's a draw!");
                    break;
                }
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        scanner.close();
    }

    private int getInput(String prompt) {
        int input;
        while (true) {
            try {
                System.out.print(prompt);
                input = scanner.nextInt();
                if (input >= 0 && input <= 2) {
                    return input;
                } else {
                    System.out.println("Invalid input. Please enter a number between 0 and 2.");
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }
}