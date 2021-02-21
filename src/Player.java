import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

// Player class. The core attribute is rule. In different games, one player will have different rules.
// rule is different based on the game, and it decides whether the player wins the game.
// This class can be used for all the board that
public class Player {
    private final String name;
    private int winNum = 0;
//    private String checkerColor;
    protected boolean isWin = false;
    Rule rule;
    boolean multiChecker = true;
    String checkerMark;

//    public Player(String name){
//        this.name = name;
//        winNum = 0;
////        this.checkerColor = color;
//    }

    public Player(String name){
        this.name = name;
    }

    public Player(){
        this.name = "unknown";
    }

    public void setRule(Rule rule) {
        this.rule = rule;
        this.isWin = false;
    }

    // help function. Ask player what type of checker to add next.
    private Checker getCheckerData(Game g){
        while (true){
            System.out.println("Please enter your checker:");
            Scanner scan = new Scanner(System.in);
            String mark;
            try {
                mark = scan.next().toUpperCase(Locale.ROOT);
                if (!g.isValid(mark)){
                    System.out.println("Invalid checker.");
                    continue;
                }
            }catch (InputMismatchException e){
                System.out.println("You should enter the mark.");
                continue;
            }
            return new Checker(mark);
        }
    }

    // player's move. This function can work for all board(Currently, only for those whose pieces can't move)
    // Print current game board, ask player where and which checker to add and then check the validation,
    // if it's invalid, ask player to enter again.
    public int[] nextMove(Game g){
        while (true) {
            if (!g.canMove()){
                Board b = g.getBoard();
                System.out.print("Player " + name + "'s turn. ");
                System.out.println("Please enter the row and col:");
                Scanner scan = new Scanner(System.in);
                int row;
                int col;
                try {
                    row = scan.nextInt();
                    col = scan.nextInt();
                }catch (InputMismatchException e){
                    System.out.println("You should enter 2 numbers.");
                    continue;
                }

                if (b.canAdd(row, col)){
                    Checker checker;
                    if (g.isMultiChecker()){
                        checker = getCheckerData(g);
                    }else {
                        checker = new Checker(checkerMark);
                    }
                    addChecker(checker, row, col, b);
                    System.out.println(b);
                    return new int[]{row, col};
                }else {
                    System.out.println("You can't go here, please select another place:");
                }
            }else {
                return null;
            }

        }
    }

    // put checker to the place
    private void addChecker(Checker checker, int row, int col, Board b){
        b.addChecker(checker, row, col);
    }

    // check whether the player win after last move(all players).
    public boolean isWin(int row, int col, Game g){
        return rule.isWin(row, col, g);
    };

//    public boolean isWin(){
//        return isWin;
//    }

    public int getWinNum(){
        return winNum;
    }

    public void addWinNum(){
        winNum += 1;
    }

    public void setMultiChecker(boolean multi){
        this.multiChecker = multi;
    }
//
//    public void setCheckerColor(String  checkerColor){
//        this.checkerColor = checkerColor;
//    }

    public void setChecker(String checkerMark){
        this.checkerMark = checkerMark;
    }

    public String getName(){
        return name;
    }
}
