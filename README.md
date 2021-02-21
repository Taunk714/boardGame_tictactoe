List & Description of classes:
* BoardGameWorld: main class.
* Play: Game center.
* Game: abstract class for turn based board game.
* TTTGame: tictactoe game.
* OCGame: order and chaos game.
* LineGame: Game whose rule is "n-in-a-row"
* Player: player. Attribute Rule makes it play differently.
* Rule: abstract class. The winning rule for player. 
* LineRule: "n-in-a-row" winning rule.
* VerseLineRule: prevent "n-in-a-row" winning rule.
* Board: game board. Normal game board.
* Block: one place of board than can place checker. No additional function.
* Checker: pieces. Normal pieces, no additional function or contraint.

# how to run
play BoardGameWorld.main()

# Via command line
- javac BoardGameWorld.java
- java BoardGameWorld

The program can change player or add a new player after one game finished, but I didn't implement team play, everyone play for them self(But it is easy to do that since I've implement methods to change player). And all the players will be record. And the grades of all players will be shown if you decide to quit.

If we want to implement a new type of game, the keypoint is to create a new subclass of Game(to set player's rule) and Rule(set winning rule for player).

