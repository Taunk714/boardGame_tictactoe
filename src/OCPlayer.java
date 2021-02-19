public class OCPlayer extends Player implements LineWin{
    public OCPlayer(String name, char checkerName) {
        super(name, checkerName);
    }

    public boolean isWin(int row, int col, Board b){
        return isHorizontalWin(row, col, b) || isVWin(row, col, b) || isDiagWin(row, col,b) || isVerseDiagWin(row, col,b);

    }

    public boolean isHorizontalWin(int row, int col, Board b){
        for (int i = 0; i < b.getSize()-1; i++) {
            if (b.getCheckerType(row, i) != b.getCheckerType(row, i+1)){
                return false;
            }
        }
        return true;
    }

    public boolean isVWin(int row, int col, Board b){
        for (int i = 0; i < b.getSize()-1; i++) {
            if (b.getCheckerType(i, col) != b.getCheckerType(i+1, col)){
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
                if (b.getCheckerType(i, 2 - i) != b.getCheckerType(i+1, 2 -i - 1)){
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
                if (b.getCheckerType(i, i) != b.getCheckerType(i+1, i+1)){
                    return false;
                }
            }
        }
        return true;
    }

}
