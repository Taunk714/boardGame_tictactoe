// Checker class. If two checkers have the same color and mark, then they are the same checker.
// Normal pieces, no constraint.
public class Checker {

    private String checkerName;
    private String mark;
    private String color;
    private Player p;

    public Checker(String checkerName, String mark, String color, Player p){
        this.checkerName = checkerName;
        this.mark = mark;
        this.color = color;
        this.p = p;
    }

    public Checker(String checkerName, String mark, String color){
        this.checkerName = checkerName;
        this.mark = mark;
        this.color = color;
    }

    public Checker(String mark, String color){
//        this.checkerName = checkerName;
        this.mark = mark;
        this.color = color;
    }

    public Checker(String mark){
//        this.checkerName = checkerName;
        this.mark = mark;
        this.color = "n";
    }

    public String getCheckerName(){
        return checkerName;
    }

    public String getMark(){
        return mark;
    }

    public String getColor(){
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Checker checker = (Checker) o;
        return mark.equals(checker.mark) && color.equals(((Checker) o).color);
    }

    @Override
    public String toString() {
        return mark;
    }







}
