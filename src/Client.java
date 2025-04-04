import java.util.Scanner;
import Models.HumanPlayer;
import Models.Player;
import Services.GameService;
import Controllers.GameController;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize Players
        Player player1 = new HumanPlayer("Player 1", 'X', 1);
        Player player2 = new HumanPlayer("Player 2", 'O', 2);

        /* Initialize GameService & Controller */
        GameService gameService = new GameService(3); // 3x3 board
        GameController gameController = new GameController(gameService);

        // Start Game
        gameController.startGame();


        // Let GameController handle the game loop
        gameController.startGame();

        scanner.close();
    }
}
