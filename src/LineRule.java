// Subclass of Rule, an attribute of player. If "n-in-a-row" is created, player wins.
public class LineRule extends Rule {
    LineRule(String name) {
        super(name);
    }

    @Override
    // Check "n-in-a-row" in 4 direction.
    public boolean isWin(int row, int col, Game g){
//        Checker checker = g.getChecker(row, col);
        return isHorizontalWin(row, col, (LineGame) g) || isVWin(row, col, (LineGame) g) ||
                isDiagWin(row, col,(LineGame) g) || isBackDiagWin(row, col,(LineGame) g);
    }

    // check "n-in-a-row" in horizontal
    public boolean isHorizontalWin(int row, int col, LineGame g){
        int cnt = 0;
        for (int i = 0; i < g.getWinRule(); i++) {
            if (col + i < g.getBoard().getHeight() && g.getBoard().getChecker(row, col).equals(g.getBoard().getChecker(row, col + i))){
                cnt++;
            } else {
                break;
            }
        }

        if (cnt == g.getWinRule()){
            return true;
        }
        int left = g.getWinRule()-cnt + 1;
        for (int i = 1; i < left; i++) {
            if (col - i >=0 && g.getBoard().getChecker(row, col).equals(g.getBoard().getChecker(row, col - i))){
                cnt++;
            }else{
                break;
            }
        }
        return cnt == g.getWinRule();
    }

    // check "n-in-a-row" in vertical
    public boolean isVWin(int row, int col, LineGame g){
        int cnt = 0;
        for (int i = 0; i < g.getWinRule(); i++) {
            if (row + i < g.getBoard().getHeight() && g.getBoard().getChecker(row, col).equals(g.getBoard().getChecker(row + i, col))){
                cnt++;
            } else {
                break;
            }
        }

        if (cnt == g.getWinRule()){
            return true;
        }

        int left = g.getWinRule()-cnt + 1;
        for (int i = 1; i < left; i++) {
            if (row - i >=0 && g.getBoard().getChecker(row, col).equals(g.getBoard().getChecker(row - i, col))){
                cnt++;
            }else{
                break;
            }
        }
        return cnt == g.getWinRule();
    }

    // check "n-in-a-row" in back-diagonal
    public boolean isBackDiagWin(int row, int col, LineGame g){
        if (Math.abs(row + col - g.getWinRule()) > (g.getBoard().getHeight() - g.getWinRule())){
            return false;
        }else {
            int cnt = 0;
            for (int i = 0; i < g.getWinRule(); i++) {
                if (row + i < g.getBoard().getHeight() && col - i >=0 &&
                        g.getBoard().getChecker(row, col).equals(g.getBoard().getChecker(row + i, col - i))){
                    cnt++;
                }else {
                    break;
                }
            }

            if (cnt == g.getWinRule()){
                return true;
            }

            int left = g.getWinRule()-cnt + 1;
            for (int i = 1; i < left; i++) {
                if (row - i >=0 && col + i < g.getBoard().getHeight() &&
                        g.getBoard().getChecker(row, col).equals(g.getBoard().getChecker(row - i, col + i))){
                    cnt++;
                }else {
                    break;
                }
            }

            return cnt == g.getWinRule();
        }
    }

    // check "n-in-a-row" in diagonal
    public boolean isDiagWin(int row, int col, LineGame g){
        if (Math.abs(row - col) > (g.getBoard().getHeight()-g.getWinRule())){
            return false;
        }else {
            int cnt = 0;
            for (int i = 0; i < g.getWinRule(); i++) {
                if (row + i < g.getBoard().getHeight() && col + i < g.getBoard().getHeight() &&
                        g.getBoard().getChecker(row, col).equals(g.getBoard().getChecker(row + i, col + i))){
                    cnt++;
                }else {
                    break;
                }
            }

            if (cnt == g.getWinRule()){
                return true;
            }

            int left = g.getWinRule()-cnt + 1;
            for (int i = 1; i < left; i++) {
                if (row - i >= 0 && col - i >=0 &&
                        g.getBoard().getChecker(row, col).equals(g.getBoard().getChecker(row - i, col - i))){
                    cnt++;
                }else {
                    break;
                }
            }

            return cnt == g.getWinRule();
        }
    }
}
