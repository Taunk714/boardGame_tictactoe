public interface LineWin {

    boolean isHorizontalWin(int row, int col, Board b);

    boolean isVWin(int row, int col, Board b);

    boolean isDiagWin(int row, int col, Board b);

    boolean isVerseDiagWin(int row, int col, Board b);
}
