public class TTTPlayer extends Player implements LineWin{
    public TTTPlayer(String name, char checkerType){
        super(name, checkerType);
    }

    public boolean isWin(int row, int col, Board b){
        Checker checker = b.getChecker(row, col);
        return isHorizontalWin(row, col, b) || isVWin(row, col, b) || isDiagWin(row, col,b) || isVerseDiagWin(row, col,b);

    }

    public boolean isHorizontalWin(int row, int col, Board b){
        for (int i = 0; i < b.getSize()-1; i++) {
            if (b.getChecker(row, i) != b.getChecker(row, i+1)){
                return false;
            }
        }
        return true;
    }

    public boolean isVWin(int row, int col, Board b){
        for (int i = 0; i < b.getSize()-1; i++) {
            if (b.getChecker(i, col) != b.getChecker(i+1, col)){
                return false;
            }
        }
        return true;
    }

    public boolean isDiagWin(int row, int col, Board b){
        if (row + col != 2){
            return false;
        }else {
            for (int i = 0; i < b.getSize(); i++) {
                if (b.getChecker(i, 2 - i) != b.getChecker(i+1, 2 -i - 1)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isVerseDiagWin(int row, int col, Board b){
        if (row != col){
            return false;
        }else {
            for (int i = 0; i < b.getSize(); i++) {
                if (b.getChecker(i, i) != b.getChecker(i+1, i+1)){
                    return false;
                }
            }
        }
        return true;
    }

}
