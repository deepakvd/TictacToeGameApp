import Controllers.GameController;
import Models.Game;
import Models.HumanPlayer;
import Models.Player;

public class Client
{
    public static void main(String[] args)
    {

        Player player1 = new HumanPlayer("Player 1", 'X', 1);
        Player player2 = new HumanPlayer("Player 2", 'O', 2);

        Game game = new Game.Builder()
                        .player1(player1, 'X')
                        .player2(player2, 'O')
                        .build();

        game.getBoard().displayBoard();



    }
}
