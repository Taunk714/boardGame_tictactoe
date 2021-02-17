import java.util.InputMismatchException;
import java.util.Scanner;

public class player {
    private String name;
    private int winNum = 0;
    private char checkerType;
    player(String name, char checkerType){
        this.name = name;
        winNum = 0;
        this.checkerType = checkerType;
    }

    public boolean nextMove(board b){
        System.out.print("Player " + checkerType + "'s turn. ");
        System.out.println("Please enter the row and col:");
        Scanner scan = new Scanner(System.in);
        int row;
        int col;
        try {
            row = scan.nextInt();
            col = scan.nextInt();
        }catch (InputMismatchException e){
            System.out.println("You should enter 2 numbers.");
            return nextMove(b);
        }

        if (b.canAdd(row, col)){
            b.addChecker(checkerType, row, col);
            System.out.println(b);
            if (isWin(row, col, b)){
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
            return nextMove(b);
        }

    }

    private boolean isWin(int row, int col, board b){
        return isHorizontalWin(row, col, b) || isVWin(row, col, b) || isDiagWin(row, col,b) || isVerseDiagWin(row, col,b);

    }

    private boolean isHorizontalWin(int row, int col, board b){
        for (int i = 0; i < b.getSize()-1; i++) {
            if (b.getCheckerType(row, i) != b.getCheckerType(row, i+1)){
                return false;
            }
        }
        return true;
    }

    private boolean isVWin(int row, int col, board b){
        for (int i = 0; i < b.getSize()-1; i++) {
            if (b.getCheckerType(i, col) != b.getCheckerType(i+1, col)){
                return false;
            }
        }
        return true;
    }

    private boolean isDiagWin(int row, int col, board b){
        if (row + col != 2){
            return false;
        }else {
            for (int i = 0; i < b.getSize(); i++) {
                if (b.getCheckerType(i, 2 - i) != b.getCheckerType(i+1, 2 -i - 1)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isVerseDiagWin(int row, int col, board b){
        if (row != col){
            return false;
        }else {
            for (int i = 0; i < b.getSize(); i++) {
                if (b.getCheckerType(i, i) != b.getCheckerType(i+1, i+1)){
                    return false;
                }
            }
        }
        return true;
    }

    public int getWinNum(){
        return winNum;
    }

    public void addWinNum(){
        winNum += 1;
    }

    public char getCheckerType(){
        return checkerType;
    }

    public void setCheckerType(char checkerType){
        this.checkerType = checkerType;
    }

    public String getName(){
        return name;
    }
}
