package Models;
import Services.BoardService;

import java.util.List;

public class Board
{
    int size;
    List<Cell> cells;

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

    public void setPlayer(int x, int y, Player player)
    {
        boardService.setPlayer(x, y, player);

        if(boardService.checkWin(player))
        {
            System.out.println("Player " + player.getSymbol() + " wins!");
        }
        else if(boardService.checkDraw())
        {
            System.out.println("It's a draw!");
        }

    }

    public void resetBoard()
    {
        boardService.resetBoard();
    }

    public void displayBoard(){
       boardService.displayBoard();
    }

    public void getGameState()
    {
        // Implement game win/draw logic


    }

    public int getBoardSize(){
        return size;
    }
}
