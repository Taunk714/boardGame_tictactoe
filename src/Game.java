public abstract class Game {
    Board b;
    String gameName;
//    boolean isWin = false;
    Player[] players;
    public Game(int row, int col, String gameName){
        b = new Board(row, col);
        this.gameName = gameName;
        players = setPlayer();
        printBoard();
    }

    public Board getBoard(){
        return b;
    }

    public abstract boolean isWin();

    public void roundPlay(Player[] p){
        while (true){
            for (Player player : p) {
                if (player.nextMove(this)) {
                    return;
                }
            }
        }
    }

    public void printBoard(){
        System.out.println(b);
    }

    public abstract Player[] setPlayer();
}
