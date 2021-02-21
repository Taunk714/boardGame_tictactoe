public abstract class Rule {
    String name;
    Rule(String name){
        this.name = name;
    }

    public abstract boolean isWin(int row, int col, Game g);


}
