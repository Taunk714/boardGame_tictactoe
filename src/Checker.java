import java.util.Objects;

public class Checker {
    // I didn't actually use it now

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
        return mark == checker.mark && Objects.equals(checkerName, checker.checkerName) && Objects.equals(color, checker.color);
    }

    @Override
    public String toString() {
        return mark + " ";
    }

    //
//    public






}
