public class LinePlayer extends Player {
    public LinePlayer(String name, String color){
        super(name, color);
    }

    public LinePlayer(String name){
        super(name);
    }

    public LinePlayer(){
        super();
    }

    public boolean isWin(int row, int col, Game g){
//        Checker checker = g.getChecker(row, col);
        isWin = isHorizontalWin(row, col, (LineGame) g) || isVWin(row, col, (LineGame) g) ||
                isDiagWin(row, col,(LineGame) g) || isVerseDiagWin(row, col,(LineGame) g);
        return isWin;
    }

    public boolean isHorizontalWin(int row, int col, LineGame g){
        for (int i = 0; i < g.getWinRule(); i++) {
            if (!g.getBoard().getChecker(row, col).equals(g.getBoard().getChecker(row, i))){
                return false;
            }
        }
        return true;
    }

    public boolean isVWin(int row, int col, LineGame g){
        for (int i = 0; i < g.getWinRule()-1; i++) {
            if (!g.getChecker(row, col).equals(g.getChecker(i, col))){
                return false;
            }
        }
        return true;
    }

    public boolean isDiagWin(int row, int col, LineGame g){
        if (row + col != 2){
            return false;
        }else {
            for (int i = 0; i < g.getWinRule(); i++) {
                if (!g.getChecker(row, col).equals(g.getChecker(i, 2 -i))){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isVerseDiagWin(int row, int col, LineGame g){
        if (row != col){
            return false;
        }else {
            for (int i = 0; i < g.getWinRule(); i++) {
                if (!g.getChecker(row, col).equals(g.getChecker(i, i))){
                    return false;
                }
            }
        }
        return true;
    }

}
