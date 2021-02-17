import java.util.Scanner;

public class play {
    private int total = 0;

    public void addTotal(){
        total += 1;
    }

    private static player createPlayer(char checkerType){
        System.out.println("Please enter the name of Player "+ checkerType +":");
        Scanner scan = new Scanner(System.in);
        return new player(scan.nextLine(), checkerType);
    }

    private static void exchangeChecker(player p1, player p2){
        char t = p1.getCheckerType();
        p1.setCheckerType(p2.getCheckerType());
        p2.setCheckerType(t);
    }

    private static void printWinStatus(player p1, player p2){
        System.out.println(p1.getName() + " wins " + p1.getWinNum() +" games.");
        System.out.println(p2.getName() + " wins " + p2.getWinNum() +" games.");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe!");
        player p1 = createPlayer('X');
        player p2 = createPlayer('O');

        game g = new game(3, 3);
        while (!g.isWin()){
            g.play(p1, p2);
            printWinStatus(p1, p2);
            System.out.println("Enter \"y\" to start a new game, enter \"u\" to change players, " +
                    "enter \"c\" to exchange checkerType of players, enter other letter to quit");
            Scanner scan = new Scanner(System.in);
            String mark = scan.next().toLowerCase();
            switch (mark){
                case "u": {
                    printWinStatus(p1, p2);
                    p1 = createPlayer('X');
                    p2 = createPlayer('O');
                    g = new game(3, 3);
                    break;
                }
                case "c": {
                    player p = p1;
                    p1 = p2;
                    p2 = p;
                    exchangeChecker(p1, p2);
                    g = new game(3, 3);
                    break;
                }
                case "y": g = new game(3,3);break;
                default: {
                    System.out.println("End!");
                    printWinStatus(p1, p2);
                    return;
                }
            }
        }

    }
}
