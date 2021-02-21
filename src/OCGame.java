import java.util.Scanner;

/*
    Order and Chaos game. Subclass of Game. Tictactoe is a LineGame so it implements LineGame
    The board size is fixed(6x6).
*/
public class OCGame extends Game implements LineGame{

    private int winRule = 5;
    static String[] checkerSet = {"X", "O"};
    static boolean multiChecker = true;
    static boolean move = false;

    public OCGame(Player[] p){
        super("OC",p);
    }

    public int getWinRule(){
        return winRule;
    }

    // Whether one player will have more than one type of checker.
    // If false, player need to provide the type of checker when add checker.
    public boolean isMultiChecker(){
        return multiChecker;
    }

    @Override
    public boolean canMove() {
        return move;
    }

    @Override
    public Board setBoard() {
        return new Board(6, 6);
    }

    @Override
    /*
        To check whether the game got the result. And print corresponding message if the game ends.
     */
    public boolean isWin(int[] place) {
        for (Player player : players) {
            if (player.isWin(place[0], place[1], this)) {
                System.out.println("Congratulations! "+ player.getName() + " wins the game!");
                player.addWinNum();
                return true;
            }
        }

        if (b.isFull()){
            System.out.println("It's a tie!");
            return true;
        }
        return false;
    }

    @Override
    // Print welcome words.
    public void printWelcome() {
        System.out.println("Welcome to Order and Chaos!");
        System.out.println("The game has 2 players. Each player has two types of checkers(X and O). \n" +
                "When you add checker, please first enter 2 numbers(0-"+b.getHeight()+"), then enter which tyoe of checker to add(X or O)" );
        System.out.println("Now, press Enter to continue!");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }

    // Whether the checker player wants to add is valid in the game.
    // To prevent typo.
    public boolean isValid(String mark){
        for (String s : checkerSet) {
            if (s.equals(mark)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void setWinRule(int winRule) {
        this.winRule = winRule;
    }

    @Override
    public void setPlayer(Player[] player) {
        System.out.print("Is "+player[0].getName()+" the Order?(Y/N)");
        Scanner scan = new Scanner(System.in);
        while (true){
            String s = scan.next();
            if ("N".equals(s)){
                helpExchange(player);
                break;
            }else if ("Y".equals(s)){
                break;
            }else {
                System.out.println("Please enter Y or N:");
            }
        }

        player[0].setRule(new LineRule("OC"));
        player[0].setMultiChecker(true);
        player[1].setRule(new VerseLineRule("OC"));
        player[0].setMultiChecker(true);
        this.players = player;
    }
}
