public class OCGame extends Game implements LineGame{
    private int winRule;
    public OCGame(int row, int col, int winRule){
        super(row,col,"OC");
        setWinRule(winRule);
    }

    public OCGame(int row, int col){
        super(row,col,"OC");
        setWinRule(winRule);;
    }

    public OCGame(int row){
        super(row, row, "OC");
        setWinRule(winRule);
    }

    public int getWinRule(){
        return winRule;
    }

    @Override
    public boolean isWin() {
        for (Player player : players) {
            if (player.isWin()) {
                return true;
            }
        }
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
}
