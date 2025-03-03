package Models;

public class Game
{
    private final Board board;
    private final Player player1;
    private final Player player2;
    private gameState state;
    private int currentPlayerIndex;

    private Game(Builder builder) {
        this.board = builder.board;
        this.player1 = builder.player1;
        this.player2 = builder.player2;
        this.state = gameState.IN_PROGRESS;
        this.currentPlayerIndex = 0;
    }

    public void setState(gameState gameState)
    {
        this.state = gameState;
    }

    public void setCurrentPlayerIndex(int i)
    {
        this.currentPlayerIndex = i;
    }

    public enum gameState {
        PLAYER1_WON,
        PLAYER2_WON,
        DRAW,
        IN_PROGRESS
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public gameState getState() {
        return state;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }




    // Builder class
    public static class Builder {
        private Board board;
        private Player player1;
        private Player player2;

        public Builder board(Board board) {
            this.board = board;
            return this;
        }

        public Builder player1(Player player1, char symbol) {
            this.player1 = player1;
            return this;
        }

        public Builder player2(Player player2, char symbol) {
            this.player2 = player2;
            return this;
        }

        public Game build() {
            return new Game(this);
        }
    }
}
