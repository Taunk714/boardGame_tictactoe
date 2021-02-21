public class ChaosPlayer extends Player{
    public ChaosPlayer(String name, String color){
        super(name, color);
    }

    public ChaosPlayer(String name){
        super(name);
    }

    public ChaosPlayer(){
        super();
    }
    public boolean isWin(int row, int col, Game g){
//        Checker checker = b.getChecker(row, col);
        return g.getBoard().isFull();

    }

}
