// Subclass of Rule, an attribute of player. If the board is full and no "n-in-a-row" exists, player wins.
public class VerseLineRule extends Rule {

    VerseLineRule(String name) {
        super(name);
    }

    @Override
    // Check no "n-in-a-row" in 4 direction and full board.
    public boolean isWin(int row, int col, Game g){
//        Checker checker = g.getChecker(row, col);
        return g.getBoard().isFull() && !isHorizontalWin(row, col, (LineGame) g) && !isVWin(row, col, (LineGame) g) &&
                !isDiagWin(row, col,(LineGame) g) && !isBackDiagWin(row, col,(LineGame) g);
    }

    // check "n-in-a-row" in horizontal.
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

        for (int i = 1; i < g.getWinRule()-cnt + 1; i++) {
            if (col - i >=0 && g.getBoard().getChecker(row, col).equals(g.getBoard().getChecker(row, col - i))){
                cnt++;
            }else{
                break;
            }
        }
        return cnt == g.getWinRule();
    }

    // check "n-in-a-row" in vertical.
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

        for (int i = 1; i < g.getWinRule()-cnt + 1; i++) {
            if (row - i >=0 && g.getBoard().getChecker(row, col).equals(g.getBoard().getChecker(row - i, col))){
                cnt++;
            }else{
                break;
            }
        }
        return cnt == g.getWinRule();
    }

    // check "n-in-a-row" in back-diagonal.
    public boolean isBackDiagWin(int row, int col, LineGame g){
        if (Math.abs(row + col - g.getWinRule()) > (g.getBoard().getHeight() - g.getWinRule())){
            return false;
        }else {
            int cnt = 0;
            for (int i = 0; i < g.getWinRule(); i++) {
                if (row + i < g.getBoard().getHeight() && col + i < g.getBoard().getHeight() &&
                        g.getBoard().getChecker(row, col).equals(g.getBoard().getChecker(row + i, col - i))){
                    cnt++;
                }else {
                    break;
                }
            }

            if (cnt == g.getWinRule()){
                return true;
            }

            for (int i = 1; i < g.getWinRule() - cnt + 1; i++) {
                if (row + i < g.getBoard().getHeight() && col + i < g.getBoard().getHeight() &&
                        g.getBoard().getChecker(row, col).equals(g.getBoard().getChecker(row - i, col + i))){
                    cnt++;
                }else {
                    break;
                }
            }

            return cnt == g.getWinRule();
        }
    }

    // check "n-in-a-row" in diagonal.
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

            for (int i = 1; i < g.getWinRule() - cnt + 1; i++) {
                if (row + i < g.getBoard().getHeight() && col + i < g.getBoard().getHeight() &&
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
