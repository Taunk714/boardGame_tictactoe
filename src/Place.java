public class Place {
    int[] place;
    public Place(int row, int col){
        place = new int[]{row, col};
    }

    public void setPlace(int[] place) {
        this.place = place;
    }

    public void setPlace(int row, int col){
        place[0] = row;
        place[1] = col;
    }

    public int[] getPlace(){
        return place;
    }
}
