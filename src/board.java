import java.util.InputMismatchException;

public class board {
    private block[][] b;
    private int row;
    private int col;
    private int freeSeat;
    board(int row, int col){
        b = new block[row][col];
        this.row = row;
        this.col = col;
        freeSeat = row * col;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                b[i][j] = new block();
            }
        }
    }

    public void addChecker(char checkerType , int row, int col){
        b[row][col].addChecker(checkerType);
        freeSeat -= 1 ;

    }

    public boolean canAdd(int row, int col){
        try {
            return b[row][col].isEmpty();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Both row and col number should between 0-2.");
            return false;
        }
    }

    public boolean isFull(){
        return freeSeat == 0;
    }

    public int getSize(){
        return col;
    }

    public char getCheckerType(int row, int col){
        return b[row][col].getChecker();
    }

    public String toString(){
        String s = "+";
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                s += "--+";
            }
            s += "\n|";
            for (int k = 0; k < col; k++) {
                s += b[i][k] + "|";
            }
            s += i+"\n+";
        }

        for (int i = 0; i < col; i++) {
            s += "--+";
        }
        s += "\n ";
        for (int i = 0; i < col; i++) {
            s += i +"  ";
        }
        return s;
    }
}
