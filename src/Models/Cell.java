package Models;

public class Cell
{
    int x;
    int y;
    Player CurrentPlayer;
    boolean isCellOccupied = false;

    public Cell(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Cell cell)
    {
        return this.x == cell.x && this.y == cell.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void updateCell(Player player)
    {
        this.CurrentPlayer = player;
        isCellOccupied = player != null;
    }

    public boolean isCellOccupied()
    {
        return isCellOccupied;
    }

    public Player getCurrentPlayer()
    {
        return CurrentPlayer;
    }

}
