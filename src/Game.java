public class Game implements Turn {
    Board b;
    public Game(int row, int col){
        b = new Board(row, col);
        printBoard();
    }

    public Board getBoard(){
        return b;
    }

    public boolean isWin(){
        return false;
    }

    public void play(Player[] p){
        while (true){
            for (Player player : p) {
                if (player.nextMove(b)) {
                    return;
                }
            }
        }
    }

    public void printBoard(){
        System.out.println(b);
    }
}
