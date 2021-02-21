/*
    One area of board that can add checker to.
 */
public class Block {
    private Checker c;
    public void addChecker(Checker checker){
        c = checker;
    }

    public boolean isEmpty(){
        return c == null;
    }

    public Checker getChecker(){
        return c;
    }

    public String toString(){
        if (c == null){
            return "  ";
        }else {
            return c + " ";
        }
    }
}
