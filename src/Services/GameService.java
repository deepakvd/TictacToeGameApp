package Services;

import Models.Board;
import Models.Player;

public class GameService {

    private final BoardService boardService;
    private final Board board;

    public GameService(BoardService boardService, Board board) {
        this.boardService = boardService;
        this.board = board;
    }

    public boolean makeMove(int row, int col, Player player) {
        if (boardService.isValidMove(board, row, col)) {
            boardService.makeMove(board, row, col, player);
            return true;
        }
        return false;
    }

    public boolean checkWin(Player player) {
        return boardService.checkWin(player);
    }

    public boolean isBoardFull() {
        return boardService.isBoardFull(board);
    }

    public void printBoard(){
        board.displayBoard();
    }
}