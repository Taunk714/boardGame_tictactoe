import java.util.Scanner;

/*
    Abstract class. Turn-based board game.
    create a new subclass if want to extend and add a new type of game.
    This class will set the rule of player and play the turn based game.
 */
public abstract class Game {
    protected Board b;
    protected String gameName;
//    boolean isWin = false;
    Player[] players;
//    protected boolean multiChecker;
    public Game(int row, int col, String gameName, Player[] p){
        b = setBoard(row, col);
        this.gameName = gameName;
        setPlayer(p);
        printWelcome();
        printBoard();
    }

    public Game(String gameName, Player[] p){
        b = setBoard();
        this.gameName = gameName;
        setPlayer(p);
        printWelcome();
        printBoard();
    }

    public Board getBoard(){
        return b;
    }

    public Board setBoard(int row, int col){
        return new Board(row, col);
    }

    public abstract Board setBoard();

    public abstract boolean isWin(int[] place);

    public abstract boolean isValid(String mark);

    public abstract boolean isMultiChecker();

    public abstract boolean canMove();

    public void roundPlay(){
        while (true){
            for (Player player : players) {
                int[] place = player.nextMove(this);
                if (isWin(place)) {
                    return;
                }
            }
        }
    }

    public void printBoard(){
        System.out.println(b);
    }

    // Help function. Players are store in Player[].
    // In the program, Player[0] always go first.
    // Sometimes user want Player[1] to go first, so this function help exchange players.
    // Used in setPlayer().
    protected void helpExchange(Player[] p){
        Player temp = p[0];
        p[0] = p[1];
        p[1] = temp;
    }

    public abstract void printWelcome();

    // Set players of this game.
    public void setPlayer(Player[] player){
        this.players = player;
    };
}
