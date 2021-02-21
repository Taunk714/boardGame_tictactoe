import java.util.ArrayList;
import java.util.Scanner;

/*
    Game world! Like a game center. Can play different games, and have many players.
 */
public class Play {
    private int total = 0;
    ArrayList<Player> players = new ArrayList<>();
    Game g;

    public void init(){
        welcome();
        gameTurn();
    }

    // help count the total number of games that played.
    private void addTotal(){
        total += 1;
    }

    // print welcome word.
    private void welcome(){
        System.out.println("Welcome to the game world!");
    }

    // select which game to play.
    private Game selectGame(Player[] p){
        while (true){
            System.out.println("Select game:");
            System.out.println("If you want to play Tictactoe, enter 1");
            System.out.println("If you want to play Order and Chaos, enter 2");
            Scanner scan = new Scanner(System.in);
            int id;
            try{
                id = scan.nextInt();
            }catch (Exception e){
                System.out.println("Please enter a number.");
                continue;
            }

            switch (id){
                case 1: return new TTTGame(p);
                case 2: return new OCGame(p);
                default:
                    System.out.println("Please enter the correct number");
            }
        }
    }

    // create a new player. Every player will be record.
    private Player createPlayer(int id){
        System.out.println("Please enter the name of new Player "+ id +":");
        Scanner scan = new Scanner(System.in);
        Player p = new Player(scan.nextLine());
        players.add(p);
        return p;
    }

    // Print the number of game each player won after a game ends.
    private void printWinStatus(Player[] p){
        for (Player player : p) {
            System.out.println(player.getName() + " wins " + player.getWinNum() + " games.");
        }
    }

    // Print the status of game center.
    private void printWinStatus(){
        System.out.println("The number of games being played: "+total);
        for (Player player : players) {
            System.out.println(player.getName() + " wins " + player.getWinNum() + " games.");
        }
    }

    // core function. play game continuously.
    private void gameTurn(){
        Player[] p = {createPlayer(0), createPlayer(1)};  // initialize two players.

        while (true){
            g = selectGame(p);
            g.roundPlay();
            addTotal();
            printWinStatus(p);
            System.out.println("Enter \"y\" to start a new game, enter other letter to quit");
            Scanner scan = new Scanner(System.in);
            String mark = scan.next().toLowerCase();
            if ("y".equals(mark)) {
                p = setPlayer(p);
            } else {
                System.out.println("End!");
                printWinStatus();
                return;
            }
        }
    }

    // set player of next game. Used after one game finished.
    // Whether to change player.
    private Player[] setPlayer(Player[] player) {
        Player[] p = new Player[player.length];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < player.length; i++) {
            System.out.println("Want to change player "+ player[i].getName()+"? (Y/N):");
            while (true){
                String s = scan.next();
                if ("N".equals(s)){
                    p[i] = player[i];
                    break;
                }else if ("Y".equals(s)){
                    p[i] = createPlayer(i);
                    break;
                }else {
                    System.out.println("Please enter Y or N:");
                }
            }
        }
        return p;
    }

}
