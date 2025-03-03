package Models;

public abstract class Player
{
    private final String name;
    private final char symbol;
    private final int id;

    public Player(String name, char symbol, int _id)
    {
        this.name = name;
        this.symbol = symbol;
        this.id = _id;
    }

    public String getName()
    {
        return name;
    }

    public char getSymbol()
    {
        return symbol;
    }

    public int getId()
    {
        return id;
    }

    public abstract void SetPosition(int x , int y);
}
