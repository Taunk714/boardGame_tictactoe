import java.util.Scanner;

public class Play {
    private int total = 0;
    Game g;

    public Play(){
        welcome();
        turn();
//        g = selectGame();
    }

    public void addTotal(){
        total += 1;
    }

    public void welcome(){
        System.out.println("Welcome to the game world!");
    }

    public void printCurrentWorld(){
        System.out.println("");
    }

    public Game selectGame(){
        while (true){
            System.out.println("Select game:");
            System.out.println("If you want to play Tictactoe, enter 1");
            System.out.println("If you want to play Order and Chaos, enter 2");
            Scanner scan = new Scanner(System.in);
            int id = scan.nextInt();
            switch (id){
                case 1: return new TTTGame(3, 3);
                case 2: return new OCGame(3, 3);
                default:
                    System.out.println("Please enter the correct number");
            }
        }
    }

    private Player createPlayer(String color){
        System.out.println("Please enter the name of Player "+ color +":");
        Scanner scan = new Scanner(System.in);
        return new LinePlayer(scan.nextLine(), color);
    }

    private void exchangeChecker(Player[] p){
//        char t = p[1].getCheckerColor();
//        p[1].setCheckerName(p[0].getCheckerName());
//        p[0].setCheckerName(t);
    }

    private void printWinStatus(Player[] p){
        for (Player player : p) {
            System.out.println(player.getName() + " wins " + player.getWinNum() + " games.");
        }
    }

    public void turn(){
        g = selectGame();
        Player[] p = {createPlayer("black"), createPlayer("white")};
//        Game g = selectGame();
        while (!g.isWin()){
            g.roundPlay(p);
            printWinStatus(p);
            System.out.println("Enter \"y\" to start a new game, enter \"u\" to change players, " +
                    "enter \"c\" to exchange checkerType of players, enter other letter to quit");
            Scanner scan = new Scanner(System.in);
            String mark = scan.next().toLowerCase();
            switch (mark){
                case "u": {
                    printWinStatus(p);
                    p[0] = createPlayer("black");
                    p[1] = createPlayer("white");
                    g = selectGame();
                    break;
                }
                case "c": {
                    Player p0 = p[0];
                    p[0] = p[1];
                    p[1] = p0;
                    exchangeChecker(p);
                    g = selectGame();
                    break;
                }
                case "y": g = selectGame();break;
                default: {
                    System.out.println("End!");
                    printWinStatus(p);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {


    }
}
