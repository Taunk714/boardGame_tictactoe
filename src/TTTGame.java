public class TTTGame extends Game implements LineGame{
    private int winRule;
    TTTGame(int row, int col, int winRule) {
        super(row, col, "TTT");
        setWinRule(winRule);
    }

    TTTGame(int row, int winRule){
        super(row, row, "TTT");
        setWinRule(winRule);
    }

    TTTGame(){
        super(3, 3, "TTT");
        setWinRule(3);
    }

    @Override
    public boolean isWin() {
        return false;
    }

    @Override
    public Player[] setPlayer() {
        return new Player[0];
    }

    @Override
    public void setWinRule(int winRule) {
        this.winRule = winRule;
    }

    public int getWinRule(){
        return winRule;
    }
}
