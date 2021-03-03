import java.util.InputMismatchException;
import java.util.Scanner;

/*
    Tictactoe game. Subclass of Game. Tictactoe is a LineGame so it implements LineGame.
    Board size can be 3-30.
 */
public class TTTGame extends Game implements LineGame{
    private int winRule;
    private static int ceil = 30;
    private static int floor = 3;
    private static boolean multiChecker = false;
    private static boolean move = false;
    TTTGame(int row, int col, Player[] p) {
        super(row, col, "TTT", p);
        setWinRule(Math.min(row, col));
    }

    TTTGame(int row,Player[] p){
        super(row, row, "TTT", p);
        setWinRule(row);
    }

    TTTGame(Player[] p){
        super("TTT", p);
        setWinRule(b.getHeight());
    }

    public Board setBoard(int row, int col){
        assert row == col;
        return new Board(row, col);
    }

    public boolean canMove(){
        return move;
    }

    @Override
    public Board setBoard() {
        while (true){
            System.out.println("Please enter the size of board(one number within "+floor+"-"+ceil+"):");
            Scanner scan = new Scanner(System.in);
            int size;
            try {
                size = scan.nextInt();
                if (size >=floor && size <= ceil){
                    return new Board(size,size);
                }
            }catch (InputMismatchException e){
                System.out.println("Please enter number:");
            }

        }
    }

    @Override
    /*
        To check whether the game got the result. And print corresponding message if the game ends.
     */
    public boolean isWin(int[] place) {
        for (Player player : players) {
            if (player.isWin(place[0], place[1],this)) {
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
    // To check whether the checker the player choose is valid.
    public boolean isValid(String mark) {
        return true;
    }

    @Override
    // Whether one player will have more than one type of checker.
    // If false, player need to provide the type of checker when add checker.
    public boolean isMultiChecker() {
        return multiChecker;
    }

    @Override
    // Print welcome words.
    public void printWelcome() {
        System.out.println("Welcome to Tictactoe!");
        System.out.println("The game has 2 players. Each player has only one type of checkers. " +
                "When you add checker, please enter 2 numbers(0-"+b.getHeight()+")" );
        System.out.println("Now, press Enter to continue!");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }


//    @Override
//    public void printEnd() {
//
//    }


    @Override
    public void setWinRule(int winRule) {
        this.winRule = winRule;
    }

    public int getWinRule(){
        return winRule;
    }

    @Override
    // Set the 2 players in this game. Set the winning rule for every player.
    public void setPlayer(Player[] player) {
        System.out.print("Does "+player[0].getName()+" hold X?(Y/N)");
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
        for (Player value : player) {
            value.setRule(new LineRule("TTT"));
            value.setMultiChecker(false);
        }
        player[0].setChecker("X");
        player[1].setChecker("O");
        this.players = player;
    }
}
