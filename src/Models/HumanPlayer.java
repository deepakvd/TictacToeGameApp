package Models;

public class HumanPlayer extends Player
{
    public HumanPlayer(String name, char symbol, int _id)
    {
        super(name, symbol, _id);
    }

    @Override
    public void SetPosition(int x, int y)
    {
        System.out.println("It's your turn, " + getName());
    }
}
