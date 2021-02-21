import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Player {
    private final String name;
    private int winNum = 0;
    private String checkerColor;
    protected boolean isWin = false;
    public Player(String name, String color){
        this.name = name;
        winNum = 0;
        this.checkerColor = color;
    }

    public Player(String name){
        this.name = name;
        winNum = 0;
    }

    public Player(){
        this.name = "unknown";
        winNum = 0;
    }

    public Checker getCheckerData(){
        return null ;
    }

    public boolean nextMove(Game g){
        Board b = g.getBoard();
        System.out.print("Player " + checkerColor + "'s turn. ");
        System.out.println("Please enter the row and col:");
        Scanner scan = new Scanner(System.in);
        int row;
        int col;
        try {
            row = scan.nextInt();
            col = scan.nextInt();
        }catch (InputMismatchException e){
            System.out.println("You should enter 2 numbers.");
            return nextMove(g);
        }
        Checker checker = getCheckerData();


        if (b.canAdd(row, col)){
            addChecker(checker, row, col, b);
            System.out.println(b);
            if (isWin(row, col, g)){
                System.out.println("Congratulations! "+ name + " wins the game!");
                addWinNum();
                return true;
            }else if (b.isFull()){
                System.out.println("It's a tie!");
                return true;
            }else {
                return false;
            }
        }else {
            System.out.println("Please select another place:");
            return nextMove(g);
        }

    }

    private void addChecker(Checker checker, int row, int col, Board b){

    }

    public abstract boolean isWin(int row, int col, Game g);

    public boolean isWin(){
        return isWin;
    }

    public int getWinNum(){
        return winNum;
    }

    public void addWinNum(){
        winNum += 1;
    }

    public String getCheckerColor(){
        return checkerColor;
    }

    public void setCheckerColor(String  checkerColor){
        this.checkerColor = checkerColor;
    }

    public String getName(){
        return name;
    }
}
