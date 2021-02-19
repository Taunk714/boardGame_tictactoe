import java.util.Scanner;

public class Play {
    private int total = 0;

    public void addTotal(){
        total += 1;
    }

    private static Player createPlayer(char checkerType){
        System.out.println("Please enter the name of Player "+ checkerType +":");
        Scanner scan = new Scanner(System.in);
        return new TTTPlayer(scan.nextLine(), checkerType);
    }

    private static void exchangeChecker(Player[] p){
//        char t = p[1].getCheckerColor();
//        p[1].setCheckerName(p[0].getCheckerName());
//        p[0].setCheckerName(t);
    }

    private static void printWinStatus(Player[] p){
        for (Player player : p) {
            System.out.println(player.getName() + " wins " + player.getWinNum() + " games.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe!");
        Player[] p = {createPlayer('X'), createPlayer('O')};
        Game g = new Game(3, 3);
        while (!g.isWin()){
            g.play(p);
            printWinStatus(p);
            System.out.println("Enter \"y\" to start a new game, enter \"u\" to change players, " +
                    "enter \"c\" to exchange checkerType of players, enter other letter to quit");
            Scanner scan = new Scanner(System.in);
            String mark = scan.next().toLowerCase();
            switch (mark){
                case "u": {
                    printWinStatus(p);
                    p[0] = createPlayer('X');
                    p[1] = createPlayer('O');
                    g = new Game(3, 3);
                    break;
                }
                case "c": {
                    Player p0 = p[0];
                    p[0] = p[1];
                    p[1] = p0;
                    exchangeChecker(p);
                    g = new Game(3, 3);
                    break;
                }
                case "y": g = new Game(3,3);break;
                default: {
                    System.out.println("End!");
                    printWinStatus(p);
                    return;
                }
            }
        }

    }
}
