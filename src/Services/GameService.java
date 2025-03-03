package Services;

import Models.Board;
import Models.Cell;
import Models.HumanPlayer;
import Models.Player;
import java.util.List;

public class GameService {
    private final Board board;
    private final List<Player> players;
    private int currentPlayerIndex;

    public GameService(int boardSize) {
        this.board = new Board(boardSize);
        this.players = List.of(new HumanPlayer("A",'X',1),
                new HumanPlayer("B",'O',2)); //
        this.currentPlayerIndex = 0;
    }

    // 🔹 Start the game by clearing the board
    public void startGame() {
        board.resetBoard();
        currentPlayerIndex = 0;
    }

    // 🔹 Makes a move on the board
    public boolean makeMove(int x, int y, Player player) {
        if (x < 0 || x >= board.getBoardSize() || y < 0 || y >= board.getBoardSize()) {
            return false; // Invalid move (out of bounds)
        }

        Cell cell = board.getCell(x, y);
        if (cell.isCellOccupied()) {
            return false; // Cell already occupied
        }

        cell.updateCell(player);
        return true;
    }

    // 🔹 Checks if the current player has won
    public boolean checkWin()
    {
        return board.GetBoardService().checkWin(players.get(currentPlayerIndex));
    }

    // 🔹 Checks if the game is a draw
    public boolean checkDraw() {
        // Call from boardService
        return board.GetBoardService().checkDraw();
    }

    // 🔹 Switches to the next player
    public void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    // 🔹 Resets the board and game state
    public void resetGame() {
        board.resetBoard();
        currentPlayerIndex = 0;
    }

    // 🔹 Displays the board
    public void displayBoard() {
        board.displayBoard();
    }

    // 🔹 Gets the current player
    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    // 🔹 Gets the board instance
    public Board getBoard() {
        return board;
    }

    public GameService getGame()
    {
        return this;
    }
}
