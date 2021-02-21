/*
    LineGame Interface. Game whose rule is "n-in-a-rows".
 */
public interface LineGame {

    void setWinRule(int winRule);

    int getWinRule();

    Board getBoard();
}
