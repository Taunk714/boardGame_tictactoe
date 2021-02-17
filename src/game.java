public class game  {
    board b;
    game(int row, int col){
        b = new board(row, col);
        printBoard();
    }

    public board getBoard(){
        return b;
    }

    public boolean isWin(){
        return false;
    }

    public void play(player p1, player p2){
        while (true){
            if (p1.nextMove(b)){
                break;
            }

            if (p2.nextMove(b)){
                break;
            }
        }
    }

    public void printBoard(){
        System.out.println(b);
    }
}
