package Services;

import Models.Game;
import Models.Player;

public class GameService
{
    private final Game game;
    private Game.gameState state;

    public GameService(Game game) {
        this.game = game;
    }

    public void startGame() {
        game.setState(Game.gameState.IN_PROGRESS);
        game.setCurrentPlayerIndex(0);
    }

    public void switchPlayer()
    {
        if(game.getCurrentPlayerIndex() == 0)
            game.setCurrentPlayerIndex(1);
        else
            game.setCurrentPlayerIndex(0);

    }

    public void makeMove(int x, int y, Player player)
    {
        if (game.getBoard().getCell(x, y).isCellOccupied()) {
            System.out.println("Cell is already occupied! Choose another move.");
            return;
        }

        game.getBoard().setPlayer(x, y, player);
        checkGameState();
        switchPlayer();
    }

    public void resetGame() {
        game.getBoard().resetBoard();
        game.setState(Game.gameState.IN_PROGRESS);
        game.setCurrentPlayerIndex(0);
    }

    private void checkGameState()
    {
        // Implement game win/draw logic
        game.getBoard().getGameState();
    }

    public Game getGame()
    {
        return game;
    }

    public void setState(Game.gameState state) {
        this.state = state;
    }

    public void setCurrentPlayerIndex(int index) {
        this.game.setCurrentPlayerIndex(index);
    }
    
    
}

