public class block {
    private char c = ' ';
    public void addChecker(char checkerType){
        c = checkerType;
    }

    public boolean isEmpty(){
        return c == ' ';
    }

    public char getChecker(){
        return c;
    }

    public String toString(){
        return c + " ";
    }
}
