package Services;

import Models.Board;
import Models.Cell;
import Models.Player;

public class BoardService {
    private final Board board;
    private int[] rows;
    private int[] cols;
    private int mainDiagonal;
    private int antiDiagonal;
    private int totalMoves;  // Track total moves for draw condition

    public BoardService(Board board) {
        this.board = board;
        int size = board.getBoardSize();
        this.rows = new int[size];
        this.cols = new int[size];
        this.mainDiagonal = 0;
        this.antiDiagonal = 0;
        this.totalMoves = 0;
    }

    public void resetBoard() {
        for (Cell cell : board.getCells()) {
            cell.updateCell(null);
        }
        int size = board.getBoardSize();
        this.rows = new int[size];
        this.cols = new int[size];
        this.mainDiagonal = 0;
        this.antiDiagonal = 0;
        this.totalMoves = 0;
    }

    public void setPlayer(int x, int y, Player player) {
        Cell cell = board.getCell(x, y);

        if (cell.isCellOccupied()) {
            throw new IllegalStateException("Cell is already occupied!");
        }

        // Set player in the cell
        cell.updateCell(player);
        totalMoves++;

        // Track player's symbol count in row, column, and diagonals
        int symbolValue = (player.getId() == 1) ? 1 : -1; // Player 1 = +1, Player 2 = -1
        int boardSize = board.getBoardSize();

        rows[x] += symbolValue;
        cols[y] += symbolValue;

        if (x == y) {
            mainDiagonal += symbolValue;
        }
        if (x + y == boardSize - 1) {
            antiDiagonal += symbolValue;
        }
    }

    public void displayBoard() {
        int s = board.getBoardSize();

        if (board.getCells() == null || board.getCells().isEmpty()) {
            return;
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                Cell cell = board.getCell(i, j);
                if (cell.isCellOccupied()) {
                    str.append("| ").append(cell.getCurrentPlayer().getSymbol()).append(" |");
                } else {
                    str.append("|   |");
                }
            }
            str.append("\n").append("-".repeat(4 * s)).append("\n");
        }
        System.out.print(str);
    }

    // Check if the current player wins
    public boolean checkWin(Player player) {
        int boardSize = board.getBoardSize();
        int winCondition = (player.getId() == 1) ? boardSize : -boardSize;

        // If any row, column, or diagonal sum matches winCondition, player wins
        for (int i = 0; i < boardSize; i++) {
            if (rows[i] == winCondition || cols[i] == winCondition) {
                return true;
            }
        }

        return (mainDiagonal == winCondition || antiDiagonal == winCondition);
    }

    // Check if the game is a draw
    public boolean checkDraw() {
        return totalMoves == board.getBoardSize() * board.getBoardSize();
    }
}
