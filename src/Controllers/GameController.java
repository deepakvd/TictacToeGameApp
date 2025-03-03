package Controllers;

import Models.Game;
import Models.Player;
import Services.GameService;

public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void startGame() {
        gameService.startGame();
    }

    public void makeMove(int x, int y, Player player) {
        gameService.makeMove(x, y, player);
    }

    public void resetGame() {
        gameService.resetGame();
    }

    public void displayBoard() {
        gameService.getGame().getBoard().displayBoard();
    }
}
