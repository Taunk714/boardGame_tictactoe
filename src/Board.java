/*
    The board.
 */
public class Board {
    /*
        Normal board(Every place can add checker).
     */
    private final Block[][] b;
    private final int row;
    private final int col;
    private int freeSeat;
    public Board(int row, int col){
        b = new Block[row][col];
        this.row = row;
        this.col = col;
        freeSeat = row * col;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                b[i][j] = new Block();
            }
        }
    }

    public Board(int row){
        this(row, row);
    }

    // Add checker to the place.
    public void addChecker(Checker checker , int row, int col){
        b[row][col].addChecker(checker);
        freeSeat -= 1 ;
    }

    // Whether this place can add checker.
    public boolean canAdd(int row, int col){
        try {
            return b[row][col].isEmpty();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Both row and col number should within the board." + "" +
                    "");
            return false;
        }
    }

    // Whether the board is full and has no empty place.
    public boolean isFull(){
        return freeSeat == 0;
    }

    // The height of the board
    public int getHeight(){
        return row;
    }

    // Get the checker in this place.
    public Checker getChecker(int row, int col){
        try {
            return b[row][col].getChecker();
        }catch (NullPointerException e){
            return null;
        }
    }

    public String toString(){
        StringBuilder s = new StringBuilder((3 * row + 1)*(2*col+1)+row+col+50);
        s.append("+");
        for (int i = 0; i < row; i++) {
            s.append("--+".repeat(Math.max(0, col)));
            s.append("\n|");
            for (int k = 0; k < col; k++) {
                s.append(b[i][k]).append("|");
            }
            s.append(i).append("\n+");
        }

        s.append("--+".repeat(Math.max(0, col)));
        s.append("\n ");
        for (int i = 0; i < col; i++) {
            s.append(i).append("  ");
        }
        return s.toString();
    }
}
