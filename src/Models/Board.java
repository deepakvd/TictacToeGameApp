package Models;
import Services.BoardService;
import java.util.ArrayList;

import java.util.List;

public class Board
{
    int size;
    List<Cell> cells = new ArrayList<>();

    private BoardService boardService;

    public Board(int size)
    {
        if(size < 3) throw new IllegalArgumentException("Board size must be at least 3");
        this.size = size;
        initializeBoard();
    }

    public List<Cell> getCells(){
        return cells;
    }

    private void initializeBoard(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                cells.add(new Cell(i, j));
            }
        }
    }

    public Cell getCell(int x, int y)
    {
        for (Cell cell : cells) {
            if (cell.getX() == x && cell.getY() == y) {
                return cell;
            }
        }
        return null;
    }

    public void resetBoard()
    {
        boardService.resetBoard();
    }

    public void displayBoard(){
       boardService.displayBoard();
    }

    public int getBoardSize(){
        return size;
    }

    public BoardService GetBoardService()
    {
        return boardService;
    }
}
